package com.poliyguus.profound.rest.model.theysaidso.adapters;

import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.poliyguus.profound.rest.model.theysaidso.ListContents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Guus on 21/11/2015.
 */
public class ListContentsAdapter extends TypeAdapter<ListContents> {

    private Gson mGson = new Gson();

    /**
     * Writes one JSON value (an array, object, string, number, boolean or null)
     * for {@code value}.
     *
     * @param out
     * @param value the Java object to write. May be null.
     */
    @Override
    public void write(JsonWriter out, ListContents value) throws IOException {
        mGson.toJson(value, ListContents.class, out);
    }

    /**
     * Reads one JSON value (an array, object, string, number, boolean or null)
     * and converts it to a Java object. Returns the converted object.
     *
     * @param in
     * @return the converted Java object. May be null.
     */
    @Override
    public ListContents read(JsonReader in) throws IOException {

        ListContents contents = new ListContents();
        List<String> categories = new ArrayList<>();

        in.beginObject(); // {
        in.nextName(); // categories
        in.beginObject(); // {

        while (in.hasNext()) {
            if(in.peek() != JsonToken.NULL) {
                categories.add(in.nextName());
            }
            else {
                in.skipValue();
            }
        }

        in.endObject(); // }
        in.endObject(); // }
        //in.endObject(); // }
        //in.close();

        contents.setContents(categories);

        return contents;
    }
}
