package tabGA;

import java.util.ArrayList;


/**
 * The Class Lute.
 */
public class Lute {

	/** The Constant SEVENTH_COURSE_FLATS_STRING. */
	// Courses up to fret 5 with flats
	public static final String[] SEVENTH_COURSE_FLATS_STRING = { "F2", "Gb2",
		"G2", "Ab2", "A2" };
	
	/** The Constant SIXTH_COURSE_FLATS_STRING. */
	public static final String[] SIXTH_COURSE_FLATS_STRING = { "G2", "Ab2",
			"A2", "Bb2", "B2" };
	
	/** The Constant FIFTH_COURSE_FLATS_STRING. */
	public static final String[] FIFTH_COURSE_FLATS_STRING = { "C3", "Db3",
			"D3", "Eb3", "E3" };
	
	/** The Constant FOURTH_COURSE_FLATS_STRING. */
	public static final String[] FOURTH_COURSE_FLATS_STRING = { "F3", "Gb3",
			"G3", "Ab3", "A3" };
	
	/** The Constant THIRD_COURSE_FLATS_STRING. */
	public static final String[] THIRD_COURSE_FLATS_STRING = { "A3", "Bb3",
			"B3", "C4", "Db4" };
	
	/** The Constant SECOND_COURSE_FLATS_STRING. */
	public static final String[] SECOND_COURSE_FLATS_STRING = { "D4", "Eb4",
			"E4", "F4", "Gb4" };
	
	/** The Constant FIRST_COURSE_FLATS_STRING. */
	public static final String[] FIRST_COURSE_FLATS_STRING = { "G4", "Ab4",
			"A4", "Bb4", "B4", "C5", "Db5", "D5", "Eb5", "E5", "F5", "Gb5",
			"G5", "Ab5", "A5" };

	/** The Constant SEVENTH_COURSE_SHARPS_STRING. */
	// Courses up to fret 5 with sharps
	public static final String[] SEVENTH_COURSE_SHARPS_STRING = { "F2", "F#2",
		"G2", "G#2", "A2" };
	
	/** The Constant SIXTH_COURSE_SHARPS_STRING. */
	public static final String[] SIXTH_COURSE_SHARPS_STRING = { "G2", "G#2",
			"A2", "A#2", "B2" };
	
	/** The Constant FIFTH_COURSE_SHARPS_STRING. */
	public static final String[] FIFTH_COURSE_SHARPS_STRING = { "C3", "C#3",
			"D3", "D#3", "E3" };
	
	/** The Constant FOURTH_COURSE_SHARPS_STRING. */
	public static final String[] FOURTH_COURSE_SHARPS_STRING = { "F3", "F#3",
			"G3", "G#3", "A3" };
	
	/** The Constant THIRD_COURSE_SHARPS_STRING. */
	public static final String[] THIRD_COURSE_SHARPS_STRING = { "A3", "A#3",
			"B3", "C4", "C#4" };
	
	/** The Constant SECOND_COURSE_SHARPS_STRING. */
	public static final String[] SECOND_COURSE_SHARPS_STRING = { "D4", "D#4",
			"E4", "F4", "F#4" };
	
	/** The Constant FIRST_COURSE_SHARPS_STRING. */
	public static final String[] FIRST_COURSE_SHARPS_STRING = { "G4", "G#4",
			"A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5",
			"G5", "G#5", "A5" };

	/** The Constant FRET_POSITIONS. */
	// Fret positions (DO NOT USE J)
	public static final char[] FRET_POSITIONS = { 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p' };

	/** The Constant NUMERIC_FRET_POSITIONS. */
	// Guitar tab style positions
	public static final String[] NUMERIC_FRET_POSITIONS = { "0", "1", "2", "3",
			"4", "5", "6", "7", "8", "9", "N10", "N11", "N12", "N13", "N14" };

	/** The Constant LOWEST_NOTE. */
	public static final int LOWEST_NOTE = 41;
	
	/** The Constant HIGHEST_NOTE. */
	public static final int HIGHEST_NOTE = 81;

	/** The Constant PITCH_41_POSITIONS. */
	// Pitch positions. 1st char is string/course, 2nd(& 3rd) fret num. 0 = open
	public static final String[] PITCH_41_POSITIONS = { "70" };
	
	/** The Constant PITCH_42_POSITIONS. */
	public static final String[] PITCH_42_POSITIONS = { "71" };
	
	/** The Constant PITCH_43_POSITIONS. */
	public static final String[] PITCH_43_POSITIONS = { "72", "60" };
	
	/** The Constant PITCH_44_POSITIONS. */
	public static final String[] PITCH_44_POSITIONS = { "73", "61" };
	
	/** The Constant PITCH_45_POSITIONS. */
	public static final String[] PITCH_45_POSITIONS = { "74", "62" };
	
	/** The Constant PITCH_46_POSITIONS. */
	public static final String[] PITCH_46_POSITIONS = { "75", "63" };
	
	/** The Constant PITCH_47_POSITIONS. */
	public static final String[] PITCH_47_POSITIONS = { "76", "64" };
	
	/** The Constant PITCH_48_POSITIONS. */
	public static final String[] PITCH_48_POSITIONS = { "77", "65", "50" };
	
	/** The Constant PITCH_49_POSITIONS. */
	public static final String[] PITCH_49_POSITIONS = { "78", "66", "51" };
	
	/** The Constant PITCH_50_POSITIONS. */
	public static final String[] PITCH_50_POSITIONS = { "79", "67", "52" };
	
	/** The Constant PITCH_51_POSITIONS. */
	public static final String[] PITCH_51_POSITIONS = { "710", "68", "53" };
	
	/** The Constant PITCH_52_POSITIONS. */
	public static final String[] PITCH_52_POSITIONS = { "711", "69", "54" };
	
	/** The Constant PITCH_53_POSITIONS. */
	public static final String[] PITCH_53_POSITIONS = { "712", "610", "55", "40" };
	
	/** The Constant PITCH_54_POSITIONS. */
	public static final String[] PITCH_54_POSITIONS = { "713", "611", "56", "41" };
	
	/** The Constant PITCH_55_POSITIONS. */
	public static final String[] PITCH_55_POSITIONS = { "714", "612", "57", "42" };
	
	/** The Constant PITCH_56_POSITIONS. */
	public static final String[] PITCH_56_POSITIONS = { "613", "58", "43" };
	
	/** The Constant PITCH_57_POSITIONS. */
	public static final String[] PITCH_57_POSITIONS = { "614", "59", "44", "30" };
	
	/** The Constant PITCH_58_POSITIONS. */
	public static final String[] PITCH_58_POSITIONS = { "510", "45", "31" };
	
	/** The Constant PITCH_59_POSITIONS. */
	public static final String[] PITCH_59_POSITIONS = { "511", "46", "32" };
	
	/** The Constant PITCH_60_POSITIONS. */
	public static final String[] PITCH_60_POSITIONS = { "512", "47", "33" };
	
	/** The Constant PITCH_61_POSITIONS. */
	public static final String[] PITCH_61_POSITIONS = { "513", "48", "34" };
	
	/** The Constant PITCH_62_POSITIONS. */
	public static final String[] PITCH_62_POSITIONS = { "514", "49", "35", "20" };
	
	/** The Constant PITCH_63_POSITIONS. */
	public static final String[] PITCH_63_POSITIONS = { "410", "36", "21" };
	
	/** The Constant PITCH_64_POSITIONS. */
	public static final String[] PITCH_64_POSITIONS = { "411", "37", "22" };
	
	/** The Constant PITCH_65_POSITIONS. */
	public static final String[] PITCH_65_POSITIONS = { "412", "38", "23" };
	
	/** The Constant PITCH_66_POSITIONS. */
	public static final String[] PITCH_66_POSITIONS = { "413", "39", "24" };
	
	/** The Constant PITCH_67_POSITIONS. */
	public static final String[] PITCH_67_POSITIONS = { "414", "310", "25", "10" };
	
	/** The Constant PITCH_68_POSITIONS. */
	public static final String[] PITCH_68_POSITIONS = { "311", "26", "11" };
	
	/** The Constant PITCH_69_POSITIONS. */
	public static final String[] PITCH_69_POSITIONS = { "312", "27", "12" };
	
	/** The Constant PITCH_70_POSITIONS. */
	public static final String[] PITCH_70_POSITIONS = { "313", "28", "13" };
	
	/** The Constant PITCH_71_POSITIONS. */
	public static final String[] PITCH_71_POSITIONS = { "314", "29", "14" };
	
	/** The Constant PITCH_72_POSITIONS. */
	public static final String[] PITCH_72_POSITIONS = { "210", "15" };
	
	/** The Constant PITCH_73_POSITIONS. */
	public static final String[] PITCH_73_POSITIONS = { "211", "16" };
	
	/** The Constant PITCH_74_POSITIONS. */
	public static final String[] PITCH_74_POSITIONS = { "212", "17" };
	
	/** The Constant PITCH_75_POSITIONS. */
	public static final String[] PITCH_75_POSITIONS = { "213", "18" };
	
	/** The Constant PITCH_76_POSITIONS. */
	public static final String[] PITCH_76_POSITIONS = { "214", "19" };
	
	/** The Constant PITCH_77_POSITIONS. */
	public static final String[] PITCH_77_POSITIONS = { "110" };
	
	/** The Constant PITCH_78_POSITIONS. */
	public static final String[] PITCH_78_POSITIONS = { "111" };
	
	/** The Constant PITCH_79_POSITIONS. */
	public static final String[] PITCH_79_POSITIONS = { "112" };
	
	/** The Constant PITCH_80_POSITIONS. */
	public static final String[] PITCH_80_POSITIONS = { "113" };
	
	/** The Constant PITCH_81_POSITIONS. */
	public static final String[] PITCH_81_POSITIONS = { "114" };

	/**
	 * Gets the legal positions.
	 *
	 * @param pitch the pitch
	 * @param eventNum the event num
	 * @return the legal positions
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
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

	/**
	 * Gets the course.
	 *
	 * @param position the position
	 * @return the course
	 */
	public static int getCourse(String position) {

		return (int) position.charAt(0);

	}

	/**
	 * Gets the fret.
	 *
	 * @param position the position
	 * @return the fret
	 */
	public static int getFret(String position) {

		return (int) Integer
				.getInteger(position.substring(1, position.length()));

	}

}
