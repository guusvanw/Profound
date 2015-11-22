package com.poliyguus.profound.rest;

import com.poliyguus.profound.rest.model.theysaidso.AuthorsResponse;
import com.poliyguus.profound.rest.model.theysaidso.CategoriesResponse;
import com.poliyguus.profound.rest.model.theysaidso.QuoteResponse;

import java.util.Map;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by Guus on 21/11/2015.
 */
public interface TheySaidSoApi {
    @GET("authors")
    Call<AuthorsResponse> retrieveAuthors();

    @GET("categories")
    Call<CategoriesResponse> retrieveCategories();

    @GET("quote")
    Call<QuoteResponse> retrieveQuoteByCategory(@Query("category") String category);
}
