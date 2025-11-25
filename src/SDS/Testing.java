//package Class and State Machine Diagrams;
package SDS;

import java.util.List;
import java.util.ArrayList;

public class Testing {

	private SDSSystem system;

	//private SDSSystem sDSSystem;

	//private SDSSystem sDSSystem;

	public Testing() {
		this.system = new SDSSystem();
	}

	/**
	 * Processes a single input command string. The publish and subscribe commands are:
	 * 
	 * publish, [restaurant name], [food item name], [quantity], [start time], [end time], [campus location]
	 * 
	 * subscribe, [diner name], [food item name], [quantity], [start time], [end time], [campus location]
	 */
	public void processInput(String input) {
		if(input == null) {
			return;
		}
		
		// seperate by commas to read type of command
		String[] parts = input.split(",");
		if(parts.length == 0) {
			return;
		}

		// handle command dtypes
		String command = parts[0].trim().toLowerCase();

		// publish command
		if("publish".equals(command)) {
			this.system.publishCommand(input);
		}
		// subscribe command
		else if ("subscribe".equals(command)) {
			this.system.subscriptionCommand(input);
		}
		else {
			return;
		}
	}

	/**
	 * Returns all notifications collected by the Broker
	 */
	public List<String> getAggregatedOutput() {
		//return null;
		List<String> output = new ArrayList<>();
		output = this.system.getBrokerNotifications();
		return output;
	}

	/**
	 * Resets Broker and clears all data
	 */
	public void reset() {
		this.system.resetSystem();
	}

}
