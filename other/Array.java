public class Array {
	public static void main(String[] args){

		char[] abcArray = new char[26];
		for(int i = 0; i < abcArray.length; i++){
			abcArray[i] = (char)('A' + i);
		}

		
		for(int j = 0; j < abcArray.length; j++){
			System.out.print(abcArray[j] + " ");
		}
	}
}