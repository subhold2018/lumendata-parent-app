package com.lumendata.common.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
/**
 * @author jeetu
 */
@NodeEntity(label = "Phone")
public class PhoneEntity {
	@Id
	@GeneratedValue
	private Long id;
    private Long phone;
    private String type;
    private String primary;

    @Relationship(type = "HAS_SOURCE", direction = Relationship.OUTGOING)
    private SourceEntity source;

	public PhoneEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PhoneEntity(Long id, Long phone, String type, String primary, SourceEntity source) {
		super();
		this.id = id;
		this.phone = phone;
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

	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
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
		return "PhoneEntity [id=" + id + ", phone=" + phone + ", type=" + type + ", primary=" + primary
				+ ", source=" + source + "]";
	}

}
