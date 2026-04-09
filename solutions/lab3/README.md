# Laborator 3 - BouncyCube

## Fisiere
- `BouncyCubeActivity.java`
- `CubeRenderer.java`
- `Cube.java`

## Setup Android Studio
1. Proiect nou: `BouncyCube`, package `cg.bouncycube`.
2. Empty Activity, fara layout XML.
3. Copiezi clasele din acest folder in pachetul proiectului.
4. Rulezi pe emulator.

## Cerinte assignment (ce trebuie testat)
1. Schimba ordinea celor 2 rotatii si translatiei in `onDrawFrame`.
2. Adauga `glScalef(1, 2, 1)` in pozitii diferite si observa efectul.
3. Schimba `zFar` din `1000` in `6.0`.
4. Revino cu `zFar = 1000`, apoi schimba `zNear` din `0.1` in `6.0`.
5. Schimba componenta `z` din `glTranslatef` in `-20`.
6. Schimba `fieldOfView` la `10` grade (in radiani: `10.0f / 57.3f`).
7. In `onSurfaceCreated`, adauga `gl.glCullFace(GL10.GL_FRONT);`.
