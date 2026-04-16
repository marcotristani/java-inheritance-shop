package org.javaOOP.shop;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {

        // definisco lo scanner
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        // ------------METODO VECCHIO DOVE CHIEDO PRIMA QUANTI PRODOTTI VANNO AGGIUNTI
        // AL CARRELLO--------------

        // definisco un array di tipo prodotto dove andrò a inserire i prodotti del
        // carrello
        // int numeroProdottiCarrello = -1;
        // do {
        // try {
        // System.out.println("Quanti prodotti vuoi inserire nel carrello?");
        // numeroProdottiCarrello = input.nextInt();
        // } catch (InputMismatchException e) {
        // System.out.println("Inserisci un numero valido!");
        // input.nextLine(); // pulisce il buffer
        // numeroProdottiCarrello = -1; // forza la ripetizione del ciclo
        // }
        // } while (numeroProdottiCarrello == -1);

        // ---NUOVO METODO PER RENDERE I NUMERO DEI PRODOTTI AL CARRELLO DINAMICO CON
        // RICHIESTA ALLA FINE DI AGGIUNTA PRODOTTO---
        // inizializzo una variabile che mi va a dire se aggiungo prodotto
        boolean aggiungiProdotto = true;

        // inizializzo l'array finale con tutti i prodotti inseriti nel carrello
        Prodotto[] prodottiCarrello = new Prodotto[0];

        // verifico se ha una carta fedelta
        boolean haveFedelityCard = false;
        String codeFedelity = "";
        String rispostaFedelity;
        do {
            System.out.println("Hai una carta fedeltà?\" \"Yes\"  o  \"No\" ?");
            rispostaFedelity = input.next();

            // se risposta è negativo rendo aggiungiprodotto falso così da uscire dal ciclo
            if (rispostaFedelity.toLowerCase().equals("yes")) {
                haveFedelityCard = true;
            }
        } while (!rispostaFedelity.toLowerCase().equals("yes") && !rispostaFedelity.toLowerCase().equals("no"));
        if (haveFedelityCard) {
            System.out.println("Inserisci qui il tuo codice fedeltà:");
            codeFedelity = input.next();
        } else {
            System.out.println("Nessun codice fedeltà inserito");
        }

        // faccio un ciclo dove vado a far inserire al'utente i prodotti nel carrello
        // finchè non mi dice di non aggiungere più prodotti
        while (aggiungiProdotto) {

            // gestisco l'array in cui voglio salvare i prodotti
            // creo un nuovo array momentaneo incrementando la dimensione di uno rispetto
            // all'array prodotto
            // vado a copiarmi i dati già esistenti in array prodotticarrello
            Prodotto[] momentaneoProdottiCarrello = new Prodotto[prodottiCarrello.length + 1];
            for (int i = 0; i < prodottiCarrello.length; i++) {
                momentaneoProdottiCarrello[i] = prodottiCarrello[i];
            }

            // definisco un array di stringhe con le categorie dei prodotti
            String[] category = { "Smartphone", "Televisione", "Cuffie" };
            int caso = 0;

            // stampo categorie e chiedo a quale categoria è interessato
            do {
                try {
                    System.out.println("-------------PRODOTTI DISPONIBILI---------\n");
                    for (int index = 0; index < category.length; index++) {
                        System.out.printf("%d - %s\n", index + 1, category[index]);

                    }
                    System.out.println("\nSelezionare in numero della categoria di prodotto interessato:");
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

                    // creo un nuovo elemento smartphone e lo salvo come ultimo elemento dell'array
                    // nuovo momentaneo da copiare nell'arrai prodotti carrello finale
                    Smartphone smartphoneCarrello = new Smartphone(nome, marca, price, memory);
                    if (haveFedelityCard) {
                        smartphoneCarrello.setFedelityCode(codeFedelity);
                    }
                    momentaneoProdottiCarrello[prodottiCarrello.length] = smartphoneCarrello;

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

                    // creo un nuovo elemento TV e lo salvo come ultimo elemento dell'array
                    // nuovo momentaneo da copiare nell'arrai prodotti carrello finale
                    TV televisioneCarrello = new TV(nome, marca, price, altezza, lunghezza, larghezza, smart);
                    if (haveFedelityCard) {
                        televisioneCarrello.setFedelityCode(codeFedelity);
                    }
                    momentaneoProdottiCarrello[prodottiCarrello.length] = televisioneCarrello;
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

                    // creo un nuovo elemento cuffie e lo salvo come ultimo elemento dell'array
                    // nuovo momentaneo da copiare nell'arrai prodotti carrello finale
                    Cuffie cuffieCarrello = new Cuffie(nome, marca, price, color, wirless);
                    if (haveFedelityCard) {
                        cuffieCarrello.setFedelityCode(codeFedelity);
                    }
                    momentaneoProdottiCarrello[prodottiCarrello.length] = cuffieCarrello;
                    break;
            }

            // vado a sovrascrivere prodottiCarrello con carrelloMomentaneo
            prodottiCarrello = momentaneoProdottiCarrello;

            // creo variabile moemntanea per verificare la risposta ad aggiunta carrello
            String rispostaAddProduct;
            do {
                System.out.println("Vuoi aggiungere un prodotto al carrello?\" \"Yes\"  o  \"No\" ?");
                rispostaAddProduct = input.next();

                // se risposta è negativo rendo aggiungiprodotto falso così da uscire dal ciclo
                if (rispostaAddProduct.toLowerCase().equals("no")) {
                    aggiungiProdotto = false;
                }
            } while (!rispostaAddProduct.toLowerCase().equals("yes") && !rispostaAddProduct.toLowerCase().equals("no"));
        }

        // stampo il carrello definitivo
        System.out.println("\n++++++++++CARRELLO++++++++++++\n");
        for (int i = 0; i < prodottiCarrello.length; i++) {

            System.out.printf("---------PRODOTTO %d------------\n%s\n\n", i + 1, prodottiCarrello[i].toString());
        }
        input.close();

    }
}
