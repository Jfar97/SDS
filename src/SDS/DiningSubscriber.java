package Class and State Machine Diagrams;

/**
 * DiningSubscriber represents a subscriber in the dining subscription system. Represents a diner who participates in the subscription process for a food item. This class implements the ISubscriber interface, providing a concrete definition of the subscription behavior.
 */
public class DiningSubscriber implements ISubscriber {

	private String name;

	private Broker broker;

	private Broker broker;

	public DiningSubscriber(String name, Broker broker) {

	}

	public String getName() {
		return null;
	}


	/**
	 * @see Class and State Machine Diagrams.ISubscriber#subscribe(java.lang.String, int, Class and State Machine Diagrams.LocalDateTime, Class and State Machine Diagrams.LocalDateTime, Class and State Machine Diagrams.CampusLocation)
	 */
	public void subscribe(String foodItemName, int quantity, LocalDateTime requestStart, LocalDateTime requestEnd, CampusLocation preferredCampusLocation) {

	}

}
