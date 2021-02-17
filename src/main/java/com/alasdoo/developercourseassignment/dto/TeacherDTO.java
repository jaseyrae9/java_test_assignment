package com.alasdoo.developercourseassignment.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TeacherDTO implements Serializable {

    private Integer id;
    
	@NotBlank(message = "Name can not be blank.")
    private String teacherName;
	
	@NotBlank(message = "Surname can not be blank.")
    private String teacherSurname;
	
    @NotBlank(message = "Email can not be blank.")
	@Email(message = "Email format is incorrect.")
    private String teacherEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }
}
