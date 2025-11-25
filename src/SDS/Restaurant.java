//package Class and State Machine Diagrams;
package SDS;

import java.time.LocalDateTime;

/**
 * Restaurant is responsible for publishing menu item availability from a specific dining location. This class represents a restaurant that publishes a food item. This class implements the IPublisher interface, meaning it provides a concrete definition of the publishing process for food item availability.
 */
public class Restaurant implements IPublisher {

	private String name;

	//private Broker broker;

	private Broker broker;

	public Restaurant(String name, Broker broker) {
		this.name = name;
		this.broker = broker;
	}

	public String getName() {
		return this.name;
	}


	/**
	 * @see Class and State Machine Diagrams.IPublisher#publish(java.lang.String, int, Class and State Machine Diagrams.LocalDateTime, Class and State Machine Diagrams.LocalDateTime, Class and State Machine Diagrams.CampusLocation)
	 */
	public void publish(String itemName, int quantity, LocalDateTime availabilityStart, LocalDateTime availabilityEnd, CampusLocation location) {
		FoodItem newFood = new FoodItem(this.name, itemName, quantity, availabilityStart, availabilityEnd, location);
		broker.addPublishedFoodItem(newFood);
	}

}
