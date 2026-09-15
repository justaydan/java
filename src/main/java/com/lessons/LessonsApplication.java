package com.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);
//      1: `ProductController`-da `/api/products/{id}` endpoint-i yarat. `@PutMapping` ilə
//      bütün məhsul məlumatlarını (`name`, `price`, `category`) `ProductUpdateDto` vasitəsilə
//      yenilə. `ProductService`-dən id-yə görə məhsulu tap, DTO-dakı bütün sahələri entity-yə
//      köçür, yadda saxla.


//        2: `EmployeeController`-da eyni `/api/employees/{id}` endpoint-ini həm `@PutMapping`,
//        həm `@PatchMapping` ilə yarat. `PUT` bütün işçi məlumatlarını (`name`, `department`,
//        `salary`, `email`) yeniləsin. `PATCH` isə yalnız göndərilən sahələri yeniləsin
//        — məsələn yalnız `salary` göndərildikdə yalnız o dəyişsin, digər sahələr toxunulmaz qalsın.
//        Bunun üçün `EmployeePatchDto`-dakı sahələri `null` yoxlaması ilə idarə et.

//        3.`OrderController`-da `/api/orders/{id}` endpoint-ini yarat. `@PutMapping` tam
//        sifarişi (`customerId`, `List<OrderItemDto>`, `status`) yeniləsin, əvvəlki `order_items`
//        silinib yenisi yazılsın. `@PatchMapping` isə yalnız `status` sahəsini yeniləsin — amma
//        status keçidi məntiqini yoxla (`DELIVERED`-dən `NEW`-ə qayıtmaq mümkün olmasın). Hər iki
//        metodda `@PathVariable` ilə gələn `id` tapılmadıqda özün yaratdığın `OrderNotFoundException`
//        atılsın.


    }
}
