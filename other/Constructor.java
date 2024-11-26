public class Constructor {
	public static void main(String[] args) {
		Person p1 = new Person("jackrolin", 20);//使用构造器
		Person p2 = new Person();//使用自定义的无参构造器
		Cat c = new Cat();//使用无参构造器/默认构造方法
	}

	public static class Person {
		String name;
		int age;
		/*创建构造器*/
		public Person(String n, int a) {
			name = n;
			age = a;
			System.out.println("Initialized as " + n + " and " + a);
		}
		/*构造器重载*/
		public Person(String n) {
			name = n;
			System.out.println("Initialized as " + n);
		} 
		/*创建无参构造器*/
		public Person() {
			name = "jack";
			age = 18;
		}
	}
	public static class Cat {
		String name;
	}
}