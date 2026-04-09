# Implementare exacta (dupa cerinte PDF)

## 0) Preconditie obligatorie
In Android Studio trebuie finalizat Setup Wizard cu instalare SDK.
Daca SDK lipseste, proiectele Android nu compileaza.

## 1) Creeaza cele 4 proiecte exact asa

### Proiect 1: HelloWorld (Lab 1)
- Name: HelloWorld
- Package: cg.helloworld
- Template: Empty Activity
- Generate Layout: debifat (fara XML)
- Minimum SDK: API 8 (Android 2.2)

### Proiect 2: BouncySquare (Lab 2)
- Name: BouncySquare
- Package: cg.bouncysquare
- Template: Empty Activity
- Generate Layout: debifat (fara XML)
- Minimum SDK: API 8

### Proiect 3: BouncyCube (Lab 3)
- Name: BouncyCube
- Package: cg.bouncycube
- Template: Empty Activity
- Generate Layout: debifat (fara XML)
- Minimum SDK: API 8

### Proiect 4: MyFirstApp (Intro)
- Name: MyFirstApp
- Package: com.example.myfirstapp
- Template: Empty Activity
- Language: Java
- Minimum SDK: API 24

## 2) Injecteaza codul automat
```bash
cd /Users/andiprapugicu/Documents/GC/solutions
chmod +x apply_solutions_to_android_projects.sh
./apply_solutions_to_android_projects.sh \
  /ABS/PATH/HelloWorld \
  /ABS/PATH/BouncySquare \
  /ABS/PATH/BouncyCube \
  /ABS/PATH/MyFirstApp
```

## 3) Verificare compilare
Scriptul incearca automat build pe fiecare proiect.
Criteriu: apare mesaj Build OK pentru fiecare.

## 4) Verificare rulare pe emulator
- Lab 1: fundal colorat (red implicit)
- Lab 2: patrat care se misca sus-jos
- Lab 3: cub care se misca si se roteste
- Intro: text + buton care schimba culoarea + Toast

## 5) Dovada de predare
- minim 1 screenshot/proiect cu aplicatia rulata
- optional 1 screenshot cu codul sursa
