 class Scope {
	  public static void main(String[] args) {
		Person p = new Person();//创建Person的实例p
		p.print();
		p.println();
		T t1 = new T();//创建T的实例t1
		t1.f1();
		t1.f2(p);
	}
}

/*默认是default*/
class Person {
	String name = "jack";	//成员变量

	void print() {
		String name = "tom";
		System.out.println(name);//输出tom
	}
	void println() {
		System.out.println(name);//输出jack
	}
}
 class T {
 	/*访问其他类的变量 方法1*/
 	void f1() {
 		Person per = new Person();//default类对于同包下的所有类都可见
 		System.out.println(per.name);
 	}
 	void f2(Person p) {	// 传入参数是Person的实例
 		System.out.println(p.name);
 	}

 }