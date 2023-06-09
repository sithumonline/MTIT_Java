package exam;

import java.util.ArrayList;
import java.util.List;

interface IVehicle {
	void displayVehicles();
}

public class Main {
	public static void main(String[] args) {
		IVehicle iVehicle = Main::displayVehicles;
		iVehicle.displayVehicles();
	}

	public static void displayVehicles() {
		List<String> vehicles = new ArrayList<>();
		vehicles.add("Car");
		vehicles.add("Bus");
		vehicles.add("Van");
		vehicles.add("Jeep");
		vehicles.add("Lorry");
		vehicles.forEach(System.out::println);
	}
}
