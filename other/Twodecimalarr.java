/*二维数组*/
public class Twodecimalarr {
	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		int[][] arr2 = {{0,1,2},
						{2,3,4},
						{4,5}	};
		int[][] arr3 = new int[3][];	//列数不确定,此时一维数组的值为null

		//输出并求和
		int sum = 0;
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[i].length; j++) {
				sum += arr2[i][j];
				System.out.print(arr2[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print(sum + "\n");

		//非齐次动态初始化
		for(int i = 0; i < arr3.length; i++) {
			arr3[i] = new int[i + 1];	//给每个一维数组分配内存空间
			for(int j = 0; j < arr3[i].length; j++) {
				arr3[i][j] = j;	
			}
		}
		//输出
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr3[i].length; j++) {
				System.out.print(arr3[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}