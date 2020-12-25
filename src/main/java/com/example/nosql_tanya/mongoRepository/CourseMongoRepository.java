package com.example.nosql_tanya.mongoRepository;

import com.example.nosql_tanya.Agg;
import com.example.nosql_tanya.document.CourseMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseMongoRepository extends MongoRepository<CourseMongo, String> {
    @Aggregation("{ $group: {_id :'$course', money : {$sum : '$price'}  } }")
    Double sumAllCoursePrice();

    @Aggregation("{ $group: {_id : '$author.name', money : {$sum : '$price'}  } }")
    List<Agg> sumAllCoursePriceByAuthor();

    @Aggregation("{ $group: {_id :'$category.name', count  : {$sum : 1}  } }")
    List<Agg> countByCategory();

    @Aggregation("{ $group: {_id :'$type.name', count  : {$sum : 1}  } }")
    List<Agg> countByType();

    @Aggregation(pipeline ={"{ $group: { id :'$category.name' , money : {$max : '$price'}  } }","{$match: { 'money':{$gte:5000 }}}"})
    List<Agg> maxPriceInCategory();


}
