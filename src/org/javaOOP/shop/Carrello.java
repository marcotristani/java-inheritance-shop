package org.javaOOP.shop;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {

        // definisco lo scanner
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        // definisco un array di tipo prodotto dove andrò a inserire i prodotti del
        // carrello
        int numeroProdottiCarrello = -1;
        do {
            try {
                System.out.println("Quanti prodotti vuoi inserire nel carrello?");
                numeroProdottiCarrello = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero valido!");
                input.nextLine(); // pulisce il buffer
                numeroProdottiCarrello = -1; // forza la ripetizione del ciclo
            }
        } while (numeroProdottiCarrello == -1);

        Prodotto[] prodottiCarrello = new Prodotto[numeroProdottiCarrello];

        // faccio un ciclo dove vado a far inserire al'utente i prodotti nel carrello
        for (int i = 0; i < prodottiCarrello.length; i++) {

            String[] category = { "Smartphone", "Televisione", "Cuffie" };
            int caso = 0;

            do {
                try {
                    System.out.println("-------------PRODOTTI DISPONIBILI---------\n");
                    for (int index = 0; index < category.length; index++) {
                        System.out.printf("%d - %s\n", index + 1, category[index]);
                    }
                    caso = input.nextInt();
                    if (caso <= 0 || caso > category.length) {
                        System.out.println("Inserire un numero corrispondente alle categorie indicato");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Inserire valore valido");
                    input.nextLine();
                    caso = 0;
                }

            } while (caso <= 0 || caso > category.length);

            // Faccio inserire i valori per ogni prodotto

            System.out.println("Inserire nome prodotto:");
            String nome = input.next();

            System.out.println("Inserire marca prodotto:");
            String marca = input.next();

            BigDecimal price = BigDecimal.valueOf(-1);
            do {
                try {
                    System.out.println("Inserire prezzo prodotto:");
                    price = input.nextBigDecimal();
                    if (price.compareTo(BigDecimal.valueOf(-1)) < 0) {
                        System.out.println("Il prezzo non può essere negativo!! \nInserisci un prezzo positivo");
                    }
                } catch (InputMismatchException e) {

                    System.out.println("Inserisci un valore corretto");
                    input.nextLine();
                    price = BigDecimal.valueOf(-1);

                }
            } while (price.compareTo(BigDecimal.valueOf(-1)) == 0 || price.compareTo(BigDecimal.valueOf(-1)) < 0);

            switch (caso) {
                case 1:
                    float memory = -1f;
                    do {
                        try {
                            System.out.println("Inserire quantità memoria in GB dello smartphone:");
                            memory = input.nextFloat();
                            if (memory < 0) {
                                System.out
                                        .println(
                                                "La qantità di memoria non può essere negativa!! \nInserisci un valore positivo");
                            }
                        } catch (InputMismatchException e) {

                            System.out.println("Inserisci un valore corretto");
                            input.nextLine();
                            memory = -1f;

                        }
                    } while (memory == -1f || memory < 0);

                    Smartphone smartphoneCarrello = new Smartphone(nome, marca, price, memory);
                    prodottiCarrello[i] = smartphoneCarrello;
                    break;

                case 2:
                    float altezza = -1f;
                    do {
                        try {
                            System.out.println("Inserire altezza TV:");
                            altezza = input.nextFloat();
                            if (altezza < 0) {
                                System.out
                                        .println(
                                                "L'altezza non può essere negativa!! \nInserisci un valore positivo");
                            }
                        } catch (InputMismatchException e) {

                            System.out.println("Inserisci un valore corretto");
                            input.nextLine();
                            altezza = -1f;

                        }
                    } while (altezza == -1f || altezza < 0);

                    float lunghezza = -1f;
                    do {
                        try {
                            System.out.println("Inserire lunghezza TV:");
                            lunghezza = input.nextFloat();
                            if (lunghezza < 0) {
                                System.out
                                        .println(
                                                "La lunghezza non può essere negativa!! \nInserisci un valore positivo");
                            }
                        } catch (InputMismatchException e) {

                            System.out.println("Inserisci un valore corretto");
                            input.nextLine();
                            lunghezza = -1f;

                        }
                    } while (lunghezza == -1f || lunghezza < 0);

                    float larghezza = -1f;
                    do {
                        try {
                            System.out.println("Inserire larghezza TV:");
                            larghezza = input.nextFloat();
                            if (larghezza < 0) {
                                System.out
                                        .println(
                                                "La larghezza non può essere negativa!! \nInserisci un valore positivo");
                            }
                        } catch (InputMismatchException e) {

                            System.out.println("Inserisci un valore corretto");
                            input.nextLine();
                            larghezza = -1f;

                        }
                    } while (larghezza == -1f || larghezza < 0);

                    // System.out.println("Il televisore è smart?\" \"Yes\" o \"No\" ?");
                    String isSmart = null;
                    boolean smart = false;
                    do {
                        System.out.println("Il televisore è smart?\" \"Yes\"  o  \"No\" ?");
                        isSmart = input.next();
                        if (isSmart.toLowerCase().equals("yes")) {
                            smart = true;
                        }
                    } while (!isSmart.toLowerCase().equals("yes") && !isSmart.toLowerCase().equals("no"));

                    TV televisioneCarrello = new TV(nome, marca, price, altezza, lunghezza, larghezza, smart);
                    prodottiCarrello[i] = televisioneCarrello;
                    break;
                case 3:

                    System.out.println("Inserire colore cuffie:");
                    String color = input.next();

                    String isWirless = null;
                    boolean wirless = false;
                    do {
                        System.out.println("Le cuffie sono wirless?\" \"Yes\"  o  \"No\" ?");
                        isWirless = input.next();
                        if (isWirless.toLowerCase().equals("yes")) {
                            wirless = true;
                        }
                    } while (!isWirless.toLowerCase().equals("yes") && !isWirless.toLowerCase().equals("no"));

                    Cuffie cuffieCarrello = new Cuffie(nome, marca, price, color, wirless);
                    prodottiCarrello[i] = cuffieCarrello;
                    break;
            }
        }

        System.out.println("++++++++++CARRELLO++++++++++++\n");
        for (int i = 0; i < prodottiCarrello.length; i++) {

            System.out.printf("---------PRODOTTO %d------------\n%s\n\n", i + 1, prodottiCarrello[i]);
        }
        input.close();

    }
}
