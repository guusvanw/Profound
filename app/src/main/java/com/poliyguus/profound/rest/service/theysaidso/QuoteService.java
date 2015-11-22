package com.poliyguus.profound.rest.service.theysaidso;

import com.poliyguus.profound.rest.TheySaidSoApi;
import com.poliyguus.profound.rest.events.ApiErrorEvent;
import com.poliyguus.profound.rest.events.QuoteRetrievedEvent;
import com.poliyguus.profound.rest.events.RetrieveQuoteEvent;
import com.poliyguus.profound.rest.model.theysaidso.CategoriesResponse;
import com.poliyguus.profound.rest.model.theysaidso.QuoteResponse;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Guus on 21/11/2015.
 */
public class QuoteService {

    private TheySaidSoApi mApi;
    private Bus mBus;

    public QuoteService(TheySaidSoApi api, Bus bus) {
        mApi = api;
        mBus = bus;
    }

    /**
     * Subscribes the onLoadStory service method to the bus.
     * @param event
     */
    @Subscribe
    public void onRetrieveQuote(RetrieveQuoteEvent event) {
        Call<QuoteResponse> call = mApi.retrieveQuoteByCategory(event.getCategory());

        call.enqueue(new Callback<QuoteResponse>() {
            @Override
            public void onResponse(Response<QuoteResponse> response, Retrofit retrofit) {
                mBus.post(new QuoteRetrievedEvent(response.body()));
            }

            @Override
            public void onFailure(Throwable t) {
                mBus.post(new ApiErrorEvent(t));
            }
        });
    }
}
