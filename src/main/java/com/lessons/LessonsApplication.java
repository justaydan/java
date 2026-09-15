package com.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);
    //`ProductController`-da eyni `/api/products/{id}` endpoint-ini iki versiyada yarat:
    // `v1` sadəcə `name` və `price` qaytarsın, `v2` isə əlavə olaraq `category` və `stock` da
    // qaytarsın. Hər versiyon üçün ayrı DTO sinifi yarat (`ProductDtoV1`, `ProductDtoV2`),
    // endpoint-ləri URL versioning ilə ayır (`/api/v1/products/{id}`, `/api/v2/products/{id}`).

//        2:`UserController`-da istifadəçiləri qaytaran endpoint yarat. `User` entity-sindəki
//        `password` və `createdAt` sahələri heç vaxt response-da görünməsin — bunun üçün
//        `UserResponseDto` yarat. `User` entity-sindən `UserResponseDto`-ya çevirmə əməliyyatını
//        ayrıca bir metodda et. Endpoint-i `/api/v1/users` və `/api/v2/users` olaraq iki
//        versiyada saxla — `v2`-də əlavə olaraq `fullName` (ad + soyad birləşdirilmiş) sahəsi
//        də qaytarılsın.



    }
}
