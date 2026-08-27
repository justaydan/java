package com.lessons;

import com.lessons.entity.AuthorEntity;
import com.lessons.entity.BookEntity;
import com.lessons.entity.DepartmentEntity;
import com.lessons.service.BookService;
import com.lessons.service.DepartmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);
//        1:Author (id, name) və Book (id, title, author) entity-lərini yarat.
//            Aralarında @ManyToOne (Book tərəfindən) əlaqəsi qur, defolt olaraq bu əlaqənin
//        LAZY yoxsa EAGER olduğunu sənədləşdirmədən yoxla və kodda fetch
//        tipini açıq şəkildə göstər. Bir neçə müəllif və kitab əlavə edib,
//                kitabı çəkəndə müəllifin nə vaxt (hansı sorğu ilə) yükləndiyini
//        konsolda loqa yaz.

        BookService bookService = context.getBean(BookService.class);

        // Save authors first, then assign to books
//        AuthorEntity tolstoy = bookService.saveAuthor(new AuthorEntity(null, "Tolstoy"));
//        AuthorEntity kafka = bookService.saveAuthor(new AuthorEntity(null, "Kafka"));
//
//        bookService.save(new BookEntity(null, "War and Peace", 1869, true, tolstoy));
//        bookService.save(new BookEntity(null, "Anna Karenina", 1878, true, tolstoy));
//        bookService.save(new BookEntity(null, "The Metamorphosis", 1915, true, kafka));

        // Lazt test will recieve 2 sql without EntityGraph
//        System.out.println("--- EAGER fetch test ---");
//        bookService.findByTitleContaining("War");

//
//        Department(id, name) və Employee (id, name, department)entity - lərini yarat.
//                Department - də @OneToMany(mappedBy = "department")
//        ilə işçilər siyahısını saxla,
//        Employee - də isə @ManyToOne ilə departamenti.
//                Department - i LAZY yükləyərək çəkəndə, işçilər siyahısına
//        toxunmadan əvvəl və sonra neçə SQL sorğusunun
//        icra olunduğunu müşahidə et
//        (Hibernate SQL logging aç).N + 1 problemi baş verirmi, izah et.

        DepartmentService departmentService = context.getBean(DepartmentService.class);
//        departmentService.save(new DepartmentEntity(null, "HR", List.of()));
//        departmentService.save(new DepartmentEntity(null, "IT", List.of()));
       departmentService.printWithNPlusOne();
    }
}
