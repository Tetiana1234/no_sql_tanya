package com.example.nosql_tanya.mongoRepository;


import com.example.nosql_tanya.document.AuthorMongo;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorMongoRepository extends MongoRepository<AuthorMongo, String> {

    List<AuthorMongo> findAllByIncomeGreaterThan(Double income);

    @Transactional
    void deleteAllByIncomeLessThan(Double income);
}
