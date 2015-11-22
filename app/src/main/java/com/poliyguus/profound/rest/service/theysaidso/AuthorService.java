package com.poliyguus.profound.rest.service.theysaidso;

import com.poliyguus.profound.rest.TheySaidSoApi;
import com.poliyguus.profound.rest.events.ApiErrorEvent;
import com.poliyguus.profound.rest.events.AuthorsRetrievedEvent;
import com.poliyguus.profound.rest.events.RetrieveAuthorsEvent;
import com.poliyguus.profound.rest.model.theysaidso.AuthorsResponse;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AuthorService {

    private TheySaidSoApi mApi;
    private Bus mBus;

    public AuthorService(TheySaidSoApi api, Bus bus) {
        mApi = api;
        mBus = bus;
    }

    /**
     * Subscribes the onLoadStory service method to the bus.
     * @param event
     */
    @Subscribe
    public void onRetrieveAuthors(RetrieveAuthorsEvent event) {
        Call<AuthorsResponse> call = mApi.retrieveAuthors();

        call.enqueue(new Callback<AuthorsResponse>() {
            @Override
            public void onResponse(Response<AuthorsResponse> response, Retrofit retrofit) {
                mBus.post(new AuthorsRetrievedEvent(response.body()));
            }

            @Override
            public void onFailure(Throwable t) {
                mBus.post(new ApiErrorEvent(t));
            }
        });
    }
}
