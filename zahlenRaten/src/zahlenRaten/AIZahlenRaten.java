package zahlenRaten;
import java.util.Scanner;

public class AIZahlenRaten  {

	static void rateZahl(int wertebereich) {
		int zufallsZahl = (int) (Math.random() * wertebereich);

	//	System.out.println(zufallsZahl); // Aus Kontrollzwecken
		Scanner scanner = new Scanner(System.in);

		//System.out.println("Gib eine Zahl zwischen 0 und "+wertebereich+" ein!");
		int eingabe = 0;//Eingabe startet jetzt bei Null
		int zaehler = 0;// Startet bei Null

		do {
			System.out.println("Gib eine Zahl zwischen 0 und " + wertebereich + " ein!");
			eingabe = scanner.nextInt();
			zaehler++;
			if (zufallsZahl == eingabe) {
				System.out.println("Richtig! Du hast " + zaehler + " Durchgänge benötigt.");
			} else if (zufallsZahl < eingabe) {
				System.out.println("Du liegst falsch! Die zu erratende Zahl ist kleiner");
			} else {
				System.out.println("Du liegst falsch! Die zu erratende Zahl ist größer");
			}
		} 
               while (zufallsZahl != eingabe);//Schleifenbedingung im Fuß
	}

	public static void main(String[] args) {
		rateZahl(10);
	}
}