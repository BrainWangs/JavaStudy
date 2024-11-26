public class EightQueen {
	int[][] arr = new int[8][8];
	public static void main(String[] args) {

	}
	public static boolean test(int x, int y) {
		if(x < 8 && y < 8) {
			if(test(x, y + 1)) {
				arr[x][y] = 1;
				if(arr[x - 1][y] == 1) 
			}
		}
		else 
			return false;
		
	}
}