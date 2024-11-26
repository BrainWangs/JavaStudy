/*选择排序算法*/
public class selection_sort {
	public static void main(String[] args) {
		int[] arr = {15, 5, 5, 2, 7, 6, 1, 4, 3, 9, 8};

		for(int i = 0; i < arr.length; i++) {
			int min = arr[i];
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
				}
			}//每次循环完可以找出本轮的最小值
			arr[i] = min; //依次将每轮最小值排序
		}


		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}//main end
}