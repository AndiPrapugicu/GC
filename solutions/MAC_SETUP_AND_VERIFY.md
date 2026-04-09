# macOS setup + verificare rapida

## Situatia ta curenta
- Android Studio: lipsa
- Android SDK: lipsa
- adb/emulator: lipsa

## Exista pachet VSCode care inlocuieste Android Studio?
Nu. VSCode are extensii pentru editare, dar nu inlocuieste complet Android SDK + Emulator + Device Manager.
Pentru laborator, varianta stabila este Android Studio.

## Instalare pe macOS
1. Instaleaza Android Studio de pe site-ul oficial Android Developers.
2. La primul start, accepta instalarea componentelor recomandate:
- Android SDK
- Android SDK Platform-Tools
- Android Emulator
3. In Android Studio, deschide Device Manager si creeaza un emulator.

## Verificare instalare (Terminal)
Ruleaza:

```bash
adb --version
emulator -version
```

Daca ambele raspund cu versiuni, mediul e ok.

## Verificare proiecte (fara click-uri inutile)
1. Creezi proiectele goale in Android Studio:
- HelloWorld
- BouncySquare
- BouncyCube
- MyFirstApp

2. Rulezi scriptul de injectare cod:

```bash
cd /Users/andiprapugicu/Documents/GC/solutions
chmod +x apply_solutions_to_android_projects.sh
./apply_solutions_to_android_projects.sh \
  /ABS/PATH/HelloWorld \
  /ABS/PATH/BouncySquare \
  /ABS/PATH/BouncyCube \
  /ABS/PATH/MyFirstApp
```

3. Daca scriptul afiseaza Build OK pentru fiecare proiect, compilarea este buna.
4. In Android Studio, apesi Run pe emulator pentru fiecare proiect si verifici vizual rezultatul.

## Cum stii ca functioneaza corect
- Build trece fara erori.
- Aplicatia se lanseaza pe emulator.
- Comportamentul vizual corespunde cerintei fiecarui laborator.
