package com.alasdoo.developercourseassignment.repository;

import com.alasdoo.developercourseassignment.entity.DeveloperCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperCourseRepository extends JpaRepository<DeveloperCourse, Integer> {

	Optional<List<DeveloperCourse>> findByDeveloperCourseName(String developerCourseName);

	@Query(value = "SELECT dc.id, dc.classes_per_week, dc.cost_per_class, dc.developer_course_name "
			+ "FROM developer_course dc " + "JOIN student_developer_course s "
			+ "ON s.student_id = :id and dc.id = s.developer_course_id", nativeQuery = true)
	Optional<List<DeveloperCourse>> findDevCourseByStudentId(@Param("id") Integer id);

	@Query(value = "SELECT dc.id, dc.classes_per_week, dc.cost_per_class, dc.developer_course_name "
			+ "FROM developer_course dc " + "JOIN teacher_developer_course t "
			+ "ON t.teacher_id = :id and dc.id = t.developer_course_id", nativeQuery = true)
	Optional<List<DeveloperCourse>> findDevCourseByTeacherId(@Param("id") Integer id);

}
