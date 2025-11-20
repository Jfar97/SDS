package Class and State Machine Diagrams;

import java.util.List;

public class Broker {

	private Map<String, List<Subscription>> subscriptions;

	private Map<String, List<FoodItem>> foodItems;

	private ArrayList<String> notifications;

	private int idCount = 0;

	private Subscription subscription;

	private FoodItem foodItem;

	private FoodItem foodItem;

	public Broker() {

	}

	public void addSubscription(Subscription subscription) {

	}

	public void addPublishedFoodItem(FoodItem publication) {

	}

	public void addNotification(String dinerName, int amount, FoodItem food) {

	}

	public void matchNewSubscription(Subscription subscription) {

	}

	public void matchNewFoodItem(FoodItem food) {

	}

	public ArrayList<String> getNotifications() {
		return null;
	}

	public void reset() {

	}

	public void notifySubscriber(String name) {

	}

}
