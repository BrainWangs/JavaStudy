import java.util.Scanner;

public class ReverseArray {
	public static void main(String[] args) {
		int[] myArray = new int[5];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < myArray.length; i++){
			myArray[i] = scan.nextInt();
		}

		int temp = 0;	//记住要初始化
		for(int i = 0; i < myArray.length/2; i++){
			temp = myArray[i];
			myArray[i] = myArray[myArray.length-1-i];
			myArray[myArray.length-1-i] = temp;
		}
		for(int j = 0; j < myArray.length; j++){
			System.out.print(myArray[j] + " ");
		}
		
	}
}