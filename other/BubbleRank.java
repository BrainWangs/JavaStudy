public class BubbleRank {
	public static void main(String[] args){

		int[] arr = {3, 88, 88, 21, 45, 6, 65, 34, 3, 3};
	

		//start 一个简单的冒泡排序
		int middle = 0;	
		/*for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[i] > arr[j]){
					middle = arr[j];
					arr[j] = arr[i];
					arr[i] = middle;
					
				}
			}
		}
*/
		
		for(int i = 0; i < arr.length - 1; i++){
			for(int j = 0; j < arr.length - i - 1; j++){
				if(arr[j] > arr[j + 1]){
					middle = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = middle;
				}
			}
		}
		//end
		for(int k = 0; k < arr.length; k++){
			System.out.print(arr[k] + " ");
		}
	}
}