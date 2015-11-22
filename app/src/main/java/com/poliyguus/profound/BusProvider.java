package com.poliyguus.profound;

import com.squareup.otto.Bus;

/**
 * The bus provider singleton
 * Created by Guus on 21/11/2015.
 */
public final class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // No instances
    }
}
