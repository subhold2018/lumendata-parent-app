
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
    "AddrLine1",
    "AddrLine2",
    "City",
    "State",
    "ZIP",
    "Type",
    "Primary",
    "Created",
    "Updated",
    "Source",
    "SRCId"
})
public class Address {

    @JsonProperty("AddrLine1")
    private String addrLine1;
    @JsonProperty("AddrLine2")
    private String addrLine2;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("ZIP")
    private String zIP;
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

    @JsonProperty("AddrLine1")
    public String getAddrLine1() {
        return addrLine1;
    }

    @JsonProperty("AddrLine1")
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    @JsonProperty("AddrLine2")
    public String getAddrLine2() {
        return addrLine2;
    }

    @JsonProperty("AddrLine2")
    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("ZIP")
    public String getZIP() {
        return zIP;
    }

    @JsonProperty("ZIP")
    public void setZIP(String zIP) {
        this.zIP = zIP;
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
