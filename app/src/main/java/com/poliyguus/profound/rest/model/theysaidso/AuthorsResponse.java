package com.poliyguus.profound.rest.model.theysaidso;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AuthorsResponse {

    private Success success;
    @SerializedName("contents")
    private ListContents listContents;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The success
     */
    public Success getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Success success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The listContents
     */
    public ListContents getListContents() {
        return listContents;
    }

    /**
     *
     * @param listContents
     * The listContents
     */
    public void setListContents(ListContents listContents) {
        this.listContents = listContents;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
