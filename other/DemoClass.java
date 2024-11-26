public class DemoClass {
	public static void main(String[] args) {
		Cat newCat = new Cat();
		newCat.sort = "fff";
		System.out.print(newCat.sort + "\n"); //属性调用
		Cat.function();	// 方法调用


Person p = new Person(); //创建一个Person对象

		

	}//main end
}
class Person {
	String name = "jack";
	int age = 20;
}
class A {
	public static void test(Person p) {
		p = null;
		p = new Person();
	}
}

class Cat {
			String name = "nya";	//利用已有数据类型创建默认属性
			int age = 8;
			String sort;			//创建未初始化的属性

			public static void function() {	//创建一个方法
				System.out.println("hello java!!!");
			}
		}
//编写一个判断奇数的简单方法
class oddselect {
	public static boolean oddselect(int num) {
		/*if(num % 2 == 0){
			return false;
		}
		else {
			System.out.println("is odd");
			return true;
		}*/

		//使用三元运算符
		return num % 2 != 0 ? true : false;
	}
}

