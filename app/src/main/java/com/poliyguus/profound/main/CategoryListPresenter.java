package com.poliyguus.profound.main;

import com.poliyguus.profound.rest.events.CategoriesRetrievedEvent;
import com.poliyguus.profound.rest.events.QuoteRetrievedEvent;

/**
 * The main presenter contract
 * Created by Guus on 21/11/2015.
 */
public interface CategoryListPresenter {

    /**
     * The logic to execute in the onResume event.
     */
    public void onResume();

    /**
     * The logic to execute when an item in the main list is clicked.
     * @param category the category for which to retrieve a quote
     */
    public void onItemClicked(String category);

    /**
     * The logic to execute when categories have been retrieved.
     * @param event
     */
    void onCategoriesRetrieved(CategoriesRetrievedEvent event);

    /**
     * The logic to execute when a quote has been retrieved
     * @param event
     */
    void onQuoteRetrieved(QuoteRetrievedEvent event);
}
