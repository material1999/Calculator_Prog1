# Tesztjegyzőkönyv
Készítette: Balla Tamás, Opauszki Filip, Vass Máté

---

A tesztelést 2 fázisban végeztük:

* Először a Tester futtatásával a kifejezés fordított lengyel jelölésben való felírásának helyességét ellenőriztük. A Transform.java egy speciális String-et kapott, a számokat {}, a műveleteket [] jelek közé írva, a végén egy = jellel. Ez egy olyan Stringeket tartalmazó listát gyártott le, ami már fordított lengyel jelölésben tartalmazta a bevitt karaktereket.
	* A fordított lengyel jelölésre átalakítást az alábbi videóból tanultuk meg: [Link](https://www.youtube.com/watch?v=LQ-iW8jm6Mk&list=PLmbvoouA4gigsnhvcIhlhwsJpKYJD_Gg0&index=3&t=0s "Fordított lengyel jelölésre alakítás")

	* Példa egy helyes Tester futtatásra:
	```bash

	java Tester "{1}[*][(]{3}[+]{4}[/]{2}[)]="

	```

* Ezek után ezt a Stringeket tartalmazó listát kapta meg a számításokért felelős osztály, ezt már a Main futtatásával, és az = gomb megnyomásával teszteltük.

## A tesztek eredményei, amiket bárki ki is próbálhat:

|   Bemenet   | Tester kimenet | Main kimenet |
|:-----------:|:--------------:|:------------:|
| 1+2=        | 12+=           |            3 |
| 1+2\*3=     | 123\*+=        |            7 |
| 1\*(2+3)=   | 123+\*=        |            6 |
| 1\*(3+4/2)= | 1342/+\*=      |            5 |

