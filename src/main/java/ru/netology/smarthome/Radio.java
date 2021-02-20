package ru.netology.smarthome;

/**
 * The type Radio, implements the following public methods only:
 * <p>
 * next() & prev(), tunes to the next/prev station number, returns int stationNumber;
 * tune(int), tunes to the station, receives RC key number as int, returns int stationNumber.
 * <p>
 * volUp() & volDn(), sets volume Up/Down, returns int stationVolume.
 * <p>
 * *********************************************************************************
 * All setters are PRIVATE, not included into API, use _tested_ PUBLIC methods only!
 * *********************************************************************************
 */


public class Radio {

	private static final int FIRST_STATION = 0;
	private static final int LAST_STATION = 9;
	private static final int MIN_VOLUME = 0;
	private static final int MAX_VOLUME = 10;

	private int stationNumber;
	private int stationVolume;

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
	 * Gets station number.
	 *
	 * @return the station number
	 */
	public int getStationNumber() {
		return stationNumber;
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
	 * Volume int.
	 *
	 * @param vol the vol
	 * @return the int
	 */
	int volume(int vol) {
		setStationVolume(vol);
		return getStationVolume();
	}

	private void setStationVolume(int stationVolume) {
		this.stationVolume = stationVolume;
	}

	public int getStationVolume() {
		return stationVolume;
	}
}
