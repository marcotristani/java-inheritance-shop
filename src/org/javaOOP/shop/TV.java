package org.javaOOP.shop;

import java.math.BigDecimal;

public class TV extends Prodotto {

    private float altezza;
    private float lunghezza;
    private float larghezza;
    private boolean smart;

    public TV(String name, String marca, BigDecimal price, float altezza, float lunghezza,
            float larghezza, boolean smart) {
        super(name, marca, price);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.lunghezza = lunghezza;
        this.smart = smart;
    }

    // METODI GETTER E SETTER
    public float getAltezza() {
        return this.altezza;
    }

    public void setAltezza(float altezza) {
        if (altezza > 0) {
            this.altezza = altezza;
        }
    }

    public float getLarghezza() {
        return this.larghezza;
    }

    public void setLarghezza(float larghezza) {
        if (larghezza > 0) {
            this.larghezza = larghezza;
        }
    }

    public float getLunghezza() {
        return this.lunghezza;
    }

    public void setLunghezza(float lunghezza) {
        if (lunghezza > 0) {
            this.lunghezza = lunghezza;
        }
    }

    public String getSmart() {
        if (this.smart) {
            return "Yes";
        } else {
            return "No";
        }
    }

    private void setSmart(boolean smart) {
        this.smart = smart;
    }

    public void isSmart() {
        if (this.smart == false) {
            setSmart(true);
        }
    }

    public void isNotSmart() {
        if (this.smart == true) {
            setSmart(false);
        }
    }

    @Override
    public BigDecimal finalPriceDiscounted() {
        BigDecimal discount = this.finalPrice().multiply(BigDecimal.valueOf(0.02));
        if (!this.smart) {
            discount = this.finalPrice().multiply(BigDecimal.valueOf(0.10));
        }
        return this.finalPrice().subtract(discount);
    }

    @Override
    public String toString() {
        return String.format("%s\nDimensioni: %.2fcm x %.2fcm x %.2fcm\nSmart: %s",
                super.toString(),
                this.getAltezza(),
                this.getLunghezza(),
                this.getLarghezza(),
                this.getSmart());
    }
}
