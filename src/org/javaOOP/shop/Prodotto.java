package org.javaOOP.shop;

import java.math.BigDecimal;
import java.util.Random;

public abstract class Prodotto implements FedelityCodes {

    // caratteristiche
    private int code;
    private String name;
    private String marca;
    private BigDecimal price;
    private BigDecimal iva;
    private String fedelityCode;

    // costruttore
    protected Prodotto(String name, String marca, BigDecimal price) {
        Random random = new Random();
        this.code = random.nextInt(999999);
        this.marca = marca;
        this.name = name;
        this.price = price;
        this.iva = BigDecimal.valueOf(0.22);
        this.fedelityCode = "NoCode";
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

    // fedelity code
    private String getFedelityCode() {
        return this.fedelityCode;
    }

    public void setFedelityCode(String fedelityCode) {
        this.fedelityCode = fedelityCode;
    }

    // metodi aggiuntivi
    public BigDecimal finalPrice() {
        return price.add(iva.multiply(BigDecimal.valueOf(100)));

    }

    @Override
    public boolean verifyFedelityCode(String fedelityCode) {
        for (int i = 0; i < fedelityCodes.length; i++) {
            if (fedelityCode.equals(fedelityCodes[i])) {
                return true;
            }
        }
        return false;
    }

    public BigDecimal finalPriceDiscounted() {
        BigDecimal discount = this.finalPrice().multiply(BigDecimal.valueOf(0.02));
        return this.finalPrice().subtract(discount);
    }

    @Override
    public String toString() {
        String prezzoScontato = "";
        if (!this.getFedelityCode().equals("NoCode")) {
            if (verifyFedelityCode(this.getFedelityCode())) {
                prezzoScontato = String.format("\nPrezzo scontato: %.2f ", this.finalPriceDiscounted());
            } else {
                prezzoScontato = "\nCodice fedeltà inserito non valido";
            }
        }
        return String.format("%s - %d\nMarca: %s\nPrezzo : %.2f euro + %.0f %% iva  = %.2f euro%s",
                this.getName(),
                this.getCode(),
                this.getMarca(),
                this.getPrice(), this.getIva().multiply(BigDecimal.valueOf(100)),
                this.finalPrice(),
                prezzoScontato);
    }

}
