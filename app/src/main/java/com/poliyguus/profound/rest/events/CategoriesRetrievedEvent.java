package com.poliyguus.profound.rest.events;

import com.poliyguus.profound.rest.model.theysaidso.CategoriesResponse;

/**
 * Created by Guus on 21/11/2015.
 */
public class CategoriesRetrievedEvent {

    /**
     * The author list retrieved
     */
    public final CategoriesResponse mCategoriesResponse;

    /**
     * Constructor
     * @param categoriesResponse
     */
    public CategoriesRetrievedEvent(CategoriesResponse categoriesResponse) {
        this.mCategoriesResponse = categoriesResponse;
    }

    public CategoriesResponse getCategoriesResponse() {
        return mCategoriesResponse;
    }
}
