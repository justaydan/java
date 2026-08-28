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
//        1.OrderStatus enum-u yarat (NEW, PROCESSING, SHIPPED, DELIVERED).
//        Order entity-sinə bu enum-u sahə kimi əlavə et.
//        @Enumerated(EnumType.STRING) ilə işarələ, bir neçə sifariş saxla və bazada statusun
//        necə saxlandığını yoxla. Sonra EnumType.ORDINAL ilə dəyişdirərək fərqi müşahidə et.
//        OrderService service = context.getBean(OrderService.class);
//        service.save(new OrderEntity(null, OrderStatus.NEW));

//        2.Money adlı @Embeddable sinif yarat (amount, currency sahələri ilə).
//        Product entity-sinə həm price (satış qiyməti), həm də costPrice (maya dəyəri)
//        sahələrini Money tipi ilə əlavə et. Eyni @Embeddable sinifi bir entity-də iki dəfə
//        istifadə etdiyindən @AttributeOverrides lazım olacaq — sütun adlarının toqquşmaması üçün tətbiq et.

//        ProductService service = context.getBean(ProductService.class);
//        System.out.println(service.findAll().getFirst().getCostPrice().getAmount());

//        3.PersonName (firstName, lastName) və ContactInfo (email, phone) adlı iki ayrı
//        @Embeddable sinif yarat. Employee entity-sinə hər ikisini @Embedded ilə əlavə et,
//        @Enumerated(EnumType.STRING) ilə EmploymentType enum-unu da (FULL_TIME, PART_TIME, CONTRACT) saxla.
//        EmployeeRepository-dən FULL_TIME işçiləri Pageable ilə çəkən, soyadına görə sıralayan metod yaz.
//        Bu tapşırıqda @Embedded, @Enumerated və Pageable üçünü birləşdir.

        EmployeeService service = context.getBean(EmployeeService.class);
        System.out.println( service.getByType(EmploymentType.FULL_TIME).getContent());

    }
}
