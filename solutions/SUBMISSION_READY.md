# Varianta gata de predare (rapid)

## Raspuns scurt la intrebarea ta
Da, trebuie sa faci partea de rulare in Android Studio (build + run pe emulator) ca sa poti demonstra ca functioneaza.

## Plan ultra-rapid (fara pierdere de timp)
1. Creezi 4 proiecte in Android Studio:
- HelloWorld (package: cg.helloworld)
- BouncySquare (package: cg.bouncysquare)
- BouncyCube (package: cg.bouncycube)
- MyFirstApp (package: com.example.myfirstapp)

2. Pentru fiecare proiect, copiezi fisierele din folderul corespunzator:
- lab1 -> clase Java in package
- lab2 -> clase Java in package
- lab3 -> clase Java in package
- intro_android -> MainActivity.java + activity_main.xml

3. Rulezi fiecare proiect pe emulator si faci dovezile de predare:
- 1 screenshot cu ecranul aplicatiei
- 1 screenshot cu codul sursa principal
- optional: scurt clip 10-20 secunde pentru intro_android (apasare buton)

## Ce se vede la fiecare tema
- Lab 1: ecran colorat cu clear color (red by default)
- Lab 2: patrat care se misca sus-jos
- Lab 3: cub 3D care se misca sus-jos si se roteste
- Intro: text + buton care schimba culoarea si afiseaza Toast

## Timp estimat realist
- Setup proiecte: 20-30 min
- Copy/paste fisiere + build fix-uri minore: 30-45 min
- Rulare + screenshot-uri: 15-20 min
Total: aproximativ 1h - 1h 30min

## Daca apare eroare rapida
1. Verifica package name-ul sa fie identic cu cel din fisiere.
2. Verifica numele Activity-ului din AndroidManifest.
3. Pentru intro_android, verifica id-urile din layout: textView, buttonChangeColor.
4. Clean Project + Rebuild Project.

## Ce sa NU faci
- Nu inventa rezultate fara run.
- Nu schimba structura proiectului in ultimul moment.
- Nu lasa warning-uri critice nerezolvate inainte de demo.
