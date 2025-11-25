//package Class and State Machine Diagrams;
package SDS;

import java.time.LocalDateTime;

public class Subscription {

	private String dinerName;

	private String itemName;

	private int quantity;

	private LocalDateTime availabilityStart;

	private LocalDateTime availabilityEnd;

	//private CampusLocation location [0 ... 1];
	private CampusLocation location;

	public Subscription(String diner, String item, int quantity, LocalDateTime start, LocalDateTime end) {
		this.dinerName = diner;
		this.itemName = item;
		this.quantity = quantity;
		this.availabilityStart = start;
		this.availabilityEnd = end;
		this.location = null;
	}

	public Subscription(String diner, String item, int quantity, LocalDateTime start, LocalDateTime end, CampusLocation campus) {
		this.dinerName = diner;
		this.itemName = item;
		this.quantity = quantity;
		this.availabilityStart = start;
		this.availabilityEnd = end;
		this.location = campus;
	}

	public String getDiner() {
		//return null;
		return this.dinerName;
	}

	public String getItem() {
		//return null;
		return this.itemName;
	}

	public int getQuantity() {
		//return 0;
		return this.quantity;
	}

	public LocalDateTime getStart() {
		//return null;
		return this.availabilityStart;
	}

	public LocalDateTime getEnd() {
		//return null;
		return this.availabilityEnd;
	}

	public CampusLocation getLocation() {
		//return null;
		return this.location;
	}

}
