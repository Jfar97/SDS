package Class and State Machine Diagrams;

/**
 * This class represents a medication with its essential details, including its name, type, available quantity, and availability time window.Represents the availability of food at a restaurant location.
 */
public class FoodItem {

	/**
	 * Unique name given to a restaurant
	 */
	public final String restuarantName = None;

	/**
	 * Name of food item
	 */
	private final String itemName;

	/**
	 * Number of food items
	 */
	protected int quantity = 0;

	/**
	 * Unique five digit ID
	 */
	final String id = 00000;

	private LocalDateTime availabilityStart;

	private LocalDateTime availabilityEnd;

	private CampusLocation location;

	public FoodItem(String restaurant, String item, int amount, LocalDateTime start, LocalDateTime end, CampusLocation location) {

	}

	public String getRestaurant() {
		return null;
	}

	public String getItemName() {
		return null;
	}

	public int getQuantity() {
		return 0;
	}

	public String getID() {
		return null;
	}

	public LocalDateTime getAvailabilityStart() {
		return null;
	}

	public LocalDateTime getAvailabilityEnd() {
		return null;
	}

	public CampusLocation getLocation() {
		return null;
	}

	public void decrementQuantity(int int amount) {

	}

	public void assignID(int String newID) {

	}

}
