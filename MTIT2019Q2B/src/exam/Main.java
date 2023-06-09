package exam;

public class Main {
	public static void main(String[] args) {
		new Thread(() -> {
			for (int row = 1; row <= 5; row++) {
				for (int column = 1; column <= 5; column++) {
					System.out.print(column + " ");
				}
				System.out.println();
			}
		}).start();
	}
}
