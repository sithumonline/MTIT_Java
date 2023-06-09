package exam;

import java.util.ArrayList;
import java.util.List;

interface ITrafficService {
	String checkSpeed(List<Double> listOfCheckPoints);
}

public class Main {
	public static void main(String[] args) {
		ITrafficService trafficService = (List<Double> listOfCheckPoints) -> {
			double total = 0;
			for (Double speed : listOfCheckPoints) {
				total += speed;
			}
			double averageSpeed = total / listOfCheckPoints.size();
			if (averageSpeed >= 100.0) {
				return "Issue Fine";
			} else if (averageSpeed >= 80.0) {
				return "Warning message";
			} else if (averageSpeed >= 50.0) {
				return "Good speed";
			} else if (averageSpeed >= 30.0) {
				return "Normal";
			} else {
				return "Slow";
			}
		};

		ArrayList<Double> speedInCheckPoint = new ArrayList<>();
		speedInCheckPoint.add(20.0);
		speedInCheckPoint.add(3.0);
		speedInCheckPoint.add(6.0);
		speedInCheckPoint.add(8.0);
		speedInCheckPoint.add(1.0);
		speedInCheckPoint.add(120.0);

		String result = trafficService.checkSpeed(speedInCheckPoint);
		System.out.println("Vehicle average status is = " + result);
	}
}
