package org.javaOOP.shop.main;

import java.math.BigDecimal;

import org.javaOOP.shop.Prodotto;

public class Main {
    public static void main(String[] args) {
        Prodotto prodotto = new Prodotto("tecnologia", "samsung", BigDecimal.valueOf(999.99), BigDecimal.valueOf(0.22));

        System.out.println(prodotto.getCode());
    }
}
