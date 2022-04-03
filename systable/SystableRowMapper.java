package com.ips.gateway.service.dao.systable;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Erik
 *	This class processing data, that we got from database and return systable.
 *  We need this class to do only one request to database and get all data, instead of doing a lot of request and creating systable object in SystableDAOImpl.
 */
@Component
public class SystableRowMapper implements RowMapper<SystableEntity> {
	
	@Override
	public SystableEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		SystableEntity Systable = new SystableEntity(); // create new object
		
		// setting our data
		Systable.setUUID(rs.getString("field_uuid"));
		Systable.setFieldName(rs.getString("field_name"));
		Systable.setRegexMask(rs.getString("regex_mask"));
		Systable.setEncrypted(rs.getBoolean("encrypted"));
		Systable.setCreatedAt(rs.getTimestamp("created_at"));
		Systable.setModifiedAt(rs.getTimestamp("modified_at"));
		Systable.setCreatedBy(rs.getLong("created_by"));
		Systable.setModifiedBy(rs.getLong("modified_by"));
		return Systable;
	}

}
