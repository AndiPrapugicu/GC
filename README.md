# GC - Predare Laboratoare

Acest repository contine implementarea pentru laboratoarele de Computer Graphics (OpenGL ES 1.x) si exercitiul de introducere in Android Studio.

## Structura repository-ului
- `solutions/` - codul de baza, scripturi de automatizare si documentatie de lucru
- `android_projects_snapshot/` - snapshot al celor 4 proiecte Android Studio, gata de evaluare

## Laboratoare incluse
1. Laborator 1 - HelloWorld OpenGL ES
2. Laborator 2 - BouncySquare (randare 2D)
3. Laborator 3 - BouncyCube (randare 3D)
4. Laborator 4 - Lights pe BouncyCube (normale + lighting + materials)
5. Introducere Android Studio - TextView + Button + schimbare culoare + Toast

## Cum se ruleaza proiectele
1. Deschide in Android Studio unul dintre proiectele din `android_projects_snapshot/`.
2. Asteapta finalizarea sincronizarii Gradle.
3. Selecteaza un emulator sau un device fizic.
4. Ruleaza configuratia `app`.
5. Repeta pentru toate cele 4 proiecte.

## Verificare rapida pentru evaluare
- Lab 1: aplicatia deseneaza fundalul cu culoarea setata in renderer.
- Lab 2: patratul este afisat si are miscare verticala.
- Lab 3: cubul este afisat, se misca si se roteste.
- Lab 4: cubul foloseste iluminare OpenGL ES (diffuse/specular/ambient) si normale.
- Intro Android: butonul schimba culoarea textului si afiseaza mesaj Toast.

## Observatii
- Proiectele au fost compilate local inainte de publicare.
- Daca nu apare niciun device la rulare, porneste emulatorul din Device Manager.
