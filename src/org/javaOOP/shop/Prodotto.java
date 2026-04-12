package org.javaOOP.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Prodotto {

    // caratteristiche
    protected int code;
    protected String name;
    protected String marca;
    protected BigDecimal price;
    protected BigDecimal iva;

    // costruttore
    public Prodotto(String name, String marca, BigDecimal price, BigDecimal iva) {
        Random random = new Random();
        this.code = random.nextInt(999999);
        this.marca = marca;
        this.name = name;
        this.price = price;
        this.iva = iva;
    }

    // METODI

    // code
    public int getCode() {
        return this.code;
    }

    // name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // marca
    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // price
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // iva
    public BigDecimal getIva() {
        return this.iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

}
