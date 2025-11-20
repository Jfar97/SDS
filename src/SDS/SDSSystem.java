package Class and State Machine Diagrams;

import java.util.List;

public class SDSSystem {

	private Broker broker;

	private Map<String, DiningSubscriber> diners;

	private Map<String, Restaurant> restaurants;

	private DateTimeFormatter formatter;

	private Broker broker;

	private Restaurant restaurant;

	private DiningSubscriber diningSubscriber;

	public SDSSystem() {

	}

	public void subscriptionCommand(String input) {

	}

	public void publishCommand(String input) {

	}

	public List<String> getBrokerNotifications() {
		return null;
	}

	public void resetSystem() {

	}

	private boolean checkForDiner(String name) {
		return false;
	}

	private void addNewDiner(String input) {

	}

	private boolean checkForRestaurant(String name) {
		return false;
	}

	private void addNewRestaurant(String input) {

	}

}
