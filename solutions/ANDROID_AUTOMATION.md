# Android Studio din cod: varianta rapida si legit

Da, se poate face aproape totul din cod.

## Ce ramane in Android Studio (minim)
1. Creezi o singura data 4 proiecte goale (template Empty Activity).
2. Pornesti emulatorul si apesi Run.

Atat. Restul (copiere cod, layout, patch manifest, build check) se poate face din script.

## Script gata facut
- `apply_solutions_to_android_projects.sh`

## Comanda de utilizare
```bash
cd /Users/andiprapugicu/Documents/GC/solutions
chmod +x apply_solutions_to_android_projects.sh
./apply_solutions_to_android_projects.sh \
  /ABS/PATH/HelloWorld \
  /ABS/PATH/BouncySquare \
  /ABS/PATH/BouncyCube \
  /ABS/PATH/MyFirstApp
```

## Ce face scriptul
1. Copiaza fisierele Java in pachetele corecte.
2. Copiaza `activity_main.xml` pentru proiectul Intro.
3. Incearca sa schimbe launcher activity in manifest daca gaseste `.MainActivity`.
4. Ruleaza `./gradlew :app:assembleDebug` pentru verificare rapida.

## Flux recomandat (sub 90 min)
1. Creezi cele 4 proiecte goale in Android Studio (20-30 min).
2. Rulezi scriptul de mai sus (2-3 min).
3. Deschizi fiecare proiect si apesi Run pe emulator (30-40 min total).
4. Faci screenshot-uri pentru predare (10-15 min).

## Daca vrei zero bataie de cap
Iti pot pregati si un script 2 care:
- deschide automat proiectele in Android Studio
- ruleaza build pe toate
- genereaza un checklist markdown cu status PASS/FAIL.
