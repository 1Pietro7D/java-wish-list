package org.lessons.java.christmas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Wish {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter("test.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		HashMap<String, ArrayList<String>> desiresLists = new HashMap<String, ArrayList<String>>();
		String userChoise = "";
		while (!userChoise.equals("6")) { // è vero che non è vero XD lol
			System.out.println("Scegli una delle seguenti azioni, con un numero: ");
			System.out.println("1 - Crea una nuova lista");
			System.out.println("2 - Cancella una lista");
			System.out.println("3 - Stampa su file");
			System.out.println("4 - Cancella da file");
			System.out.println("5 - Leggi da file");
			System.out.println("6 - Termina programma");

			userChoise = s.nextLine();

			switch (userChoise) {
			case "1":
				boolean option1 = true;
				String titleList = "";
				while (titleList.equals("")) {
					System.out.println("Inserisci il titolo della lista: ");
					titleList = s.nextLine();
				}
				ArrayList<String> list = new ArrayList<String>();
				desiresLists.put(titleList, list);
				String item = "";
				while (option1 || item.equals("")) {
					System.out.println("Inserisci un elemento della lista (esc per terminare): ");
					item = s.nextLine();
					if (item.equals("esc")) {
						option1 = false;
						break;
					}
					list.add(item);
				}
				break;
			case "2":
				System.out.println("Quale lista vuoi cancellare : ");
				for (String title : desiresLists.keySet()) {
					System.out.println("Lista - " + title);
				}
				System.out.print("Quale scegli? scrivi il nome del titolo-> ");
				String titleToDelete = s.nextLine();
				if (desiresLists.containsKey(titleToDelete)) {
					desiresLists.remove(titleToDelete);
					System.out.println("Lista eliminata con successo!");
				} else {
					System.out.println("\nIl titolo inserito non esiste.\n");
				}
				break;
			case "3":
				System.out.println("nel file nella directory \"test.txt\" verranno scritte le seguenti liste: ");
				System.out.println("Liste create: ");
				for (String title : desiresLists.keySet()) {
					System.out.println("\nLista - " + title);
					for (String itemList : desiresLists.get(title)) {
						System.out.println("- " + itemList);
					}
				}
				String option3 = "";
				System.out.println("\nVuoi procedere?: se \"s\" bene altrimenti ti rimando al menù principale");
				option3 = s.nextLine();
				if (option3.equals("s")) {
					try {
						for (String title : desiresLists.keySet()) {
							myWriter.write("NOME LISTA: " + title.toUpperCase() + System.lineSeparator());
							int z = 1;
							for (String wish : desiresLists.get(title)) {
								myWriter.write(z + ") " + wish + System.lineSeparator());
								z++;
							}
							myWriter.write(" " + System.lineSeparator());
							myWriter.flush();
						}
						System.out.println("\nScrittura sul file eseguita correttamente.\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				} else {
					System.out.println("Lo considero un no");
					break;
				}
			case "4":
				System.out.println("cooming soon");
				break;
				/*System.out.println("Quali liste vuoi cancellare nel file?");

				String option4 = s.nextLine();
				List<String> lines = Files.readAllLines(Paths.get("file.txt"));
				System.out.println(lines);
				for (String title : desiresLists.keySet()) {
					System.out.println(desiresLists.get(title).size());
					if (option4.equals(title)) {
						for (int i = 0; i < lines.size(); i++) {
							if (lines.get(i).equals("NOME LISTA: " + title.toUpperCase())) {
								lines.remove(i);

								for (int j = 1; j < desiresLists.get(title).size(); j++) {
									lines.remove(i + j);
								}
								break;
							}
						}
						Files.write(Paths.get("test.txt"), lines);
					}
				}*/
			case "5":
				File listaTxt = new File("test.txt");
				try {
					Scanner reader = new Scanner(listaTxt);
					while (reader.hasNextLine()) {
						String data = reader.nextLine();
						System.out.println(data);
					}
					reader.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			case "6":
				System.out.println("Programma terminato");
				break;
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
