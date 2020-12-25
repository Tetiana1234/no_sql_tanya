package com.example.nosql_tanya.entity;


import com.example.nosql_tanya.document.AuthorMongo;

import javax.persistence.*;
import java.util.List;

@Entity
public class AuthorSQL {
    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "info", nullable = false)
    private String info;

    @Column(name = "income", nullable = false)
    private Double income;

    @OneToMany(mappedBy = "authorSQL", fetch = FetchType.LAZY)
    private List<CourseSQL> courseSQLS;

    public AuthorSQL() {
    }

    public AuthorSQL(AuthorMongo a) {
        this.id = Integer.parseInt(a.getId());
        this.name = a.getName();
        this.info = a.getInfo();
        this.income = a.getIncome();
    }

    public AuthorSQL(Integer id, String name, String info, Double income) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.income = income;
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

    public List<CourseSQL> getCourseSQLS() {
        return courseSQLS;
    }

    public void setCourseSQLS(List<CourseSQL> courseSQLS) {
        this.courseSQLS = courseSQLS;
    }

    @Override
    public String toString() {
        return "AuthorSQL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", income=" + income +
                '}';
    }
}
