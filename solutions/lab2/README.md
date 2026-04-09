# Laborator 2 - BouncySquare

## Fisiere
- `BouncySquareActivity.java`
- `SquareRenderer.java`
- `Square.java`

## Setup Android Studio
1. Proiect nou: `BouncySquare`, package `cg.bouncysquare`.
2. Empty Activity, fara layout XML.
3. Copiezi clasele din acest folder in pachetul proiectului.
4. Rulezi pe emulator.

## Cerinte assignment (ce trebuie testat)
1. In `vertices`, schimba primul numar din `-1.0f` in `-2.0f`.
2. Schimba culoarea patratului in verde, apoi in albastru (bufferul `colors`).
3. Inlocuieste `GL_TRIANGLES` in `glDrawElements` cu:
   - `GL_POINTS`
   - `GL_LINE_STRIP`
   - `GL_LINE_LOOP`
   - `GL_LINES`
   - `GL_TRIANGLE_STRIP`
   - `GL_TRIANGLE_FAN`
4. Schimba incrementul `mTransY += 0.075f` in `mTransY += 0.3f`.
5. Lasa dithering activ (sterge `glDisable(GL10.GL_DITHER)`).
6. Schimba culoarea de fundal din `glClearColor(0, 0, 0, 0)`.
