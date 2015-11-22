package com.poliyguus.profound.main;

import java.util.List;

/**
 * Created by Guus on 17/11/2015.
 */
public interface MainView {

    public void showProgress();

    public void hideProgress();

    public void setItems(List<String> items);

    public void showMessage(String message);
}
