package ru.netology.smarthome;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Radio, implements the following public methods only:
 * <p>
 * next() & prev(), tunes to the next/prev station number, returns int stationNumber;
 * tune(int), tunes to the station, receives RC key number as int, returns int stationNumber.
 * <p>
 * volUp() & volDn(), sets volume Up/Down, returns int stationVolume.
 * <p>
 * *********************************************************************************
 * All setters are PRIVATE, not included into API. Use _tested_ PUBLIC methods only!
 * *********************************************************************************
 */

public class Radio {

    static final int FIRST_STATION = 0;
    static final int DEFAULT_STATIONS_NUMBER = 10;
    static final int MIN_VOLUME = 0;
    static final int MAX_VOLUME = 100;

    @Getter
    private final int LAST_STATION;

    @Getter
    private int stationNumber;
    @Getter @Setter
    private int stationVolume;

    /**
     * Instantiates a new Radio.
     *
     * @param maxStations max number of stations
     */
    public Radio(int maxStations) {
        if (maxStations < 1) {
            LAST_STATION = DEFAULT_STATIONS_NUMBER;
        } else {
            LAST_STATION = maxStations;
        }
    }

    /**
     * Instantiates a new Radio with DEFAULT_STATIONS_NUMBER.
     */
    public Radio() {
        LAST_STATION = DEFAULT_STATIONS_NUMBER;
    }

    /**
     * Next int.
     *
     * @return the int
     */
    public int next() {
        int num = getStationNumber();
        if (num == LAST_STATION) {
            num = FIRST_STATION;
        } else {
            ++num;
        }
        return tune(num);
    }

    /**
     * Prev int.
     *
     * @return the int
     */
    public int prev() {
        int num = getStationNumber();
        if (num == FIRST_STATION) {
            num = LAST_STATION;
        } else {
            --num;
        }
        return tune(num);
    }

    /**
     * Tune int.
     *
     * @param stationNumber the station number
     * @return the int
     */
    public int tune(int stationNumber) {
        setStationNumber(stationNumber);
        return getStationNumber();
    }

    private void setStationNumber(int stationNumber) {
        if (stationNumber < FIRST_STATION || stationNumber > LAST_STATION) {
            return;
        }
        this.stationNumber = stationNumber;
    }

    /**
     * Vol up int.
     *
     * @return the int
     */
    public int volUp() {
        int vol = getStationVolume();
        if (vol < MAX_VOLUME) {
            vol = volume(vol + 1);
        }
        return vol;
    }

    /**
     * Vol dn int.
     *
     * @return the int
     */
    public int volDn() {
        int vol = getStationVolume();
        if (vol > MIN_VOLUME) {
            vol = volume(vol - 1);
        }
        return vol;
    }

    /**
     * Do not use this undocumented method, ever -- for accompanying test class only!
     */
    int volume(int vol) {
        setStationVolume(vol);
        return getStationVolume();
    }
}
