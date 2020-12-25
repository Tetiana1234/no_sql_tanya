package com.example.nosql_tanya.mongoRepository;

import com.example.nosql_tanya.document.CategoryMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryMongoRepository extends MongoRepository<CategoryMongo, String> {
    List<CategoryMongo> findAllByName(String name);

    List<CategoryMongo> findFirst100ByName(String name);
}
