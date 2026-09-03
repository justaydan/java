package com.lessons;

import com.lessons.entity.*;
import com.lessons.enums.EmploymentType;
import com.lessons.enums.OrderStatus;
import com.lessons.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);
//        1. ProductController classi yarat, @RestController ilə işarələ. /api/products endpoint-i bütün məhsulları qaytarsın,
//        /api/products/{id} isə id-yə görə tək məhsul qaytarsın. Hər ikisini @GetMapping ilə təyin et, ProductService-dən məlumatları al.


//        2. EmployeeController-da /api/employees endpoint-i bütün işçiləri qaytarsın.
//        Əlavə olaraq /api/employees/search endpoint-i department adlı query parametr qəbul etsin
//        (@RequestParam) — həmin departamentdəki işçiləri filtrələyib qaytarsın. department parametri göndərilmədikdə bütün işçilər qaytarılsın.


//        3. OrderController-da üç fərqli @GetMapping endpoint-i yarat: /api/orders/{id} — id-yə görə tək
//        sifariş, /api/orders/customer/{customerId} — müştəriyə aid bütün sifarişlər, /api/orders — status
//        query parametrinə görə filtrələnmiş sifarişlər (@RequestParam ilə, parametr olmadıqda hamısı
//        qaytarılsın). Hər endpoint üçün @PathVariable və @RequestParam tətbiq et.

    }
}
