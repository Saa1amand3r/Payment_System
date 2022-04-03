package com.ips.gateway.service.dao.systable;

/**
 * @author Erik
 * This interface is used for interaction with database table "Systable".
 * 
 */

public interface SystableDAO {
	/**
	 * 
	 * @param entityName
	 * 		String with name of entity you search.
	 * @return systable
	 * 		This method returns you an object with some system information about entity.
	 * 		This object contains information like id, uuid, entity name, field name, regex mask, encryption, when it was created, modified and by who.
	 */
	SystableEntity findByEntityName(String entityName);
	
	/**
	 * 
	 * @param entity
	 * 		systable object (entity) which you want to add in database.
	 * @return boolean
	 * 		Method returns result of creating an object. True for successful, false for error.
	 */
	boolean create(SystableEntity entity);
	
	/**
	 * 
	 * @param entityName
	 * 		name of entity which you want to delete.
	 * @return boolean
	 * 		Method returns result of deleting an object. True for successful, false for error.
	 */
	boolean delete(String entityName);
	
	/**
	 * 
	 * @param entityName
	 * 		name of entity which you want to update.
	 * @param updatedEntity
	 * 		systable object (entity) with updated data.
	 * @return boolean
	 * 		Method returns result of updating an object. True for successful, false for error.
	 */
	boolean update(String entityName, SystableEntity updatedEntity);
	
	
}
