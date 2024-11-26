public class Thistest {

	public static void main(String[] args) {
		test t = new test();
		t.f2();
	}
	public static class test {
		String name;
		int age;
		int salary;
		//在无参构造器中调用其他构造器
		test() {
			this("jack", 18, 4000);//必须放在首句
			System.out.println("transfered");

		}//在构造器中使用this
		test(String name, int age, int salary) {
			this.name = name;
			this.age = age;
			this.salary = salary;
		}
		void f1() {
			System.out.print("name " + this.name);
		}
		//使用this调用方法f1()
		void f2() {
			this.f1(); 
		}
	}
}