package exam;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		Thread producerThread = new Thread(() -> {

			int value = 0;
			while (true) {
				System.out.println("Producer started");
				try {
					synchronized (list) {
						value += 10;
						list.add(value);
						System.out.println("Producer adding value = " + value + " to Queue");
						System.out.println("Elements in Queue after add = " + list);
						list.notify(); // Notify consumer thread
						list.wait(); // Wait for consumer thread to remove value
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumerThread = new Thread(() -> {

			int value = 0;
			while (true) {
				System.out.println("Consumer started");
				try {
					synchronized (list) {
						Thread.sleep(1000); // Wait for producer to add value
						value = list.remove(0);
						System.out.println("Consumer remove value = " + value + " from Queue");
						System.out.println("Elements in Queue after remove = " + list);
						list.notify(); // Notify producer thread
						list.wait(); // Wait for producer thread to add value
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		producerThread.start();
		consumerThread.start();
	}
}
