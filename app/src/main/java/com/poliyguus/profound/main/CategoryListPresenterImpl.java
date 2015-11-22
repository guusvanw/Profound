package com.poliyguus.profound.main;

import com.poliyguus.profound.BusProvider;
import com.poliyguus.profound.rest.events.AuthorsRetrievedEvent;
import com.poliyguus.profound.rest.events.CategoriesRetrievedEvent;
import com.poliyguus.profound.rest.events.QuoteRetrievedEvent;
import com.poliyguus.profound.rest.events.RetrieveAuthorsEvent;
import com.poliyguus.profound.rest.events.RetrieveCategoriesEvent;
import com.poliyguus.profound.rest.events.RetrieveQuoteEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Created by Guus on 21/11/2015.
 */
public class CategoryListPresenterImpl implements CategoryListPresenter {

    private Bus mBus;

    private MainView mMainView;

    public CategoryListPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    /**
     * The logic to execute in the onResume event.
     */
    @Override
    public void onResume() {
        mMainView.showProgress();

        getBus().register(this);
        getBus().post(new RetrieveCategoriesEvent());
    }

    /**
     * The logic to execute when an item in the main list is clicked.
     *
     * @param category the category selected
     */
    @Override
    public void onItemClicked(String category) {
        mBus.post(new RetrieveQuoteEvent(category));
    }

    /**
     * The logic to execute when authors have been retrieved.
     *
     * @param event
     */
    @Subscribe
    @Override
    public void onCategoriesRetrieved(CategoriesRetrievedEvent event) {
        mMainView.setItems(event.getCategoriesResponse().getListContents().getContents());
        mMainView.hideProgress();
    }

    /**
     * The logic to execute when a quote has been retrieved
     *
     * @param event
     */
    @Subscribe
    @Override
    public void onQuoteRetrieved(QuoteRetrievedEvent event) {
        mMainView.showMessage(event.getQuoteResponse().getContents().getQuote());
    }

    // Use some kind of injection, so that we can swap in a mock for tests.
    // Here we just use simple getter/setter injection for simplicity.
    private Bus getBus() {
        if (mBus == null) {
            mBus = BusProvider.getInstance();
        }
        return mBus;
    }

    public void setBus(Bus bus) {
        mBus = bus;
    }
}
