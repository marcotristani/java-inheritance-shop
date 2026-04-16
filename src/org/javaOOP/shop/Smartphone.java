package org.javaOOP.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Smartphone extends Prodotto {

    private int IMEIcode;
    private float memory;

    public Smartphone(String name, String marca, BigDecimal price, float memory) {
        super(name, marca, price);
        this.memory = memory;

        Random random = new Random();
        this.IMEIcode = random.nextInt(9999);
    }

    // METODI GETTER E SETTER
    public int getIMEIcode() {
        return this.IMEIcode;
    }

    public float getMemory() {
        return this.memory;
    }

    public void setMemory(float memory) {
        if (memory > 0) {
            this.memory = memory;
        }
    }

    @Override
    public BigDecimal finalPriceDiscounted() {
        BigDecimal discount = this.finalPrice().multiply(BigDecimal.valueOf(0.02));
        if (memory < 32f) {
            discount = this.finalPrice().multiply(BigDecimal.valueOf(0.05));
        }

        return this.finalPrice().subtract(discount);
    }

    @Override
    public String toString() {
        return String.format("%s\nCodice IMEI: %d \nMemoria: %.2f GB\n ",
                super.toString(),
                this.getIMEIcode(),
                this.getMemory()

        );
    }
}
