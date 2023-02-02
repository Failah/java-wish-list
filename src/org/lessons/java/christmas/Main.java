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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> desideri = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		boolean continua = true;

		while (continua) {
			System.out.println("La lista dei desideri contiene " + desideri.size() + " elementi.");
			System.out.print("Inserisci un nuovo elemento alla lista o digita 'stop' per terminare: ");
			String desiderio = s.nextLine();
			System.out.println();

			if (desiderio.equals("stop")) {
				continua = false;
			} else {
				desideri.add(desiderio);
			}
		}

		Collections.sort(desideri);
		System.out
				.println("La lista dei desideri è composta da " + desideri.size() + " elementi, che sono i seguenti: ");
		int i = 1;
		for (String desiderio : desideri) {
			System.out.println("Elemento " + i + " => " + desiderio);
			i++;
		}

		s.close();
	}
}
