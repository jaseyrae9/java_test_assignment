package com.alasdoo.developercourseassignment.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.alasdoo.developercourseassignment.dto.TeacherDeveloperCourseDTO;
import com.alasdoo.developercourseassignment.entity.TeacherDeveloperCourse;

@Component
public class TeacherDeveloperCourseMapper {

    public TeacherDeveloperCourseDTO transformToDTO(TeacherDeveloperCourse teacherDeveloperCourseSrc) {
        TeacherDeveloperCourseDTO teacherDeveloperCourseDTO = new TeacherDeveloperCourseDTO();
        BeanUtils.copyProperties(teacherDeveloperCourseSrc, teacherDeveloperCourseDTO);
        return teacherDeveloperCourseDTO;
    }

    public TeacherDeveloperCourse transformToEntity(TeacherDeveloperCourseDTO teacherDeveloperCourseDTOSrc) {
        TeacherDeveloperCourse teacherDeveloperCourse = new TeacherDeveloperCourse();
        BeanUtils.copyProperties(teacherDeveloperCourseDTOSrc, teacherDeveloperCourse);
        return teacherDeveloperCourse;
    }
    
    public List<TeacherDeveloperCourseDTO> transformToListOfDTO(List<TeacherDeveloperCourse> teacherDeveloperCourseSrc) {
        List<TeacherDeveloperCourseDTO> teacherDeveloperCourseDTO = new ArrayList<>(teacherDeveloperCourseSrc.size());
        for (TeacherDeveloperCourse teacherDeveloperCourse : teacherDeveloperCourseSrc) {
        	teacherDeveloperCourseDTO.add(transformToDTO(teacherDeveloperCourse));
        }
        return teacherDeveloperCourseDTO;
    }
    
    public List<TeacherDeveloperCourse> transformToListOfEntity(List<TeacherDeveloperCourseDTO> dtos) {
    	List<TeacherDeveloperCourse> ret = new ArrayList<>(dtos.size());
    	for(TeacherDeveloperCourseDTO dto: dtos) {
    		ret.add(transformToEntity(dto));
    	}
    	return ret;
    }
}

