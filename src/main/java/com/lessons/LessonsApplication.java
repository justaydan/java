package com.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);
//        1. ProductController: /api/products/{id} endpoint-i üçün @PutMapping istifadə edərək
//        məhsulun tam yenilənməsini (name, price, category) həyata keçirməlisən.

//        2. EmployeeController: /api/employees/{id} üçün həm @PutMapping (bütün sahələr üçün),
//        həm də @PatchMapping (yalnız göndərilən sahələr üçün null yoxlaması ilə) yaratmalısan.

//        3. OrderController: /api/orders/{id} üçün @PutMapping (bütün sifarişi yeniləmək)
//        və @PatchMapping (yalnız statusu yeniləmək və keçid məntiqini yoxlamaq) istifadə etməlisən.
//        Həmçinin tapılmayan sifarişlər üçün xüsusi OrderNotFoundException istifadəsi tələb olunur.
    }
}
