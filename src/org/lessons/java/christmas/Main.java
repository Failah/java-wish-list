/*
 * Creare una classe Main con metodo main, in cui implementare il seguente programma:
creare una nuova ArrayList dove salvare la lista dei desideri
continuare a chiedere all’utente di inserire un nuovo desiderio nella lista, fino a che l’utente sceglie di fermarsi
ad ogni iterazione mostrare la lunghezza della lista e chiedere all’utente se vuole continuare
ad ogni iterazione aggiungere il desiderio alla lista
al termine dell’inserimento ordinare la lista
stampare a video la lista ordinata
 */

package org.lessons.java.christmas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter("file.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean exit = false;

		while (!exit) {
			ArrayList<String> desideri = new ArrayList<String>();
			System.out.println("Inserisci un nuovo elemento alla lista o digita 'stop' per terminare: ");
			String desiderio = s.nextLine();
			while (!desiderio.equals("stop")) {
				desideri.add(desiderio);
				System.out.println("La lista dei desideri contiene " + desideri.size() + " elementi.");
				System.out.print("Inserisci un nuovo elemento alla lista o digita 'stop' per terminare: ");
				desiderio = s.nextLine();
				System.out.println();
			}

			Collections.sort(desideri);
			System.out.println(
					"La lista dei desideri è composta da " + desideri.size() + " elementi, che sono i seguenti: ");
			int i = 1;
			for (String desider : desideri) {
				System.out.println("Elemento " + i + " => " + desider);
				i++;
			}

			// scrivere il file
			System.out.println();
			System.out.println("Vuoi scrivere la lista generata sul file.txt? s/n");
			String input = s.nextLine();
			if (input.equals("s")) {
				try {
					System.out.println("Inserisci il titolo della lista: ");
					String title = s.nextLine();
					myWriter.write("NOME LISTA: " + title.toUpperCase() + System.lineSeparator());
					int j = 1;
					for (String desidero : desideri) {
						myWriter.write(j + ") " + desidero + System.lineSeparator());
						j++;
					}
					myWriter.write(" " + System.lineSeparator());

					System.out.println("Scrittura sul file eseguita correttamente.");
					System.out.println();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// end scrivere il file

			System.out.println("Vuoi creare una nuova lista? s/n");
			String scelta = s.nextLine();
			if (scelta.equals("n")) {
				exit = true;
				System.out.println("Programma terminato.");
			}
		}
		try {
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.close();
	}
}
