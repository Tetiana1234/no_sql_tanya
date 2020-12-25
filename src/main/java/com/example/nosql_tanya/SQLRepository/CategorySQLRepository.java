package com.example.nosql_tanya.SQLRepository;

import com.example.nosql_tanya.entity.CategorySQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorySQLRepository extends JpaRepository<CategorySQL, Integer> {


    List<CategorySQL> findAllByName(String name);

    List<CategorySQL> findFirst100ByName(String name);
}
