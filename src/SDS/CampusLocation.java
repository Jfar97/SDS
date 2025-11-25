//package Class and State Machine Diagrams;
package SDS;

/**
 * Enumeration representing all the restaurant locations.
 */
public enum CampusLocation {

	TEMPE("Tempe"),

	POLYTECHNIC("Polytechnic"),

	PHOENIX("Phoenix"),

	WEST("West");

	private final String displayName;

	/*Location(String displayName) {

	}*/

	private CampusLocation(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		//return null;
		return this.displayName;
	}

	public static CampusLocation fromString(String text) {
		String textString = text.trim().toLowerCase();
		for(CampusLocation loc : values()) {
			if(loc.displayName.toLowerCase().equals(textString)) {
				return loc;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		//return null;
		return this.displayName;
	}

}
