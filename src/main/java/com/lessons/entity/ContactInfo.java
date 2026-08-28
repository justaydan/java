package com.lessons.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactInfo {
    private String email;
    private String phone;
}
