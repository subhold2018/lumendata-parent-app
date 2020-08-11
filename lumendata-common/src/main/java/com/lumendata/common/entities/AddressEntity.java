package com.lumendata.common.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author jeetu
 */
@NodeEntity(label = "Address")
public class AddressEntity {

	@Id
	@GeneratedValue
	private Long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private String type;
    private String primary;
    
    @Relationship(type = "HAS_SOURCE", direction = Relationship.OUTGOING)
    private SourceEntity source;
    
	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AddressEntity(Long id, String addressLine1, String addressLine2, String city, String state, String zipCode,
			String type, String primary, SourceEntity source) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.type = type;
		this.primary = primary;
		this.source = source;
	}

	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SourceEntity getSource() {
		return source;
	}

	public void setSource(SourceEntity source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", type=" + type + ", primary="
				+ primary + ", sourceEntity=" + source + "]";
	}

}

