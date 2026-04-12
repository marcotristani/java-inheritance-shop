package org.javaOOP.shop;

import java.math.BigDecimal;

public class Cuffie extends Prodotto {

    private String color;
    private Boolean wirless;
    private Boolean cablate;

    public Cuffie(String nome, String marca, BigDecimal price, BigDecimal iva, String color, boolean wirless) {
        super(color, marca, price, iva);
        this.color = color;
        if (wirless) {
            this.wirless = true;
            this.cablate = false;
        } else {
            this.wirless = false;
            this.cablate = true;
        }
    }

    // metodi
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private boolean getWirless() {
        return this.wirless;
    }

    private void setWirless(boolean wirless) {
        this.wirless = wirless;
    }

    private boolean getCablate() {
        return this.cablate;
    }

    private void setCablate(boolean cablate) {
        this.cablate = cablate;
    }

    public String getType() {
        if (this.getWirless()) {
            return "Wirless";
        } else if (this.getCablate()) {
            return "Cablate";
        }
        return "non definito";
    }

    public void isWirless() {
        if (wirless == false) {
            this.setWirless(true);
            this.setCablate(false);
        }
    }

    public void isCablate() {
        if (cablate == false) {
            this.setCablate(true);
            this.setWirless(false);
        }
    }
}
