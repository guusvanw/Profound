package com.poliyguus.profound.main;

import com.poliyguus.profound.rest.events.AuthorsRetrievedEvent;

/**
 * The main presenter contract
 * Created by Guus on 21/11/2015.
 */
public interface AuthorListPresenter {

    /**
     * The logic to execute in the onResume event.
     */
    public void onResume();

    /**
     * The logic to execute when an item in the main list is clicked.
     * @param position the position of the item clicked
     */
    public void onItemClicked(int position);

    /**
     * The logic to execute when authors have been retrieved.
     * @param event
     */
    void onAuthorsRetrieved(AuthorsRetrievedEvent event);
}
