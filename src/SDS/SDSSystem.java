//package Class and State Machine Diagrams;
package SDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SDSSystem {

	private Broker broker;

	private Map<String, DiningSubscriber> diners;

	private Map<String, Restaurant> restaurants;

	private DateTimeFormatter formatter;

	//private Broker broker;

	//private Restaurant restaurant;

	//private DiningSubscriber diningSubscriber;

	public SDSSystem() {
		this.broker = new Broker();
		this.diners = new HashMap<>();
		this.restaurants = new HashMap<>();
		this.formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	}

	public void subscriptionCommand(String input) {
		// split string:
		/*
		0 = command type
		1 = name
		2 = food item
		3 = quantity
		4 = start date
		5 = end date
		6 = location
		*/
		String[] parts = input.split(",");
		if(parts.length < 6) {
			// invalid command structure
			return;
		}

		// names from input
		String dinerName = parts[1].trim();
		String foodName = parts[2].trim();

		// quantity from input
		String quantityString = parts[3].trim();
		int quantity = Integer.parseInt(quantityString);

		// dates
		String startString = parts[4].trim();
		LocalDateTime start = LocalDateTime.parse(startString, formatter);
		String endString = parts[5].trim();
		LocalDateTime end = LocalDateTime.parse(endString, formatter);

		// Location (if available)
		CampusLocation location = null;
		if(parts.length >= 7) {
			String locationString = parts[6].trim();
			location = CampusLocation.fromString(locationString);
		}

		if(checkForDiner(dinerName.toLowerCase()) == false) {
			// create new diner if they do not
			addNewDiner(dinerName.toLowerCase());
		}

		DiningSubscriber diner = this.diners.get(dinerName.toLowerCase());

		diner.subscribe(foodName, quantity, start, end, location);
	}

	public void publishCommand(String input) {
		// split string:
		/*
		0 = command type
		1 = name
		2 = food item
		3 = quantity
		4 = start date
		5 = end date
		6 = location
		*/
		String[] parts = input.split(",");
		if(parts.length < 7) {
			// invalid command structure
			return;
		}

		// names from input
		String restaurantName = parts[1].trim();
		String foodName = parts[2].trim();

		// quantity from input
		String quantityString = parts[3].trim();
		int quantity = Integer.parseInt(quantityString);

		// dates
		String startString = parts[4].trim();
		LocalDateTime start = LocalDateTime.parse(startString, formatter);
		String endString = parts[5].trim();
		LocalDateTime end = LocalDateTime.parse(endString, formatter);

		// Location
		String locationString = parts[6].trim();
		CampusLocation location = CampusLocation.fromString(locationString);

		// Check if restaurant already exists
		if(checkForRestaurant(restaurantName.toLowerCase()) == false) {
			// create new diner if they do not
			addNewRestaurant(restaurantName.toLowerCase());
		}

		Restaurant restaurant = this.restaurants.get(restaurantName.toLowerCase());

		restaurant.publish(foodName, quantity, start, end, location);
	}

	public List<String> getBrokerNotifications() {
		//return null;
		List<String> output = new ArrayList<>();
		output = this.broker.getNotifications();
		return output;
	}

	public void resetSystem() {
		this.broker.reset();
		diners.clear();
		restaurants.clear();
	}

	private boolean checkForDiner(String name) {
		if(diners.containsKey(name)) {
			return true;
		}
		return false;
	}

	private void addNewDiner(String input) {
		DiningSubscriber diner = new DiningSubscriber(input, this.broker);
		diners.put(diner.getName(), diner);
	}

	private boolean checkForRestaurant(String name) {
		if(restaurants.containsKey(name)) {
			return true;
		}
		return false;
	}

	private void addNewRestaurant(String input) {
		Restaurant restaurant = new Restaurant(input, this.broker);
		restaurants.put(restaurant.getName(), restaurant);
	}
}
