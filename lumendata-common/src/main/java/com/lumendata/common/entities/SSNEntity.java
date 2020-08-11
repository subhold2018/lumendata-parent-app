package com.lumendata.common.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "SSN")
public class SSNEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String ssn;
	
	@Relationship(type = "HAS_SOURCE", direction = Relationship.OUTGOING)
	private SourceEntity source;

	public SSNEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SSNEntity(Long id, String ssn, SourceEntity source) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public SourceEntity getSource() {
		return source;
	}

	public void setSource(SourceEntity source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "SSNEntity [id=" + id + ", ssn=" + ssn + ", source=" + source + "]";
	}
	
}
