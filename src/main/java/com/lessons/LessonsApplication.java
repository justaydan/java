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
//    1.EmployeeService sinifindəki getEmployee() metodunu @Transactional(readOnly = true)
//    ilə işarələ, saveEmployee() metodunu isə adi @Transactional ilə.
//    application.
//    properties-də Hibernate SQL logundan izlə —
//    hər iki metodun fərqli davranışını müşahidə et.

//        OrderService service = context.getBean(OrderService.class);
//        service.save(new EmployeeEntity(null, "test", 0.45));

//        2.OrderService-in cancelOrder() metodu @Transactional olsun.
//        Ləğv əməliyyatı zamanı özün yaratdığın OrderAlreadyCancelledException atıldıqda rollback baş verməsin,
//        amma StockUpdateException atıldıqda mütləq rollback baş versin.
//        rollbackFor və noRollbackFor atributlarından istifadə edib hər iki halı test et.
//        service.cancelOrder();

//        3.CustomerService-in deleteCustomer() metodu @Transactional ilə işarələnib.
//        Bu metod içindən NotificationService-in sendDeletionAlert() metodunu çağırır — bu
//        metod REQUIRES_NEW ilə öz ayrı transaction-ında işləsin ki,
//        əsas silmə əməliyyatı uğursuz olsa belə bildiriş loqu bazaya yazılsın.
//        Hər iki propagation rejimini müqayisə edib fərqi konsol çıxışında göstər.
        CustomerService customerService = context.getBean(CustomerService.class);
        customerService.deleteCustomer();
    }
}
