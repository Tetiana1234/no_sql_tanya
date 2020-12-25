package com.example.nosql_tanya.entity;


import com.example.nosql_tanya.document.CourseMongo;

import javax.persistence.*;

@Entity
public class CourseSQL {
    @Id
    private Integer id;

    @Column(name = "tittle", nullable = false)
    private String tittle;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "type_id", nullable = false)
    private TypeSQL typeSQL;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id", nullable = false)
    private CategorySQL categorySQL;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorSQL authorSQL;

    public CourseSQL() {
    }

    public CourseSQL(CourseMongo c) {
        this.id = Integer.parseInt(c.getId());
        this.tittle = c.getTittle();
        this.description = c.getDescription();
        this.price = c.getPrice();
        this.typeSQL = new TypeSQL(c.getTypeMongo());
        this.categorySQL = new CategorySQL(c.getCategoryMongo());
        this.authorSQL = new AuthorSQL(c.getAuthorMongo());
    }


    public CourseSQL(Integer id, String tittle, String description, Double price, TypeSQL typeSQL, CategorySQL categorySQL, AuthorSQL authorSQL) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.price = price;
        this.typeSQL = typeSQL;
        this.categorySQL = categorySQL;
        this.authorSQL = authorSQL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TypeSQL getTypeSQL() {
        return typeSQL;
    }

    public void setTypeSQL(TypeSQL typeSQL) {
        this.typeSQL = typeSQL;
    }

    public CategorySQL getCategorySQL() {
        return categorySQL;
    }

    public void setCategorySQL(CategorySQL categorySQL) {
        this.categorySQL = categorySQL;
    }

    public AuthorSQL getAuthorSQL() {
        return authorSQL;
    }

    public void setAuthorSQL(AuthorSQL authorSQL) {
        this.authorSQL = authorSQL;
    }

    @Override
    public String toString() {
        return "CourseSQL{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", typeSQL=" + typeSQL.getId() +
                ", categorySQL=" + categorySQL.getId() +
                ", authorSQL=" + authorSQL.getId() +
                '}';
    }
}
