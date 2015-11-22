package com.poliyguus.profound.rest.model.theysaidso;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class QuoteResponse {

    private Success success;
    private QuoteContents contents;
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
     * The contents
     */
    public QuoteContents getContents() {
        return contents;
    }

    /**
     *
     * @param contents
     * The contents
     */
    public void setContents(QuoteContents contents) {
        this.contents = contents;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

