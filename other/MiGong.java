/*老鼠出迷宫问题*/

public class MiGong {
	public static void main(String[] args) {
		int[][] MiGong = CreatMiGong();
		for(int i = 0; i < MiGong.length; i++) {
			for(int j = 0; j < MiGong[i].length; j++) {
				System.out.print(MiGong[i][j] + " ");
			}
			System.out.print("\n");
		}
		Find(MiGong, 1, 1);

		System.out.print("\n\n\n");
		for(int i = 0; i < MiGong.length; i++) {
			for(int j = 0; j < MiGong[i].length; j++) {
				System.out.print(MiGong[i][j] + " ");
			}
			System.out.print("\n");
		}
	}//main end
	/*初始化迷宫*/
	public static int[][] CreatMiGong() {
		int [][] arr = new int[8][7];
		for(int i = 0; i < 7; i++) {
			arr[0][i] = 1;
			arr[7][i] = 1;
		}
		for(int i = 0; i < 8; i++) {
			arr[i][0] = 1;
			arr[i][6] = 1;
		}
		arr[3][1] = 1;
		arr[3][2] = 1;
		return arr;
	}//function end
	/*找路函数*/
	public static boolean Find(int[][] map, int x, int y) {
		if(map[6][5] == 2)
			return true;
		else {
			if(map[x][y] == 0) {	//当前位置能走
				map[x][y] = 2;		//走过的路标记为2

				if(Find(map, x+1, y)) {//递归探测是否有出路
					return true;	//向下找到出路
				}
				else if(Find(map, x, y+1)) {
					return true;	//向右找到出路
				}
				else if(Find(map, x-1, y)) {
					return true;
				}
				else if(Find(map, x, y-1)) {
					return true;
				}
				else {
					return false;	//找不到出路
				}
		 	}
		 	else 
		 		return false;	//遇到障碍物或标记2
		}
	}
}

