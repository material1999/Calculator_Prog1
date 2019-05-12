# Tesztjegyzőkönyv
Készítette: Balla Tamás, Opauszki Filip, Vass Máté

---

## Röviden a tesztelési módszerünkről:
A tesztelést 2 fázisban végeztük:

* Először a kifejezés fordított lengyel jelölésben való felírásának helyességét ellenőriztük. A Transform osztály egy speciális String-et kapott, a számokat {}, a műveleteket [] jelek közé írva, a végén egy = jellel. Ez egy olyan Stringeket tartalmazó listát gyártott le, ami már fordított lengyel jelölésben tartalmazta a bevitt karaktereket.

	A fordított lengyel jelölésre átalakítást az alábbi videóból tanultuk meg: [Link](https://www.youtube.com/watch?v=LQ-iW8jm6Mk&list=PLmbvoouA4gigsnhvcIhlhwsJpKYJD_Gg0&index=3&t=0s "Fordított lengyel jelölésre alakítás")

	Példa egy helyes bemeneti Stringre:

	```java
	String exampleInput = "{1}[*][(]{3}[+]{4}[/]{2}[)]="
	```

* Miután a Transform osztály helyesen működött, az eredményként kapott Stringeket tartalmazó listát kapta meg a számításokért felelős CoreBuilder osztály, és el lehetett végezni a beírt kifejezést.

## A tesztek eredményei, amiket bárki ki is próbálhat:
A Main futtatásával a terminálban kiírásra kerül az aktuális beviteli String, valamint az = gomb lenyomása után a fordított lengyel jelölésre átalakított String-eket tartalmazó lista is ellenőrizhető.

|   Bemenet   | Fordított lengyel jelölés | Eredmény |
|:-----------:|:-------------------------:|:--------:|
| 1+2=        | 12+=                      |        3 |
| 2\*4=       | 24\*=          			  |        8 |
| 1+2\*3=     | 123\*+=        			  |        7 |
| 1\*2+3=     | 12\*3+=        			  |        5 |
| 1\*(2+3)=   | 123+\*=        			  |        5 |
| 1\*(3+4/2)= | 1342/+\*=      			  |        5 |
| 3\*4/6=     | 34\*6/=        			  |        2 |
