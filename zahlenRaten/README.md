# zahlenRaten

Klassisches Zahlen-Raten-Spiel in zwei Varianten: **menschlicher Spieler** vs. **KI mit binärer Suche**.

## Enthaltene Klassen

| Klasse | Beschreibung |
|--------|-------------|
| `ZahlenRaten` | Interaktives Spiel: Mensch rät, Computer bewertet |
| `AI_ZahlenRaten` | KI rät automatisch per binärer Suche |

## Lernziele

- `do-while`-Schleife (Fußprüfung: Bedingung wird erst am Ende geprüft)
- Zufallszahlen mit `Math.random()`
- Konsoleneingabe mit `Scanner`
- **Binäre Suche** als effizienter Suchalgorithmus

## Binäre Suche erklärt

Die KI halbiert bei jedem Versuch den Suchbereich:

```
Wertebereich = 100, gesuchte Zahl = 73:
  Versuch 1: 50       → zu klein  → min=50
  Versuch 2: 75       → zu groß   → max=75
  Versuch 3: 62       → zu klein  → min=62
  Versuch 4: 68       → zu klein  → min=68
  Versuch 5: 71       → zu klein  → min=71
  Versuch 6: 73       → TREFFER (in 6 Versuchen)
```

Maximale Versuche: **log₂(n)** – bei n=100 sind das ≤ 7 Versuche.

## Ausführen

Eclipse-Projekt im Unterordner `zahlenRaten/src/zahlenRaten/`. Beide Klassen haben eine `main`-Methode.
