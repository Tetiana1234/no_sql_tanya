package com.example.nosql_tanya;

import com.example.nosql_tanya.SQLRepository.AuthorSQLRepository;
import com.example.nosql_tanya.SQLRepository.CategorySQLRepository;
import com.example.nosql_tanya.SQLRepository.CourseSQLRepository;
import com.example.nosql_tanya.SQLRepository.TypeSQLRepository;
import com.example.nosql_tanya.document.AuthorMongo;
import com.example.nosql_tanya.document.CategoryMongo;
import com.example.nosql_tanya.document.CourseMongo;
import com.example.nosql_tanya.document.TypeMongo;
import com.example.nosql_tanya.entity.AuthorSQL;
import com.example.nosql_tanya.entity.CategorySQL;
import com.example.nosql_tanya.entity.CourseSQL;
import com.example.nosql_tanya.entity.TypeSQL;
import com.example.nosql_tanya.mongoRepository.AuthorMongoRepository;
import com.example.nosql_tanya.mongoRepository.CategoryMongoRepository;
import com.example.nosql_tanya.mongoRepository.CourseMongoRepository;
import com.example.nosql_tanya.mongoRepository.TypeMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class NosqlTanyaApplication implements CommandLineRunner {
    @Autowired
    private AuthorSQLRepository authorSQLRepository;
    @Autowired
    private CategorySQLRepository categorySQLRepository;
    @Autowired
    private TypeSQLRepository typeSQLRepository;
    @Autowired
    private CourseSQLRepository courseSQLRepository;

    @Autowired
    private CategoryMongoRepository categoryMongoRepository;
    @Autowired
    private AuthorMongoRepository authorMongoRepository;
    @Autowired
    private CourseMongoRepository courseMongoRepository;
    @Autowired
    private TypeMongoRepository typeMongoRepository;

    public static void main(String[] args) {
        SpringApplication.run(NosqlTanyaApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        // sqlTest();
        // mongoTest();
        // Test();
        //migrationFromSqlToMongo();
        //migrationFromMongoToSql();
        // replication();
        aggregation();
      //  testAggregation();
    }


    public void sqlTest() {
        AuthorSQL a = new AuthorSQL(1, "Павел", "Информация о авторе", 15000.0);
        authorSQLRepository.save(a);
        authorSQLRepository.save(new AuthorSQL(2, "Виктор", "Информация о авторе", 150000.0));
        authorSQLRepository.save(new AuthorSQL(3, "Анастасия", "Информация о авторе", 7000.0));
        authorSQLRepository.save(new AuthorSQL(4, "Александр", "Информация о авторе", 95000.0));
        authorSQLRepository.save(new AuthorSQL(5, "Татьяна", "Информация о авторе", 18000.0));
        for (AuthorSQL as : authorSQLRepository.findAll()) {
            System.out.println(as);
        }
        System.out.println();
        for (AuthorSQL as : authorSQLRepository.findAllByIncomeGreaterThan(50000.0)) {
            System.out.println(as);
        }
        a.setIncome(100000.0);
        authorSQLRepository.save(a);
        System.out.println(authorSQLRepository.findById(1));

        authorSQLRepository.deleteAllByIncomeLessThan(10000.0);
        for (AuthorSQL as : authorSQLRepository.findAll()) {
            System.out.println(as);
        }
        System.out.println();


    }

    public void mongoTest() {
        AuthorMongo a = new AuthorMongo("1", "Павел", "Информация о авторе", 15000.0);
        authorMongoRepository.save(a);
        authorMongoRepository.save(new AuthorMongo("2", "Виктор", "Информация о авторе", 150000.0));
        authorMongoRepository.save(new AuthorMongo("3", "Анастасия", "Информация о авторе", 7000.0));
        authorMongoRepository.save(new AuthorMongo("4", "Александр", "Информация о авторе", 95000.0));
        authorMongoRepository.save(new AuthorMongo("5", "Татьяна", "Информация о авторе", 18000.0));
        for (AuthorMongo as : authorMongoRepository.findAll()) {
            System.out.println(as);
        }
        System.out.println();
        for (AuthorMongo as : authorMongoRepository.findAllByIncomeGreaterThan(50000.0)) {
            System.out.println(as);
        }
        a.setIncome(100000.0);
        authorMongoRepository.save(a);
        System.out.println(authorMongoRepository.findById("1"));

        authorMongoRepository.deleteAllByIncomeLessThan(10000.0);
        for (AuthorMongo as : authorMongoRepository.findAll()) {
            System.out.println(as);
        }
        System.out.println();
        CategoryMongo c = new CategoryMongo("1", "Математика", "Курсы для 9-11 классов");
        categoryMongoRepository.save(c);
        TypeMongo t = new TypeMongo("1", "онлайн", "курсы проводятся онлайн");
        typeMongoRepository.save(t);
        courseMongoRepository.save(new CourseMongo("1", "Курс с математики", "описание курса", 1500.0, t, c, a));
    }

    public void Test() {
        categorySQLRepository.deleteAll();
        categoryMongoRepository.deleteAll();
        Long startTime2 = System.nanoTime();
        for (Integer i = 1; i < 10000; i++) {
            categorySQLRepository.save(new CategorySQL(i, "категория" + i, "описание категории" + i));
        }
        Long endTime2 = System.nanoTime();

        Long startTime = System.nanoTime();
        for (Integer i = 1; i < 10000; i++) {
            categoryMongoRepository.save(new CategoryMongo(i.toString(), "категория" + i, "описание категории" + i));
        }
        Long endTime = System.nanoTime();
        System.out.print("Insert into SQL took:");
        System.out.println((endTime2 - startTime2) / (double) 1000000000);
        System.out.print("Insert into Mongo took:");
        System.out.println((endTime - startTime) / (double) 1000000000);

        startTime = System.nanoTime();
        List<CategorySQL> categorySQLList = categorySQLRepository.findAllByName("категория99");
        endTime = System.nanoTime();
        System.out.print("Select from SQL took:");
        System.out.println((endTime - startTime) / (double) 1000000000);

        startTime = System.nanoTime();
        List<CategoryMongo> categoryMongoList = categoryMongoRepository.findAllByName("категория99");
        endTime = System.nanoTime();
        System.out.print("Select from Mongo took:");
        System.out.println((endTime - startTime) / (double) 1000000000);

    }

    public void migrationFromSqlToMongo() {
        List<AuthorSQL> authorSQLList = authorSQLRepository.findAll();
        for (AuthorSQL a : authorSQLList) {
            authorMongoRepository.save(new AuthorMongo(a));
        }

        List<CategorySQL> categorySQLList = categorySQLRepository.findAll();
        for (CategorySQL c : categorySQLList) {
            categoryMongoRepository.save(new CategoryMongo(c));
        }

        List<TypeSQL> typeSQLList = typeSQLRepository.findAll();
        for (TypeSQL t : typeSQLList) {
            typeMongoRepository.save(new TypeMongo(t));
        }

        List<CourseSQL> courseSQLList = courseSQLRepository.findAll();
        for (CourseSQL c : courseSQLList) {
            courseMongoRepository.save(new CourseMongo(c));
        }
    }

    public void migrationFromMongoToSql() {
        List<CategoryMongo> categoryMongoList = categoryMongoRepository.findAll();
        for (CategoryMongo c : categoryMongoList) {
            categorySQLRepository.save(new CategorySQL(c));
        }

        List<AuthorMongo> authorMongoList = authorMongoRepository.findAll();
        for (AuthorMongo a : authorMongoList) {
            authorSQLRepository.save(new AuthorSQL(a));
        }

        List<TypeMongo> typeMongoList = typeMongoRepository.findAll();
        for (TypeMongo t : typeMongoList) {
            typeSQLRepository.save(new TypeSQL(t));
        }

        List<CourseMongo> courseMongoList = courseMongoRepository.findAll();
        for (CourseMongo c : courseMongoList) {
            courseSQLRepository.save(new CourseSQL(c));
        }
    }

    public void replication() throws InterruptedException {
        categoryMongoRepository.deleteAll();
        long startTime = System.nanoTime();
        for (Integer i = 1; i < 10000; i++) {
            insert(new CategoryMongo(i.toString(), "категория" + i, "описание категории" + i));
        }
        long endTime = System.nanoTime();
        System.out.println("Insert: " + (double) (endTime - startTime) / 1000000000);
        startTime = System.nanoTime();
        List<CategoryMongo> categoryMongoList = categoryMongoRepository.findAll();
        endTime = System.nanoTime();
        System.out.println("Select: " + (double) (endTime - startTime) / 1000000000);
    }

    public boolean insert(CategoryMongo categoryMongo) throws InterruptedException {
        int tempts = 3;
        while (tempts > 0) {
            try {
                if (categoryMongoRepository.save(categoryMongo) != null) {
                    return true;
                }
            } catch (Exception e) {
                tempts--;
                Thread.sleep(1000);
            }
        }
        System.out.println("Error to insert document");
        return false;
    }


    public void aggregation() {
        //1Agg
        for (Agg a : courseMongoRepository.countByCategory()) {
            System.out.println(a);
        }
        //2Agg
        for (Agg a : courseMongoRepository.countByType()) {
            System.out.println(a);
        }
        //3 Agg
        for (Agg a : courseMongoRepository.sumAllCoursePriceByAuthor()) {
            System.out.println(a);
        }
        //4 Agg
        System.out.println(courseMongoRepository.sumAllCoursePrice());
        //5Agg
        for (Agg a : courseMongoRepository.maxPriceInCategory()) {
            System.out.println(a);
        }
    }

    public void testAggregation() {
        AuthorMongo auth = new AuthorMongo("11", "Артем", "Информация о авторе", 15000.0);
        CategoryMongo cat = new CategoryMongo("11", "Математика", "Курсы для 9-11 классов");
        TypeMongo type = new TypeMongo("11", "онлайн", "курсы проводятся онлайн");
        for (Integer i = 1; i < 100000; i++) {
            courseMongoRepository.save(new CourseMongo(i.toString(), "Курс с математики"+i, "описание курса", (double)i%10000, type, cat, auth));

        }

        //1Agg
        long startTime = System.nanoTime();
        List<Agg> result = courseMongoRepository.countByCategory();
        long endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //1Not
        startTime = System.nanoTime();
        List<CourseMongo> temp = courseMongoRepository.findAll();
        HashMap<String, Integer> countByCategory = new HashMap<>();
        for (CourseMongo c : temp) {
            Integer frequency = countByCategory.get(c.getCategoryMongo().getName());
            countByCategory.put(c.getCategoryMongo().getName(), frequency == null ? 1 : frequency + 1);
        }
        result = new ArrayList<Agg>();
        for (Map.Entry<String, Integer> entry : countByCategory.entrySet()) {
            result.add(new Agg(entry.getKey(), entry.getValue()));
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //2Agg
        startTime = System.nanoTime();
        result = courseMongoRepository.countByType();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //2Not
        startTime = System.nanoTime();
        temp = courseMongoRepository.findAll();
        HashMap<String, Integer> countByType = new HashMap<>();
        for (CourseMongo c : temp) {
            Integer frequency = countByType.get(c.getTypeMongo().getName());
            countByType.put(c.getTypeMongo().getName(), frequency == null ? 1 : frequency + 1);
        }
        result = new ArrayList<Agg>();
        for (Map.Entry<String, Integer> entry : countByType.entrySet()) {
            result.add(new Agg(entry.getKey(), entry.getValue()));
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //3 Agg
        startTime = System.nanoTime();
        result = courseMongoRepository.sumAllCoursePriceByAuthor();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //3Not
        startTime = System.nanoTime();
        temp = courseMongoRepository.findAll();
        HashMap<String, Double> priceByAuthor = new HashMap<>();
        for (CourseMongo c : temp) {
            Double sum = priceByAuthor.get(c.getAuthorMongo().getName());
            priceByAuthor.put(c.getAuthorMongo().getName(), sum == null ? c.getPrice() : sum + c.getPrice());
        }
        result = new ArrayList<Agg>();
        for (Map.Entry<String, Double> entry : priceByAuthor.entrySet()) {
            result.add(new Agg(entry.getKey(), entry.getValue()));
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);
        //4 Agg
        startTime = System.nanoTime();
        System.out.println(courseMongoRepository.sumAllCoursePrice());
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);
        //4Not
        startTime = System.nanoTime();
        temp = courseMongoRepository.findAll();
        double sum = 0;
        for (CourseMongo c : temp) {
            sum += c.getPrice();
        }
        System.out.println(sum);
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);
        //5Agg
        startTime = System.nanoTime();
        result = courseMongoRepository.maxPriceInCategory();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);
        //5Not
        startTime = System.nanoTime();
        temp = courseMongoRepository.findAll();
        HashMap<String, Double> maxPrice = new HashMap<>();
        for (CourseMongo c : temp) {
            Double price = maxPrice.get(c.getCategoryMongo().getName());
            maxPrice.put(c.getCategoryMongo().getName(), (price == null || c.getPrice() > price) ? c.getPrice() : price);
        }
        result = new ArrayList<Agg>();
        for (Map.Entry<String, Double> entry : maxPrice.entrySet()) {
            if (entry.getValue() >= 5000) {
                result.add(new Agg(entry.getKey(), entry.getValue()));
            }
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);
    }

}
