package zahlenRaten;

import java.util.Scanner;

public class AI_ZahlenRaten {
	static int wertebereich = 100;
	static int min = 0;
	static int max = wertebereich;
	static int eingabe = 0;
	static int zaehler = 0;// Startet bei Null
	static int zufallsZahl = (int) (Math.random() * wertebereich);

	static int AIraten() {
		if (zaehler == 0) {
			eingabe = max / 2;
			System.out.println(eingabe);
			return eingabe;
		}
		if (eingabe < zufallsZahl) {
			min = eingabe;
			eingabe = (min + max) / 2;

			System.out.println(eingabe);
			return eingabe;
		}
		if (eingabe > zufallsZahl) {
			max = eingabe;
			eingabe = (min + max) / 2;
			System.out.println(eingabe);
			return eingabe;
		}
		return 0;
	}

	static void rateZahl(int wertebereich) {

		System.out.println(zufallsZahl); // Aus Kontrollzwecken

		do {
			System.out.println("Gib eine Zahl zwischen 0 und " + wertebereich + " ein!");

			eingabe = AIraten();
			zaehler++;
			System.out.println("Versuch "+ zaehler);
			if (zufallsZahl == eingabe) {
				System.out.println("Richtig! Du hast " + zaehler + " Durchgänge benötigt.");
			} else if (zufallsZahl < eingabe) {
				System.out.println("Du liegst falsch! Die zu erratende Zahl ist kleiner, nämlich " + zufallsZahl);
			} else {
				System.out.println("Du liegst falsch! Die zu erratende Zahl ist größer, nämlich " + zufallsZahl);
			}
		} while (zufallsZahl != eingabe);// Schleifenbedingung im Fuß
	}

	public static void main(String[] args) {
		rateZahl(wertebereich);
	}
}