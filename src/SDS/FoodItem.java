//package Class and State Machine Diagrams;
package SDS;

import java.time.LocalDateTime;

/**
 * This class represents a medication with its essential details, including its name, type, available quantity, and availability time window.Represents the availability of food at a restaurant location.
 */
public class FoodItem {

	/**
	 * Unique name given to a restaurant
	 */
	//public final String restuarantName = None;
	public final String restuarantName;

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
	//final String id = 00000;
	private String id = "00000";

	private LocalDateTime availabilityStart;

	private LocalDateTime availabilityEnd;

	private CampusLocation location;

	public FoodItem(String restaurant, String item, int amount, LocalDateTime start, LocalDateTime end, CampusLocation location) {
		this.restuarantName = restaurant;
		this.itemName = item;
		this.quantity = amount;
		this.availabilityStart = start;
		this.availabilityEnd = end;
		this.location = location;
	}

	public String getRestaurant() {
		//return null;
		return this.restuarantName;
	}

	public String getItemName() {
		//return null;
		return this.itemName;
	}

	public int getQuantity() {
		//return 0;
		return this.quantity;
	}

	public String getID() {
		//return null;
		return this.id;
	}

	public LocalDateTime getAvailabilityStart() {
		//return null;
		return this.availabilityStart;
	}

	public LocalDateTime getAvailabilityEnd() {
		//return null;
		return this.availabilityEnd;
	}

	public CampusLocation getLocation() {
		//return null;
		return this.location;
	}

	public void decrementQuantity(int amount) {
		this.quantity -= amount;
		if(this.quantity < 0) {
			this.quantity = 0;
		}
	}

	public void assignID(String newID) {
		this.id = newID;
	}

}
