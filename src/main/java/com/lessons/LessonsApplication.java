package com.lessons;

import com.lessons.entity.Book;
import com.lessons.entity.Employee;
import com.lessons.entity.Product;
import com.lessons.service.BookService;
import com.lessons.service.EmployeeService;
import com.lessons.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);
//1
//        ProductService service = context.getBean(ProductService.class);
//        service.save(new Product(null, "Apple", 2.5));
//        service.save(new Product(null, "Banana", 1.2));
//        service.save(new Product(null, "Cherry", 5.0));
//
//        service.findAll().forEach(System.out::println);

        //2
        // Employee entity-si yarat (id, name, department, salary).
        // EmployeeRepository-də (metod adına görə avtomatik sorğu)
        // istifadə edərək müəyyən departamentdəki işçiləri tapan (findByDepartment)
        // və maaşı müəyyən məbləğdən çox olanları tapan (findBySalaryGreaterThan) metodlar yaz.
        // Hər ikisini test et.

//        EmployeeService service = context.getBean(EmployeeService.class);
//        service.save(new Employee(null, "Aydan", "Dep1", 56.9));
//        service.save(new Employee(null, "Azer", "Dep2", 45.0));
//        service.save(new Employee(null, "Nazrin", "Dep1", 60.0));
//        service.findByDepartment("Dep1");
//        service.findByDepartment("Dep1").forEach(System.out::println);
//        service.findBySalaryGreaterThan(56.0).forEach(System.out::println);

        //3. Book entity-si yarat (id, title, author, publishedYear, available).
        // BookRepository-də bir neçə fərqli query methode yaz:
        // müəyyən müəllifin kitablarını tapan (findByAuthor),
        // müəyyən ildən sonra çap olunmuş və hazırda mövcud olanları tapan
        // (findByPublishedYearGreaterThanAndAvailableTrue),
        // başlığında müəyyən söz keçən kitabları tapan (findByTitleContaining).
        // Əlavə olaraq existsByTitle və deleteByAuthor metodlarını da yaz.
        // Bütün metodları ardıcıl çağırıb nəticələri konsola yazdır.

        BookService service = context.getBean(BookService.class);

        // save books
        service.save(new Book(null, "Crime and Punishment", "Dostoyevski", 1866, true));
        service.save(new Book(null, "The Idiot", "Dostoyevski", 1869, false));
        service.save(new Book(null, "War and Peace", "Tolstoy", 1869, true));
        service.save(new Book(null, "Anna Karenina", "Tolstoy", 1878, true));
        service.save(new Book(null, "The Master and Margarita", "Bulgakov", 1967, true));
        service.save(new Book(null, "1984", "Orwell", 1949, false));

        // findByAuthor
        service.findByAuthor("Dostoyevski").forEach(System.out::println);

        // findByPublishedYearGreaterThanAndAvailableTrue
        service.findByPublishedYearGreaterThanAndAvailableTrue(1900).forEach(System.out::println);

        // findByTitleContaining
        service.findByTitleContaining("and").forEach(System.out::println);

        // existsByTitle
        System.out.println(service.existsByTitle("1984"));
        System.out.println(service.existsByTitle("Harry Potter"));

        // deleteByAuthor
        service.deleteByAuthor("Orwell");
        System.out.println(service.existsByTitle("1984"));


    }
}
