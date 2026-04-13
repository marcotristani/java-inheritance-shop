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

        } while (numeroProdottiCarrello == -1 || !(numeroProdottiCarrello < 7));

        Prodotto[] prodottiCarrello = new Prodotto[numeroProdottiCarrello];

        // faccio un ciclo dove vado a far inserire al'utente i prodotti nel carrello
        for (int i = 0; i < prodottiCarrello.length; i++) {

            System.out.println(
                    "PRODOTTI DISPONIBILI :\n1-Smartphone\n2-Televisione\n3-Cuffie\n-------------------\nDigita il numero relativo al prodotto desiderato:");
            int caso = input.nextInt();

            // Faccio inserire i valori per ogni prodotto
            System.out.println("Inserire nome prodotto:");
            String nome = input.next();
            System.out.println("Inserire marca prodotto:");
            String marca = input.next();
            System.out.println("Inserire prezzo prodotto:");
            float priceInput = input.nextFloat();
            BigDecimal price = BigDecimal.valueOf(priceInput);
            switch (caso) {
                case 1:
                    System.out.println("Inserire quantità memoria in GB dello smartphone:");
                    float memory = input.nextFloat();
                    Smartphone smartphoneCarrello = new Smartphone(nome, marca, price, memory);
                    prodottiCarrello[i] = smartphoneCarrello;
                    break;
                case 2:
                    System.out.println("Inserire altezza TV:");
                    float altezza = input.nextFloat();
                    System.out.println("Inserire lunghezza TV:");
                    float lunghezza = input.nextFloat();
                    System.out.println("Inserire larghezza TV:");
                    float larghezza = input.nextFloat();
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
                    // System.out.println("Il televisore è smart?\" \"Yes\" o \"No\" ?");
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
