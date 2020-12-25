package com.example.nosql_tanya.SQLRepository;

import com.example.nosql_tanya.entity.AuthorSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorSQLRepository extends JpaRepository<AuthorSQL, Integer> {

    List<AuthorSQL> findAllByIncomeGreaterThan(Double income);

    @Transactional
    void deleteAllByIncomeLessThan(Double income);
}
