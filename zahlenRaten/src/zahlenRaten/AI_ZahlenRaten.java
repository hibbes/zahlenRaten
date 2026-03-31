package zahlenRaten;

import java.util.Scanner;

/**
 * KI-gesteuerte Variante des Zahlen-Raten-Spiels: Der Computer rät die Zahl
 * mithilfe der <b>Binären Suche</b>.
 *
 * <h2>Was ist binäre Suche?</h2>
 * <p>Die binäre Suche halbiert bei jedem Schritt den Suchbereich.
 * Ausgangspunkt: Der Bereich ist [min, max].<br>
 * Jeder Rateversuch ist die Mitte des aktuellen Bereichs.
 * Ist die Mitte zu groß, wird max auf die Mitte gesetzt.
 * Ist sie zu klein, wird min auf die Mitte gesetzt.
 * So wird der Bereich bei jedem Versuch halbiert.</p>
 *
 * <p><b>Maximale Versuche:</b> log₂(wertebereich). Bei 100 Zahlen ≤ 7 Versuche.</p>
 *
 * <pre>
 * Beispiel (wertebereich=100, gesuchte Zahl=73):
 *   Versuch 1: Mitte von [0,100] = 50   → zu klein  → min=50
 *   Versuch 2: Mitte von [50,100] = 75  → zu groß   → max=75
 *   Versuch 3: Mitte von [50,75] = 62   → zu klein  → min=62
 *   Versuch 4: Mitte von [62,75] = 68   → zu klein  → min=68
 *   Versuch 5: Mitte von [68,75] = 71   → zu klein  → min=71
 *   Versuch 6: Mitte von [71,75] = 73   → TREFFER!
 * </pre>
 *
 * <p><b>Lernziele:</b>
 * <ul>
 *   <li>Binäre Suche als effizienter Suchalgorithmus</li>
 *   <li>Statische Klassenvariablen und ihr Scope</li>
 *   <li>Methoden mit Rückgabewert</li>
 *   <li>Vergleich: naives Raten vs. Strategie</li>
 * </ul>
 * </p>
 *
 * @author hibbes
 * @see ZahlenRaten für die manuelle Variante
 */
public class AI_ZahlenRaten {

    // ── Klassenvariablen (gelten für die gesamte Klasse, nicht nur eine Methode) ──
    static int wertebereich = 100;   // Suchbereich: 0 bis wertebereich
    static int min = 0;              // Untere Grenze des aktuellen Suchintervalls
    static int max = wertebereich;   // Obere Grenze des aktuellen Suchintervalls
    static int eingabe = 0;          // Letzter Rateversuch der KI
    static int zaehler = 0;          // Anzahl der bisherigen Versuche

    // Die zu erratende Zufallszahl (einmalig beim Programmstart festgelegt)
    static int zufallsZahl = (int) (Math.random() * wertebereich);

    /**
     * Berechnet den nächsten Rateversuch der KI nach dem Prinzip der binären Suche.
     *
     * <p>Beim ersten Aufruf (zaehler == 0) wird die Mitte des gesamten Bereichs geraten.
     * Bei jedem weiteren Aufruf wird die Mitte des noch verbleibenden Suchintervalls
     * [min, max] als neuer Versuch gewählt.</p>
     *
     * @return Den nächsten Rateversuch der KI
     */
    static int AIraten() {
        if (zaehler == 0) {
            // Erster Versuch: exakt die Mitte des Wertebereichs
            eingabe = max / 2;
            System.out.println("KI rät: " + eingabe);
            return eingabe;
        }

        if (eingabe < zufallsZahl) {
            // Letzter Versuch war zu klein: untere Grenze nach oben verschieben
            min = eingabe;
            eingabe = (min + max) / 2;   // neue Mitte des verbleibenden Bereichs
            System.out.println("KI rät: " + eingabe);
            return eingabe;
        }

        if (eingabe > zufallsZahl) {
            // Letzter Versuch war zu groß: obere Grenze nach unten verschieben
            max = eingabe;
            eingabe = (min + max) / 2;   // neue Mitte des verbleibenden Bereichs
            System.out.println("KI rät: " + eingabe);
            return eingabe;
        }

        return 0;   // Wird nur erreicht, wenn zufallsZahl == eingabe (Treffer)
    }

    /**
     * Simuliert das Ratespiel mit der KI als Ratenden.
     *
     * <p>Die gesuchte Zahl wird zu Beginn verraten (Kontrollausgabe),
     * damit der Ablauf der binären Suche nachvollzogen werden kann.</p>
     *
     * @param wertebereich Suchbereich: 0 bis wertebereich
     */
    static void rateZahl(int wertebereich) {
        // Zahl aufdecken (zur Demonstration und Kontrolle)
        System.out.println("Gesuchte Zahl: " + zufallsZahl);

        do {
            System.out.println("--- Versuch " + (zaehler + 1) + " ---");
            eingabe = AIraten();   // KI berechnet nächsten Versuch
            zaehler++;

            if (zufallsZahl == eingabe) {
                System.out.println("KI hat die Zahl " + zufallsZahl
                    + " in " + zaehler + " Versuchen gefunden!");
                System.out.println("(Optimal: max. " + (int)(Math.log(wertebereich)/Math.log(2)+1) + " Versuche)");
            } else if (zufallsZahl < eingabe) {
                System.out.println("→ zu groß (gesuchte Zahl " + zufallsZahl + " ist kleiner)");
            } else {
                System.out.println("→ zu klein (gesuchte Zahl " + zufallsZahl + " ist größer)");
            }
        } while (zufallsZahl != eingabe);
    }

    /**
     * Startet die KI-Simulation.
     *
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        rateZahl(wertebereich);
    }
}
