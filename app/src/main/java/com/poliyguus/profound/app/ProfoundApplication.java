package com.poliyguus.profound.app;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.poliyguus.profound.BusProvider;
import com.poliyguus.profound.app.config.ApiConfig;
import com.poliyguus.profound.rest.TheySaidSoApi;
import com.poliyguus.profound.rest.events.ApiErrorEvent;
import com.poliyguus.profound.rest.model.theysaidso.ListContents;
import com.poliyguus.profound.rest.model.theysaidso.adapters.ListContentsAdapter;
import com.poliyguus.profound.rest.service.theysaidso.CategoryService;
import com.poliyguus.profound.rest.service.theysaidso.QuoteService;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * The profound application class
 * Created by Guus on 21/11/2015.
 */
public class ProfoundApplication extends Application {

    private CategoryService mCategoryService;
    private QuoteService mQuoteService;
    private Bus mBus = BusProvider.getInstance();
    private ApiConfig mApiConfig;
    private String mApiKey;
    private String mApiEndpoint;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiConfig = new ApiConfig(this);
        mApiKey = mApiConfig.getTheySaidSoApiKey();
        mApiEndpoint = mApiConfig.getmTheySaidSoEndpoint();

        TheySaidSoApi api = buildApi();

        // Construct services
        mCategoryService = new CategoryService(api, mBus);
        mQuoteService = new QuoteService(api, mBus);

        // Register services
        mBus.register(mCategoryService);
        mBus.register(mQuoteService);

        mBus.register(this); //listen for "global" events
    }

    private TheySaidSoApi buildApi() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ListContents.class, new ListContentsAdapter());
        Gson gson = gsonBuilder.create();

        // Add headers to request
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("X-Mashape-Key", mApiKey)
                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        return new Retrofit.Builder()
                .baseUrl(mApiEndpoint)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build()
                .create(TheySaidSoApi.class);
    }

    @Subscribe
    public void onApiError(ApiErrorEvent event) {
        Toast.makeText(ProfoundApplication.this, "Something went wrong, please try again.", Toast.LENGTH_SHORT).show();
        Log.e("Profound", event.getMessage());
    }
}
