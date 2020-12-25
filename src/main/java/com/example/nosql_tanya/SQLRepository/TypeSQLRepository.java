package com.example.nosql_tanya.SQLRepository;



import com.example.nosql_tanya.entity.TypeSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSQLRepository extends JpaRepository<TypeSQL, Integer> {

}
