package com.example.nosql_tanya.SQLRepository;


import com.example.nosql_tanya.entity.CourseSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSQLRepository extends JpaRepository<CourseSQL, Integer> {

}
