# zahlenRaten

Klassisches Zahlen-Raten-Spiel in zwei Varianten: **menschlicher Spieler** vs. **KI mit binärer Suche**. Unterrichtsmaterial für die Einführung von Schleifen, Zufallszahlen und Suchalgorithmen.

## Enthaltene Klassen

| Klasse | Beschreibung |
|--------|--------------|
| `ZahlenRaten` | Interaktives Spiel: Mensch rät, Computer bewertet (`zu groß` / `zu klein` / `Treffer`) |
| `AI_ZahlenRaten` | KI rät automatisch per binärer Suche – halbiert bei jedem Versuch den Suchbereich |

## Lernziele

- `do-while`-Schleife (Fußprüfung: Bedingung wird erst am Ende geprüft)
- Zufallszahlen mit `Math.random()`
- Konsoleneingabe mit `Scanner`
- **Binäre Suche** als effizienter Suchalgorithmus – im Vergleich zur linearen Suche

## Binäre Suche erklärt

Die KI halbiert bei jedem Versuch den Suchbereich:

```
Wertebereich = 100, gesuchte Zahl = 73:
  Versuch 1: 50   → zu klein  → min=50
  Versuch 2: 75   → zu groß   → max=75
  Versuch 3: 62   → zu klein  → min=62
  Versuch 4: 68   → zu klein  → min=68
  Versuch 5: 71   → zu klein  → min=71
  Versuch 6: 73   → TREFFER (in 6 Versuchen)
```

Maximale Versuche: **⌈log₂(n)⌉** – bei `n = 100` sind das höchstens 7 Versuche, bei `n = 1 000 000` höchstens 20.

## Projektstruktur

```
zahlenRaten/
└── zahlenRaten/              ← Eclipse-Projekt
    ├── README.md             ← detailliertere Version
    └── src/zahlenRaten/
        ├── ZahlenRaten.java
        └── AI_ZahlenRaten.java
```

## Ausführen

Das Eclipse-Projekt liegt im Unterordner `zahlenRaten/`. Beide Klassen besitzen eine eigene `main`-Methode und lassen sich direkt ausführen.

## Kontext

Unterrichtsmaterial Informatik, Sekundarstufe I/II (Schiller-Gymnasium Offenburg).
