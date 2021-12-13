/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.wallet.utils;

/**
 *
 * @author jonavcar
 */
public enum CustomerType {
    LEGAL_PERSON("PJ"),
    NATURAL_PERSON("PN");

    public final String value;

    @Override
    public String toString() {
        return value;
    }

    public boolean equalsName(String otherValue) {
        return value.equals(otherValue);
    }

    private CustomerType(String value) {
        this.value = value;
    }
}
