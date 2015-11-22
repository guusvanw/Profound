package com.poliyguus.profound.rest.events;

import com.poliyguus.profound.rest.model.theysaidso.QuoteResponse;

/**
 * Created by Guus on 21/11/2015.
 */
public class QuoteRetrievedEvent {

    /**
     * The author list retrieved
     */
    public final QuoteResponse mQuoteResponse;

    /**
     * Constructor
     * @param quoteResponse
     */
    public QuoteRetrievedEvent(QuoteResponse quoteResponse) {
        this.mQuoteResponse = quoteResponse;
    }

    public QuoteResponse getQuoteResponse() {
        return mQuoteResponse;
    }
}
