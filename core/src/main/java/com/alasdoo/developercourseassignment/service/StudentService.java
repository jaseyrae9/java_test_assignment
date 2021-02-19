package com.alasdoo.developercourseassignment.service;

import com.alasdoo.developercourseassignment.dto.StudentDTO;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;

public interface StudentService extends CrudService<StudentDTO> {

	StudentDTO findByAccountName(String accountName) throws ResourceNotFoundException;

	StudentDTO findByAccountNameAndPassword(String accountName, String password) throws ResourceNotFoundException;
}
