public class polyobject {
	public static void main(String[] args) {
		Student stu = new Xiaoming();
		manager manager_ = new manager();
		manager_.get_info(stu);


	}

	public class Student {
	}
	public class Xiaoming extends Student {
		String name = "xiaoming";
		int age = 18;
	}
	public class Zhangsan extends Student {
		String name = "zhangsan";
		int age = 17;
	}

	public class manager {
		public void get_info(Student stu) {
			System.out.println("Name = " + stu.name + "Age = " + stu.age);
		}
	}
}