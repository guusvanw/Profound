package com.poliyguus.profound.rest.service.theysaidso;

import com.poliyguus.profound.rest.TheySaidSoApi;
import com.poliyguus.profound.rest.events.ApiErrorEvent;
import com.poliyguus.profound.rest.events.CategoriesRetrievedEvent;
import com.poliyguus.profound.rest.events.RetrieveCategoriesEvent;
import com.poliyguus.profound.rest.model.theysaidso.CategoriesResponse;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Guus on 21/11/2015.
 */
public class CategoryService {

    private TheySaidSoApi mApi;
    private Bus mBus;

    public CategoryService(TheySaidSoApi api, Bus bus) {
        mApi = api;
        mBus = bus;
    }

    /**
     * Subscribes the onLoadStory service method to the bus.
     * @param event
     */
    @Subscribe
    public void onRetrieveCategories(RetrieveCategoriesEvent event) {
        Call<CategoriesResponse> call = mApi.retrieveCategories();

        call.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Response<CategoriesResponse> response, Retrofit retrofit) {
                mBus.post(new CategoriesRetrievedEvent(response.body()));
            }

            @Override
            public void onFailure(Throwable t) {
                mBus.post(new ApiErrorEvent(t));
            }
        });
    }
}
