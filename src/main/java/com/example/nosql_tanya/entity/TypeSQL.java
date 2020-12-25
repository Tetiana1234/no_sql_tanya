package com.example.nosql_tanya.entity;

import com.example.nosql_tanya.document.TypeMongo;

import javax.persistence.*;
import java.util.List;


@Entity
public class TypeSQL {
    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "typeSQL", fetch = FetchType.LAZY)
    private List<CourseSQL> coursesSQL;


    public TypeSQL() {
    }

    public TypeSQL(TypeMongo t) {
        this.id = Integer.parseInt(t.getId());
        this.name = t.getName();
        this.description = t.getDescription();
    }
    public TypeSQL(Integer id, String name, String description, AuthorSQL authorSQL) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "TypeSQL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description +
                '}';
    }
}
