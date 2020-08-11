package com.lumendata.common.entities;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * @author jeetu
 */
@NodeEntity(label = "Customer")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerEntity {
	@Id
	private String guid;

	@Relationship(type = "HAS_NAME", direction = Relationship.OUTGOING)
    private List<NameEntity> names;

	@Relationship(type = "HAS_PHONE", direction = Relationship.OUTGOING)
    private List<PhoneEntity> phones;

	@Relationship(type = "HAS_EMAIL", direction = Relationship.OUTGOING)
    private List<EmailEntity> emails;

	@Relationship(type = "HAS_ADDRESS", direction = Relationship.OUTGOING)
	private List<AddressEntity> addresses;
	
	@Relationship(type = "HAS_DOB", direction = Relationship.OUTGOING)
	private DOBEntity dobEntity;
	
	@Relationship(type = "HAS_SSN", direction = Relationship.OUTGOING)
	private SSNEntity ssnEntity;

	public CustomerEntity() {
		super();
	}
	
	public CustomerEntity(String guid, List<NameEntity> names, List<PhoneEntity> phones,
			List<EmailEntity> emails, List<AddressEntity> addresses, DOBEntity dobEntity, SSNEntity ssnEntity) {
		super();
		this.guid = guid;
		this.names = names;
		this.phones = phones;
		this.emails = emails;
		this.addresses = addresses;
		this.dobEntity = dobEntity;
		this.ssnEntity = ssnEntity;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public List<NameEntity> getNames() {
		return names;
	}

	public void setNames(List<NameEntity> names) {
		this.names = names;
	}

	public List<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
	}

	public List<EmailEntity> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailEntity> emails) {
		this.emails = emails;
	}

	public List<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	public DOBEntity getDobEntity() {
		return dobEntity;
	}

	public void setDobEntity(DOBEntity dobEntity) {
		this.dobEntity = dobEntity;
	}

	public SSNEntity getSsnEntity() {
		return ssnEntity;
	}

	public void setSsnEntity(SSNEntity ssnEntity) {
		this.ssnEntity = ssnEntity;
	}

	@Override
	public String toString() {
		return "CustomerEntity [guid=" + guid + ", names=" + names + ", phones="
				+ phones + ", emails=" + emails + ", addresses=" + addresses + ", dobEntity=" + dobEntity
				+ ", ssnEntity=" + ssnEntity + "]";
	}
    
}
