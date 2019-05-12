# Calculator Project Prog1
Készítette: Balla Tamás, Opauszki Filip, Vass Máté

---

## Rövid ismertető
A feladatunk egy saját műveletekkel bővíthető számológép elkészítése volt. A program futás közben új műveleteket keres egy adott mappában (Műveletnév.java néven, lásd a későbbiekben az *Új művelet hozzáadása* résznél), és új operáció esetén új gombot generálva neki az adott művelet már el is végezhető.

### Program futtatása:
A program a GitHub-ról letöltött repository gyökérkönyvtárából indítható az alábbi parancssal:
```bash
java Main
```

### Program használata:
Ha az utóbbi parancsot helyesen írta be a felhasználó, a program el is indult és megjelent a főképernyő. A számokon és a 4 alapműveleten (+, -, /, \*) az alábbi gombok jelennek meg:

* %   :	maradékos osztás maradékát adja
* C   :	utolsó karakter törlése a kifejezés végéről
* CE  :	teljes kifejezés törlése
* =   :	eredmény kiíratása
* ,   :	tizedesvessző
* ... :	*Hozzáadott műveletek* fül megnyitása

A programból kilépni a jobb felső *X* gomb megnyomásával lehet.


### Új művelet hozzáadása (profi felhasználóknak):
Új műveletet hozzáadásához a ~/hu/uszeged/inf/core/builder/operations mappába kell a *Műveletnév.java* fájlt bemásolni, majd egy fordítást végezni a gyökérkönyvtárból az alábbi parancssal:
```bash
find . -name "*.java" | xargs javac
```
A fordítandó *Műveletnév.java* fájlnak pedig a következőképpen kell kinéznie:
```java
package hu.uszeged.inf.core.builder.operations;
import hu.uszeged.inf.core.builder.*;

public class Műveletnév extends HányVáltozós {

	/*	Hány változós a művelet? "HányVáltozós" szó helyére kell az alábbiak egyikét írni:
	 *	egyváltozós: Linear
	 *	kétváltozós: Bivariate
	 *	háromváltozós: Trivariate
	 */

	public Műveletnév() {
		super("művelet ID-je", művelet prioritása);
	}

	/*
	 *	művelet ID-je (String): egy rövid, pár betűs azonosítója a műveletnek, ami még nincs használatban
	 *	művelet prioritása (int): prioritás, minél nagyobb, annál hamarabb kell elvégezni
	 *	pl: összeadásnak 1, szorzásnak 2 a prioritása
	 */

	protected double operation(double param_1, double param_2) {
		/*	Annyi változót kell a függvénynek átadni, amennyi változós,
		 *	majd meg kell valósítani a műveletet.
		 *	Figyelem!!! A változók veremben tárolódnak, fontos figyelni a számok sorrendjére.
		 *	Amelyik szám később lett beolvasva, az szerepel a paraméterek között hamarabb.
		 */
		return param_1 + param_2;
	}
}
```
Fordítás és a megfelelő mappába való bemásolás után a *Hozzáadott műveletek* fül újboli megnyitásával lefut a mappaszkennelés, és az új műveletek azonnal elérhetőek a programon belülről.