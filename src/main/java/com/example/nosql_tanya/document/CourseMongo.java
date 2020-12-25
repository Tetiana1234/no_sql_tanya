package com.example.nosql_tanya.document;


import com.example.nosql_tanya.entity.CourseSQL;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Course")
public class CourseMongo {
    @Id
    private String id;

    @Field(name = "tittle")
    private String tittle;

    @Field(name = "description")
    private String description;

    @Field(name = "price")
    private Double price;

    @Field(name = "type")
    private TypeMongo typeMongo;

    @Field(name = "category")
    private CategoryMongo categoryMongo;

    @Field(name = "author")
    private AuthorMongo authorMongo;

    public CourseMongo() {
    }
    public CourseMongo(CourseSQL c) {
        this.id = c.getId().toString();
        this.tittle = c.getTittle();
        this.description = c.getDescription();
        this.price = c.getPrice();
        this.typeMongo = new TypeMongo(c.getTypeSQL());
        this.categoryMongo = new CategoryMongo(c.getCategorySQL());
        this.authorMongo = new AuthorMongo(c.getAuthorSQL());
    }

    public CourseMongo(String id, String tittle, String description, Double price, TypeMongo typeMongo, CategoryMongo categoryMongo, AuthorMongo authorMongo) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.price = price;
        this.typeMongo = typeMongo;
        this.categoryMongo = categoryMongo;
        this.authorMongo = authorMongo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public TypeMongo getTypeMongo() {
        return typeMongo;
    }

    public void setTypeMongo(TypeMongo typeMongo) {
        this.typeMongo = typeMongo;
    }

    public CategoryMongo getCategoryMongo() {
        return categoryMongo;
    }

    public void setCategoryMongo(CategoryMongo categoryMongo) {
        this.categoryMongo = categoryMongo;
    }

    public AuthorMongo getAuthorMongo() {
        return authorMongo;
    }

    public void setAuthorMongo(AuthorMongo authorMongo) {
        this.authorMongo = authorMongo;
    }

    @Override
    public String toString() {
        return "CourseMongo{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", typeMongo=" + typeMongo +
                ", categoryMongo=" + categoryMongo +
                ", authorMongo=" + authorMongo +
                '}';
    }
}
