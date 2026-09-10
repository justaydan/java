package com.lessons.enums;

public enum OrderStatus {
    NEW, PROCESSING, SHIPPED, DELIVERED;

    public boolean canTransitionTo(OrderStatus next) {
        return switch (this) {
            case NEW -> next == PROCESSING;
            case PROCESSING -> next == SHIPPED;
            case SHIPPED -> next == DELIVERED;
            case DELIVERED -> false;
        };
    }
}
