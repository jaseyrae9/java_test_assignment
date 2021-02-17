package com.alasdoo.developercourseassignment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;

@Service
public class TeacherServiceImpl {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private TeacherMapper teacherMapper;

    public TeacherDTO findOne(Integer id) {
    	Optional<Teacher> teacher = teacherRepository.findById(id);
		if (!teacher.isPresent()) {
			throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found.");
		}
		return teacherMapper.transformToDTO(teacher.get());
    }

    public List<TeacherDTO> findAll() {
        return null;
    }

    public TeacherDTO save(TeacherDTO teacherDTO) {
        return null;
    }

    public void remove(Integer id) throws IllegalArgumentException {
    }

    public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
        return null;
    }

    public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
        return null;
    }

    public TeacherDTO findByTeacherEmail(String email) {
        return null;
    }
}
