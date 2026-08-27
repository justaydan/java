package com.lessons;

import com.lessons.entity.AuthorEntity;
import com.lessons.entity.BookEntity;
import com.lessons.entity.DepartmentEntity;
import com.lessons.entity.EmployeeEntity;
import com.lessons.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);

//        1.BookRepository-dən kitabları Pageable ilə çək:
//        PageRequest.of(0, 5, Sort.by("title")) istifadə edərək ilk 5 kitabı əlifba sırasına görə gətir.
//        Nəticədəki Page obyektindən ümumi səhifə sayını, cəmi element sayını və hazırkı səhifənin məzmununu konsola yazdır.
//        BookService service = context.getBean(BookService.class);
//
//        var page = service.findAll(0, 5, "title");
//
//        System.out.println("Total pages: " + page.getTotalPages());
//        System.out.println("Total elements: " + page.getTotalElements());
//        System.out.println("Current page content:");
//        page.getContent().forEach(System.out::println);

//        2. ProductService-in findCheapProducts() metodu @Transactional(readOnly = true) olsun
//        və ProductRepository-dən qiyməti müəyyən həddən aşağı olan məhsulları Pageable ilə
//        gətirsin. İstifadəçi hər dəfə fərqli səhifə nömrəsi və ölçüsü göndərə bilsin — metod
//        bu parametrləri qəbul etsin. Nəticəni qiymətə görə artan sırada çap et.
//        ProductService service = context.getBean(ProductService.class);
//        System.out.println(service.findCheapProducts(10, 1, 1));;

//        3.InvoiceService-in generateInvoice() metodu @Transactional ilə işarələnib.
//        Bu metod içindən LogService-in writeLog() metodunu çağırır (REQUIRES_NEW).
//        generateInvoice() xəta atdıqda rollback edilsin, amma writeLog() öz transaction-ında saxlanılsın.
//        Eyni zamanda InvoiceRepository-dən fakturları Pageable ilə çəkən,
//        hər səhifədə 10 faktura göstərən, tarixə görə azalan sırada sıralayan metod yaz.
//        Bütün üç konsepti (readOnly, REQUIRES_NEW, Pageable) bir ssenarinin içinə yerləşdir.

        InvoiceService service = context.getBean(InvoiceService.class);
//        service.generateInvoice();
        var page = service.get(0, 10);
        System.out.println("Total elements: " + page.getTotalElements());
        page.getContent().forEach(System.out::println);
    }
}
