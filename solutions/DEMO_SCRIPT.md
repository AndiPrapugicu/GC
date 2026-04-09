# Script de prezentare (2-4 minute)

## Structura de prezentare
1. Spui pe scurt scopul: OpenGL ES 1.x, randare 2D si 3D, plus exercitiu Android UI.
2. Rulezi Lab 1 si arati ca fundalul se deseneaza corect.
3. Rulezi Lab 2 si explici pe scurt translatarea sinusoidala.
4. Rulezi Lab 3 si explici translatarea + doua rotatii + frustum.
5. Rulezi Intro Android si apesi butonul de schimbare culoare.

## Fraze scurte utile la sustinere
- "In onDrawFrame refac fiecare cadru si aplic transformarile." 
- "In onSurfaceChanged setez viewport-ul si frustum-ul." 
- "Datele geometrice sunt trimise prin vertex/color buffers." 
- "La UI, butonul schimba culoarea textului si afiseaza Toast." 

## Intrebari probabile + raspuns scurt
1. De ce se foloseste glLoadIdentity?
R: Ca sa resetez matricea inainte de noile transformari pe fiecare frame.

2. De ce nu se vad unele fete ale cubului?
R: Pentru ca este activ backface culling (optimizare).

3. Ce face zNear/zFar?
R: Definesc planele de clipping pe adancime in frustum.

4. De ce folosesti sin pentru miscare?
R: Produce oscilatie lina, naturala, intre valori pozitive si negative.
