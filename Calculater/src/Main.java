
public class Main {

	public static void main(String args[]) {
		
		//入力
		String input = Get.getInput();
		
		//計算
		double result = Cal.calInput(Operator.addMultiplication(input));
		
		//出力
		System.out.println("計算結果：" + result);
	}
}
