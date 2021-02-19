package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.StudentDTO;
import com.alasdoo.developercourseassignment.entity.Student;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;
import com.alasdoo.developercourseassignment.mapper.StudentMapper;
import com.alasdoo.developercourseassignment.repository.StudentRepository;
import com.alasdoo.developercourseassignment.service.StudentService;
import com.alasdoo.developercourseassignment.utils.RandomString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private StudentDeveloperCourseServiceImpl studentDeveloperCourseServiceImpl;

	@Override
	public StudentDTO findOne(Integer id) throws ResourceNotFoundException {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Student not found.");
		}
		return studentMapper.transformToDTO(student.get());
	}

	@Override
	public List<StudentDTO> findAll() {
		return studentRepository.findAll().stream().map(i -> studentMapper.transformToDTO(i))
				.collect(Collectors.toList());
	}

	@Override
	public StudentDTO save(StudentDTO studentDTO) {
		Student student = studentMapper.transformToEntity(studentDTO);
		student.setPassword(RandomString.generateRandomString());
		return studentMapper.transformToDTO(studentRepository.save(student));
	}

	@Transactional
	@Override
	public void remove(Integer id) throws IllegalArgumentException, ResourceNotFoundException {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Student not found.");
		}

		// when deleting student it has to be deleted from student developer course
		studentDeveloperCourseServiceImpl.deleteStudentDeveloperCoursesByStudentId(id);
		studentRepository.deleteById(id);
	}

	@Override
	public StudentDTO update(Integer id, StudentDTO studentDTO) throws ResourceNotFoundException {
		Optional<Student> oldStudent = studentRepository.findById(id);
		if (!oldStudent.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Student not found.");
		}
		oldStudent.get().setName(studentDTO.getName());
		oldStudent.get().setSurname(studentDTO.getSurname());
		// oldStudent.get().setAccountName(studentDTO.getAccountName());
		// oldStudent.get().setPassword(studentDTO.getPassword());
		oldStudent.get().setEmail(studentDTO.getEmail());
		// oldStudent.get().setBankCardNumber(studentDTO.getBankCardNumber());
		studentRepository.save(oldStudent.get());
		return studentMapper.transformToDTO(oldStudent.get());
	}

	@Override
	public StudentDTO findByAccountName(String accountName) throws ResourceNotFoundException {
		Optional<Student> student = studentRepository.findByAccountName(accountName);
		if (!student.isPresent()) {
			throw new ResourceNotFoundException(accountName, "Student not found.");
		}
		return studentMapper.transformToDTO(student.get());
	}

	@Override
	public StudentDTO findByAccountNameAndPassword(String accountName, String password)
			throws ResourceNotFoundException {
		Optional<Student> student = studentRepository.findByAccountNameAndPassword(accountName, password);
		if (!student.isPresent()) {
			throw new ResourceNotFoundException(accountName + " " + password, "Student not found.");
		}
		return studentMapper.transformToDTO(student.get());
	}
}
