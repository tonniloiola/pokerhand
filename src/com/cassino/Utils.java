package com.cassino;

public class Utils {
	
	public static boolean isMaior(Double d1, Double d2) {
		boolean isMaior = false;

		int retval = Double.compare(d1, d2);

		if (retval > 0) {
			isMaior = true;
		}

		return isMaior;

	}

	public static boolean isMenor(Double d1, Double d2) {
		boolean isMaior = false;

		int retval = Double.compare(d1, d2);

		if (retval < 0) {
			isMaior = true;
		}

		return isMaior;

	}

	public static boolean isIgual(Double d1, Double d2) {
		boolean isMaior = false;

		int retval = Double.compare(d1, d2);

		if (retval == 0) {
			isMaior = true;
		}

		return isMaior;

	}
}
