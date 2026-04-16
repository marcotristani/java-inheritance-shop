package org.javaOOP.shop;

import java.math.BigDecimal;
import java.util.Random;

public abstract class Prodotto {

    // caratteristiche
    private int code;
    private String name;
    private String marca;
    private BigDecimal price;
    private BigDecimal iva;

    // costruttore
    protected Prodotto(String name, String marca, BigDecimal price) {
        Random random = new Random();
        this.code = random.nextInt(999999);
        this.marca = marca;
        this.name = name;
        this.price = price;
        this.iva = BigDecimal.valueOf(0.22);
    }

    // METODI

    // code(solo get)
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

    public BigDecimal finalPrice() {
        return price.add(iva.multiply(BigDecimal.valueOf(100)));
    }

    @Override
    public String toString() {
        return String.format("%s - %d\nMarca: %s\nPrezzo : %.2f euro + %.0f %% iva  = %.2f euro", this.name, this.code,
                this.getMarca(),
                this.getPrice(), this.getIva().multiply(BigDecimal.valueOf(100)),
                this.finalPrice());
    }

}
