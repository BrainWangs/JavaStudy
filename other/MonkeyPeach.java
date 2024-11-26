/*猴子吃桃问题,猴子每天吃二分之一加一个桃子,求桃子总数*/

public class MonkeyPeach {
	public static void main(String[] args) {
		peach(1);
	}
	
	public static int peach(int day) {
		
		if(day == 10){
			return 1;
		}
		else {
			int nextday = peach(day + 1);	
			int today = (nextday + 1)*2;
			System.out.println("today the peaches are " + today);
			return today;	//把每天的桃子数量作为返回值
		}
	}
}