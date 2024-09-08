
import java.util.Scanner;

public class Get {

	public static String getInput() {
		
		System.out.println("計算式を入力してください。");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		return input;
	}
}
