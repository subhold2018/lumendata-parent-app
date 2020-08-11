
package com.lumendata.common.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FN",
    "LN"
})
public class Name {

    @JsonProperty("FN")
    private String fN;
    @JsonProperty("LN")
    private String lN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FN")
    public String getFN() {
        return fN;
    }

    @JsonProperty("FN")
    public void setFN(String fN) {
        this.fN = fN;
    }

    @JsonProperty("LN")
    public String getLN() {
        return lN;
    }

    @JsonProperty("LN")
    public void setLN(String lN) {
        this.lN = lN;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
