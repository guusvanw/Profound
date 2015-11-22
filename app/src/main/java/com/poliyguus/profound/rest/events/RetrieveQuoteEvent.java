package com.poliyguus.profound.rest.events;

import java.util.List;

/**
 * The event kicking of author retrieval
 * Created by Guus on 21/11/2015.
 */
public class RetrieveQuoteEvent {

    private String mCategory;

    public RetrieveQuoteEvent(String category) {
        this.mCategory = category;
    }

    public String getCategory() {
        return mCategory;
    }
}
