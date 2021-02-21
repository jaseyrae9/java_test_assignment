package com.alasdoo.developercourseassignment.dto;

import javax.validation.constraints.NotNull;

public class StudentDeveloperCourseDTO {

	private Integer id;

	@NotNull(message = "Student must be enetered.")
	private Integer studentId;

	@NotNull(message = "Developer class must be enetered.")
	private Integer developerCourseId;

	@NotNull(message = "Plese, enter for how many classes are bought.")
	private Integer classesBought;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getDeveloperCourseId() {
		return developerCourseId;
	}

	public void setDeveloperCourseId(Integer developerCourseId) {
		this.developerCourseId = developerCourseId;
	}

	public Integer getClassesBought() {
		return classesBought;
	}

	public void setClassesBought(Integer classesBought) {
		this.classesBought = classesBought;
	}
}
