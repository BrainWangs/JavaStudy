## 面向对象编程(OOP)

---

**什么是面向对象编程(Object Oriented Programming)**

[什么是面向对象-CSDN博客](https://blog.csdn.net/ThinkWon/article/details/100667386)

- 面向过程编程 : 为解决某一个实际问题开发一个程序,每次都要重新开发
- 面向对象编程 : 把实际问题抽象成对象, 编写然后封装, 用户端只需使用接口即可处理问题

## 第一个java程序

---

这是一个示例 

```HelloWorld.java```

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
```
该程序有以下特点:

1. 主程序放在**公共类public class**下面,事实上**在 Java 中，所有代码都位于类的内部**

2. ```public class```下面有一个```public main```函数,由前面的关键字可以看出:

​	这个函数声明了**static静态函数**和**void返回类型**

​	同时传递形参为**string[]空数组** 和**args**两个参数

​	由此我们可以窥见java语言的一些特性

**运行该程序**

**终端运行** :

在终端窗口(powershell或git bash)使用cd命令移动到该文件所在目录下  执行如下命令

```bash
$ javac HelloWorld.java
$ java HelloWorld
Hello World! 
```

第一个命令``` javac <FileName>``` 即 java complier ,它负责编译 .java 文件,并生成一个同名的 .class 文件

紧接着 我们运行 ```java ClassName ```命令,这里的**HelloWorld**即程序的主类名,注意不是文件名

在java中我们运行的是程序的主类 

通过这两步便可在终端窗口中运行java程序,如果情况顺利,则会输出写好的字符串

> 对于Java Could not find or load main class错误类型
>
> 尝试: **java -cp . HelloWorld** 这一命令
>
> -cp . 指定java在当前目录下查找class文件

**这是一种原始的编译方式,但这是所有开发端软件编译的底层原理**

![](https://joshhug.gitbooks.io/hug61b/content/assets/compilation_figure.svg)

---

**使用主流编译器运行 :**

![image-20240801165150295](C:\Users\12275\AppData\Roaming\Typora\typora-user-images\image-20240801165150295.png)



## 变量(variable)

---

输出0 - 10 的简单循环程序

```java
public class Main {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
            x = x + 1;
            System.out.print(x + "\n");     //其效果与println相同
        }

    }
}
```

这里我们可以发现java的一些新特性 :

1. 变量的声明必须声明其类型,这与c/c++相似
2. 在print中引用变量不需要指定转换说明,这又区别于c语言

#### 整型

| 整型  | 占用字节空间大小 |       取值范围       | 默认值 |
| :---: | :--------------: | :------------------: | :----: |
| byte  |      1字节       |      -128 ~ 127      |   0    |
| short |      2字节       |    -32768 ~ 32767    |   0    |
|  int  |      4字节       | -2^31 ~ （2^31） - 1 |   0    |
| long  |      8字节       | -2^63 ~ （2^63） - 1 |   0L   |

#### 浮点型

| 浮点型 | 占用字节空间大小 | 取值范围 | 默认值 |
| :----: | :--------------: | :------: | :----: |
| float  |      4字节       |  10^38   |  0.0F  |
| double |      8字节       |  10^308  |  0.0   |

#### 字符型

| 字符型 | 占用字节空间大小 | 取值范围  | 默认值 |
| :----: | :--------------: | :-------: | :----: |
|  char  |      2字节       | 0 ~ 65535 | ‘\u0’  |

char 数据类型可以储存任何字符 ,实际存储方式是整数型,注意字符只能由一个

#### 布尔型

| 布尔型  | 占用字节空间大小 |  取值范围   | 默认值 |
| :-----: | :--------------: | :---------: | :----: |
| boolean |    视情况而定    | true、false | false  |

#### String

string并非基本的数据类型,它属于**引用类型**(像数组)

它是一个类,**声明String类型的变量即创建一个对象**

String类型创建有两种方式

```java
（1）String s1="abc"；            //s1指向的是方法区中String常量池中的字符串

（2）String s2=new String("abc")；//s2指向的是*堆*上的对象,这里是new了一个String对象
```

这两种方式在jvm内存中的存储方式不同

**String的默认值为null**

**基本数据类型转字符串**

> 基本数据类型 + " " 即可自动转换



---

**静态类型static**

当我们尝试在上面代码中加一句错误类型

```java
public class Main {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
            x = x + 1;
            System.out.print(x + "\n");     //其效果与println相同
        }
        x = "horse";	// <--error
    }
}
```

这时的输出结果

> java: incompatible types: java.lang. **String cannot be converted to int**

**String cannot be converted to int** 说明在程序运行之前,java编译器便发现了此错误

与python等动态类型语言相比,java的静态类型使得它不会出现*类型转换错误*



### 类型转换

---

java中存在与c相同的类型转换

这里引入c的**隐式转换**规则 :

>1、算术运算式中，低类型能够转换为高类型。
>
>​		 例：int + char  +double运算的结果应该为double类型
>
>     2、赋值表达式中，右边表达式的值自动隐式转换为左边变量的类型，并赋值给他。
>
> 		例：int  =  float + char,表达式的右边char 类型和float类型进行运算进行隐式转换为float类型，		在将float类型转换为int类型赋值给表达式左边的int类型变量。
>
>     3、函数调用中参数传递时，系统隐式地将实参转换为形参的类型后，赋给形参。
>
>4、函数有返回值时，系统将隐式地将返回表达式类型转换为返回值类型，赋值给调用函数。

```
int x = 5;
System.out.println(x / 2.0);			//7.0
```

```
int x = 5;
System.out.println(x + 2.3);			//7.3
```

```
int x = 5;
System.out.println(x + "10");			//510
```

如上述三个例子所示

**自动类型转换**

当变量数据类型与接受的数据类型不一致时,java会尝试进行自动类型转换,其中由**低精度** -> **高精度**的类型转换可以成功,而**高精度**->**低精度**的类型转换会造成可能的数据溢出,**```会被编译器返回警告信息```**,若想强制执行这种转换,则需要使用强制类型转换

**强制类型转换**

在数据前使用括号标记要转换的数据类型

```java
// 左边是int类型，右边是long类型，左右不一样；
// long --> int,范围从大到小；
// 需要强制类型转换。
int num = (int) 100L;
System.out.println(num);//100
```

用char类型数组创建26个字母表

```java
public class Array {
	public static void main(String[] args){

		char[] abcArray = new char[26];
		for(int i = 0; i < abcArray.length; i++){
			abcArray[i] = (char)('A' + i);	//这里'A'+i是int型,因此用强制转换为char型
		}
		for(int j = 0; j < abcArray.length; j++){
			System.out.println(abcArray[j]);
		}
	}
}
```



## ==运算符

== 用于比较两个变量是否相等

**对于基本数据类型:** 比较值的大小是否相等

**对于引用数据类型: **比较地址是否相等

```java
String str1 = new String("123");
String str2 = new String("123");
System.out.println(str1 == str2);//false 地址不相同
```



## 定义函数(方法)

定义一个简单的比较函数:

```java
public class Main {
    //自定义函数模块
    public static int larger_function(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        System.out.print(larger_function(-5,10));
    }
}
```

在java中,定义函数的关键字是**public static**

由于函数定义在**主类**中,这样的函数被称为**方法(method)**

定义的函数,主函数 都放在**主类**中,且从主函数开始运行,这有点像c语言

**数组形参的传递**

```java
 public static int[] method(int[] x) { // 接收整型数组并返回一个整形数组 其中x是数组名
     
     /*执行模块*/
     
     return x; // 返回数组
 }
```

## 参数传递特点

java中所有的参数传递都是**值传递**

对于基本数据类型, 传递的是值的复制体, 这意味着不能通过成员方法修改传入的实参本身

对于引用数据类型(数组, 类), 传递的是引用的复制体, 可以通过引用的复制简介修改其值

这种特性的优点:

> 1. **简化内存管理**：Java自动管理内存，通过垃圾回收机制来回收不再使用的对象。如果允许引用传递，开发者需要手动管理内存，这会增加复杂性和出错的可能性。
> 2. **提高安全性**：通过值传递，可以避免外部代码对内部对象的直接修改，从而提高代码的安全性。
> 3. **避免副作用**：引用传递可能导致方法内部对参数的修改影响外部对象，这可能会产生难以追踪的副作用。Java的设计哲学是尽量减少这类副作用。
> 4. **保持一致性**：Java的所有数据类型（无论是基本数据类型还是对象）都采用值传递，这使得语言的学习和使用更加一致。
> 5. **简化语言特性**：Java去掉了指针的概念，使得语言更加简洁，易于理解和使用。





## 条件语句

```java
int dogSize = 20;
if (dogSize >= 50) {
    System.out.println("woof!");
} 
else if (dogSize >= 10) {
    System.out.println("bark!");
} 
else {
    System.out.println("yip!");
}
```

```java
 switch (month){                           
    case 2:                                        
      days = 28;        
      break;              
    case 4:                                
    case 6:                                          
    case 9:                                            
    case 11:                                                    
      days = 30;            
      break;
    default:
      days = 31;
      break;
}              
```



## 循环语句

while循环

```java
int bottles = 99;
while (bottles > 0) {
    System.out.println(bottles + " bottles of beer on the wall.");
    bottles = bottles - 1;
}
```

for循环

```java
public class ForLoop {
    public static void main(String args[]) {
        int result = 0;
        for (int i = 1; i <= 100; i++) {//1.初始化部分 2.循环条件部分 3.迭代部分
            result += i;//循环体部分
        }
        System.out.println("result=" + result);
    }
}
```



## 输入流 Scanner

**Scannner类**

scannner类是常用的用户输入类,位于```java.util.Scannner```包下面

使用时在主类外面通过```import```导入此包

scanner类常用的输入**方法**有**next()   nextLine()   hasNextxxx()**

**创建一个scanner**

 ```java
Scanner sc=new Scanner(System.in);
 ```

**使用next()方法**

```java
public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println(sc.next());
       System.out.println(sc.next());
    }
```

第3行 , next()方法阻塞程序并等待用户输入 遇到空格(空字符)读取跳过并结束(与c语言的scanf类似)

第4行 , 第二个next继续读取剩下的字符串(从第一个非空字符开始)

**使用next()接收字符类型输入:**

```java
Scanner scan = new Scanner(System.in);
char s = scan.next().charAt(0);		//接受字符类型输入
```



**使用nextLine()方法**

```java
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用nextLine方式接收：");

        if (scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println("输出内容："+str);
        }
        scanner.close();
    }
}
```

nextLine()方法可以**获取带有空字符的字符串**



**使用hasNext()方法**

```java
public static void main(String[] args) {

   	   Scanner sc=new Scanner(System.in);
   	   int i=1;
   	   while(sc.hasNext()){
   	   System.out.println("第"+i+"个字符串"+sc.next());
   	   i++;
        }
   	   System.out.println("输入完成");
	}
```

第5行 , hasNext方法阻塞程序等待用户输入,该方法检测指针指向位置的下一个字符是否为空,非空返回True

​		若为空,则等待用户输入 . **即hasNext永远不会返回False**

在返回True后,程序执行到第6行,next()方法读入字符串,直到第一个空字符结束

一般使用hasNext()检查并限制输入数据的类型

使用**hasNextType()**进行类型限制,此方法只有在类型匹配时返回True,其余返回False

```java
import java.util.Scanner;
 
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        }
        else if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        }
        scan.close();
    }
}
```

此程序演示了一个利用hasNextType()区分不同输入类型.并给出不同的输出的案例





## 数组(array)

### 一维数组 基本介绍

数组是**引用类型**,创建一个数组即创建一个对象

**数组声明**

```java
dataType[] arrayRefVar = new dataType[arraySize];	//新建数组但不填充元素
dataType arrayRefVar[] = new dataType[arraySize];	
实例     
double[] myList = new double[size];
      myList[0] = 5.6;
      myList[1] = 4.5;
      myList[2] = 3.3;
      myList[3] = 13.2;
      myList[4] = 4.0;
      myList[5] = 34.33;
      myList[6] = 34.0;
      myList[7] = 45.45;
      myList[8] = 99.993;
      myList[9] = 11123;
```

**new **命令在内存中为这段数组分配空间 , 使数组名指向具体的内存空间

或

```java
dataType[] arrayRefVar = {value0, value1, ..., valuek};	
```

**length**方法 : 返回数组的长度

```java
array.length
```

**contains**方法 : 查找一个字符串数组中是否含有某一**连续**字符串

```java
stringname.contains(CharSequence chars)
    
如
public class Main {
    public static void main(String[] args) {
        String myStr = "Runoob";
        System.out.println(myStr.contains("Run"));		//true
        System.out.println(myStr.contains("bo"));		//false
        System.out.println(myStr.contains("s"));		//false
    }
}
```



**遍历数组:for-each循环**

不使用下标的情况下遍历数组

```java
for(type element: array)
{
    System.out.println(element);
}
```

```java
public class TestArray {
   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};
 
      // 打印所有数组元素
      for (double element: myList) {
         System.out.println(element);
      }
   }
}
```



### 数组和引用  (reference)

和c语言相似, java的数组名指向一个确定的地址,由地址访问内存空间

这个数组名是**对一个数组对象**的引用(reference) , 引用类型是一个特殊类型, **不具有具体的数据类型**

与c语言不同的是

> - java**不能**通过地址**直接操作**数组元素,只能通过过下标访问
> - java数组相邻元素地址间的关系不像c语言一样间隔一个数据类型
>- java中数组的地址指向数组的起始位置,每个元素相对于起始位置有一个"偏移量"
> - java的引用不像c的指针可以被一个具体的数据类型(c中的整型)存储并输出

<img src="C:\Users\12275\AppData\Roaming\Typora\typora-user-images\image-20240806183636257.png" alt="image-20240806183636257" style="zoom:50%;" />

**引用类型本身存储一个引用对象的地址(是存储/指向 而不是它本身就是地址)**

> #### gpt4 对于引用的讲解 :
>
> 在Java中，引用本身并没有显式的数据类型。它是一种抽象的概念，用来引用对象或数组，但其具体的实现细节是由Java虚拟机（JVM）管理的。
>
> #### 引用的存储与类型
>
> - **引用类型**:
>   - Java的引用类型包括类类型、接口类型、数组类型等。
>   - 引用类型的变量存储的是对象在内存中的地址，但这个地址是抽象化和封装在JVM内部的，开发者无法直接访问或操作这个地址。
> - **引用的存储**:
>   - 引用通常存储在栈内存（stack memory）中，而引用指向的对象或数组本身存储在堆内存（heap memory）中。
>   - 引用类型变量只占用一个固定大小的内存空间，这个大小通常是32位或64位，具体取决于JVM的实现和目标平台的架构（32位系统或64位系统）。
>
> #### JVM 中的引用实现
>
> - **引用的实现**:
>   - 在JVM中，引用可以被认为是一个包含对象内存地址的指针，但是这个指针是受JVM严格控制的，不能被直接操作。
>   - 引用类型的变量在赋值时，只是复制引用本身，而不是复制对象。这意味着多个引用变量可以指向同一个对象或数组。
> - **引用的类型分类**（JVM层面）:
>   - **强引用**（Strong Reference）: 最常见的引用类型，当一个对象被一个强引用引用时，垃圾回收器不会回收该对象。
>   - **软引用**（Soft Reference）: 允许垃圾回收器在内存不足时回收该对象。
>   - **弱引用**（Weak Reference）: 在垃圾回收时会被立即回收。
>   - **虚引用**（Phantom Reference）: 仅用于跟踪对象的垃圾回收状态，不能通过它访问对象。

### 数组拷贝

**1. for循环拷贝**

**2. Arrays.copyOf()拷贝**





### 例题1 : 数组倒序

```java
public class Test2 {
    public static void main(String[] args){
        int[] test= {1,2,4,5,7};
        for (int i : test) {
            System.out.print(i+" ");
        }
        System.out.println("\n");
        test = Test2.reverse(test);
        for (int i : test) {
            System.out.print(i+" ");
        }
    }
	
//新建一个数组,利用下标把原数组倒序放入新数组
    public static int[] reverse(int[] arr){
        int[] result = new int[arr.length];
        for (int i = 0,j=result.length-1; i < arr.length; i++,j--) {
            result[j] = arr[i];
        }
        return result;
    }
}

```

该方法**空间复杂度**较高,不是最优解法 ↑

```java
/*不使用新数组的方法*/
import java.util.Scanner;

public class ReverseArray {
	public static void main(String[] args) {
		int[] myArray = new int[5];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < myArray.length; i++){
			myArray[i] = scan.nextInt();
		}

		int temp = 0;	//记住要初始化
		for(int i = 0; i < myArray.length/2; i++){
			temp = myArray[i];
			myArray[i] = myArray[myArray.length-1-i];
			myArray[myArray.length-1-i] = temp;
		}
		for(int j = 0; j < myArray.length; j++){
			System.out.print(myArray[j] + " ");
		}
		
	}
}
```



### 例题2 : 找出数组最大值

```java
public class Main {
    public static int max(int[] array) {
        int max = array[0];
        int i;
       for (i = 0; i < array.length; i++){
           if(max < array[i]) {
               max = array[i];
           }
       }
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.print(max(numbers));

    }
}
```



### 例题3 : 找出数组中连续的一段字符串

```java
public class ContinueDemo {
    public static void main(String[] args) {
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};

        for (int i = 0; i < a.length; i += 1) {
            if (a[i].contains("horse")) {
                continue;
            }
            for (int j = 0; j < 3; j += 1) {
                System.out.println(a[i]);
            }
        }
    }
}
```



### 例题4 : 数组求和 (难)

> 编写一个函数 `windowPosSum（int[] a， int n）`该函数将每个元素 a[i] 替换为 a[i] 到 a[i + n] 的总和，但前提是 **a[i] 为正值**。
>
> 如果由于我们到达数组的末尾而没有足够的值，我们只对现有值求和。

```java
public class windowpossum {
    public static void main (String[] args){
        int[] array1 = {-1,2,3,4,5,6,7,8,9};
        ranksum(array1);
    }
    public static void ranksum(int[] array){
       int length = array.length;

       for(int i = 0; i < length; i++){
           int sum = 0;         //每次内循环结束重置sum
           for( int j = i ; j < length ; j++){
               if(array[j] >= 0){
                   sum += array[j];
               }
               else continue;		//元素为负时跳出本次求和
           }
           System.out.println(sum);
       }
    }
}

```

### 例题5 : 数组动态扩容(难)

> 要求:
>
> 1. 原始数组使用静态分配 int[] arr = {1, 2, 3}
> 2. 增加的元素放在数组末尾
> 3. 用户可选是否继续增加元素或退出程序

**思路:**

1. 创建新数组,长度为 arr.length+1
2. 拷贝数组
3. 由scanner将扩容元素添加到新数组末尾
4. 销毁原数组 `arr = newarr` (由于原数组无任何引用(无地址)会被JVM自动销毁)
5. 使用循环不断重复,以实现动态扩容(由于至少执行一次故使用do while)

```java
import java.util.Scanner;

public class ExpandArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Scanner scan = new Scanner(System.in);
		
		do{
			int[] newarr = new int[arr.length+1];
			//遍历数组 复制元素
			for(int i = 0; i < arr.length; i++) {
				newarr[i] = arr[i];
			}
			//扩容最后一个元素
			System.out.println("please print an integer");
			newarr[arr.length] = scan.nextInt();
			arr = newarr;
            //重点,原本的arr所占内存空间被销毁,现在arr和newarr指代相同(同时实现了arr+1)
			//输出函数
			System.out.println("====AFTER====");
			for(int i = 0; i < newarr.length; i++) {
				System.out.print(newarr[i] + " ");
			}
			//跳出循环选项
			System.out.println("\nContinue? y or any keys to quit");
			if(scan.next().charAt(0) != 'y') {
				break;
			}

		}
		while(true);

	}
}
```



**扩展 : 数组动态缩减**

与动态扩容思路基本一致

```java
import java.util.Scanner;
public class ReduceArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		Scanner scan = new Scanner(System.in);
		
		do{
			int[] newarr = new int[arr.length - 1];
			//遍历数组 复制元素
			for(int i = 0; i < arr.length - 1; i++) {
				newarr[i] = arr[i];
			}
			arr = newarr;

			//输出函数
			System.out.println("====AFTER====");
			for(int i = 0; i < newarr.length; i++) {
				System.out.print(newarr[i] + " ");
			}
			//检查数组剩余元素个数
			if(arr.length == 1) {
				System.out.println("\nthe last one");
				break;
			}
			//跳出循环选项
			System.out.println("\nContinue? y or any keys to quit");
			if(scan.next().charAt(0) != 'y') {
				break;
			}
		}
		while(true);
	}
}
```

### 例题6 : 数组动态增加和动态删减

其实就是例题5的结合 , 但思路略有区别

**核心思路:**

1. 动态增加(见上) , 动态删除(见上)
2. 每次执行完操作后询问用户下一步操作内容(while循环)

```java
import java.util.Scanner;
public class ExpandArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Scanner scan = new Scanner(System.in);
		
		do{
			int[] newarr = new int[arr.length+1];
			//遍历数组 复制元素
			for(int i = 0; i < arr.length; i++) {
				newarr[i] = arr[i];
			}
			//扩容最后一个元素
			System.out.println("\nplease print an integer");
			newarr[arr.length] = scan.nextInt();
			arr = newarr;//重点,原本的arr所占内存空间被销毁,现在arr和newarr指代相同(同时实现了arr+1)
			//输出函数
			System.out.println("====AFTER====");
			for(int i = 0; i < newarr.length; i++) {
				System.out.print(newarr[i] + " ");
			}
			//跳出循环选项
			char key;
			while(true) {
				System.out.println("\nContinue added? y / r to reduce last element / any other keys to quit");
				key = scan.next().charAt(0);
				if( key == 'y' ) {
					break;
				}
				else if( key == 'r') {
					reduce(arr);	//调用reduce函数,传入数组的指针作为参数
				}				
			}
			if(key != 'y' && key != 'r') {
				break;
			}
		}
		while(true);
}
    
		/*动态删除函数*/
		public static void reduce(int[] arr) {
				int[] newarr = new int[arr.length - 1];
				//遍历数组 复制元素
				for(int i = 0; i < arr.length - 1; i++) {
					newarr[i] = arr[i];
				}
				arr = newarr;
				//输出函数
				System.out.println("====AFTER====");
				for(int i = 0; i < newarr.length; i++) {
					System.out.print(newarr[i] + " ");
				}
				//检查数组剩余元素个数
				if(arr.length == 1) {
					System.out.println("\nthe last one");
				}
		}
}
```





### 算法: 冒泡排序

```java
public class BubbleRank {
	public static void main(String[] args){
		int[] arr = {3, 88, 88, 21, 45, 6, 65, 34, 3, 3};
		//start 一个简单的冒泡排序
		int middle = 0;			
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
```

**思路**

>- 外层循环 `i` 从0遍历到数组的倒数第二个元素。
>- 内层循环 `j` 从0遍历到 `arr.length - i - 1`。
>- 比较 `arr[j]` 和 `arr[j + 1]` 的大小，如果 `arr[j]` 大于 `arr[j + 1]`，则交换两者的位置。
>- **每一轮内层循环结束后，最大的元素都会被放置到数组的末尾位置**，因此不需要再比较已经排好序的部分  `j < arr.length - i - 1`

> 注: 外循环length - 1是为了减少最后一次运算(非必要) , 内循环length - 1是防止数组溢出边界

另一种**伪冒泡循环**:

```java
for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[i] > arr[j]){
					middle = arr[j];
					arr[j] = arr[i];
					arr[i] = middle;
				}
			}
		}
```

> **缺点**：
>
> 1. 时间复杂度较高
> 2. 每次比较是从 `i + 1` 开始，效率不高。
> 3. 不能充分利用冒泡排序的特性。



### 算法: 插入排序

**思路**

> 1. 类比扑克牌的插入排序,将目标牌key与之前的每一位array[j]作比较
> 2. 每次比较若array[j] > key 说明目标牌key应该放在比较牌的前面
> 3. 为了给目标牌腾出存放的位置,需要将array[j]右移一位
> 4. 当遇到第一个小于或等于key的牌时,排序结束(不会再遇到比key大的牌),那么key应该放在这个牌的右边,即 array[j + 1] = key ( j + 1是因为while退出之前会多减一位 )

```java
public class InsertArray {
	public static void main(String[] args) {
		int[] arr = {3, 3, 1, 5, 12, 8, 9};
		Insert(arr);
	}

	public static void Insert(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > key) {
				array[j + 1] = array[j];  
              //比较第j个元素与key的关系,若array[j]更大,则右移一位为key腾出位置
				j--;
			}
			array[j + 1] = key; //插入key到第一个比key小(或相等)的元素后面
            
			/*每次排序结束后输出当前数组*/
			for(int k = 0; k < array.length; k++) {
				System.out.print(array[k] + " ");
			}
			System.out.print("\n");
		}
	}
}
```

算法过程举例

<img src="C:\Users\12275\AppData\Roaming\Typora\typora-user-images\image-20240808214205076.png" alt="image-20240808214205076" style="zoom:70%;" />



---

### 二维数组

二维数组,即**数组的数组**,二维数组名即**指针的指针**

**声明**

```java
int[][] arr1 = {{0,1,2},
				{2,3,4}
				{4,5}	};	//静态声明

int[][] arr2 = new int[3][3];//动态声明
```

**动态初始化-列数不确定**

```java
int[][] arr3 = new int[3][];//列数不确定,此时一维数组的值为null
//非齐次动态初始化
for(int i = 0; i < arr3.length; i++) {
    arr3[i] = new int[i + 1];	//给每个一维数组分配内存空间, **注意这个+1**
    for(int j = 0; j < arr3[i].length; j++) {
        arr3[i][j] = j;	
    }
}
//输出
for(int i = 0; i < arr.length; i++) {
    for(int j = 0; j < arr3[i].length; j++) {
        System.out.print(arr3[i][j] + " ");
    }
    System.out.print("\n");
}
/* output
0
0 1
0 1 2	*/
```

**二维数组遍历**

```java
public class Twodecimalarr {
	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
/*	输出 output
0 0 0
0 0 0
0 0 0	默认初始化0 */ 
```

**二维数组在内存中的形式**

<img src="https://pic.imgdb.cn/item/66b7792dd9c307b7e926d823.png" style="zoom:67%;"  >

---

**二维数组的声明 易错题**

<img src="https://pic.imgdb.cn/item/66b7784cd9c307b7e9260fc3.png" style="zoom: 67%;">

数组名是一个对数组对象的引用(reference) ,

因此把一个具有确定的数据类型的数组元素赋值数组名(x和y和y[]) 都是非法的

此外, **Java要求赋值操作的左右两边类型要相同或具有兼容性** 因此f选项将二维数组地址赋值给一维数组会造成类型错误



### 例题7 : 杨辉三角

输入任意正整数n,打印n行杨辉三角

**我的基本思路**

> - 二维数组 动态初始化-列数不确定
> - 初始化为1
> - 使用杨辉三角的规律:两肩之和 arr\[i][j] = arr\[i-1][j-1] + arr\[i-1][j];

```java
//基本思路
import java.util.Scanner;
public class YHtriangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("print an number\n");
		int max = scan.nextInt();

		int[][] arr = new int[max][];

		for(int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1]; //为一维数组创建空间
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 1; //全部初始化为1
			}
		}
		for(int i = 2; i < arr.length; i++) {
			for(int j = 1; j < arr[i].length - 1; j++) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
	}//main end
}
```

**-->改进思路**

> 使用if-else语句,当遇到开头和结尾时初始化为1,其他情况为两肩之和
>
> 改进后的优点:大幅缩减代码量

```java
import java.util.Scanner;
public class YHtriangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("print an number\n");
     
		int max = scan.nextInt();
		int[][] arr = new int[max][];   //创建一个列数不确定的二维数组
        
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1]; //为一维数组创建空间
			for(int j = 0; j < arr[i].length; j++) {
				if(j == 0 || j == arr[i].length - 1) {
					arr[i][j] = 1;	//每个一维数组的头和尾初始化为1
				}
				else {	//每一行的其余位数为两肩之和(利用杨辉三角的基本性质)
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			} 
		}// for end
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}

	}//main end
}
```





## 类与对象

> Java 类的五大成分(成员)：`成员变量 构造方法 代码块 成员方法 内部类`

**类(class)**是包含**成员变量/属性(attribute)**和**方法(method)**的自定义数据类型

**对象(object)**是**类(class)**的**实例**

**属性**可以定义为任意类型 , 可以是基本数据类型,也可以是引用类型(数组 , 对象)

**方法**即定义在类里面的函数,调用规则和属性相似

```java
public class DemoClass {
	public static void main(String[] args) {
		Cat newCat = new Cat();	//new一个类的实例
		newCat.sort = "fff"; // 属性赋值
		System.out.print(newCat.sort + "\n"); //属性调用
		Cat.function();	// 方法调用(跨类调用)

	}//main end
}

class Cat {
			String name = "nya";	//利用已有数据类型创建默认属性
			int age = 8;
			String sort;			//创建未初始化的属性,默认值遵循基本规则
			public static void function() {	//创建一个方法
				System.out.println("hello java!!!");
			}
}//class end
```



### 对象在内存中的存储机制

1. 属性的存储机制
   - 字符串(是一个引用,和数组一样) 存放在方法区内
   - 基本数据类型存放在堆空间

<img src="https://pic.imgdb.cn/item/66b77b3ed9c307b7e928d387.png" style="zoom: 50%;">

2. 方法的存储机制

   - 当程序执行到一个方法时,会开辟一个独立的栈空间
   - 当方法执行完毕,将返回值(若果有)返回给 原调用 栈空间
   - 执行完毕的方法其栈空间会被销毁,下次调用会重新创建

   <img src="https://pic.imgdb.cn/item/66b86855d9c307b7e92ebfa9.png" style="zoom: 80%;"  >







### 方法的定义与使用

```java
访问修饰符 返回值类型 方法名(形式参数列表){
    方法体; 
    返回值;
}
```

- 访问修饰符 :

  ​	**private** : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）

  ​	**default** (即缺省，什么也不写，不使用任何关键字）: 在同一包内可见，不使用任何修饰符。使用对象：					类、接口、变量、方法

  ​	**protected** : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）

  ​	**public** : 对所有类可见。使用对象：类、接口、变量、方法

- 返回值类型 : 可以是基本数据类型和引用类型 , 返回值类型必须与返回值保持一致, 一个方法只能有一						个返回值 (返回多个值则使用数组或对象)

- 形式参数(形参) : 在方法体内使用的参数,在调用时由调用函数传入实际参数(实参). 形参的声明要包含数据类    						型和形参名. 多个形参使用逗号间隔,传入的实参要求数量,顺序和形参保持一致

  > 关于形参 : 基本数据类型传递的是值(值拷贝) 
  >
  > ​				   引用类型传递的是"引用类型"本身 他们指向同一个地址(地址拷贝) 
  >
  > 值拷贝引起的形参变化不会影响到实参;
  >
  > 地址拷贝引起的形参变化会反映到实参上(由地址直接操作实参);

- 方法体 : 函数(方法)的主体部分 , **方法体内不能定义新方法(可以调用已定义的方法)**



**方法调用**

- 同一个类中方法调用 : 直接调用 方法名()
- 跨类方法调用 : 对象名.方法名()  ;  如main()方法调用其他方法就是一种跨类调用
- 跨类调用方法受到访问修饰符影响,如private修饰符仅允许类内调用

### 引用对象的参数传递机制

```java
//有两个对象
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
//在main函数中有:
	Person p = new Person(); //创建一个Person对象
	A.test(p);

// 对象p会发生什么?
```

 首先,main函数中创建了一个名为p的Person类实例. 

接着调用了test()方法并传入形参p(引用类型) ,

 在test()方法中, 该方法先是拷贝传入参数p(同名p),使得它指向对象p的地址`此时的p与main中的p是同名同地址`

接着执行`p=null`语句,使得p引用对象变为'空' `main中的p还是指向p对象地址` `此时的p与main中的p同名不同地址`

下一步`p=new Person()`创建一个新的实例,此时的p有了引用对象,但与main中的对象地址不同

在这个程序中,当`class A`调用完毕后会被jvm销毁,此时test方法中的p被销毁,即该对象没有了对应的引用类型,同样会被jvm销毁

<img src="https://pic.imgdb.cn/item/66b88e1dd9c307b7e9638a20.png" style="zoom: 100%;" >



### Java创建对象的内存机制(重点)

[java 创建对象的内存图解 CSDN博客](https://blog.csdn.net/TYRA9/article/details/128508466?spm=1001.2014.3001.5501)

1. 在方法区加载相关类的字节码文件,为main()方法开辟栈空间

<img src="https://i-blog.csdnimg.cn/blog_migrate/c9d3d6cb936267d6ee581aab72459a86.png" style="zoom: 67%;" >

2. 执行new关键字,在堆内存开辟新空间给创建的对象

<img src="https://i-blog.csdnimg.cn/blog_migrate/ade813ae1cc41c62569eca66cf099ba3.png" style="zoom:67%;" >

3. 根据属性和方法划分空间,**堆空间内存放的是基本数据类型的值和引用类型/成员方法的地址(指向方法区)**

<img src="https://i-blog.csdnimg.cn/blog_migrate/957673be14b3fabb5d5609b10d94cf61.png">

4. 属性初始化 : 默认初始化 --> 显式初始化(如果有) --> 构造器初始化(显式/隐式)
   - 默认初始化: 根据属性的数据类型进行初始化, 如int初始化0, String初始化null
   - 显式初始化: 如果属性在声明时进行了赋值,则初始化为所赋的值,如果没有,跳过此步
   - 构造器初始化: 将属性初始化为构造器传入的实参(显式),或系统无参构造器初始化(隐式)

5. new关键字结束,创建完成的实例地址将被返回给栈空间中的引用类型

<img src="https://i-blog.csdnimg.cn/blog_migrate/8c10eb435142d4da5953ecadd87629b0.png">





## 递归(recursion)

**递归的运行机制**

```java
public class Recurtion {
	public static void main(String[] args) {
		recurtion(4);
	}
	public static void recurtion(int n) {
	    if(n > 2) {
	        recurtion(n - 1);
	    }
	    System.out.println("n = " + n);
	} 
}
```

**在栈中的运行机制**

<img src="https://pic.imgdb.cn/item/66b8c84ad9c307b7e9b36e8f.png" style="zoom: 60%; float:left" >

从main()开始执行并创建一个栈空间,每次读取到recurtion()再创建一个栈空间,每个栈空间的数据相互独立

当执行到recurtion(2)时,不再满足if测试条件,因此从recurtion(2)开始执行下一步命令,直到该方法执行结束

在jvm中,**最后被创建的栈空间最先退出** 因此从上到下依次退出,如果有返回值,则从上到下依次返回每一步的值

最后输出的结果是 : 

> n = 2
> n = 3
> n = 4

### 递归使用重要规则

1. 每次递归调用一个方法,均会开辟一个新的独立空间
2. 每个独立空间内的基本数据类型变量相互独立,引用类型变量共享
3. 递归**必须向退出递归的条件逼近**,否则会出现无限递归(StackOverFlowError 栈溢出)
4. 当方法执行完毕或遇到return,返回值遵循**谁调用就返回给谁**,从递归最后一个方法开始依次返回

### 递归思想

1. 确定函数的递归部分到底要干什么

2. 寻找递归条件

3. 以递归的某一层举例计算看是否符合预期

   **递归的基本结构模版**

   ```java
   伪代码如下：
   int f(int n)
   {
   	if(递归结束条件）
   		return ；		//	基线条件;
   	else
   		return 递归;		//递归条件;
   ```

   当达到递归结束条件时 return一个常量(不再调用方法)使得递归程序能够正确退出

   当满足某一条件时 return递归函数 , 使得程序不断递归一直到顶层(栈顶层)

   > 注: 不一定要把递归部分放在return上,如例2的猴子吃桃问题

### 记忆化搜索

记忆化搜索比递归多了什么？

比递归多了一个“备忘录”的功能（加强版的递归）。递归的缺点就是有时会进行大量的重复计算，导致时间复杂度过大。

“备忘录”就是用来存储每次递归的结果，如果在另一个分支中有进行一样的运算，就不需要再进行递归展开了，只要从“备忘录”中将值取出来直接返回即可。

如下图 , 以斐波那契数列为例

<img src="https://i-blog.csdnimg.cn/blog_migrate/2591ca843a733576f657b3e402627b76.png" style="zoom:67%;" >

记忆化搜索**适用于会有大量重复计算的递归问题** 其时间复杂度相比递归有大幅提升

```java
/*记忆化搜索*/ /*以斐波那契数列为例*/
import java.util.Scanner;
public class Feibonachi {
    public static int[] memo;	//定义全局可见数组memo[]
    //主函数
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // 要计算的斐波那契数列位置
        memo = new int[n + 1];  // 初始化缓存数组 注意这个n+1
      	fibonacci(n);
        for(int i = 0; i < memo.length - 1; i++) {
    	System.out.print(memo[i] + " ");
    	}
    }
    // 记忆化递归函数
    public static int fibonacci(int n) {
        if (n <= 1) {
        	memo[n] = n;
            return memo[n];
        }
        // 检查缓存中是否已有计算结果
        if (memo[n] != 0) {
            return memo[n];
        }
        // 递归计算并存储到缓存
        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }
}
```

**重点**

> 1. 在创建"备忘录"数组时要声明为**全局变量**
> 2. 数组的长度n+1可以避免后续调用memo[n]时出现越界错误



### 例题1 : 斐波那契数列

斐波那契数列的定义如下：

>  `F(0) = 0`
>
> `F(1) = 1`
>
> 对于 `n >= 2`，`F(n) = F(n-1) + F(n-2)`

使用基本递归解法 : 

```java
public class Feibonachi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("please print an number:\n");
		f(scan.nextInt());
	}

	public static int f(int n) {
		if(n <= 1) {
			return n;
		}
		else {
			int num = f(n - 1) + f(n - 2);
			return num;
		}
	}
}
```

若输出前10项

> 0 1 1 2 3 5 8 13 21 34   // f(0) ~ f(9)

**使用记忆化搜索**

见	记忆化搜索板块



### 例题2 : 猴子吃桃问题

问题描述 :

猴子第一天摘下若干个桃子，当即吃掉一半，还不过瘾，又多吃了一个。第二天早上又吃掉剩下的一半，还是不满足，又多吃了一个。每天如此，到了第10天早上只剩下一个桃子。求第一天共摘了多少桃子，并列出每一天桃子的剩余数量。

> **思路**
>
> 1. 从第一天到第九天,每天的桃子数量=(前一天数量/2)-1
>
> 2. 若递归从 1 -- 10 , 从最顶端(第十天)算起,桃子数量=(今天+1)*2
>
>    把每一天(today)的桃子数量作为返回值,由递归的性质,我们假设已经知道了下一天(nextday)的桃子数量,根据(nextday+1)*2即可求出today的桃子数量,以此类推

```java
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
```



### 例题3 : 老鼠出迷宫(难)

现有一8行7列的迷宫,用递归思想编写能使老鼠走出迷宫的程序

<img src="https://i-blog.csdnimg.cn/blog_migrate/9d57f9c29e4df4b87ae646c308985fb4.png" style="zoom: 25%; float:left" >

**思路**

> 1. 在整个递归程序中,实际上是从终点到起点的反推
> 2. 下一次递归为本次递归提供条件 : 能通过 -> true ; 不能通过 -> false
> 3. 先向右走或先向下走会出现不同的路线

```java
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
		Find(MiGong, 1, 1);	// 调用递归函数

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
	/*递归函数*/
	public static boolean Find(int[][] map, int x, int y) {
		if(map[6][5] == 2)
			return true;		//到达终点时,结束递归
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
					return true;	//向上找到出路
				}
				else if(Find(map, x, y-1)) {
					return true;	//向左找到出路
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
```

**过程讲解:**

- 第一步,程序检测此处为0,并标记为2,由下一次递归结果确定向下走可以,因此向下走
- 第二步,步骤如上,程序由下一次递归返回结果:向下走为false,向右走为true,因此向右走
- 剩下步骤基本一致

> 这里最难理解的地方在于当前递归的判断是基于下一次递归的结果,整个程序实际上是先跑到终点,再由终点开始反推,依次确定路径上哪些点应该被标记为2

这是最基础的问题版本,后续还可以出现: 最短路径 / 列出不同路径 等

**关于回溯现象**

若在(2,2)处将迷宫的障碍物增加,此时按照下右左上的策略,老鼠会卡在(2,1)处((1,1)标记为2)

即返回false并结束此栈,进入上一层栈空间

返回到上一层栈,此栈再此进行新的路径探索(当为"上"时返回true)再次回到(1,1),然后按照原策略继续找路

(此时被卡住的(2,1)位置标记为2,不会再走)



### 例题4 : 汉诺塔

[汉诺塔递归问题思路讲解-bilibili](https://www.bilibili.com/video/BV1Zh411y7XB/?spm_id_from=333.337.search-card.all.click&vd_source=98d8086c38b750b0ce152d6d7c45607f) (crtl + 鼠标左键)

**思路**

> 汉诺塔的每层递归可以总结为:
>
> 1. 把前 n-1 层塔移动到B柱
> 2. 把最后一层(第n层)塔移动到C柱
> 3. 把前 n-1 层塔先移到A柱,再移到C柱
>
> 这三步就是一层递归,一直递归到n=2,由此开始依次处理

<img src="https://pic.imgdb.cn/item/66bb6cbad9c307b7e93222cc.png" style="zoom: 80%;" >

汉诺塔的递归树,形象清晰的展现了每层递归情况

```java
public class HanoiTower {
	public static void main(String[] args) {
		tower(5, 'A', 'B', 'C');
	}
	public static void tower(int n, char A, char B, char C) {
		if(n == 1) {	//ABC三个位置分别是起始,中转,目标
			System.out.println(A +" -> "+ C);
            //这里的A和C应该理解为起始柱和目标柱
		}
		else {
			tower(n - 1, A, C, B);	//前n-1个柱由起始柱到中转柱

			System.out.println(A +" -> "+ C);	//最底层移动到目标柱

			tower(n - 1, B, A, C);	//前n-1个柱由中转柱到目标柱
		}
	}

}
```





## 方法重载(overload)

方法重载 是指在同一个类中,存在多个方法名相同,但形参列表不同的方法

最典型的重载 就是 **System.out.println()** ,该方法能够接收不同的数据类型并处理,这就是重载的体现

**重载的好处:**

1. 减轻起名和记名的麻烦,对于功能相似的方法直接用重载实现,方便编写

**重载的使用细节:**

1. 重载的方法名**必须相同**
2. 重载的形参列表**必须不同** , 必须满足以下其一或更多 :
   - 形参**类型**不同 	如: `int sum(int a, int b)` 和  `double sum(double a, int b)`
   - 形参**数量**不同     如: `int sum(int a, int b)` 和 `int sum(int a, int b, int c)`
   - 形参**顺序**不同     如: `double sum(double a, int b)` 和 `double sum(int a, double b)`

3. 与形参的名称**无关**     如: `sum(int a, int b)` 和 `sum(int n1, int n2)` 不能构成重载

4. 与返回类型**无关**       如: `int sum(int a, int b)` 和 `void sum(int a, int b)` 不能构成重载

也就是说,在编写或判断方法重载时,仅关注方法名和形参是否符合要求

   ```java
/*方法重载实例练习*/
import java.util.Scanner;
public class OverloadExercise {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Method.overf(2);
		Method.overf(3, 4);
		Method.overf("ajsda");
		Method.max(2.3, 4.0, 5);
	}// main end
	public class Method {
		/*方法重载*/
		public static int overf(int n1) {
			return n1 * n1;
		}
		public static int overf(int n1, int n2) {
			return n1 * n2;
		}
		public static void overf(String str) {
			System.out.println(str);	
		}
		public static int max(int n1, int n2) {
			int max = n1 > n2 ? n1 : n2;
			System.out.println(" int max = " + max);
			return max;
		}
		public static double max(double n1, double n2, double n3) {
			double max = n1;
			if(n2 > max) 
				max = n2;
			if(n3 > max)
				max = n3;
			System.out.println("double max = " + max);
			return max;
		}
	}// method class end
}
   ```



## 可变参数

---

可变参数 允许你在方法中传递不定数量的参数。可变参数的数据类型用三个点（`...`）表示，放置在方法参数的类型之前。**可变参数实际上是一个数组，允许你传递任意数量的参数值**。

```java
public void methodName(Type... variableName) {
    // 方法体
}
--------------------------------------------
// 如 int类型多个整数求和:
public int sum(int... nums) {
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {	
        sum += nums[i];
    }
    return sum;
}// 由于形参nums实际上是数组,所以遍历数组求和
```

**可变参数 使用细节**

1. 可变参数的实参**可以为0或任意多个**
2. 可变参数的**本质是数组**
3. 可变参数可以和普通参数一起出现,但是可变参数 ==必须放在形参列表的最后==
4. 一个形参列表中**只能有一个**可变参数





## 变量作用域

---

全局变量&局部变量

- **全局变量(成员变量)**

也就是属性,声明在所属类中的变量,具有**默认值**,**作用域是整个类**(可以被类和子类中的方法调用)

生命周期是**从类的创建到销毁**,生命周期较长

**本类的全局变量可以被其它类调用** : 创建类的实例 / 传入对象形参	(见下例)

全局变量可以被访问修饰符修饰

- **局部变量**

除了属性之外的其他变量,不具有默认值,即没有初始化不可使用,作用域范围是定义它的代码块内

生命周期是**从代码块的执行到代码块结束**,生命周期较短

局部变量不可被访问修饰符修饰

**[使用细节]**

- 全局变量(属性)和局部变量可以重名,访问时遵循**就近原则**

- 全局变量与全局变量,局部变量与局部变量 之间,不能重名

```java
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
	String name = "jack";	//成员变量/全局变量

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
```





## 构造器(constructor)

---

构造器, 又叫构造方法/构造函数,创建在同名类中,构造器用于**初始化被创建的实例** , 其语法与方法类似

```java
[访问修饰符] 构造方法名(形参) {
    ...
}
```

[使用细节]

1. 构造器/构造方法 名称必须**与所属类名相同**
2. 构造器创建在同名类里面,可以看做是一个特殊的方法
3. 构造器**没有返回值** , 因此也没有返回类型声明
4. 构造器是**对已创建类的实例的初始化**,而不是创建实例
5. 一个类中可以有多个构造器,即构造器重载,使用规范参考 [**方法重载**]
6. 若创建的类中没有构造器,则程序会生成一个[无参构造器/默认构造方法], 即new一个实例时 类名() `如 Person()` , 显示声明的构造器会覆盖无参构造器,若仍想使用,需要自己创建(即重载)
7. 无参构造器也可以自己声明,此时在构造器内设定的值就是创建实例的默认值

示例: 

```java
public class Constructor {
	public static void main(String[] args) {
		Person p1 = new Person("jackrolin", 20);//使用构造器
		Person p2 = new Person();//使用自定义的无参构造器
		Cat c = new Cat();//使用系统无参构造器/默认构造方法
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
```

- 子类的构造器

当一个类继承自父类时, 在子类构造器中要显式或隐式的使用super()去初始化父类构造器, 这是java类加载的内存机制 , 详情见java三大特性---创建子类对象的内存机制





## this关键字

对于一个构造器,当形参名称和类的属性名称相同时,会出现什么?

```java
class Account {
    private String name;
    private double balance;
    private String pwd;
    
    //Account类的一个构造器
    public Account(String name, double balance, String pwd) {
        //构造器的实现---初始化对象
        //不用this
        name = name;
        balance = balance;
        pwd = pwd;
    }
    public void showInfo() {
        System.out.println("name:" + name + " " + "balance:" + balance + " " + "pwd:" + pwd);
        return;
    }
}
```

**根据变量作用域原则**,在调用该构造器时,构造器中的'name'和'balance' 'pwd'都会被视为形参名,也就是构造器执行的是局部变量自身赋值. 当构造器调用完毕,局部变量被销毁,此时属性仍没有被初始化,因此会返回其默认值

<img src="https://i-blog.csdnimg.cn/blog_migrate/93e5b74533c8df57fdfb341c566f65a5.png">

---

**使用this关键字可以解决这一问题**

**this关键字官方解释：**

> [Java虚拟机](https://so.csdn.net/so/search?q=Java虚拟机&spm=1001.2101.3001.7020)（JVM）会给**每个对象**分配一个this,来**代表当前对象**,

**说人话解释：**

- this其实可以理解为对象的一个**属性（成员变量）**,但是这个属性是**隐藏的**.即**this相当于对象的一个隐藏属性。**
- 和对象的其他属性一样，在`new`一个新对象的时候，会在**堆内存**为对象分配空间，属性就储存在这份空间中。且该**this属性**的值就是**对象在堆内存中地址**，即this指向该对象（this代表该对象）.

> **[重点]综上：this是对象的隐藏属性（本质就是一个普通的成员变量），和其他`non-static`属性一样，在创建对象的时候会为每个新对象分配该对象的专属成员变量（this就是其中一个），this这个成员变量存储在堆内存中，该变量的值是所属对象在堆内存的地址。**

​	即：创建1000个对象，就有1000个this，它们之间相互独立

**[使用细节]**

- **this关键字可以用来区分当前类的属性&局部变量。**
- 使用this时,**this指代的是当前调用的对象 --> 调用谁,this指向谁**
- 使用this关键字可以用来访问本类的实例属性、实例方法、构造器(“实例”指的就是`non-static`修饰 的）
  - 访问本类实例属性：`this.属性`
  - 访问本类实例方法：`this.方法名(参数列表)`
  - 访问本类构造器：`this(参数列表)`

**注意：**`this(参数列表)`来访问本类构造器需要注意以下几点 :

- **只能在构造器中使用`this(参数列表）;`**即在一个构造器中访问本类的另外一个构造器。（**默认构造器行首是`super();`,）。**
- 显示使用`this()`时，默认的`super()`就被覆盖
- `this(参数列表）` 和 `super(参数列表）`在构造器中有且只能存在一个。
- 若在构造器中使用 `this(参数列表）`，则此语句只能**位于构造器第一行**
- 类中的**静态方法`static method`**中**不能使用`this`**

```java
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
        //使用this访问属性
		void f1() {
			System.out.print("name " + this.name);
/*对于一般写法,name实际上是按照就近原则寻找的,如果明确要访问的是属性,应该用this指代*/
		}
		//使用this调用方法f1()
		void f2() {
			this.f1(); 
		}
	}
}
```



## Java包(封装)

在Java中，包是一种将类、接口和其他包分组在一起的机制。

包的主要目的是帮助开发者组织代码, 防止命名冲突, 并控制访问级别. Java使用文件系统的目录作为包的物理表示, 每个包对应于一个目录. 每个目录下存放类文件, 不同包名下的类文件名可以重复.

**为什么使用包**

1. **代码组织**：包帮助开发者将功能相关的类和接口组织在一起, 使得代码更加模块化
2. **避免命名冲突**：包为类和函数提供了命名空间, 这样即使在不同的包中有同名的类, 它们也不会冲突
3. **访问控制**：包可以限制类成员的可见性。使用访问修饰符（如public, protected和private），开发者可以控制哪些其他包的代码可以访问当前包中的类成员

**创建包**

在Java中创建包非常简单。你只需在**源文件的顶部**添加一个`package`语句，然后**将源文件放在与包名称对应的目录结构中**  例如：

```java
package com.example.myapp;

public class MyClass {    
    // 类实现
}
```

在这个例子中，`MyClass`类属于`com.example.myapp `包

根据这个包名，源文件应该位于`com/example/myapp` 的目录路径下

**[注意]:** **一个类只能存在于一个包下** , 也就是一个类文件中只能有一个package

**在IDEA中创建包**

<img src="https://pic.imgdb.cn/item/66bdf59cd9c307b7e98e0be8.png" style="zoom:50%;float:left" >
<img src="https://pic.imgdb.cn/item/66bdf649d9c307b7e98ea282.png" style="zoom: 55%;" >

<img src="https://pic.imgdb.cn/item/66bdf654d9c307b7e98ead37.png">

<img src="https://pic.imgdb.cn/item/66bdf84ed9c307b7e9906f7a.png" style="zoom: 67%;" >

com和example文件夹非必须,只创建一个文件夹也能为包

**引入包**

要在Java程序中使用包内的类，可以使用 `import` 语句。例如，要引入上面创建的`MyClass`，可以在另一个包中的Java文件中这样写：

```java
import com.example.myapp.MyClass;

public class Test {
    public static void main(String[] args) {
       	MyClass obj = new MyClass();
        // 使用MyClass
	}
}
```

也可以使用星号（*）来导入一个包中的所有类：

```java
import com.example.myapp.*;
```

这样，`com.example.myapp`包中的所有类都可以在当前文件中直接使用

在实际开发中, 最好是**只导入需要使用的类**

**引入不同包的同名类文件**

第一个类可以使用 `import com.example.myapp.MyClass;` 写法, 在创建实例的时候 `类名 + 实例名`

第二个类的引入不能再使用上述语句, 而是在创建实例时 `包名.类名 + 实例名 `

```java
import com.example.myapp.MyClass;

public class demo {
    public static void main(String[] args) {
        MyClass mc = new MyClass(); //引入并使用其他包的类
    }
    com.demo.MyClass mc = new com.demo.MyClass();//引入同名不同包的类
}
```

<img src="https://pic.imgdb.cn/item/66bdfc33d9c307b7e9946e78.png"  >

**包命名规范**

通常，包命使用小写英文字母进行命名，并使用“.”进行分割，每个被分割的单元只能包含一个名词。

一般地，包命名常采用顶级域名作为前缀，例如com，net，org，edu，gov，cn，io等，随后紧跟公司/组织/个人名称以及功能模块名称。

**包命名规则**

- 只能以字母作为开头,数字不能放在开头    如: demo.12aa.exc

- 可以包含数字, 字母, 下划线   

- 不能是关键字或保留字    如: demo.class.exe

- 使用小圆点" . " 分割不同的目录层级

  

## 访问修饰符

访问修饰符 :

​	**private** : 在同一类内可见。使用对象：变量、方法。

​					 注意：不能修饰类（外部类）

任何在当前类的外部调用private类的成员都是非法的,包括在main()中创建该对象并调用成员

​	**default** : (即缺省，什么也不写，不使用任何关键字)在同一包内可见，不使用任何修饰符。

​					使用对象: 类、接口、变量、方法

​	**protected** : 对同一包内的类和所有子类可见。使用对象：变量、方法。 

​						注意：不能修饰类（外部类）

​	**public** : 对所有类可见。使用对象：类、接口、变量、方法



<img src="https://i-blog.csdnimg.cn/blog_migrate/7da4ff7952b16683dbc146d4cdc9cb19.png" alt="访问修饰符" style="zoom:120%;" />

这四种访问修饰符均可以修饰 属性attribute 和 方法method

但**只有public和default可以修饰 类class**



## Java三大特性

### 封装(package)

封装（encapsulation）是指对于某个对象，Java隐藏对象的属性和实现细节，**仅对外公开接口，控制在程序中属性的读取和修改的访问级别。**

在Java中每一个类都是一个**类文件** , 功能相似的类文件放在同一个目录下就是**包**,在主类下调用某个类文件时, 只需要导入包名和类名,即可调用, 封装的特性使得代码模块化程度提高

调用封装的类文件时,我们通常不会直接调用/更改其属性(这些属性或方法通常被设为私有private),而是通过类文件提供的公共public方法去间接操作属性, 这种方式更加人性化, 也避免因误修改属性导致程序错误

**创建一个封装**

```java
package 包名;
```

封装必须放在类文件的开头(所有类之上)

**导入封装类**

```java
import 包名.类名;
```

**实例:**

```java
/*封装类Person*/
package com.eli.cc;

public class Person {
    public String name;
    //名字和工资赋予私有属性,不能通过外部方法操作
    private int age;
    private int salary;
	//创建一个默认初始化构造器
    public Person() { 
        this("未初始化", 0, 0);
    }
    /*在构造器中调用set方法*/
    public Person(String name, int age, int salary) {
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }
    //设置对外开放的方法供给用户端操作
    public void setName(String name) {
       if(name.length() > 1 && name.length() < 7) {
           this.name = name;
       } else {
           System.out.println("illegal name");
       }
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        if(age > 0 && age < 100) {
            this.age = age;
        } else {
            System.out.println("illegal age");
        }
    }
    public int getAge() {
        return age;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getSalary() {
        return salary;
    }
    public void get_info() {
        System.out.println("成员信息如下:");
        System.out.println(this.getName());
        System.out.println(this.getAge());
        System.out.println(this.getSalary());
    }
}
```

对封装类进行操作 :

在这一操作中,我们只能使用封装类提供的"接口"(三个set方法或构造器),若直接对实例的属性进行操作,则会根据提示错误

```java
package com.eli;

/*Person是封装的类,这个主类相当于用户端,
通过指定的方法对封装类进行操作,而非直接修改封装类的属性*/

import com.eli.cc.Person;//导入Person封装类
public class fengzhuang {
    public static void main(String[] args) {
        Person person = new Person();
    //或 Person person = new Person("jack", 20, 10000);
        person.setName("jack");
        person.setAge(20);
        person.setSalary(10000);

        person.get_info();
    }
}
```



---

### 继承(extends)

继承是从已有的类中派生出新的类，新的类能吸收已有类的数据属性和行为，并能扩展新的能力。

在Java之中，如果要实现继承的关系，可以使用如下的语法：

```
class 子类 extends 父类 {
	...//添加子类自己的属性和方法
}
```

子类又被称为派生类； 父类又被称为超类(Super Class)

子类会继承父类的**所有属性和方法(包括private和default修饰的)**

==**[使用细节]**==

- **在创建子类实例时, 必须调用父类的构造器, 完成父类的属性初始化, 接着再初始化子类实例**
  - 子类在默认情况下调用父类的无参构造器(显示或隐式), 相当于有一个隐式的 `super()`
  - 如果父类没有无参构造器, 则必须在子类构造器中使用 `super(形参列表)` 指定使用父类的哪个构造器
  - 如果希望显示调用某个父类构造器, 也可以在子类有参构造器中使用 `super(形参列表)`
  - `super()` 放在子类构造器的第一行 
  -  `this(参数列表）` 和 `super(参数列表）`在构造器中有且只能存在一个
- 编写子类时遵循: **父类构造器完成父类初始化, 子类构造器完成子类初始化** 的思想
- 对父类构造器的调用不限于直接父类, 会一直向上追溯到Object类(顶级父类)
- Java中的所有类都是Object类(顶级父类)的子类
- **一个子类只能继承自一个父类(直接父类)  **[单继承机制]
- 慎用继承, 只有当两个对象是确切的包含与被包含关系时才需要使用

>  子类继承了父类的属性和方法, 可以访问在子类对象中直接访问(非private类型)

**创建一个Students父类**

```java
/*构造一个父类*/
public class Students {
    private String name;
    private int age;
    private int grades;
    //构造器
    public Students() {
    }
    public Students(String name, int age, int grades) {
        this.setName(name);
        this.setAge(age);
        this.setGrades(grades);
    }
    //接口方法
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setGrades(int grades) {
        this.grades = grades;
    }
    public int getGrades() {
        return grades;
    }
    public void showInfo() {
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Grade: " + this.getGrades());
    }
}
```

**Graduate子类**

```java
/*Graduate类继承了Student类的属性和方法*/
public class Graduate extends Students {
    //Graduate类独有的属性和方法
    private double GPA;
	//创建子类的构造器,其中要包含继承自父类的属性形参
    public Graduate(String name, int age, int grades, double GPA) {
    //**super()将子类构造器的形参传递给父类,使父类初始化**
        super(name, age, grades);
        this.setGPA(GPA);
    }
    public void setGPA(double GPA) {
        if(GPA > 0 && GPA <= 4.0)
        this.GPA = GPA;
        else {
            System.out.println("ileagl gpa");
        }
    }
    public double getGPA() {
        return GPA;
    }
    //重写同名父类方法,这会覆盖父类原有的方法
    public void showInfo() {
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Grade: " + this.getGrades());
        System.out.println("GPA: " + this.getGPA());
    }
}
```

**在主类中调用**

```java
public class Mainprogramme {
    public static void main(String[] args) {
        //创建Graduate子类的实例,并初始化
        Graduate graduate = new Graduate("Jack Rolin", 20, 98, 4.0);
        graduate.showInfo();
    }
}
```



---

### 创建子类对象的内存机制(重点)

[java 继承关系的内存图解  CSDN博客](https://blog.csdn.net/TYRA9/article/details/128729074)

1. main()方法所在类及其方法优先加载到方法区(method area)
2. jvm为main()开辟栈空间, main()方法进栈
3. 执行new关键字, 将子类Hua加载到方法区, 在堆内存为Hua对象开辟空间

<img src="https://i-blog.csdnimg.cn/blog_migrate/66905195d8829a732e5d49935657aef4.png">

4. 由于Hua继承了直接父类Child和间接父类Parent, **jvm会优先初始化高级别父类**, 即按照Parent -> Child -> Hua的顺序初始化相应的属性,并将开辟的堆空间分为三部分 分别存储三个类的属性和方法(地址)

<img src="https://i-blog.csdnimg.cn/blog_migrate/e228432c781d8283c6d8f7d0513d0a0a.png">

5. new关键字结束,把对象地址返回给栈空间中的引用对象fuHua, 子类对象创建完毕

**[总结&注意事项]**

- 在子类对象的创建过程中, 会按照 **高优先级父类 -> 子类 **的顺序分别 ~~创建~~ **划分 **空间并初始化
- 在调用构造器进行属性初始化时, 会先从子类构造器判断使用哪个父类构造器, 以此类推
- 子类对象中包含所有父类(直接和间接)的属性和方法, 不论这些方法是否是私有private||default
- 若子类中存在与父类同名同数据类型的属性, 这并不会覆盖原有父类属性, 只是无法在子类对象中直接调用(可以使用父类提供的方法间接调用或使用super关键字)
- 当调用子类对象的属性或方法时, 程序会先查找子类中是否有这项属性或方法, 若没有则向父类中查找,一直到顶级父类Object **[查找关系 --> 继承的本质]**

---

### **super**关键字详解

super是一个和this相似的关键字, this指代当前引用对象, super则指代当前子类的**直接父类**对象

回忆前面讲解的子类对象在内存中的创建机制 :

<img src="https://pic.imgdb.cn/item/66c069dcd9c307b7e911186c.png" style="zoom: 67%;" >

一个子类对象的**堆空间**按照它所属的父类数量依次划分

> 当调用子类对象的属性或方法时, 程序会先查找子类中是否有这项属性或方法, 若没有则向父类中查找,一直到顶级父类Object **[查找关系 --> 继承的本质]**

而super关键字可以告诉程序跳过子类查找这一步, 直接向父类成员中查找

**super的使用方法**

1. `super.属性名` 在继承的父类中查找相关属性, 如果直接父类中没有, 则继续向上查找, 直到Object
2. `super.方法名` 同上
3. `super(形参列表)` 写在子类构造器第一行, 指定使用父类构造器进行初始化

**[使用细节&注意事项]**

- 当子类的属性/方法与父类重名时(即覆盖/重写), 要想访问父类已被覆盖的属性/方法, 则必须使用super
- 当子类的属性/方法不与父类重名, 使用`直接访问` , `this关键字访问` , `super关键字访问` 在结果上并无区别, 只是查找过程不同

**super和this的比较**

<img src="https://pic.imgdb.cn/item/66c06f19d9c307b7e916cc11.png">





### 方法重写(override)

---

当子类中有一个方法名称和形参列表都与父类相同的方法时, 子类的方法会覆盖父类的方法, 即方法重写

重写后若仍想访问父类的方法, 可以显式使用super关键字

方法重写可以以**多态**的形式被访问

注: 成员属性 没有重写的概念, 在子类定义与父类相同的属性后, 父类属性会被隐藏

[使用细节]

- 子类方法的 `形参列表(不看形参名)` 和 `方法名称` 与父类相同

- 子类的返回类型应与父类保持一致, 或是父类返回类型的子类
  - 如下所示代码是可行的(Graduate是Students的子类)
  	
  	```java
  	//父类
  	public Students method() {
  	    ...
  	    return student;//返回一个Students对象
  	} 
  	//子类
  	public Graduate method() {
  	    ...
  	    return graduate;//返回一个Graduate对象
  	}
  	/*构成方法重写*/
  	```
  - 或是与父类保持一致

  	```java
  	//父类
  	public String method() {
  	    ...
  	} 
  	//子类
  	public String method() {
  	    ...
  	}
  	```
  
- **子类不能缩小父类方法的作用域 (可以扩大)**

  - ```java
    //父类
    default String method() {
        ...
    }
    //子类
    private String method() { //错误
        ...
    }
    //子类
    public String method() { //可以
        ...
    }
    ```

**重写(override)和重载(overload)的对比**

<img src="https://pic.imgdb.cn/item/66c07930d9c307b7e9239fa5.png">

----

### 多态(Polymorphism)

对象的多态, 指一个对象可以同时具有多种形态

如一个班的所有学生,每个学生都是一个独立的个体, 学生类 和个体类 构成父子类关系, 现在我们建立一个信息管理类, 要想对每个学生进行描述(假设每个学生类下有一个独立的方法), 现有的做法是:

- 创建信息管理类 对象
- 创建学生甲 对象
- 传入相关参数, 得到学生信息

对于这种方法, 每次描述一个学生的信息, 我们需要创建一个新的信息管理类, 并传入对应的学生参数, 这种做法低效且不易管理

利用对象的多态, 我们便可解决这一问题

**对于两个具有继承关系的对象, 父类A的运行类型既可以是A, 也可以是子类B**

**即对象的编译类型和运行类型可以不相同,但必须包含继承关系**

如父类Student, 子类Xiaoming

```java
Student stu = new Xiaoming();
```

此时创建的对象stu其**编译类型**是Student, 而实际**运行类型**是其子类Xiaoming

程序从运行类型Xiaoming中查找相关成员

```java
public class Student {
    String name;
    int age;
    public String getName() {//让编译器能正确识别成员方法(但实际上在多态中并未使用)
        return name;
    }
    public int getAge() {
        return age;
    }
}
class Xiaoming extends Student {//学生1
    String name = "xiaoming";
    int age = 18;

    public String getName() {//方法重写
        return name;
    }
    public int getAge() {//方法重写
        return age;
    }
}
class Zhangsan extends Student {//学生2
    String name = "zhangsan";
    int age = 17;
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
class manager {//创建信息管理类
    public void get_info(Student stu) {//传入形参是父类Student对象(多态参数的应用)
        System.out.println("Name = " + stu.getName() + "\tAge = " + stu.getAge());//识别的是编译类型(父类)的成员方法
    }//父类的方法被子类重写override
}
```

```java
public class polyobject {
    public static void main(String[] args) {
       Xiaoming xm = new Xiaoming();
       Zhangsan zs = new Zhangsan();
       manager manager_ = new manager();
        manager_.get_info(xm);
        manager_.get_info(zs);
    }//只需创建一次对象,每次调用不同的学生信息
}
```

**运行机制**

1. 编写`Student stu = new Xiaoming();`语句
2. 编译javac : 识别 = 左边的编译类型
   - 由于编译器只识别编译类型(父类), 若想实际使用子类的方法, 必须在父类中重写
3. 运行java : 识别 = 右边的运行类型
4. jvm程序从 实际运行类型的对象(子类)中开始查找,若找不到,则向父类查找

在上面列出的例子中, 编译器在编译`get_info(Student stu)`时识别编译类型, 在jvm运行时识别实际运行类型即传入的对象`manager_.get_info(xm)` 和 `manager_.get_info(zs);`

Student类的对象 stu 在这个过程中体现了多态的特性

---

### 多态的转型

多态有两种类型

**1. 向上转型 :**	即前面所讲的内容, **向上转型即把低阶的子类转换为高阶的父类**, 是数据类型的转换

```java
父类类型 引用名 = new 子类类型();

Animal animal = new Cat();	//向上转型
Animal animal = dog;	//这也是向上转型,假设Dog是Animal的子类
```

**本质: ==父类的引用指向子类的对象==**

**[使用细节]**

- 使用对象的多态必须与其他对象构成继承关系
- 编译类型看 = 左边 , 运行类型看 = 右边
- **向上转型 可以调用父类的成员(也就是本身编译类型对象)**
- **向上转型 不能直接调用子类成员方法, 不能调用子类特有成员方法**
  - 编译器只识别编译类型对象的成员,如果编译类型对象没有就报错
  - 只有编译类型和运行类型同时存在该成员方法(方法重写),才能通过编译并运行
- 向上转型 成员属性不存在重写, **调用成员属性只取决于 编译类型**

 

**2. 向下转型 :** 把高阶的父类转换为低阶的子类, 即"向下"转换数据类型

**本质: ==把一个已经向上转型的子类对象，将父类引用转为子类引用==**

​	**或 : 将父类对象实例, 赋值给子类引用**

**意义:** 在向上转型中, 父类引用的子类对象不能直接使用子类成员, 为了使用子类成员, 在不创建新的对象的前提下, 让一个 **被父类引用的子类对象 **重新被一个子类引用

```java
子类类型 引用名 = (子类类型) 父类引用;

Animal animal = new Dog();	//向上转型
Dog dog = animal;			//error,违反了继承关系(is-a关系),父类不能直接赋值给子类
Dog dog = (Dog)animal;		//因此使用(Dog)强制转换animal类型
```

**[使用细节]**

- 只能**强制转换父类的引用**，不能强制转换父类的对象
- 要求父类的引用**必须指向**的是**当前目标类型的对象**
  - 父类引用指向的对象(运行类型)必须和强制转换类型一致
- 当向下转型后，**可以调用子类**类型中**所有的成员**

**[使用例子]**

```java
A is-a AA;	//A是AA的子类
B is-a A;		//B是A的子类
/*==============*/
AA a1 = new A();	//向上转型 父类引用a1指向子类对象A
AA a2 = new B();	//向上转型 a2是父类的父类引用
B  a3 = new A();	//error   子类引用a3不可以指向其父类对象A
Object obj = "hello"//向上转型 
A a = new A();
AA a_ = a;	--->	//这也是向上转型**

A a11 = (A)a1;		//向下转型	创建一个新的引用指向a1对象 (A)表示将编译类型强制转换为A类
A a22 = (A)a2;		//error	   a2原运行类型是B类,强制转换类型必须与原运行类型相同
```

在多态数组中，使用类型判断+向下转型输出子类特有方法

```java
public class PolyArray {
    public static void main(String[] args) {
        Person[] array = new Person[5];//创建一个Person类型的多态数组
        array[0] = new Person("jack", 18);
        array[1] = new Students("jane", 22, 100);
        array[2] = new Students("tom", 19, 90);
        array[3] = new Teacher("sara", 28, 6000);
        array[4] = new Teacher("mike", 29, 8000);
        //遍历数组,并输出子类特有方法
        for(int i = 0; i < array.length; i++) {
            //共有方法,利用方法重写和动态绑定机制,针对不同对象输出
            array[i].say(); 
            //判断当前对象,并强制转换编译类型,以此输出特有方法
            if(array[i] instanceof Students) {
                ((Students) array[i]).study();
            } else if(array[i] instanceof Teacher) {
                ((Teacher) array[i]).teach();
            }
        }
    }
}
```



---

### 多态的内存机制

<img src="https://pic.imgdb.cn/item/66c30b9cd9c307b7e9e11f6f.png"  >



### 动态绑定

- 调用对象方法时, 该方法与对象的内存地址/运行类型绑定
- 调用对象属性时, 没有动态绑定机制, 遵循就近原则

动态绑定是与运行类型绑定, 因此经常出现在多态中

```java
//创建父类
public class Person {
    //简单的创建两个属性
    private String name;
    private int age;

    //创建行为方法，方法中调用创建的say方法
    public void haviours(){
        say();
    }
    //创建方法
    public void say(){
        System.out.println("我是人类！！！");
    }

}
//创建子类
public class Student extends Person {
    //创建学生的属性
    private int  score;
    //重写行为
    public void haviours(){
        say();
    }
    //重写say方法
    public void say(){
        System.out.println("我是学生！！！");
    }
}
```

当我们调用子类的say方法

```java
public class Demo02 {
    public static void main(String[] args) {
        //创建学生
        Person student = new Student();
        //调用学生的haviours方法，由于我们的编译类型是Person类，而运行类型是Student类，而动态绑定机制是绑定运行类型。
        //所以，当我们调用haviours（）方法时，该对象绑定的是Student类，所以是调用Student类的say（）方法
        student.haviours();//返回我是学生！！！
    }
}
```

当我们删去Student类中的haviours()方法

```java
public class Demo03 {
    public static void main(String[] args) {
        //创建学生
        Person student = new Student();
        //调用学生的haviours方法，由于我们的编译类型是Person类，而运行类型是Student类，而动态绑定机制是绑定运行类型。
        student.haviours();//返回我是学生！！！
    }
}
```

当我们调用haviours() 方法时，由于子类没有havious方法，调用父类的havious方法，在父类的havious中，调用say方法，这时，动态绑定机制是绑定运行类型。**该对象绑定的是Student类，所以是调用Student类的say() 方法**

---

### 多态数组

利用对象多态特性建立一个可以存放本类和子类的数组, 并调用其共有方法和特有方法

```java
public class PolyArray {
    public static void main(String[] args) {
        Person[] array = new Person[5];//创建一个Person类型的多态数组
        array[0] = new Person("jack", 18);
        array[1] = new Students("jane", 22, 100);
        array[2] = new Students("tom", 19, 90);
        array[3] = new Teacher("sara", 28, 6000);
        array[4] = new Teacher("mike", 29, 8000);
        //遍历数组,并输出子类特有方法
        for(int i = 0; i < array.length; i++) {
            array[i].say(); //共有方法,利用方法重写和动态绑定机制,针对不同对象输出
            //判断当前对象,并强制转换编译类型,以此输出特有方法
            if(array[i] instanceof Students) {
                ((Students) array[i]).study();
            } else if(array[i] instanceof Teacher) {
                ((Teacher) array[i]).teach();
            }
        }
    }
}
class Person {//父类
    String name;
    int age;
    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void say() {
        System.out.println("Person: " + name + " " + age);
    }
}
class Students extends Person {//子类1
    int score;
    public Students(String name, int age, int score) {
        super(name,age);
        this.score = score;
    }
    @Override//重写say()
    public void say() {
        System.out.println("Students: " + name + " " + age + " " + score);
    }
    //编写Students类特有方法
    public void study() {
        System.out.println(name + " is studying java");
    }
}
class Teacher extends Person {//子类2
    int salary;
    public Teacher(String name, int age, int salary) {
        super(name,age);
        this.salary = salary;
    }
    @Override
    public void say() {
        System.out.println("Teacher: " + name + " " + age +" " + salary);
    }
    //编写Teacher特有方法
    public void teach() {
        System.out.println(name + " is teaching java");
    }
}
```

---

### 多态参数

编写方法时, 形式参数是父类, 传入的实际参数可以是本类或其子类







### 对多态的经验总结

**==对多态运用的一些总结==**

- 当多个对象的属性和方法具有一些共性, 可以抽象出一个父类, 利用父类的多态来调用子类, 大幅减少了代码冗余问题, 提高编写效率
- 当希望对一群子类调用一个共有成员方法时, 抽象出的父类也需要编写这个方法, 以便构成**重写**, 利用方法重写和动态绑定机制, 程序能够根据传入的当前对象自动调用相应的属性和方法
- 当希望调用每个子类特有的方法时, 利用 **instanceof** 判断当前对象的运行类型, 并将其编译类型强制转换为运行类型(向下转型), 这样才能直接调用子类的特有方法


---

## equals()方法

equals是**jdk**中定义在Object类中的一个方法, 用于比较两个**引用类型**的地址是否相等(默认)

以下是Object类下的原码:

```java
 public boolean equals(object obj) {
		return (this == obj);  //this是指类的当前实例
 }
```

所有的类都继承于Object类, 对于已有数据类型(基本数据类型,引用数据类型, 其他类)又进行了方法重写

如在String类下重写:

```java
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String) anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

String使用: `"hello".equals("hello")  //true`

**语法** : **`对象1.equals(对象2)`**

重写后比较传入对象与当前对象的"值"是否相等(不再是比较地址)

对Integer类的重写:

```java
 public boolean equals(object obj) {
     if(obj instanceof Integer) {
		return value == ((Integer)obj).intValue();
       //value和intValue()分别获取对象1和对象2的这个属性值
     }
     return false;
 }	
```

如果**自定义类时需要使用equals, 则需要自己重写**

## hashCode()

定义在Object类的方法, `对象名.hasCode()`返回当前对象的哈希码, 哈希码具有唯一性



## toString()

定义在Object类的方法, 默认返回 **全类名 + @ + 16进制哈希码**

源码:

```java
 public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```

用法 : 

```java
test ts = new test();
System.out.println(ts);				//直接调用对象名
System.out.println(ts.toString());	 //调用对象方法


/* 两者输出相同 :
com.exercise.hw03.test@b4c966a
com.exercise.hw03.test@b4c966a	*/
```

在实际使用中, 通常重写toString方法来**输出有关属性的信息**

```java
package com.exercise.hw03;

public class test {
    private String name = "jads";
    private int age = 19;

    @Override	//显示声明重写方便阅读
    public String toString() {
        return "name: " + name + ", age: " + age;
    }
}

public class main {
    public static void main(String[] args) {
        test ts = new test();
        System.out.println(ts);
        System.out.println(ts.toString());
    }
}
/* 输出结果
name: jads, age: 19
name: jads, age: 19	*/
```



## 断点调试(debug)

断点调试可以反映程序每一步的执行情况, 常用于检查bug所在位置, 也便于理解代码

1. 利用断点调试分析程序

<img src="https://pic.imgdb.cn/item/66d42b85d9c307b7e948b9be.png">

先标记一处断点(**红色**), 程序会从断点处开始执行(断点之前的代码会被执行但不会显示在debugger中)

蓝色行 为程序将要执行的内容 	每一步执行的结果会在**debugger**中写明

debugger支持动态下断点, 即debug时也可以下断点(至少有一处才能进入debug)

操作说明 :

- step over(步过) : 执行当前行程序, 并进入下一行
- step into(步入) : 执行当前行 并 跳转到当前行所执行的方法体中(如果有) 
- step out(步出) : 跳出方法体,回到上一步执行位置
- resume : 跳到下一处断点

2. 利用断点调试查看方法体

![11](https://pic.imgdb.cn/item/66d42efcd9c307b7e94ec445.png)



## Static 静态成员

---

Static关键字不能修饰类名 , 可以修饰成员方法 , 成员方法,  被static修饰的成员变量和成员方法**独立于该类的任何对象**

==它不属于某个对象实例，而属于整个类==

static关键字的引出，其中一个目的是为了不实例化就调用某些方法，提高效率

### 类变量

- 使用static关键字修饰，所有类(父类和子类及其实例)共有的变量
- **内存机制**：在jdk7之前，类变量存放在方法区内；从jdk8开始，类变量存放在元空间内，元空间不属于jvm，是计算机本地存储空间
- 通过类名(父类和子类和实例都行)调用，但是一般使用静态变量修饰的变量都是使用类名调用

```java
class Dog {
    public static int counts;	//定义静态成员变量
}
public class staticUse {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dos1.counts++;	//调用静态成员变量(类变量)
        Dog.counts++;	//等价写法
    }
}
```



### 类方法

- **重点** : 类方法中不能有this，super参数(this指向该方法的实例，静态方法不属于某个实例)
- 静态成员方法(包括静态代码块) 不能调用非静态成员属性, 因为后者基于具体的对象实现

```java
class Dog {
    public int weights;
    public Dog() {
    }
    public Dog(int weights) {
        this.weights = weights;
    }
    /*定义静态成员方法*/
    public static Dog weightCompare(Dog d1, Dog d2) {
        if(d1.weights > d2.weights) {
            return d1;
        } else {
            return d2;
        }
    }
}

/*===============================*/
public class staticUse {
    public static void main(String[] args) {
        Dog d1 = new Dog(17);
        Dog d2 = new Dog(28);
        
        Dog rt = Dog.weightCompare(d1, d2); //使用类名直接调用静态成员方法
        System.out.println(rt.weights);
    }
}
```



## main()函数详解

- **public**：jvm可以在程序所有类中调用main函数，因此他必须是public
- **static**：因为jvm调用main不需要对象，所以他必须是static
- **参数类型String[]**：用于存储java程序在执行时被传入的命令参数
- **形参args**：所有传入main()函数的参数 (不论main()中是否有scanner)

<img src="https://pic.imgdb.cn/item/672237d0d29ded1a8c904f92.png" style="zoom:60%; float:left;" >

运行该程序, 验证main()接收的参数来源

```java
public class mainTest {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + i + "个参数=" + args[i]);
        }
    }
}
```

<img src="https://pic.imgdb.cn/item/672237d1d29ded1a8c904ffc.png" style="zoom: 67%; float: left;" >

java 类名 后面紧跟的就是传入的命令参数

在idea中传入参数

<img src="https://pic.imgdb.cn/item/67232012d29ded1a8cfd31ec.png" style="zoom: 50%;" >

<img src="https://pic.imgdb.cn/item/67232012d29ded1a8cfd31d7.png" style="zoom: 50%;" >

<img src="https://pic.imgdb.cn/item/67232012d29ded1a8cfd31b7.png" style="zoom: 50%;" >



## abstract 抽象类

abstract关键词用于修饰抽象类和抽象方法。引入抽象类的目的是为了把一些公共方法和私有方法做区分

[使用细节]

- 抽象类不能被实例化，它可以作为其他类的基类，一个基本的模版被使用
- **(重点)** 使用抽象类修饰抽象方法，相当于声明一个方法的原型(没有方法体)，**在子类中必须重写才能调用该方法**
- 当一个非抽象类中有一个方法被abstract修饰时，这个类自动转化为抽象类，即不能再实例化
- 抽象方法没有方法体，也不能写方法体
- 抽象类中可以没有抽象方法，抽象类中的非抽象方法只能通过子类继承并调用
- 当子类继承了抽象类，则子类中必须实现抽象类的所有抽象方法，或者把子类也声明为抽象类
- **(重点)** 抽象类是对成员方法的抽象, 不存在抽象成员属性, 抽象类中的属性只能通过非抽象子类继承调用

```java
abstract class AA {
    int arg1 = 10; //抽象类的普通成员属性

    public abstract void fun1();
    protected abstract void fun2();
    public void p_function() {} //非抽象方法允许拥有方法体
}

//子类声明为abstract可以继承抽象父类
abstract class BB extends AA {
    abstract void fun3 ();
}

//非抽象类继承抽象类必须实现所有方法
class CC extends AA {
    @Override
    public void fun1() {
        System.out.println(arg1);//借助子类调用抽象类的属性
    }
    @Override
    protected void fun2() {
    }
}
```





## final关键字

final用于修饰类、成员变量和成员方法

final修饰的类有以下特点

- **不能被继承**（String、StringBuilder、StringBuffer、Math，不可变类）

- **所有的方法都不能被重写** (这里需要注意的是不能被重写，但是可以被重载，这里很多人会弄混)

final的不可重写性质与abstract刚好相反





## interface 接口

---

### 接口的基本知识

> **此接口和网络接口不是一个概念, 一般的接口更多的指网络通信接口**

`接口interface` 本身是一种抽象类型

接口和抽象类的概念不一样，接口不是类。接口是对动作的抽象，抽象类是对根源的抽象

和abstract类型一样，interface类型可以被普通类实现，且必须实现所有方法；可以被其他接口类继承

[使用细节]


- 接口是抽象类型, 不能实例化
- 接口的访问修饰符只有 public 和 default
- 接口中的所有方法必须在普通类中实现 (快捷键alt+enter)
- **(重点)** *一个普通类可以同时实现多个接口(但是一个类只能继承一个类) 使用逗号隔开* `class implIAA implements IAA, IAB ` 
- 接口的成员属性必须是 `public static final` (可省略) 必须初始化变量; 调用方法为`[接口名/子接口名/实现接口的子类名].[属性名]`
- 接口成员方法默认是` public 和 abstract`, 可以省略, 方法可以被private修饰, 表示只允许此接口使用, 此时必须有方法体
- 接口不能继承自其它类, 但是可以继承自其它接口 (允许多继承)



```java
interface IAA { //接口1
    public abstract void fun1(); 
    void fun2();//等价写法fun1
}

interface IAB { //接口2
    void fun3();
    void fun4();
}

//接口可以继承自其他接口,可以多继承
interface IAC extends IAA,IAB { //接口3
    void fun5();
}

//普通类实现接口类型,可以实现多个接口
class implIAA implements IAA, IAB  { //实现接口IAA,IAB
    //注:方法重写不能缩小父类方法,可以扩大
    @Override
    public void fun1() {
    }
    @Override
    public void fun2() {
    }
    @Override
    public void fun3() {
    }
    @Override
    public void fun4() {
    }
}
```



### 接口和类的关系

- 类与类

继承关系，只能单继承，可以多层继承

- 接口和接口之间的关系

继承关系，可以单继承，也可以多继承，并且可以多层继承

- 接口和类之间的关系

实现关系
**单实现:** 一个类实现一个接口
**多实现:** 一个类可以同时实现多个接口并且还可以在继承一个类的同时实现多个接口

`public class 类名 extends 父类名 implements 接口名1,接口名2,…{ }`

- 接口与抽象类之间的关系

接口不是类, 抽象类是类, 因此接口相比于抽象类拥有 **多继承机制**

接口在功能实现上比抽象类更简洁。只有抽象方法和静态变量存在，没有构造方法，也不能有静态代码块以及静态方法等，所有的实现都在其实现类中完成。

继承是满足is - a的关系，而接口只需满足like - a的关系。接口也更加方便扩展功能，而继承更可能带来一定的冗余，比如继承后拥有一些父类有但自己又不需要的功能。

> 举个例子，接口是对人类行为的抽象（走，跑，跳，吃饭），人类可以同时存在多种行为，因此一个类可以实现多个接口；抽象类是对人类这一概念的抽象（灵长类，哺乳类），人类作为一个物种是唯一的，就像生物学上的种类划分，是多层继承，而不是多继承

这两个都是提供了一种模版，方便后续对相关方法的实现



### 实现和继承的关系

前文所举的例子同样适用于实现和继承的说明:

> 接口是对人类行为的抽象（走，跑，跳，吃饭），人类可以同时存在多种行为，因此**一个类可以实现多个接口**；抽象类是对人类这一概念的抽象（灵长类，哺乳类），人类作为一个物种是唯一的，就像生物学上的物种划分，**是多层继承，而不能是多继承**

实现和继承并不冲突, `public class 类名 extends 父类名 implements 接口名1,接口名2,…{ }`

当一个普通类如果同时继承一个类和实现一个接口时:

- 这个类和接口中存在同名成员属性, 在子类调用中要作区分才能调用 (接口属性使用静态变量法调用, 父类属性使用super关键字调用)
- 类和接口中存在同名成员方法, 则无需理会, 因为子类必须重写该方法



```java
interface Interface {
    String arg = "Interface arg"; //等价于 public static final String
    void printArgs();
}
class Father {
    String arg = "Father arg";
    void printArgs() {
        System.out.println(arg);
    }
}
class Son extends Father implements Interface {
    @Override
    public void printArgs() {
        System.out.print(Interface.arg + "and" + super.arg);//变量冲突的解决方案
    }
}
```











### 接口的多态特性

和继承多态类似 , 接口类型可以作为编译类型使用, 实现接口的类作为运行类型

应用包括: 多态数组 和 多态函数

```java
public class interface_ {
    public static void main(String[] args) {
        //定义类编译类型为IAA接口,其运行类型可以是接口IAA及其实现类
        IAA iaa01 = new implIAA();
        IAA iaa02 = new implIAB();

        IAA[] iaaArray = new IAA[2];//多态数组
        iaaArray[0] = iaa01;
        iaaArray[1] = iaa02;
        for (int i = 0; i < iaaArray.length; i++) {
            iaaArray[i].fun1();
            if (iaaArray[i] instanceof implIAA) {
                ((implIAA) iaaArray[i]).funCLass();
            }
        }
    }
}


class implIAA implements IAA, IAB  {
    @Override
    public void fun1() {
        System.out.println("fun1 in implIAA");
    }
     public void funCLass() { //普通类的特有方法
        System.out.println("funCLass in implIAA");
    }
}
class implIAB implements IAA,IAB {
    @Override
    public void fun1() {
        System.out.println("fun1 in implIAB");
    }
}
```

<img src="https://pic.imgdb.cn/item/6725efb5d29ded1a8c877306.png" style="float: left; zoom: 80%;" >







## **类加载机制**

---

[参考文献 -- 类加载过程](https://javaguide.cn/java/jvm/class-loading-process.html#%E7%B1%BB%E5%8A%A0%E8%BD%BD%E8%BF%87%E7%A8%8B)

### 类的生命周期

类从被加载到虚拟机内存中开始到卸载出内存为止，它的整个生命周期可以简单概括为 7 个阶段：加载（Loading）、验证（Verification）、准备（Preparation）、解析（Resolution）、初始化（Initialization）、使用（Using）和卸载（Unloading）。其中，验证、准备和解析这三个阶段可以统称为连接（Linking）

<img src="https://pic.imgdb.cn/item/67232479d29ded1a8c012b1b.png" style="zoom: 67%; float:left;" >

### 类加载的时机 -- 什么情况下会触发类加载

类加载是一个非常重要的概念

特别注意，**访问类的静态成员**会导致类被加载，而加载的过程遵循一定的顺序，当加载和初始化完毕才会继续访问操作

<img src="https://i-blog.csdnimg.cn/blog_migrate/faf1bb44299ed4cf2c8cfb19093984ef.jpeg" style="zoom: 67%; float: left;" >

### 类内部加载和初始化顺序

由上述声明周期，类加载并连接之后要进行初始化，一个类内部的初始化顺序遵循以下顺序：

1. **调用静态代码块和静态成员属性初始化（二者优先级相等，按照定义顺序进行）**
2. **调用普通代码块和普通成员属性初始化（同上）**
3. **调用构造器初始化 **

若存在继承关系，则先从父类开始初始化（从顶级父类Object）顺序是：

1. **父类静态代码块和静态属性**
2. **子类静态代码块和静态属性**
3. **父类普通代码块和属性**
4. **父类构造器**
5. **子类普通代码块和属性**
6. **子类构造器**

> 注意这里的顺序来源，子类被加载，由子类的构造方法（ **super()** ）找到父类，从父类开始初始化，依次向下直到调用的子类





## 内部类 (InnerClass)

---

在Java 中，可以**将一个类定义在另一个类里面或者一个方法里面，这样的类称为内部类**。与之相对的是外部类(OuterClass);  广泛意义上的内部类一般来说包括这四种：静态内部类、匿名内部类、成员内部类和局部内部类

内部类是类的第五大成员 ; 包括 `成员变量 构造方法 代码块 成员方法 内部类`

<img src="https://i-blog.csdnimg.cn/blog_migrate/26d0a48b8bab0b23bb7a44677321f337.jpeg">





### 局部内部类

定义在外部类的**局部位置(方法体或代码块中)**, 有类名, **其地位相当于外部类的一个局部变量(不是属性)**

- 可以访问外部类的所有成员, 包括private
- 不允许添加访问修饰符, 但可以用final修饰
- 作用域范围仅在定义它的方法体或代码块中
- 当内部类和外部类成员重名时, 遵循就近原则

```java
public class Test {
    public int a = 0;
    public double b = 0.0;
    public void fun(){
        System.out.println("哈哈哈");
    }
    public static void main(String[] args) {
        class T{  //局部内部类 定义到main方法内部作为局部变量
            public int a = 10; //访问外部类的成员
            public void fun(){ //重写外部类方法
                System.out.println("hahaha");
            }
        }
        T t = new T(); //在外部类中访问内部类
        t.fun();
        System.out.println(t.a);
    }
}
```



### 匿名内部类 (最重要)

匿名内部类是没有名字的内部类(事实上, 匿名类不是没有名字, 而是系统分配不可见), **定义在方法体或代码块的内部**, 它同时也是一个对象

基本语法: `new OutClassName() { body..... }` 为了在外部类访问, 一般还是要加上编译类型和类名

直接在new对象的后面插入方法体, 方法体内部就是匿名内部类的主体

匿名内部类的编译类型 : 与外部类保持一致;  运行类型: `编译类型 + 04$1...9` , 即运行类型是它本身

```java
class implIAA implements IAA, IAB  { 
    @Override
    public void fun1() {
        System.out.println("fun1 in implIAA");
    }
    @Override
    public void fun2() {
    implIAA iaa1 = new implIAA() { //匿名内部类
        @Override
        public void fun1() {
            System.out.println("fun1 in 匿名类"); //一般是重写外部类成员才能访问
        }
        void sprint() { //定义的内部成员方法,无法在外部类访问,因为无法向下转型
               System.out.println("fun in implIAA");
           }
        };//匿名类结束,注意分号
    iaa1.fun1(); //在外部类访问匿名类成员
    }

```

**匿名类和接口的搭配使用**

```java
public interface Calculator { //定义接口
    void work(int num1, int num2); //接口是不能有方法体的
}

public class CellPhone {
    /*把接口作为一个参数传入方法
    * 在调用方法时传入已经实现了该接口的一个匿名类
    * 这种方式灵活且不受方法体的限制*/
    public void testWork(Calculator calculator, int num1, int num2) {
        calculator.work(num1, num2);
    }
}


public static void main(String[] args) {
        int num1 = 1, num2 = 2;
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new Calculator() {//使用匿名接口类
            @Override
            public int work(int num1, int num2) {//重写接口方法实现
                return num1 + num2;
            }
        }, num1, num2);//匿名类结束
}
```











### 成员内部类

定义在外部类的成员位置, 没有static修饰(否则就变成了静态内部类), 相当于外部类的一个成员属性

- 成员内部类可以直接访问外部类的成员, 包括private , static修饰的
- 访问修饰符范围和普通成员变量一样(即四大访问修饰符)
- 成员内部类的作用域和普通成员一致
- **在外部类方法体中调用内部类成员, 要先创建内部类的实例**
- 当外部类和内部类成员同名时, 对外部类使用`外部类名.this.成员名`作区分

```java
public class Outer {

    private int outerVariable = 1;
    private int commonVariable = 2;
    private static int outerStaticVariable = 3;

    public class Inner { //内部类
        private int commonVariable = 20;
        public Inner() {}
        
        public void innerShow() {
            //当和外部类冲突时，直接引用属性名，是内部类的成员属性
            System.out.println("内部的commonVariable:" + commonVariable);
            //内部类访问外部属性
            System.out.println("outerVariable:" + outerVariable);
            //当和外部类属性名重叠时，可通过外部类名.this.属性名
            System.out.println("外部的commonVariable:" + Outer.this.commonVariable);
            System.out.println("outerStaticVariable:" + outerStaticVariable);
            //访问外部类的方法
            outerMethod();
            outerStaticMethod();
        }
    }
    
	//外部类访问内部类信息
    public void outerShow() {
        Inner inner = new Inner();
        inner.innerShow();
    }
}

```

其他类要访问某一个内部类时, 有以下两种方法

```java
方法1
public class Other {
    public static void main(String[] args) {
        //外部类对象
        Outer outer = new Outer();
        //创造内部类对象
        Outer.Inner inner = outer.new Inner(); 
        inner.innerShow();
    }
}


方法2
* 可在Outer中定义get方法，获得Inner对象,那么使用时，只需outer.getInnerInstance()即可。
* public Inner getInnerInstance(Inner类的构造方法参数){
*   return new Inner(参数);
* }

```



### 静态内部类

就是加了static修饰的成员内部类, 使用和成员内部类有一定区别, 和静态成员方法有共同点

- 访问修饰符为四大修饰符
- 可以访问外部类的静态方法, 但是不能访问非静态方法(和静态成员方法相同)
- 作用域范围和普通成员一致
- **在外部类中使用内部类名直接调用内部类的成员方法(类比静态类的调用)**

```java
/**
 * 外部类、内部类定义
 */
public class Outer {
    private int outerVariable = 1;
    /**
     * 外部类定义的属性(重名)
     */
    private int commonVariable = 2;
    
    private static int outerStaticVariable = 3;

    static {
        System.out.println("Outer的静态块被执行了……");
    }
    /**
     * 成员方法
     */
    public void outerMothod() {
        System.out.println("我是外部类的outerMethod方法");
    }
    /*
    *	静态方法
    */
    public static void outerStaticMethod() {
        System.out.println("我是外部类的outerStaticMethod静态方法");
    }
    /**
     * 静态内部类
     */
    public static class Inner {
        /**
         * 成员信息
         */
        private int innerVariable = 10;
        private int commonVariable = 20;

        static {
            System.out.println("Outer.Inner的静态块执行了……");
        }
        private static int innerStaticVariable = 30;
        /**
         * 成员方法
         */
        public void innerShow() {
            System.out.println("innerVariable:" + innerVariable);
            System.out.println("内部的commonVariable:" + commonVariable);
            System.out.println("outerStaticVariable:"+outerStaticVariable);
            outerStaticMethod();
        }
        /**
         * 静态方法
         */
        public static void innerStaticShow() {
        	//被调用时会先加载Outer类
            outerStaticMethod();
            System.out.println("outerStaticVariable"+outerStaticVariable);
        }
    }
     //外部类的内部如何和内部类打交道
    public static void callInner() {
        System.out.println(Inner.innerStaticVariable);
        Inner.innerStaticShow();
    }
}

```

其他类访问静态内部类

```java
public class Other {
    public static void main(String[] args) {
        //访问静态内部类的静态方法，Inner类被加载,此时外部类未被加载，独立存在，不依赖于外围类。
        Outer.Inner.innerStaticShow();
        //访问静态内部类的成员方法
        Outer.Inner oi = new Outer.Inner();
        oi.innerShow();
    }
}
```



## 枚举类

---

[使用细节]

- 创建枚举类不能跟继承，因为它有一个隐式的继承自Enum类
- 枚举类可以实现接口
- 和C,C++区别，不能自己设置枚举对象的编号，而是系统自己默认设置



不使用枚举类的表示

```java
public class DayDemo {
    public static final int MONDAY =1;
 
    public static final int TUESDAY=2;
 
    public static final int WEDNESDAY=3;
 
    public static final int THURSDAY=4;
 
    public static final int FRIDAY=5;
 
    public static final int SATURDAY=6;
 
    public static final int SUNDAY=7;
}
```

使用枚举类

```java
//枚举类型，使用关键字enum
enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```



枚举类的调用

```java
enum Color  //声明一个枚举类
{ 
    RED, GREEN, BLUE; 
} 
  
public class Test 
{ 
    // 执行输出结果
    public static void main(String[] args) 
    { 
        Color c1 = Color.RED; 
        System.out.println(c1); //输出RED
    } 
}
```





## 注解Annotation

---

以下三种注解类都是被@interface修饰的**注解类**

- @Override 注解

```java
/*源码*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
```

由于被`@Target(ElementType.METHOD)`修饰，**只能修饰方法体**，用于方法声明语句上层

其作用在于做语法校验，加上@override修饰后如果不构成重写，则无法通过编译。

同时，显示声明也可以提醒程序员这里的方法需要重写

- @Deprecated

```java
/*源码*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
public @interface Deprecated {
```

由`@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})`修饰，**可以修饰包，类，方法，属性，参数等等**

用于表示被修饰的方法、类、参数已经过时，不适合最新版本，但不代表不能使用。用于版本过渡



- @SuppressWarnings( {参数} )

可以修饰具体的**类，方法，属性，参数，对象**

用于抑制编译器传出的警告信息(黄色波浪线和黄色高亮), 参数为可选关键字



### 元注解

元注解是**修饰注解的注解**，用于限定注解的某些功能。其主要的用途是看源码

- @Retention(RetentionPolicy.{关键字})

指定注解的生效范围，有三种 `RetentionPolicy.RUNTIME(运行时)` `RetentionPolicy.CLASS(类文件)` `RetentionPolicy.SOURCE(源文件)`

- @Target(ElementType.{关键字})

指定注解可以在哪些地方使用, 关键字限定可以使用的范围

- @Documented

被@Documented指定的注解在生成 `java.doc` 文档的时候保留

- @Inherited	 

被@Inherited指定的注解修饰的元素被继承时，被指定的注解也会被继承



## 异常

---

当程序的某一段出现错误，使用异常处理机制可以避免程序崩溃，可以异常类Exception捕获出现的异常，并进行相应的处理使得程序可以继续运行

### 异常的分类

1. Error

严重的程序错误会导致系统崩溃，不能通过异常处理解决，如：栈溢出、内存泄漏

2. Exception

因编程错误导致的部分异常，可以使用异常捕获去处理和解决，如：空指针、文件读取失败、网络中断

Exception分为两大类：**运行时异常**`RuntimeException` 和 **编译时异常** 。	以下讨论的都是Exception异常

> 注: 语法错误和部分逻辑错误不属于异常的范畴

<img src="https://pic.imgdb.cn/item/6746d462d0e0a243d4d1e914.png">

异常类的关系图如上所示

所有异常(exception和error)的直接父类是`Throwable` , 顶级父类是`Serializable`

### RuntimeException 五种常见类型

- NullPointerException   空指针异常
- ArithmeticException  算数异常(即由数学运算错误引起的异常)
- ArrayIndexOutOfBounds   数组越界异常(索引为负或大于等于length)
- ClassCastException   类转型异常(向上或向下转型出现错误)
- NumberFormatException  数字格式异常(如字符串字母转型整数出现错误)

### 常见编译异常

<img src="https://pic.imgdb.cn/item/6746dd18d0e0a243d4d1ed3a.png">



### 异常处理 tcf

- **try-catch-finally** 基本格式

```java
try {
  //正常语句
} catch([异常类] [类名]) {
  //捕获并处理异常操作
} finally {
  //不论是否异常都执行,且一定最后执行
}
```

如:

```java
/*异常处理*/
public class exception {
    public static void main(String[] args) {
        try {
            String str = "abc";
            System.out.println(Integer.parseInt(str)); 
            //将字符串转换成整数,如果不能转换会抛出转型异常
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally run");
        }
    }
}
```

<img src="https://pic.imgdb.cn/item/6746e47dd0e0a243d4d1f058.png" style="zoom:80%;" >

❤例题1:	下列代码的执行顺序和输出结果

```c
public class ExceptionExe01 {
    public static int method() {
        int i = 1;
        try {
            i++;
            String[] names = new String[3];
            if (names[1].equals("tom")) { //空指针错误,跳出try
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) { //进入空指针异常catch块
            return ++i; //执行
        } finally { //finally块最后执行
            ++i; 
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
```

> 分析:	这里在进入catch后执行到`return i++` , 正常情况下程序遇到return语句就会返回并退出, 但是由于finally块还未执行, jvm程序在这里的做法是----**使用临时变量temp存储i++的结果 i = 3, 然后执行finally语句, 由于finally中没有return, 在执行结束后返回catch块, 此时的变量i仍是临时变量temp中保存的i = 3**, 也就是说, 程序最后的结果是输出 i=3

通过本题得知: **如果catch中存在结束程序的语句, 而finally代码块存在且尚未执行, 程序会将catch中的结果以临时变量的形式存储, 并在必要时回溯并返回该值** , 当catch和finally都有return语句时，只执行finally中的return，因为finally最后必须执行



### tcf使用细节

1. 在idea中, 选中认为会出现异常的语句，按`ctrl+alt+t` , 选择try catch语句，即可自动生成该格式
2. try中的语句若有异常，则执行到语句就会转到catch中，try中剩下的语句不再执行
3. 若没有异常，则将try中语句执行完，不会执行catch中的语句
4. finally一般用于关闭资源，用不到的时候可以不写这部分，即只有try-catch
5. catch部分可以不写，即只有try-finally，这么做的话，因为没有catch语句，即使获取错误也不会处理，而是直接报错，其目的就在于在报错前执行finally语句

6. 可调用多个catch来防止多重异常，**但父类Exception必须写在最后一个，且碰到一个错误就会返回异常，并不会将所有错误检测出，**相当于建立了多重墙，并返回首个异常



### 异常处理 throws

- **throws** 关键字用于在方法声明中指定该方法可能抛出的异常。当方法内部因为运行错误抛出指定类型的异常时，该异常会被传递给调用该方法的代码，该代码中必须设置相应的异常处理块(当异常为编译异常时, 见下文)
- 可以抛出多个异常, 包括父类Exception

```java
public void readFile(String filePath) throws IOException, FileNotFoundException {
    //throws跟在方法声明头的后面
  BufferedReader reader = new BufferedReader(new FileReader(filePath));
  String line = reader.readLine();
  while (line != null) {
    System.out.println(line);
    line = reader.readLine();
  }
  reader.close();
} //当出现异常时,停止方法内的语句,并返回异常类对象给调用代码
```



### throws使用细节

1. 对于编译异常, 必须更改代码或显式的调用throws, 才能通过编译
2. 对于运行异常, jvm程序中隐式执行了throws, 也就是不声明throws, 程序运行异常也会在终端输出(有默认处理)
3. 当子类重写了父类的方法并且父类方法显式的抛出异常时，子类抛出的异常类型必须和父类相同，或者是父类异常类型的子类(子类可以不写throws, 不抛出异常)
4. throws 和 tcf , 一个是检测到并抛出自己不处理, 一个是检测到并自己内部处理



### 自定义异常类

- 继承自Exception , 则认为是编译异常
- 继承自RuntimeException , 则认为是运行异常(用的更多)

```java
class AgeExecption extends RuntimeException{ 
    public AgeExecption(String message) { //构造器
        super(message); 
        /*//显式初始化父类
        因为每个异常类都需要一个消息字符串来描述异常的原因，
        这个字符串最初是在Throwable类中定义的。*/
    }
}

```



## 包装类(wrapper)

---

8种基本数据类型对应的包装类名

| 基本数据类型 |             包装类型              |
| :----------: | :-------------------------------: |
|     byte     |   java.lang.Byte（父类Number）    |
|    short     |   java.lang.Short（父类Number）   |
|     int      |  java.lang.Integer（父类Number）  |
|     long     |   java.lang.Long（父类Number）    |
|    float     |   java.lang.Float（父类Number）   |
|    double    |  java.lang.Double（父类Number）   |
|   boolean    |  java.lang.Boolean（父类Object）  |
|     char     | java.lang.Character（父类Object） |

包装类属于**引用数据类型**(和string一样), 具有类的特性, 封装了很多操作方法

Character 和 Boolean 是直接继承的Object类，实现了`Serializable`接口

其余六种继承Number类，实现的`Comparable`接口（Number类也实现了Serializable接口）

<img src="https://pic.imgdb.cn/item/67472a7bd0e0a243d4d2f226.png" style="zoom:67%;" >



### 基本数据类型和包装类转换

* 转换又称为**装箱**（基本数据类型->包装类）/ **拆箱**（包装类->基本数据类型）
* 转换分为手动和自动两种形式，现在一般用自动，自动的底层实现就是手动















## 泛型

---

>  泛型的作用
>
> - **类型安全**：通过在编译时指定类型参数，避免了类型转换错误(增减了类型检查)，提高了类型安全性。
> - **代码复用**：泛型允许编写可以应用于多种类型的通用类、接口或方法，减少代码重复。
> - **减少类型转换**：使用泛型后，不需要显式地进行类型转换，因为编译器会自动处理。

泛型允许你在定义类、接口或方法时，不指定具体的类型，而是使用类型参数（如 `T`、`E`、`K`、`V` 等）来代替具体的类型。类型参数可以在运行类、接口或方法时再指定具体的类型。

```java
class Box<T> {
    private T item;	//在创建类的时候,属性itme的类型就是T

    public void set(T item) { //set方法初始化属性
        this.item = item;
    }
    public T get() {
        return item;
    }
}

public static void main(String[] args) {
       Box<String> box = new Box<String>();	//创建对象,要在类名后面声明类型参数的具体类型
       box.set("12345");
       System.out.println(box.get());
   }
```

ps : 泛型在这里的作用相当于一个占位符, 在主函数中创建类的实例时, 编译器把泛型参数替换成指定的类型



**利用泛型进行对象数组的遍历和方法调用**

```java
/*传统方法*/
public static void main(String[] args) {
        Person[] array = new Person[5];//创建一个Person类型的多态数组
        array[0] = new Person("jack", 18);
        array[1] = new Students("jane", 22, 100);
        array[2] = new Students("tom", 19, 90);
        array[3] = new Teacher("sara", 28, 6000);
        array[4] = new Teacher("mike", 29, 8000);
        //遍历数组,并输出子类特有方法
        for(int i = 0; i < array.length; i++) {
            array[i].say(); 
            //判断当前对象,并强制转换编译类型,以此输出特有方法
            if(array[i] instanceof Students) {
                ((Students) array[i]).study();
            } else if(array[i] instanceof Teacher) {
                ((Teacher) array[i]).teach();
            }
        }
    }
```

缺点 :

- 不能对输入数组的对象进行类型检查
- 调用子类方法时需要向下转型, 代码冗余

```java
// 泛型方法，接收一个 Person 及其子类的数组
public static <T extends Person> void printSays(T[] array) {
    for (T element : array) {
        element.say();
    }
}	
public static void main(String[] args) {
        // 创建一个包含 Person 和 Student 对象的数组
        Person[] people = new Person[] {
            new Person(),
            new Student()
        };
        printSays(people);
}
  
```

使用 `T extends Person` 限定泛型必须是 `Person` 类或其子类，这样就能在数组中存放 `Person` 及其子类的对象







## Java设计模式

---

**什么是设计模式?**

设计模式（Design pattern）是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性

- 总体来说设计模式分为三大类

创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。

结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。



### 单例模式

单例模式是指程序的整个生命周期中有且仅有一个对象的类，这个类提供了一种访问其唯一的对象的方法，可以直接访问，不需要实例化该类的对象，也就是说不能使用new关键字来创建对象。

- **饿汉式** (线程安全)

这种方法通过将对象的实例设置为静态的方式，保证了该对象的实例，永远只有一份，且*该对象的创建在类加载的时候就会立即创建在jvm内存中的方法区*，在程序运行期间永久存在，所以当我们的对象太大的时候就会造成一种资源的浪费。

1. 构造器私有化（防止在类的外部创建对象）
2. 类的内部创建其唯一对象
3. 向外暴露一个静态方法用于操作对象

```java
public class Singleton {
    //私有化构造方法
    private Singleton() { }
    //在成员位置创建该类的对象并静态化
    private static Singleton instance = new Singleton();
    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        return instance;
    }
}
```



- **懒汉式1** (线程不安全)

基本框架和饿汉式相同, 区别在于创建对象的时机放到公共静态成员方法中, 只有当使用时才创建, 而在类加载时不会创建, 确保了资源的有效利用

```java
public class Singleton {
    //私有构造方法
    private Singleton() {}
    //在成员位置创建该类的对象
    private static Singleton instance; //<---注意这里没有new对象,只是编译
    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```





## I/O流

---

**输入流**(Inout Stream)与 **输出流**(Output Stream)合称为 **数据流**(Data Stream)

输入输出流的来源和接收者可以是文件、内存、网络连接等

写入数据的原理：Java程序→JVM→OS→OS调用写入数据的方法→写入成功→手动释放OS资源

读取数据的原理：Java程序→JVM→OS→OS调用读取数据的方法→读取成功→手动释放OS资源



### 文件

- 创建文件

文件对象 `File` (位于java.io包内) , 封装了文件的相关操作, 具有多个构造器

<img src="https://pic.imgdb.cn/item/674b18e3d0e0a243d4db79f3.png" style="zoom: 80%;" >

```java
public File(String pathname);	//根据绝对路径创建文件(包含要创建的文件名)
public File(File parent, String child);	//根据父文件和相对路径创建
public File(String parent, String child); //根据父文件和子文件相对路径创建
```

代码演示

```java
import java.io.File; //包名

//1.根据子文件的绝对路径创建
public void createFile_1() {
    String path = "C:\\Users\\12275\\Documents\\file1.txt"; //需要指定子文件名
    File file = new File(path);
    //创建文件的操作强制要求处理异常,否则不能通过编译
    try {
        file.createNewFile();
        System.out.println("File Created");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

//2.根据父文件目录定位和子文件名创建
public void createFile_2() {
    File parent = new File("C:\\Users\\12275\\Documents\\"); //注意末尾应该加'\\'
    //不指定文件名,不会创建文件,但是相当于打开了指定工作目录
    //当然也可以借助一个实际的文件定位工作目录,然后创建子文件
    String path = "file2.txt";
    File file = new File(parent, path);
    try {
        file.createNewFile();
        System.out.println("File Created");
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

//3.根据父目录和子目录创建文件
public void createFile_3() {
    String parent = "C:\\Users\\12275\\Documents\\";
    String son = "file3.txt";
    File file = new File(parent, son);
    try {
        file.createNewFile();
        System.out.println("File Created");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
```



- 获取文件信息

File类提供了很多文件操作方法, 在需要使用时可以查表

```java
public void getInfo(File file) {
    file = new File("C:\\Users\\12275\\Documents\\file1.txt");

    System.out.println("获取文件名: " + file.getName());
    System.out.println("获取绝对路径: " + file.getAbsolutePath());
    System.out.println("获取父目录: " + file.getParent());
    System.out.println("获取文件大小(字节): " + file.length());
    System.out.println("文件是否存在: " + file.exists());
    System.out.println("判断是否是文件: " + file.isFile());
    System.out.println("判断是否是目录: " + file.isDirectory());
}
```

输出结果

<img src="https://pic.imgdb.cn/item/674b2b7ed0e0a243d4db7de9.png" style="zoom: 80%; float: left;" >





















## 网络编程

---

课程跳转 https://www.bilibili.com/video/BV1fh411y7R8?vd_source=98d8086c38b750b0ce152d6d7c45607f&spm_id_from=333.788.videopod.episodes&p=666

