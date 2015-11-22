package com.poliyguus.profound.main;

import com.poliyguus.profound.BusProvider;
import com.poliyguus.profound.rest.events.AuthorsRetrievedEvent;
import com.poliyguus.profound.rest.events.RetrieveAuthorsEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * Created by Guus on 21/11/2015.
 */
public class AuthorListPresenterImpl implements AuthorListPresenter {

    private Bus mBus;

    private MainView mMainView;

    public AuthorListPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    /**
     * The logic to execute in the onResume event.
     */
    @Override
    public void onResume() {
        mMainView.showProgress();

        getBus().register(this);
        getBus().post(new RetrieveAuthorsEvent());
    }

    /**
     * The logic to execute when an item in the main list is clicked.
     *
     * @param position the position of the item clicked
     */
    @Override
    public void onItemClicked(int position) {
        mMainView.showMessage(String.format("Position %d clicked", position + 1));
    }

    /**
     * The logic to execute when authors have been retrieved.
     *
     * @param event
     */
    @Subscribe
    @Override
    public void onAuthorsRetrieved(AuthorsRetrievedEvent event) {
        mMainView.setItems(event.getAuthorsResponse().getListContents().getContents());
        mMainView.hideProgress();
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
