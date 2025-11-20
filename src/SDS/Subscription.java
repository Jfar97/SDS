package Class and State Machine Diagrams;

public class Subscription {

	private String dinerName;

	private String itemName;

	private int quantity;

	private LocalDateTime availabilityStart;

	private LocalDateTime availabilityEnd;

	private CampusLocation location [0 ... 1];

	public Subscription(String diner, String item, int quantity, LocalDateTime start, LocalDateTime end) {

	}

	public Subscription(String diner, String item, int quantity, LocalDateTime start, LocalDateTime end, CampusLocation campus) {

	}

	public String getDiner() {
		return null;
	}

	public String getItem() {
		return null;
	}

	public int getQuantity() {
		return 0;
	}

	public LocalDateTime getStart() {
		return null;
	}

	public LocalDateTime getEnd() {
		return null;
	}

	public CampusLocation getLocation() {
		return null;
	}

}
