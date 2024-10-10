# Stundenplan-Backend [ in Arbeit ]

Hier entsteht eine stark vereinfachte Stundenplan-API, umgesetzt mit Kotlin und Spring.

#### Schule

##### Eingaben:
- Name der Schule
- Schulform: Grundschule, Oberschule
  - Liste von Klassen: 1-6 oder 7-12 je nach Schulform (konkrete Klassen z.B. 1a, 5b)
    - Liste von Unterricht
      - Anzahl der Stunden pro Woche
      - Fach

##### Ausgabe:
Stundenplan, ungefähr so:

```
{
    "schule": {
        "name": "...",
        ...
    }
}
```

#### Initial vorhanden:

- [ ] Fächer:
    - verfügbar für Klassen: 1-12
- [x] eine Beispiel-Schule mit allen nötigen Einträgen (siehe POST in beispiel-requests.http)

#### Speicherung der Daten:

- eine H2 DB in einer physikalischen Datei im Projektverzeichnis

#### TODOs

- [x] Liste von Fächern bei Klasse in der DB speichern
- [ ] weitere Endpoints
- [ ] Lehrer:
    - [ ] Fächer (die sie unterrichten könnten)
    - [ ] Klassen (die sie unterrichten könnten): 1-12
    - [ ] Klassenleiter für: Klasse 1-12 (Auswahl an bereits vorhandenen Klassen)
- [ ] minimale Logik für Stundenplan + Endpoints
- [ ] CRUD für alles, was nötig ist
- [x] H2 File DB
- [ ] ArchUnit?!
