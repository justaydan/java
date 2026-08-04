public enum OrderStatus {
    NEW("Sifariş yaradılıb"),
    PROCESSING("Sifariş hazırlanır"),
    SHIPPED("Sifariş göndərilib"),
    DELIVERED("Sifariş çatdırılıb"),
    CANCELLED("Sifariş ləğv edilib");


    private final String desc;

    OrderStatus(String s) {
        this.desc = s;
    }

    public String getDesc() {
        return desc;
    }

    public boolean canTransit(OrderStatus status) {
        return (this == NEW && (status == PROCESSING || status == CANCELLED));
    }
}
