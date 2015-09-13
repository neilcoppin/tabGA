package tabGA;

import java.util.ArrayList;

public class Lute {

	// Courses up to fret 5 with flats
	public static final String[] SEVENTH_COURSE_FLATS_STRING = { "F2", "Gb2",
		"G2", "Ab2", "A2" };
	public static final String[] SIXTH_COURSE_FLATS_STRING = { "G2", "Ab2",
			"A2", "Bb2", "B2" };
	public static final String[] FIFTH_COURSE_FLATS_STRING = { "C3", "Db3",
			"D3", "Eb3", "E3" };
	public static final String[] FOURTH_COURSE_FLATS_STRING = { "F3", "Gb3",
			"G3", "Ab3", "A3" };
	public static final String[] THIRD_COURSE_FLATS_STRING = { "A3", "Bb3",
			"B3", "C4", "Db4" };
	public static final String[] SECOND_COURSE_FLATS_STRING = { "D4", "Eb4",
			"E4", "F4", "Gb4" };
	public static final String[] FIRST_COURSE_FLATS_STRING = { "G4", "Ab4",
			"A4", "Bb4", "B4", "C5", "Db5", "D5", "Eb5", "E5", "F5", "Gb5",
			"G5", "Ab5", "A5" };

	// Courses up to fret 5 with sharps
	public static final String[] SEVENTH_COURSE_SHARPS_STRING = { "F2", "F#2",
		"G2", "G#2", "A2" };
	public static final String[] SIXTH_COURSE_SHARPS_STRING = { "G2", "G#2",
			"A2", "A#2", "B2" };
	public static final String[] FIFTH_COURSE_SHARPS_STRING = { "C3", "C#3",
			"D3", "D#3", "E3" };
	public static final String[] FOURTH_COURSE_SHARPS_STRING = { "F3", "F#3",
			"G3", "G#3", "A3" };
	public static final String[] THIRD_COURSE_SHARPS_STRING = { "A3", "A#3",
			"B3", "C4", "C#4" };
	public static final String[] SECOND_COURSE_SHARPS_STRING = { "D4", "D#4",
			"E4", "F4", "F#4" };
	public static final String[] FIRST_COURSE_SHARPS_STRING = { "G4", "G#4",
			"A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5",
			"G5", "G#5", "A5" };

	// Fret positions (DO NOT USE J)
	public static final char[] FRET_POSITIONS = { 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p' };

	// Guitar tab style positions
	public static final String[] NUMERIC_FRET_POSITIONS = { "0", "1", "2", "3",
			"4", "5", "6", "7", "8", "9", "N10", "N11", "N12", "N13", "N14" };

	public static final int LOWEST_NOTE = 41;
	public static final int HIGHEST_NOTE = 81;

	// Pitch positions. 1st char is string/course, 2nd(& 3rd) fret num. 0 = open
	public static final String[] PITCH_41_POSITIONS = { "70" };
	public static final String[] PITCH_42_POSITIONS = { "71" };
	public static final String[] PITCH_43_POSITIONS = { "72", "60" };
	public static final String[] PITCH_44_POSITIONS = { "73", "61" };
	public static final String[] PITCH_45_POSITIONS = { "74", "62" };
	public static final String[] PITCH_46_POSITIONS = { "75", "63" };
	public static final String[] PITCH_47_POSITIONS = { "76", "64" };
	public static final String[] PITCH_48_POSITIONS = { "77", "65", "50" };
	public static final String[] PITCH_49_POSITIONS = { "78", "66", "51" };
	public static final String[] PITCH_50_POSITIONS = { "79", "67", "52" };
	public static final String[] PITCH_51_POSITIONS = { "710", "68", "53" };
	public static final String[] PITCH_52_POSITIONS = { "711", "69", "54" };
	public static final String[] PITCH_53_POSITIONS = { "712", "610", "55", "40" };
	public static final String[] PITCH_54_POSITIONS = { "713", "611", "56", "41" };
	public static final String[] PITCH_55_POSITIONS = { "714", "612", "57", "42" };
	public static final String[] PITCH_56_POSITIONS = { "613", "58", "43" };
	public static final String[] PITCH_57_POSITIONS = { "614", "59", "44", "30" };
	public static final String[] PITCH_58_POSITIONS = { "510", "45", "31" };
	public static final String[] PITCH_59_POSITIONS = { "511", "46", "32" };
	public static final String[] PITCH_60_POSITIONS = { "512", "47", "33" };
	public static final String[] PITCH_61_POSITIONS = { "513", "48", "34" };
	public static final String[] PITCH_62_POSITIONS = { "514", "49", "35", "20" };
	public static final String[] PITCH_63_POSITIONS = { "410", "36", "21" };
	public static final String[] PITCH_64_POSITIONS = { "411", "37", "22" };
	public static final String[] PITCH_65_POSITIONS = { "412", "38", "23" };
	public static final String[] PITCH_66_POSITIONS = { "413", "39", "24" };
	public static final String[] PITCH_67_POSITIONS = { "414", "310", "25", "10" };
	public static final String[] PITCH_68_POSITIONS = { "311", "26", "11" };
	public static final String[] PITCH_69_POSITIONS = { "312", "27", "12" };
	public static final String[] PITCH_70_POSITIONS = { "313", "28", "13" };
	public static final String[] PITCH_71_POSITIONS = { "314", "29", "14" };
	public static final String[] PITCH_72_POSITIONS = { "210", "15" };
	public static final String[] PITCH_73_POSITIONS = { "211", "16" };
	public static final String[] PITCH_74_POSITIONS = { "212", "17" };
	public static final String[] PITCH_75_POSITIONS = { "213", "18" };
	public static final String[] PITCH_76_POSITIONS = { "214", "19" };
	public static final String[] PITCH_77_POSITIONS = { "110" };
	public static final String[] PITCH_78_POSITIONS = { "111" };
	public static final String[] PITCH_79_POSITIONS = { "112" };
	public static final String[] PITCH_80_POSITIONS = { "113" };
	public static final String[] PITCH_81_POSITIONS = { "114" };

	public static ArrayList<FingeredNote> getLegalPositions(int pitch, int eventNum)
			throws IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException {

		int validPitch = pitch;

		while (validPitch < 41 || validPitch > 81)
			if (validPitch > 81) {
				validPitch = validPitch - 12;
			} else if (pitch < 41) {
				validPitch = validPitch + 6;
			}

		String fieldName = "PITCH_" + validPitch + "_POSITIONS";
		// String value =
		// String.valueOf(TesterConstants.class.getField(fieldName).get(null));
		// System.out.println(fieldName);
		String[] positionStrings = (String[]) Lute.class.getField(fieldName)
				.get(null);

		/*
		 * for (int i=0; i<positionStrings.length; i++) {
		 * System.out.println(positionStrings[i]); }
		 */

		ArrayList<FingeredNote> positions = new ArrayList<FingeredNote>();
		for (int i = 0; i < positionStrings.length; i++) {

			positions.add(new FingeredNote(positionStrings[i], validPitch, eventNum, positionStrings.length, i));
			// System.out.println(new FingeredNote(positionStrings[i]));

		}

		return positions;
	}

	public static int getCourse(String position) {

		return (int) position.charAt(0);

	}

	public static int getFret(String position) {

		return (int) Integer
				.getInteger(position.substring(1, position.length()));

	}

}
