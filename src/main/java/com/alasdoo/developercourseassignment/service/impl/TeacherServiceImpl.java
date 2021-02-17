package com.alasdoo.developercourseassignment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		return teacherRepository.findAll().stream().map(t -> teacherMapper.transformToDTO(t))
				.collect(Collectors.toList());
	}

	public TeacherDTO save(TeacherDTO teacherDTO) {
		Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
		return teacherMapper.transformToDTO(teacherRepository.save(teacher));
	}

	public void remove(Integer id) throws IllegalArgumentException {
		Optional<Teacher> teacher = teacherRepository.findById(id);
		if (!teacher.isPresent()) {
			throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found.");
		}
		teacherRepository.deleteById(id);
	}

	public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
		Optional<Teacher> oldTeacherOpt = teacherRepository.findById(id);
		if (!oldTeacherOpt.isPresent()) {
			throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found.");
		}
		Teacher oldTeacher = oldTeacherOpt.get();
		oldTeacher.setTeacherName(teacherDTO.getTeacherName());
		oldTeacher.setTeacherSurname(teacherDTO.getTeacherSurname());
		oldTeacher.setTeacherEmail(teacherDTO.getTeacherEmail());
		teacherRepository.save(oldTeacher);
		return teacherMapper.transformToDTO(oldTeacher);
	}

	public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
		return null;
	}

	public TeacherDTO findByTeacherEmail(String email) {
		return null;
	}
}
