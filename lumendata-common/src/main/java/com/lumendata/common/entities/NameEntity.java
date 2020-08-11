package com.lumendata.common.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
/**
 * @author jeetu
 */
@NodeEntity(label = "Name")
public class NameEntity {
	
	@Id
	@GeneratedValue
	private Long id;
    private String firstName;
    private String lastName;
    
    @Relationship(type = "HAS_SOURCE", direction = Relationship.OUTGOING)
    private SourceEntity source;
    
	public NameEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NameEntity(Long id, String firstName, String lastName, SourceEntity source) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public SourceEntity getSource() {
		return source;
	}

	public void setSource(SourceEntity source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "NameEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", source=" + source
				+ "]";
	}
    
}
