package org.javaOOP.shop.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.javaOOP.shop.Cuffie;
import org.javaOOP.shop.Smartphone;
import org.javaOOP.shop.TV;

public class Main {
    public static void main(String[] args) {

        // Smartphone
        System.out.println("------------------------SMARTPHONE---------------------\n");
        Smartphone iphone16 = new Smartphone("Iphone16", "APPLE", BigDecimal.valueOf(1299.00), BigDecimal.valueOf(0.22),
                125.7f);

        System.out.println(
                String.format("---%s---\n%s-%d\nIMEI : %d\nPrezzo: %.2f + %.0f%% iva\nMemory:%.2f GB\n",
                        iphone16.getMarca(),
                        iphone16.getName(),
                        iphone16.getCode(),
                        iphone16.getIMEIcode(),
                        iphone16.getPrice().setScale(2, RoundingMode.DOWN),
                        iphone16.getIva().multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.DOWN),
                        iphone16.getMemory()));

        // TV
        System.out.println("\n------------------------TELEVISIONI---------------------\n");

        TV primaTV = new TV("TV camera", "Thomson", BigDecimal.valueOf(456.00), BigDecimal.valueOf(0.22), 26.5f, 57.8f,
                5.2f, false);

        primaTV.isSmart();

        System.out.println(
                String.format(
                        "---%s---\n%s-%d\nDimensioni: %.2fcm x %.2fcm x %.2fcm\nPrezzo: %.2f + %.0f%% iva\nSmart: %s\n",
                        primaTV.getMarca(),
                        primaTV.getName(),
                        primaTV.getCode(),
                        primaTV.getAltezza(),
                        primaTV.getLunghezza(),
                        primaTV.getLarghezza(),
                        primaTV.getPrice().setScale(2, RoundingMode.DOWN),
                        primaTV.getIva().multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.DOWN),
                        primaTV.getSmart()));

        // TV
        System.out.println("\n------------------------CUFFIE---------------------\n");

        Cuffie cuffia1 = new Cuffie("cuffia mia", "Samsung", BigDecimal.valueOf(56.00), BigDecimal.valueOf(0.22), "blu",
                true);

        cuffia1.isCablate();

        System.out.println(
                String.format(
                        "---%s---\n%s-%d\nColore: %s\nTipo: %s\nPrezzo: %.2f + %.0f%% iva\n",
                        cuffia1.getMarca(),
                        cuffia1.getName(),
                        cuffia1.getCode(),
                        cuffia1.getColor(),
                        cuffia1.getType(),
                        cuffia1.getPrice().setScale(2, RoundingMode.DOWN),
                        cuffia1.getIva().multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.DOWN)));
    }
}
