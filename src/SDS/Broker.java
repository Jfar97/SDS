//package Class and State Machine Diagrams;
package SDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.lang.Math;
import java.util.Map;
import java.time.format.DateTimeFormatter;

public class Broker {

	private Map<String, List<Subscription>> subscriptions;

	private Map<String, List<FoodItem>> foodItems;

	private ArrayList<String> notifications;

	private int idCount = 0;

	//private Subscription subscription;

	//private FoodItem foodItem;

	//private FoodItem foodItem;

	public Broker() {
		this.subscriptions = new HashMap<>();
		this.foodItems = new HashMap<>();
		this.notifications = new ArrayList<>();
	}

	public void addSubscription(Subscription subscription) {
		String itemKey = subscription.getItem().toLowerCase();
		// no subscription instances for that item yet
		if(subscriptions.containsKey(itemKey) == false) {
			ArrayList<Subscription> subList = new ArrayList<>();
			subList.add(subscription);
			subscriptions.put(itemKey, subList);
		}
		// add another subscription for keys
		else {
			List<Subscription> subList = subscriptions.get(itemKey);
			subList.add(subscription);
		}

		matchNewSubscription(subscription);
	}

	public void addPublishedFoodItem(FoodItem publication) {
		String nextID = Integer.toString(idCount);
		publication.assignID(nextID);
		idCount++;

		String itemKey = publication.getItemName().toLowerCase();
		// no food item instances for that item yet
		if(foodItems.containsKey(itemKey) == false) {
			ArrayList<FoodItem> foodList = new ArrayList<>();
			foodList.add(publication);
			foodItems.put(itemKey, foodList);
		}
		// add another food item for key
		else {
			List<FoodItem> foodList = foodItems.get(itemKey);
			foodList.add(publication);
		}

		matchNewFoodItem(publication);
	}

	public void addNotification(String dinerName, int amount, FoodItem food) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

		String message = String.format(
            "%s is notified of %d %s available at %s in %s between %s and %s.",
            dinerName,
            amount,
            food.getItemName(),
            food.getRestaurant(),
            food.getLocation().getDisplayName(),
            food.getAvailabilityStart().format(formatter),
            food.getAvailabilityEnd().format(formatter)
        );

        notifications.add(message);
	}

	public void matchNewSubscription(Subscription subscription) {
		String subFoodItem = subscription.getItem().toLowerCase();

		if(foodItems.containsKey(subFoodItem) == false) {
			return;
		}

		List<FoodItem> currFoods = foodItems.get(subFoodItem);
		int amountRemaining = subscription.getQuantity();

		// Need to iterate over the arraylist to see if multiple restaurants can match the subscription
		for(FoodItem food : currFoods) {
			// Skip instance if campus location does not match
			if(subscription.getLocation() != null && (subscription.getLocation() != food.getLocation())) {
				continue;
			}
			// Skip if availabilitys do not match
			if(!(subscription.getStart().isBefore(food.getAvailabilityEnd()) && subscription.getEnd().isAfter(food.getAvailabilityStart()))) {
				continue;
			}

			int foodQuantity = food.getQuantity();
			if (foodQuantity > 0) {
				amountRemaining -= foodQuantity;
				// Full amount met for subscription
				if(amountRemaining <= 0) {
					break;
				}
			}
		}

		// Subscription can not be fulfilled currently
		if(amountRemaining > 0) {
			return;
		}

		amountRemaining = subscription.getQuantity();

		for(FoodItem food : currFoods) {
			// Skip instance if campus location does not match
			if(subscription.getLocation() != null && (subscription.getLocation() != food.getLocation())) {
				continue;
			}
			// Skip if availabilitys do not match
			if(!(subscription.getStart().isBefore(food.getAvailabilityEnd()) && subscription.getEnd().isAfter(food.getAvailabilityStart()))) {
				continue;
			}

			int available = food.getQuantity();
			// No items for current food item for subscription
			if(available <= 0) {
				continue;
			}

			int used = Math.min(available, amountRemaining);
			food.decrementQuantity(used);
			amountRemaining -= used;

			addNotification(subscription.getDiner(), used, food);
			notifySubscriber(subscription.getDiner());

			// Subscription fulfilled
			if(amountRemaining <= 0) {
				break;
			}
		}
	}

	public void matchNewFoodItem(FoodItem food) {
		String foodItem = food.getItemName().toLowerCase();
		if(subscriptions.containsKey(foodItem) == false) {
			return;
		}

		List<Subscription> subsToFood = subscriptions.get(foodItem);
		for(Subscription currSub : subsToFood) {
			matchNewSubscription(currSub);
		}
	}

	public ArrayList<String> getNotifications() {
		//return null;
		return this.notifications;
	}

	public void reset() {
		subscriptions.clear();
		foodItems.clear();
		notifications.clear();
		idCount = 0;
	}

	public void notifySubscriber(String name) {

	}

}
