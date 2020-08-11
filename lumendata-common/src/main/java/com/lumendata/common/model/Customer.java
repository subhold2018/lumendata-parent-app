
package com.lumendata.common.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Source",
    "SRCId",
    "Created",
    "Updated",
    "dob",
    "Name",
    "SSN",
    "Phone",
    "Email",
    "Address"
})
public class Customer {

    @JsonProperty("Source")
    private String source;
    @JsonProperty("SRCId")
    private String sRCId;
    @JsonProperty("Created")
    private String created;
    @JsonProperty("Updated")
    private String updated;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("Name")
    private List<Name> name = null;
    @JsonProperty("SSN")
    private String sSN;
    @JsonProperty("Phone")
    private List<Phone> phone = null;
    @JsonProperty("Email")
    private List<Email> email = null;
    @JsonProperty("Address")
    private List<Address> address = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("dob")
    public String getDob() {
        return dob;
    }

    @JsonProperty("dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @JsonProperty("Name")
    public List<Name> getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(List<Name> name) {
        this.name = name;
    }

    @JsonProperty("SSN")
    public String getSSN() {
        return sSN;
    }

    @JsonProperty("SSN")
    public void setSSN(String sSN) {
        this.sSN = sSN;
    }

    @JsonProperty("Phone")
    public List<Phone> getPhone() {
        return phone;
    }

    @JsonProperty("Phone")
    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    @JsonProperty("Email")
    public List<Email> getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(List<Email> email) {
        this.email = email;
    }

    @JsonProperty("Address")
    public List<Address> getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(List<Address> address) {
        this.address = address;
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
