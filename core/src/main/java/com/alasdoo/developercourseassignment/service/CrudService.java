package com.alasdoo.developercourseassignment.service;

import java.util.List;

import com.alasdoo.developercourseassignment.exceptions.RequestDataException;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;

public interface CrudService<DTO> {

	/**
	 * Find and return entity with passed id.
	 *
	 * @param id of the entity to return
	 * @return entity with passed id or null if not found
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	DTO findOne(Integer id) throws ResourceNotFoundException;

	/**
	 * Return back all existing entities.
	 *
	 * @return list of existing entities, empty list if there are no entities
	 */
	List<DTO> findAll();

	/**
	 * Save entity and return saved instance (with id set).
	 *
	 * @param dto to be saved
	 * @return saved instance
	 * @throws RequestDataException      if data passed within the request is
	 *                                   incorrect
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	DTO save(DTO dto) throws RequestDataException, ResourceNotFoundException;

	/**
	 * Remove entity with passed id.
	 *
	 * @param id of the entity to be removed
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	void remove(Integer id) throws ResourceNotFoundException;

	/**
	 *
	 * Update entity with passed id and entity.
	 *
	 * @param id and entity id is used to recognize which entity should be updated
	 *           with the entity provided
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	DTO update(Integer id, DTO dto) throws ResourceNotFoundException;

}
