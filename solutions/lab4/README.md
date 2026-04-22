# Laborator 4 - Lights (OpenGL ES 1.x)

## Fisiere
- `BouncyCubeActivity.java`
- `CubeRenderer.java`
- `Cube.java`

## Ce s-a adaugat fata de Lab 3
1. Normale per varf in `Cube` (`mNormalBuffer`, `glNormalPointer`, `GL_NORMAL_ARRAY`).
2. Configurare lumina in `CubeRenderer` (`initLighting`).
3. Materiale (`GL_DIFFUSE`, `GL_AMBIENT`, `GL_SPECULAR`) + `GL_SHININESS`.
4. Atenuare liniara (`GL_LINEAR_ATTENUATION`).
5. Parametri spotlight (`GL_SPOT_DIRECTION`, `GL_SPOT_CUTOFF`, `GL_SPOT_EXPONENT`).

## Setup Android Studio
1. Deschide proiectul `BouncyCube` (package `cg.bouncycube`).
2. Copiaza clasele din acest folder in pachetul proiectului.
3. Ruleaza pe emulator/device.

## Checklist experimente (cerinte Lab 4)
1. Diffuse lighting:
- Schimba culoarea luminii diffuse (verde/alb) si observa culoarea cubului.
2. Material diffuse:
- Schimba materialul intre `red`, `green`, `blue` si compara rezultatul sub lumina alba.
3. Specular lighting:
- Modifica `GL_SHININESS` (ex: `5`, `25`) si observa cum se concentreaza highlight-ul.
4. Ambient lighting:
- Schimba componentele ambient pentru light/material si observa iluminarea de baza.
5. Attenuation:
- Modifica `GL_LINEAR_ATTENUATION` si/sau pozitia luminii pentru a vedea scaderea intensitatii cu distanta.
6. Spotlight:
- Modifica directia (`GL_SPOT_DIRECTION`) si unghiul (`GL_SPOT_CUTOFF`) pentru a orienta fasciculul.

## Observatie
Build local in acest mediu nu poate fi validat complet deoarece este disponibil doar JVM 8, iar Gradle din proiect cere JVM 17+.
