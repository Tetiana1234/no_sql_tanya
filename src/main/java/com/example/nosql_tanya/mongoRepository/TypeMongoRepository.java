package com.example.nosql_tanya.mongoRepository;

import com.example.nosql_tanya.document.TypeMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeMongoRepository extends MongoRepository<TypeMongo, String> {


}
