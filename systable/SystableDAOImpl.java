package com.ips.gateway.service.dao.systable;


import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class SystableDAOImpl implements SystableDAO {
	
	private static final String SQL_REQUEST_CREATE_ENTITY = "INSERT INTO `ips_test`.`systable` (`field_uuid`, `entity_name`, `field_name`, `regex_mask`, `encrypted`, `created_at`, `modified_at`, `created_by`, `modified_by`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_REQUEST_UPDATE_ENTITY = "UPDATE `ips_test`.`systable` SET `entity_name` = ?, `field_name` = ?, `regex_mask` = ?, `encrypted` = ?,`modified_at` = ?, `modified_by` = ? WHERE (`entity_name` = ?)";
	private static final String SQL_REQUEST_DELETE_ENTITY = "DELETE FROM `ips_test`.`systable` WHERE (`entity_name` = ?);";
	private static final String SQL_REQUEST_FIND_BY_ENTITY_NAME = "select field_uuid, field_name, regex_mask, encrypted, created_at, modified_at, created_by, modified_by from ips_test.systable where entity_name = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RowMapper<SystableEntity> rowMapper;
	
	@Override
	public SystableEntity findByEntityName(String entityName) throws DataAccessException { // method take user(or service) requests and do new systable object based on data, it takes from database
		SystableEntity entity = new SystableEntity(); // initializing our systable object
				/*
		 * Request all data for object with entity_name = EntityName. After that our RowMapper add data to systable object 
		 */
	    entity = jdbcTemplate.queryForObject(SQL_REQUEST_FIND_BY_ENTITY_NAME, rowMapper, entityName); // entityName may not be initialized!
		return entity;
	}
	
	@Override
	public boolean create(SystableEntity entity) throws DataAccessException {
		// дополнить генерацию ююид и возможно перенести её в конструктор класса systable
		// Maybe we need to generate id too. The question is how.
		entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		entity.setUUID(UUID.randomUUID().toString()); // generating UUID for object
		//creating new data in database
		int rows = jdbcTemplate.update(SQL_REQUEST_CREATE_ENTITY,
				entity.getUUID(),
				entity.getEntityName(),
				entity.getFieldName(), 
				entity.getRegexMask(),
				entity.isEncrypted(),
				entity.getCreatedAt(),
				entity.getModifiedAt(),
				entity.getCreatedBy(),
				entity.getModifiedBy());
		
		return rows == 1 ? true : false; // нужен ли тут boolean?
	}

	@Override
	public boolean delete(String entityName) throws DataAccessException {
		// Now this method delete all data in database, that contains object with that id
		int rows = jdbcTemplate.update(SQL_REQUEST_DELETE_ENTITY, entityName);
		return rows == 1 ? true : false;
	}

	@Override
	public boolean update(String entityName, SystableEntity updatedEntity) throws DataAccessException {
		//updating database
		updatedEntity.setModifiedAt(new Timestamp(System.currentTimeMillis())); // we set time when it was modified
		int rows = jdbcTemplate.update(SQL_REQUEST_UPDATE_ENTITY,
				updatedEntity.getEntityName(),
				updatedEntity.getFieldName(), 
				updatedEntity.getRegexMask(),
				updatedEntity.isEncrypted(),
				updatedEntity.getModifiedAt(),
				updatedEntity.getModifiedBy(),
				entityName);
		return rows == 1 ? true : false;
	}
	
}
