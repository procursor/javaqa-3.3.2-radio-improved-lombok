package ru.netology.smarthome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RadioTest {

    Radio station = new Radio();

    /*
     * public int station.tune(int) sanity checks
     *
     * Два теста на проверку граничных условий *публичного* метода: int tune(int)
     * на тот случай, если его позовут с некоректным параметром номера станции,
     * выходящим за границы условия: "Номер текущей радиостанции изменяется в пределах от 0 до 9".
     *
     * В таком случае номер текущей р/с после попытки такой настройки должен остаться неизменным.
     */

    /*
     1. НЕ должен изменять номер текущей р/с, если номер на входе меньше 0
     */
    @Test
    void shouldNotSetStationIfNumberLessThanFirstStation() {
        station.tune(5);
        assertEquals(5, station.tune(-1));
    }

    /*
     2. НЕ должен изменять номер текущей р/с, если номер на входе больше 9
     */
    @Test
    void shouldNotSetStationIfNumberGreaterThanLastStation() {
        station.tune(5);
        assertEquals(5, station.tune(10));
    }

    /*
     3. должен увеличивать Номер текущей радиостанции на единицу
     */
    @Test
    void shouldIncrementStationNumber() {
        station.tune(5);
        assertEquals(6, station.next());
    }

    /*
     4. должен уменьшать Номер текущей радиостанции на единицу
     */
    @Test
    void shouldDecrementStationNumber() {
        station.tune(5);
        assertEquals(4, station.prev());
    }

    /*
     5. должен устанавливать Номер текущей радиостанции номером первой (0)
     */
    @Test
    void shouldSetFirstStationNumberOnIncrement() {
        station.tune(9);
        assertEquals(0, station.next());
    }

    /*
     6. должен устанавливать Номер текущей радиостанции номером последней (9)
     */
    @Test
    void shouldSetLastStationNumberOnDecrement() {
/*      Radio station.stationNumber should be initialized by 0 on object creation

		station.tune(0);
*/
        assertEquals(9, station.prev());
    }


    /*
     * проверки регулировки громкости
     */

    /*
    7. должен увеличивать громкость на единицу
     */
    @Test
    void shouldIncrementVol() {
        station.volume(5);
        assertEquals(6, station.volUp());
    }

    /*
    8. должен уменьшать громкость на единицу
     */
    @Test
    void shouldDecrementVol() {
        station.volume(5);
        assertEquals(4, station.volDn());
    }

    /*
    9. НЕ должен увеличивать максимальную громкость (> 10)
     */
    @Test
    void shouldNotIncreaseVolAboveMax() {
        station.volume(10);
        assertEquals(10, station.volUp());
    }

    /*
 	10. НЕ должен уменьшать минимальную громкость (< 0)
	*/
    @Test
    void shouldNotDecreaseVolBelowMin() {
        station.volume(0);
        assertEquals(0, station.volDn());
    }
}