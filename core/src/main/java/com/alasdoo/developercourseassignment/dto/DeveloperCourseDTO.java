package com.alasdoo.developercourseassignment.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class DeveloperCourseDTO implements Serializable {

	private Integer id;

	@NotBlank(message = "Please, enter a developer course name.")
	@Length(max = 250, message = "Developer course name cannot be longer than 250.")
	private String developerCourseName;

	@NotNull(message = "Plese, enter cost per class.")
	@Min(value = 1, message = "Cost per class must be at least 1.")
	private Integer costPerClass;

	@NotNull(message = "Plese, enter how many classes per week.")
	@Min(value = 1, message = "Class per week must be at least 1.")
	private Integer classesPerWeek;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeveloperCourseName() {
		return developerCourseName;
	}

	public void setDeveloperCourseName(String developerCourseName) {
		this.developerCourseName = developerCourseName;
	}

	public Integer getCostPerClass() {
		return costPerClass;
	}

	public void setCostPerClass(Integer costPerClass) {
		this.costPerClass = costPerClass;
	}

	public Integer getClassesPerWeek() {
		return classesPerWeek;
	}

	public void setClassesPerWeek(Integer classesPerWeek) {
		this.classesPerWeek = classesPerWeek;
	}
}
