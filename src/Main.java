//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

//    Season season = Season.SUMMER;
//
//    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//    // to see how IntelliJ IDEA suggests fixing it.
//    switch (season){
//        case AUTUMN -> System.out.println("Payiz");
//        case WINTER -> System.out.println("Qish");
//        case SUMMER -> System.out.println("Yay");
//        case SPRING -> System.out.println("Yaz");
//    }

    System.out.println(OrderStatus.NEW.canTransit(OrderStatus.PROCESSING));
    System.out.println(OrderStatus.NEW.getDesc());
}
