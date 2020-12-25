package com.example.nosql_tanya.document;


import com.example.nosql_tanya.entity.AuthorSQL;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Author")
public class AuthorMongo {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "info")
    private String info;


    @Field(name = "income")
    private Double income;

    public AuthorMongo() {
    }
    public AuthorMongo(AuthorSQL a) {
        this.id = a.getId().toString();
        this.name = a.getName();
        this.info = a.getInfo();
        this.income = a.getIncome();
    }

    public AuthorMongo(String id, String name, String info, Double income) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.income = income;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

   public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }


    @Override
    public String toString() {
        return "AuthorMongo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", income=" + income +
                '}';
    }
}

