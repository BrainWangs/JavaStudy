public class InsertArray {
	public static void main(String[] args) {
		int[] arr = {3, 3, 1, 5, 12, 8, 9};
		Insert(arr);
	}
/*insert function*/
	public static void Insert(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > key) {
				array[j + 1] = array[j];  
			//比较第j个元素与key的关系,若array[j]更大,则右移一位为key腾出位置
				j--;
			}
			array[j + 1] = key; //插入key到第一个比key小(或相等)的元素后面
			/*每次排序结束后输出当前数组*/
			for(int k = 0; k < array.length; k++) {
				System.out.print(array[k] + " ");
			}
			System.out.print("\n");
		}
	}
}