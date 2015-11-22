package com.poliyguus.profound.app.config;

import android.content.Context;

import com.github.fernandodev.androidproperties.lib.AssetsProperties;
import com.github.fernandodev.androidproperties.lib.Property;

/**
 * Config file used for api properties. Found at
 *
 *
 * Created by Guus on 22/11/2015.
 */
public class ApiConfig extends AssetsProperties {

    @Property("mashape-theysaidso-api-key") String mTheySaidSoApiKey;
    @Property("mashape-theysaidso-api-endpoint") String mTheySaidSoEndpoint;

    public ApiConfig(Context context) {
        // Change second parameter to "api-config" and edit the file when API key/endpoint change.
        // File can be found in "app/src/main/assets/" directory.
        super(context, "poliyguus-api-config");
    }

    public String getTheySaidSoApiKey() {
        return mTheySaidSoApiKey;
    }

    public String getmTheySaidSoEndpoint() {
        return mTheySaidSoEndpoint;
    }
}
