package com.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);

//        1. ProductController-da getById() metoduna @ExceptionHandler əlavə et.
//        Məhsul tapılmadıqda özün yaratdığın ProductNotFoundException atılsın,
//        @ExceptionHandler isə bunu tutub istifadəçiyə mesaj qaytarsın.


//        2. ErrorResponseDto (message, status, timestamp) adlı cavab sinifi yarat.
//        UserController-da @ExceptionHandler ilə həm UserNotFoundException,
//        həm IllegalArgumentException-ı tut — hər biri fərqli HTTP status kodu (404, 400)
//        ilə bu DTO formatında cavab qaytarsın.

//        3.OrderController-da bir neçə fərqli xəta ola bilər: sifariş tapılmadıqda
//        OrderNotFoundException, status keçidi yanlış olduqda InvalidStatusTransitionException,
//        müştəri bloklandıqda CustomerBlockedException. Hər birini controller daxilindəki
//        @ExceptionHandler-lərlə tut, fərqli HTTP status kodları və ErrorResponseDto ilə
//        cavablandır.


    }
}
