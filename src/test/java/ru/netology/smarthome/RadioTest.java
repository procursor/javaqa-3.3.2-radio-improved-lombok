package ru.netology.smarthome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.smarthome.Radio.DEFAULT_STATIONS_NUMBER;
import static ru.netology.smarthome.Radio.FIRST_STATION;
import static ru.netology.smarthome.Radio.MAX_VOLUME;
import static ru.netology.smarthome.Radio.MIN_VOLUME;

import org.junit.jupiter.api.Test;

class RadioTest {

    private final int LAST_STATION = 999;
    Radio station = new Radio(LAST_STATION);

    /*
        The constructor Radio(int) basic sanity check. Also covers 'int' type overflow case.
        Constructor should create a new object with default number of stations if parameter
        is incorrect. That is, if number of stations less than one.
    */
    @Test
    void shouldNotModifyIfBelowMin() {
        Radio station = new Radio(-1);
        assertEquals(DEFAULT_STATIONS_NUMBER, station.getLAST_STATION());
    }

    /*
     * Два теста публичного метода int tune(int) на проверку граничных условий параметра
     * с некорректным номером станции, выходящим за границы.
     *
     * В этом случае номер текущей р/с после такой попытки должен быть по умолчанию: 0
     */

    /*
        1. должен возвращать 0 по умолчанию, если номер р/с за пределами
     */
    @Test
    void shouldSetFirstStationIfNumberLessThanFirstStation() {
        assertEquals(0, station.tune(FIRST_STATION - 1));
    }

    /*
        2. должен возвращать 0 по умолчанию, если номер р/с за пределами
    */
    @Test
    void shouldSetFirstStationIfNumberGreaterThanLastStation() {
        assertEquals(0, station.tune(LAST_STATION + 1));
    }

    /*
        3. должен увеличивать номер текущей радиостанции на единицу
     */
    @Test
    void shouldIncrementStationNumber() {
        station.tune(5);
        assertEquals(5 + 1, station.next());
    }

    /*
        4. должен уменьшать номер текущей радиостанции на единицу
     */
    @Test
    void shouldDecrementStationNumber() {
        station.tune(5);
        assertEquals(5 - 1, station.prev());
    }

    /*
        5. должен устанавливать номер текущей радиостанции номером последней,
        если текущая первая
     */
    @Test
    void shouldSetLastStationNumberOnDecrement() {
        station.tune(FIRST_STATION);
        assertEquals(LAST_STATION, station.prev());
    }

    /*
        6. должен устанавливать номер текущей радиостанции номером первой,
        если текущая последняя
     */
    @Test
    void shouldSetFirstStationNumberOnIncrement() {
        station.tune(LAST_STATION);
        assertEquals(FIRST_STATION, station.next());
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
        assertEquals(5 + 1, station.volUp());
    }

    /*
        8. должен уменьшать громкость на единицу
     */
    @Test
    void shouldDecrementVol() {
        station.volume(5);
        assertEquals(5 - 1, station.volDn());
    }

    /*
        9. НЕ должен увеличивать максимальную громкость
     */
    @Test
    void shouldNotIncreaseVolAboveMax() {
        station.volume(MAX_VOLUME);
        assertEquals(MAX_VOLUME, station.volUp());
    }

    /*
        10. НЕ должен уменьшать минимальную громкость
	*/
    @Test
    void shouldNotDecreaseVolBelowMin() {
        station.volume(MIN_VOLUME);
        assertEquals(MIN_VOLUME, station.volDn());
    }
}