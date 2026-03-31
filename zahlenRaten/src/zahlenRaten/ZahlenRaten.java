package zahlenRaten;

import java.util.Scanner;

/**
 * Einfaches Zahlen-Raten-Spiel: Der Computer wählt eine Zufallszahl, der Spieler
 * muss sie durch Eingaben erschließen.
 *
 * <p><b>Spielprinzip:</b>
 * <ol>
 *   <li>Der Computer wählt zufällig eine Zahl zwischen 0 und {@code wertebereich}.</li>
 *   <li>Der Spieler gibt eine Schätzung ein.</li>
 *   <li>Der Computer antwortet mit "zu groß", "zu klein" oder "Richtig!".</li>
 *   <li>Das Spiel endet, wenn die richtige Zahl gefunden wurde.</li>
 * </ol>
 * </p>
 *
 * <p><b>Lernziele:</b>
 * <ul>
 *   <li>{@code do-while}-Schleife mit Abbruchbedingung am Ende</li>
 *   <li>Zufallszahlen mit {@link Math#random()}</li>
 *   <li>Konsoleneingabe mit {@link Scanner}</li>
 *   <li>Verzweigungen ({@code if-else if-else})</li>
 *   <li>Zählvariable für Spielzüge</li>
 * </ul>
 * </p>
 *
 * <p><b>Optimale Strategie (Binäre Suche):</b><br>
 * Bei einem Wertebereich von n benötigt ein optimaler Spieler maximal log₂(n) Versuche.
 * Bei n=10 sind das maximal 4, bei n=100 maximal 7 Versuche.
 * Die KI-Variante {@link AI_ZahlenRaten} implementiert genau diese Strategie.</p>
 *
 * @author hibbes
 * @see AI_ZahlenRaten
 */
public class ZahlenRaten {

    /**
     * Spielt eine Runde Zahlen-Raten mit dem menschlichen Spieler.
     *
     * <p>Die Methode verwendet eine {@code do-while}-Schleife (Fußprüfung):
     * Die Abbruchbedingung wird erst am Ende jedes Durchgangs geprüft, sodass
     * die Schleife mindestens einmal ausgeführt wird – der Spieler macht immer
     * mindestens einen Versuch.</p>
     *
     * @param wertebereich Die gesuchte Zahl liegt zwischen 0 (inkl.) und {@code wertebereich} (exkl.)
     */
    static void rateZahl(int wertebereich) {
        // Zufallszahl im Bereich [0, wertebereich) erzeugen
        // Math.random() liefert einen double in [0.0, 1.0), mit *wertebereich und int-Cast
        // ergibt sich eine ganze Zahl im gewünschten Bereich
        int zufallsZahl = (int) (Math.random() * wertebereich);

        Scanner scanner = new Scanner(System.in);
        int eingabe = 0;    // Speichert den aktuellen Rateversuch des Spielers
        int zaehler = 0;    // Zählt die Anzahl der Versuche

        // do-while: Schleifenrumpf wird mindestens einmal ausgeführt
        do {
            System.out.println("Gib eine Zahl zwischen 0 und " + wertebereich + " ein!");
            eingabe = scanner.nextInt();
            zaehler++;  // Versuch zählen (vor der Auswertung, auch Fehlversuche zählen)

            if (zufallsZahl == eingabe) {
                // Treffer: Spiel beenden
                System.out.println("Richtig! Du hast " + zaehler + " Durchgänge benötigt.");
            } else if (zufallsZahl < eingabe) {
                // Eingabe zu groß: gesuchte Zahl liegt links davon
                System.out.println("Du liegst falsch! Die zu erratende Zahl ist kleiner.");
            } else {
                // Eingabe zu klein: gesuchte Zahl liegt rechts davon
                System.out.println("Du liegst falsch! Die zu erratende Zahl ist größer.");
            }
        } while (zufallsZahl != eingabe);   // Abbruchbedingung: weitermachen, solange noch nicht getroffen
    }

    /**
     * Startet ein Spiel mit Wertebereich 0–9 (10 mögliche Zahlen).
     *
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        rateZahl(10);
    }
}
