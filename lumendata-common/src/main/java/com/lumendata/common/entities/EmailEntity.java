package com.lumendata.common.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
/**
 * @author jeetu
 */
@NodeEntity(label = "Email")
public class EmailEntity {
	@Id
	@GeneratedValue
	private Long id;
    private String email;
    private String type;
    private String primary;

    @Relationship(type = "HAS_SOURCE", direction = Relationship.OUTGOING)
    private SourceEntity source;
    
	public EmailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmailEntity(Long id, String email, String type, String primary, SourceEntity source) {
		super();
		this.id = id;
		this.email = email;
		this.type = type;
		this.primary = primary;
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

	public SourceEntity getSource() {
		return source;
	}

	public void setSource(SourceEntity source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "EmailEntity [id=" + id + ", email=" + email + ", type=" + type + ", primary=" + primary
				+ ", source=" + source + "]";
	}

}
