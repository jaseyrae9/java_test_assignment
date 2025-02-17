package com.alasdoo.developercourseassignment.dto;

import javax.validation.constraints.NotNull;

public class TeacherDeveloperCourseDTO {

	private Integer id;

	@NotNull(message = "Developer class must be enetered.")
	private Integer developerCourseId;

	@NotNull(message = "Student must be enetered.")
	private Integer teacherId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDeveloperCourseId() {
		return developerCourseId;
	}

	public void setDeveloperCourseId(Integer developerCourseId) {
		this.developerCourseId = developerCourseId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer developerCourseTeacherId) {
		this.teacherId = developerCourseTeacherId;
	}
}
