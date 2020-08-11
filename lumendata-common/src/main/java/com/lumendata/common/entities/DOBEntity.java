package com.lumendata.common.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "DOB")
public class DOBEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String dob;

	@Relationship(type = "HAS_SOURCE", direction = Relationship.OUTGOING)
	private SourceEntity source;

	public DOBEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DOBEntity(Long id, String dob, SourceEntity source) {
		super();
		this.id = id;
		this.dob = dob;
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public SourceEntity getSource() {
		return source;
	}

	public void setSource(SourceEntity source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "DOBEntity [id=" + id + ", dob=" + dob + ", source=" + source + "]";
	}

}
