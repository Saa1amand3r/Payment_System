package com.ips.gateway.service.dao.systable;

import java.sql.Timestamp;

public class SystableEntity {
	private String uuid;
	private String entityName;
	private String fieldName;
	private String regexMask;
	private boolean encrypted;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	private Long createdBy;
	private Long modifiedBy;
	
	public SystableEntity() {} 
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUUID() {
		return uuid;
	}

	public void setUUID(String uuid) {
		this.uuid = uuid;
	}
	
	public String getEntityName() {
		return entityName;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getRegexMask() {
		return regexMask;
	}
	
	public void setRegexMask(String regexMask) {
		this.regexMask = regexMask;
	}
	
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	public Long getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public boolean isEncrypted() {
		return encrypted;
	}
	
	public void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp timestamp) {
		this.createdAt = timestamp;
	}
	
	public Timestamp getModifiedAt() {
		return modifiedAt;
	}
	
	public void setModifiedAt(Timestamp timestamp) {
		this.modifiedAt = timestamp;
	}
	
}
