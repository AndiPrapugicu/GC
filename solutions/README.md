# Solutii teme laborator CG

## Structura
- `lab1/` - HelloWorld OpenGL ES 1.x
- `lab2/` - BouncySquare (2D rendering)
- `lab3/` - BouncyCube (3D rendering)
- `lab4/` - BouncyCube Lighting (OpenGL ES 1.x lights + materials)
- `lab5/` - BouncySquare Textures (OpenGL ES 1.x texture mapping)
- `lab6/` - BouncySquare Blending (alpha blending + multitexturing)
- `intro_android/` - Introducere Android Studio (TextView + Button)

## Acoperire cerinte PDF
1. `CG_Laboratory_1_unlocked.pdf.pdf`
- Implementat `HelloWorldActivity` + `HelloWorldRenderer`.
- Aplicatia clear-uieste ecranul cu culoare setata in `glClearColor`.

2. `CG_Laboratory_2_unlocked.pdf.pdf`
- Implementat `Square`, `SquareRenderer`, `BouncySquareActivity`.
- Include translatie sinusoidala, projection frustum, buffers, draw elements.
- README-ul laboratorului contine checklist-ul de experimente cerut in assignment.

3. `CG_Laboratory_3_unlocked.pdf.pdf`
- Implementat `Cube`, `CubeRenderer`, `BouncyCubeActivity`.
- Include bounce, doua rotatii, frustum cu FOV/aspect/zNear/zFar.
- README-ul laboratorului contine checklist-ul de experimente cerut in assignment.

4. `CG_Laboratory_4_unlocked.pdf.pdf`
- Implementat normale per varf in `Cube` si trimitere in pipeline cu `glNormalPointer`.
- Implementat `initLighting` in `CubeRenderer` cu diffuse/ambient/specular, materiale si shininess.
- Include atenuare liniara si parametri spotlight pentru experimentele de lighting.
- README-ul laboratorului contine checklist-ul de experimente cerut in assignment.

5. `CG_Laboratory_5_unlocked.pdf.pdf`
- Implementat `Square`, `SquareRenderer`, `BouncySquareActivity`.
- Include texture mapping folosind `hedly.png` si miscarea verticala a square-ului.
- README-ul laboratorului contine checklist-ul de experimente cerut in assignment.

6. `CG_Laboratory_6_unlocked.pdf.pdf`
- Implementat blending intre doua square-uri colorate.
- Implementat blending pe texturi cu doua resurse si blend additive.
- Implementat multitexturing cu doua texture units si `GL_MODULATE`.
- README-ul laboratorului contine checklist-ul de experimente cerut in assignment.

7. `Introducere în Android Studio.pdf`
- Implementat `MainActivity` + `activity_main.xml` conform ex1 si ex2.
- Butonul schimba culoarea textului si afiseaza Toast.

## Observatii
- Fisierele de aici sunt cod sursa de laborator.
- Nu am rulat emulatorul in acest mediu, deci verificarea finala se face in Android Studio.
