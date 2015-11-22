package com.poliyguus.profound.rest.events;

import com.poliyguus.profound.rest.model.theysaidso.AuthorsResponse;

/**
 * Created by Guus on 21/11/2015.
 */
public class AuthorsRetrievedEvent {

    /**
     * The author list retrieved
     */
    public final AuthorsResponse mAuthorsResponse;

    /**
     * Constructor
     * @param authorsResponse
     */
    public AuthorsRetrievedEvent(AuthorsResponse authorsResponse) {
        this.mAuthorsResponse = authorsResponse;
    }

    public AuthorsResponse getAuthorsResponse() {
        return mAuthorsResponse;
    }
}
