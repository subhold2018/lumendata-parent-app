
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
    "Phone",
    "Type",
    "Primary",
    "Created",
    "Updated",
    "Source",
    "SRCId"
})
public class Phone {

    @JsonProperty("Phone")
    private Long phone;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Primary")
    private String primary;
    @JsonProperty("Created")
    private String created;
    @JsonProperty("Updated")
    private String updated;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("SRCId")
    private String sRCId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Phone")
    public Long getPhone() {
        return phone;
    }

    @JsonProperty("Phone")
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Primary")
    public String getPrimary() {
        return primary;
    }

    @JsonProperty("Primary")
    public void setPrimary(String primary) {
        this.primary = primary;
    }

    @JsonProperty("Created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("Created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("Updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("Updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("SRCId")
    public String getSRCId() {
        return sRCId;
    }

    @JsonProperty("SRCId")
    public void setSRCId(String sRCId) {
        this.sRCId = sRCId;
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
