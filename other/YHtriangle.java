import java.util.Scanner;
public class YHtriangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("print an number\n");
		int max = scan.nextInt();

		int[][] arr = new int[max][];

		for(int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1]; //创建空间
			for(int j = 0; j < arr[i].length; j++) {
				if(j == 0 || j == arr[i].length - 1) {
					arr[i][j] = 1;
				}
				else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			} 
		}// for end
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}

	}//main end
}

/*
for i = 0 to n
	for j = 0 to i
		初始化为1	---改进思路--->	使用if else语句判别 初始化的值

for i = 2 to n
	for j = 1 to n-1
		arr[i][j] = arr[i-1][j-1] + arr[i-1][j] 两肩之和

output
*/