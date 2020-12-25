package com.example.nosql_tanya.entity;



import com.example.nosql_tanya.document.CategoryMongo;

import javax.persistence.*;
import java.util.List;

@Entity
public class CategorySQL {
    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "categorySQL", fetch = FetchType.LAZY)
    private List<CourseSQL> courseSQLS;

    public CategorySQL() {
    }
    public CategorySQL(CategoryMongo c) {
        this.id = Integer.parseInt(c.getId());
        this.name = c.getName();
        this.description = c.getDescription();
    }
    public CategorySQL(Integer id, String name, String description) {
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

    public List<CourseSQL> getCourseSQLS() {
        return courseSQLS;
    }

    public void setCourseSQLS(List<CourseSQL> courseSQLS) {
        this.courseSQLS = courseSQLS;
    }

    @Override
    public String toString() {
        return "CategorySQL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", courseSQLS=" + courseSQLS +
                '}';
    }
}

