package com.lumendata.common.entities;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
/**
 * @author jeetu
 */
@NodeEntity(label = "Source")
public class SourceEntity {
	@Id
    private String sourceId;
    private String createdDate;
    private String updatedDate;
    private String source;

    public SourceEntity() {
        super();
    }

    public SourceEntity(String sourceId, String createdDate, String updatedDate, String source) {
        super();
        this.sourceId = sourceId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.source = source;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Source{" +
                "sourceId='" + sourceId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
