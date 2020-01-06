# 2. Create a simple Dart class

## Define a Bicycle Class

#### Dart

```dart
class Bicycle{
  int cadence;
  int speed;
  int gear;
}

void main(List<String> args) {
  for (int i = 0; i < 5; i++) {
    print('hello ${i + 1}');
  }
}
```

#### Java

```java
public class Bicycle{
  int cadence;
  int speed;
  int gear;
  
  public static void main(String args[]){
    
    for(int i =0; i<5; i++){
      System.out.printf("hello %d", i+1);
    }
  }
}
```



1. main()메소드 선언 : main() main(List<String> args)
2. main()이 class 밖에 선언되어있다. 코드를 class 밖에서 선언 할 수 있다. (variable, function, getter, setter 등)
3. dart는 private를 사용하지 않는다. 
4. class나 main을 public 으로 사용하지 않아도 된다. identifier는 default가 public이다. dart는 public, private, or protected 키워드가 없다.
5. dart의 indet는 2-charater이다. (4 대신)



## Define a Bicycle constructor

#### Dart

```dart
class Bicycle{
  int cadence;
  int speed;
  int gear;
  
  Bicycle(this.cadence, this.speed, this.gear);
  
}

void main(List<String> args) {
  for (int i = 0; i < 5; i++) {
    print('hello ${i + 1}');
  }
}
```

#### Java

```java
public class Bicycle{
  private int cadence;
  private int speed;
  private int gear;

  Bicycle(int cadence, int speed ,int gear) {
    this.cadence = cadence;
    this.speed = speed;
    this.gear = gear;
  }
  
  int getCadence(){
    return this.cadence;
  }
  
  void setCadence(int newValue){
    this.cadence = newValue;
  }
  
  int getGear(){
    return this.gear;
  }
    
  void setGear(int newValue){
    this.gear = newValue;
  }
  
  int getSpeed(){
    return this.speed;
  }
  
  void setSpeed(int newValue){
    this.speed = newValue;
  }

  public static void main(String args[]){
    for (int i = 0; i < 5; i++) {
      System.out.printf("hello %d", (i+1));
    }
  }
}
```

1. constructor가 body를 가지지 않는다.
2. constructor의 끝에 세미콜론(;)을 붙이지 않으면 error가 발생한다.
3. constructor의 parameter에 this를 사용하면, instance 변수에 값을 하나씩 할당할 수 있다.



## Format the code

#### Dart

```dart
class Bicycle{
  int cadence;
  int speed;
  int gear;
  
  Bicycle(this.cadence, this.speed, this.gear);
  
}

void main(List<String> args) {
  var bike = new Bicycle(2,0,1);
  // var bike = Bicycle(2,0,1);
  print(bike);
  // >> Instance Of 'Bicycle'
}
```

#### Java

```java
public class Bicycle{
  private int cadence;
  private int speed;
  private int gear;

  Bicycle(int cadence, int speed ,int gear) {
    this.cadence = cadence;
    this.speed = speed;
    this.gear = gear;
  }
  
  int getCadence(){
    return this.cadence;
  }
  
  void setCadence(int newValue){
    this.cadence = newValue;
  }
  
  int getGear(){
    return this.gear;
  }
    
  void setGear(int newValue){
    this.gear = newValue;
  }
  
  int getSpeed(){
    return this.speed;
  }
  
  void setSpeed(int newValue){
    this.speed = newValue;
  }

  public static void main(String args[]){
    final Bicycle bike = new Bicycle(2,0,1);
    System.out.println(bike);
    //>> hashcode
  }
}
```

1. new 생성자가 optional이다.
2. 만약 variable이 바뀌지 않으면 final 대신 var를 사용한다.



## Improve the output

#### Dart

```dart
class Bicycle{
  int cadence;
  int speed;
  int gear;
  
  Bicycle(this.cadence, this.speed, this.gear);

  @override
  String toString() => 'Bicycle: $speed mph';
}

void main(List<String> args) {
  var bike = Bicycle(2,0,1);
  print(bike);
  // >> Bicycle: 0mph
}
```

#### Java

```java
public class Bicycle{
  private int cadence;
  private int speed;
  private int gear;

  Bicycle(int cadence, int speed ,int gear) {
    this.cadence = cadence;
    this.speed = speed;
    this.gear = gear;
  }
  
  int getCadence(){
    return this.cadence;
  }
  
  void setCadence(int newValue){
    this.cadence = newValue;
  }
  
  int getGear(){
    return this.gear;
  }
    
  void setGear(int newValue){
    this.gear = newValue;
  }
  
  int getSpeed(){
    return this.speed;
  }
  
  void setSpeed(int newValue){
    this.speed = newValue;
  }
  
  @override
  public String toString(){
    return "Bicycle: " +this.speed + " mph"; 
  }

  public static void main(String args[]){
    final Bicycle bike = new Bicycle(2,0,1);
    System.out.println(bike);
  }
}
```

1. @override 어노테이션을 사용해서, 멤버를 재정의 한다는걸 analyzer에 명시한다.
2. 문자열을 지정할 때, 작은 따옴표와 큰 따옴표 모두를 지원한다.
3. 식의 값을 ${expression}을 이용해서 문자열 안에 넣을 수 있다. 만약 expression이 identifier이면 $variableName으로 사용이 가능하다.
4. function이나 method를 => 를 사용해서 짧게 한줄표현이 가능하다.



## Add a read-only variable

#### Dart

```dart
class Bicycle{
  int cadence;
  int _speed = 0;
  int gear;
  
  Bicycle(this.cadence, this.gear);

  int get speed => _speed;
  
  void applyBrake(int decrement){
    _speed -=decrement;
  }
  
  void speedUp(int increment){
    _speed +=increment;
  }
  
  @override
  String toString() => 'Bicycle: $speed mph';
}

void main() {
  var bike = Bicycle(2,1);
 
  print(bike);
}
```

#### Java

```java
public class Bicycle{
  private int cadence;
  private int speed = 0;
  private int gear;

  Bicycle(int cadence, int gear) {
    this.cadence = cadence;
    this.gear = gear;
  }
  
  int getCadence(){
    return this.cadence;
  }
  
  void setCadence(int newValue){
    this.cadence = newValue;
  }
  
  int getGear(){
    return this.gear;
  }
    
  void setGear(int newValue){
    this.gear = newValue;
  }
  
  int getSpeed(){
    return this.speed;
  }
  
  void applyBrake(int decrement){
    this.speed -= decrement;
  }
  
  void speedUp(int increment){
    this.speed += increment;
  }
  
  @override
  public String toString(){
    return "Bicycle: " +this.speed + " mph"; 
  }

  public static void main(String args[]){
    final Bicycle bike = new Bicycle(2,0,1);
    System.out.println(bike);
  }
}
```

1. initialize하지 않은 valiable은 default로 null이다.
2. dart compiler는 앞에 밑줄(_)이 붙은 identifier에 대해 privacy를 부여한다.
3. 기본적으로 Dart는 모든 public instance variable에 대한 암시적인 getter setter를 제공한다. 읽기 전용이나 쓰기 전용 변수를 적용하려는 경우가 아니면 getter, setter를 정의할 필요가 없다.
4. cadence와 gear는 getter와 setter를 제공하므로 bike.gear, bike.cadence로 접근할 수 있다.
5. 밑줄이 붙은 identifier는 getter나 setter의 기능을 수행하는 코드를 작성한다.



# 3. Use optional parameters (instead of overloading)

Java 코드는 constructor가 동일한 이름을 갖고, parameter의 수가 다르려면 여러개를 만들어야한다. 그러나 Dart는 Optional을 이용해서 overloading constructor를 만들지 않는다.



## Add a Rectangle constructor

#### Dart

```dart
import 'dart:math';

class Rectangle {
  int width;
  int height;
  Point origin;
  
  Rectangle({this.origin = const Point(0,0), this.width = 0, this.height = 0});
  
  @override
  String toString() => 'Origin: (${origin.x}, ${origin.y}), width: $width, height: $height';
}
```

#### Java

```java
import java.awt.*;

public class Rectangle {
    int width;
    int height;
    Point origin;

    public Rectangle(int width, int height, Point origin) {
        this.width = width;
        this.height = height;
        this.origin = origin;
}
    public Rectangle(int width) {
        this.width = width;
    }

    public Rectangle(Point origin) {
        this.origin = origin;
    }

    public Rectangle() {
    }

    @Override
    public String toString() {
        return "Origin: ("+ origin.x + "}, {" + origin.y+ "}), width: " + width + ", height: " + height;
    }
}
```

constructor는 optional parameter를 사용함을 알 수 있다.

1. this.origin, this.width, this.height는 constructor의 정의 안에 instance 변수를 할당하는 트릭을 사용할 수 있다.
2. this.origin, this.width, this.height는 optional named parameter이며. Named parameter는 {}를 이용해서 감싸주어야 한다.
3. this.origin = const Point(0,0) 문법은 default value가 Point(0,0)임을 의미하며, 이렇게 특정화하는 default 값은 반드시 compile-time constant여야 한다. 



## Add a Rectangle constructor

#### Dart

```dart
import 'dart:math';

class Rectangle {
  int width;
  int height;
  Point origin;
  
  Rectangle({this.origin = const Point(0,0), this.width = 0, this.height =0});
  
  @override
  String toString() => 'Origin: (${origin.x}, ${origin.y}), width: $width, height: $height';
}

main() {
  print(Rectangle(origin: const Point(10,20), width: 100, height: 200));
  print(Rectangle(origin: const Point(10,10)));
  print(Rectangle(width: 200));
  print(Rectangle());
}
```

#### Java

```java
import java.awt.*;

public class Rectangle {
    int width;
    int height;
    Point origin;

    public Rectangle(int width, int height, Point origin) {
        this.width = width;
        this.height = height;
        this.origin = origin;
}
    public Rectangle(int width) {
        this.width = width;
    }

    public Rectangle(Point origin) {
        this.origin = origin;
    }

    public Rectangle() {
    }

    @Override
    public String toString() {
        return "Origin: ("+ origin.x + "}, {" + origin.y+ "}), width: " + width + ", height: " + height;
    }

    public static void main(String[] args) {
        System.out.println(new Rectangle(100, 200, new Point(10,20)));
        System.out.println(new Rectangle(new Point(10,10)));
        System.out.println(new Rectangle(100));
        System.out.println(new Rectangle());
    }
}

```

1. Rectangle Java의 constructor의 16줄 대신, 똑같은 Rectangle Dart Constructor는  한 줄의 코드이다.




# 4. Create a Factory

Java에서 일반적으로 사용하는 디자인 패턴인 Factory는 몇가지 장점이 있다. (instance화의 detail 숨기기, subtype을 factory retur 타입으로 사용하기, 선택적으로 새로운 객체가 아닌 기존의 객체를 리턴하기 등)



#### Dart

```dart
import 'dart:math';

abstract class Shape {
  num get area;
}

class Circle implements Shape {
  final num radius;
  Circle(this.radius);
  num get area => pi * pow(radius, 2);
}

class Square implements Shape {
  final num side;
  Square(this.side);
  num get area => pow(side, 2);
}

main() {
  final circle = Circle(2);
  final square = Square(2);
  print(circle.area);
  print(square.area);
  // 12.566370614359172
  // 4
}
```

#### Java

```java
abstract class Shape {
    private double area;
    double getArea(){
        return area;
    }

    public static void main(String[] args) {
        final Circle circle = new Circle(2);
        final Square square = new Square(2);
        System.out.println(circle.getArea());
        System.out.println(square.getArea());
    }
}

class Circle extends Shape {
    final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
}

class Square extends Shape{
    final int side;

    Square(int side) {
        this.side = side;
    }

    double getArea(){
        return Math.pow(side, 2);
    }
}

```

1. Dart는 abstract class를 지원한다.
2. 한개의 파일에 여러개의 class를 정의할 수 있다.
3. dart.math는 Dart의 코어한 라이브러리다. Dart의 다른 코어 라이브러리는 (dart:core, dart:async, dart:convery, dart:collection)이 있다.
4. Dart 1.x 버전에서는 PI 로 해서 대문자를 사용했고, Dart 2.x 버전에서는 pi 로 해서 소문자를 사용했다.
5. getter안에서 compute 할 수 있다.



## Option1 : Create a top-level function

#### Dart

```dart 
import 'dart:math';

abstract class Shape {
  num get area;
}

Shape shapeFactory(String type){
  if(type == 'circle') return Circle(2);
  if(type == 'square') return Square(2);
  throw 'Can\'t create $type';
}

class Circle implements Shape {
  final num radius;
  Circle(this.radius);
  num get area => pi * pow(radius, 2);
}

class Square implements Shape {
  final num side;
  Square(this.side);
  num get area => pow(side, 2);
}

main() {
  final circle = shapeFactory('circle');
  final square = shapeFactory('square');
  print(circle.area);
  print(square.area);
}
```

#### Java

```java
abstract class Shape {
    private double area;
    double getArea(){
        return area;
    }

    public static void main(String[] args) {
        final Shape circle = ShapeFactory.shapeFactory("circle");
        final Shape square = ShapeFactory.shapeFactory("square");
        System.out.println(circle.getArea());
        System.out.println(square.getArea());

    }
}

class ShapeFactory{
    public static Shape shapeFactory(String type){
        if(type.equals("circle")) return new Circle(2);
        if(type.equals("square")) return new Square(2);
        throw new IllegalArgumentException("Can't create " + type);
    }
}

class Circle extends Shape {
    final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
}

class Square extends Shape{
    final int side;

    Square(int side) {
        this.side = side;
    }

    double getArea(){
        return Math.pow(side, 2);
    }
}
```

1. 함수가 'circle'이나 'square'가 아닌 것을 호출하면 exception이 터진다.
2. Dart SDK는 여러 exception에 대한 클래스를 정의하거나, Exception 클래스를 확장하여 더 구체적으로 만들거나, 여기서와 같이 문제를 설명하는 문자열을 throw 할 수 있다.
3. exception이 발생하면, DartPad는 'Uncaught Error: Can't create $type'을 보여준다. 이때 try-catch로 감싸서 Exception을 다룰 수 있다.
4. 문자열을 작은 따옴표에서 사용하기 위해서 slash를 이용해서 Can't의 '를 표시하면 된다. 아니면 큰 따옴표를 사용하면 된다.



## Option 2: Create a factory constructor

#### Dart

```dart
import 'dart:math';

abstract class Shape {
  factory Shape(String type) {
    if (type == 'circle') return Circle(2);
    if (type == 'square') return Square(2);
    throw 'Can\'t create $type.';
  }
  num get area;
}

Shape shapeFactory(String type){
  if(type == 'circle') return Circle(2);
  if(type == 'square') return Square(2);
  throw 'Can\'t create $type';
}

class Circle implements Shape {
  final num radius;
  Circle(this.radius);
  num get area => pi * pow(radius, 2);
}

class Square implements Shape {
  final num side;
  Square(this.side);
  num get area => pow(side, 2);
}

main() {
  final circle = Shape('circle');
  final square = Shape('square');
  print(circle.area);
  print(square.area);
}
```

#### Java



```java
abstract class Shape {
    public static Shape createWithFactory(String type){
        if(type.equals("circle")) return new Circle(2);
        if(type.equals("square")) return new Square(2);
        throw new IllegalArgumentException("Can't create " + type);
    }
    private double area;
    double getArea(){
        return area;
    }

    public static void main(String[] args) {
        final Shape circle = Shape.createWithFactory("circle");
        final Shape square = Shape.createWithFactory("square");
        System.out.println(circle.getArea());
        System.out.println(square.getArea());

    }
}

class Circle extends Shape {
    final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
}

class Square extends Shape{
    final int side;

    Square(int side) {
        this.side = side;
    }

    double getArea(){
        return Math.pow(side, 2);
    }
}
```

1. Dart의 factory 키워드를 이용해서 factory constructor를 만들 수 있다.
2. Factory constructor는 option1의 shapeFactory() 함수와 동일하다.



# 5. Implement an interface

#### Dart

```Dart
import 'dart:math';

abstract class Shape {
  factory Shape(String type) {
    if (type == 'circle') return Circle(2);
    if (type == 'square') return Square(2);
    throw 'Can\'t create $type.';
  }
  num get area;
}

class Circle implements Shape {
  final num radius;
  Circle(this.radius);
  num get area => pi * pow(radius, 2);
}

class Square implements Shape {
  final num side;
  Square(this.side);
  num get area => pow(side, 2);
}

class CircleMock implements Circle {
  num area;
  num radius;
}

main() {
  final circle = Shape('circle');
  final square = Shape('square');
  print(circle.area);
  print(square.area);
}
```

1. CircleMock은 동작을 정의하지 않았음에도 Circle을 implements한 유효한 코드이다.

> 내생각엔 읽기 전용이었던 것들을 CircleMock 클래스에서 default로 다시 되돌릴 때 사용하려고 만든 코드인가 싶다.



## 6. Use Dart for functional programming

함수형 프로그래밍

- 함수를 인자로 전달한다.
- 변수에 함수를 할당한다.
- 여러개의 인자를 하나의 인자로 취급하는 함수로 분해한다.
- 상수값으로 사용되는 익명 함수를 만든다. (lambda라고 불린다.)



Dart도 함수형 모든 특징을 지원한다. Dart에서, Function 타입으로 함수 자체도 객체가된다.

이것은 함수가 변수에 할당되거나, 다른 함수의 인자로 전달할 수 있음을 의미한다.

또 instance를 함수인 것 처럼 호출할 수도 있다.

```dart
class WannabeFunction {
  call(String a, String b, String c) => '$a $b $c!';
}

main() {
  var wf = new WannabeFunction();
  var out = wf("Hi","there,","gang");
  print('$out');
}
```



## Non-functional Code

#### Dart

```dart
String scream(int length) => "A${'a' * length}h!";

main() {
  final values = [1, 2, 3, 5, 10, 50];
  for (var length in values) {
    print(scream(length));
  }
}
```

```Console
Aah!
Aaah!
Aaaah!
Aaaaaah!
Aaaaaaaaaaah!
Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah!
```

#### Java

```java
public class Main {

    public static String repeatString(String s, int count){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<count; i++){
            sb.append(s);
        }
        return sb.toString();
    }

    static String scream(int length){
        return "A" + repeatString("a", length)+"h!";
    }

    public static void main(String[] args) {
        int[] values = {1,2,3,5,10,50};
        for(int length : values){
            System.out.println(scream(length));
        }           
    }
}
```

1. 문자열의 반복을 사용할 때, ${'a' * length}는 'a' 문자를 length번 반복한다는 뜻이다.




## Functional Code

#### Dart

```dart
String scream(int length) => "A${'a' * length}h!";

main() {
  final values = [1, 2, 3, 5, 10, 50];
  values.map(scream).forEach(print);
  values.skip(1).take(3).map(scream).forEach(print);
}
```

```Console
Aah!
Aaah!
Aaaah!
Aaaaaah!
Aaaaaaaaaaah!
Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah!
Aaah!
Aaaah!
Aaaaaah!
```

#### Java

```java
import java.util.Arrays;

public class Main {

    public static String repeatString(String s, int count){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<count; i++){
            sb.append(s);
        }
        return sb.toString();
    }

    static String scream(int length){
        return "A" + repeatString("a", length)+"h!";
    }

    public static void main(String[] args) {
        int[] values = {1,2,3,5,10,50};

        Arrays.stream(values)
                .mapToObj(Main::scream)
                .forEach(System.out::println);

        Arrays.stream(values)
                .skip(1)
                .limit(3)
                .mapToObj(Main::scream)
                .forEach(System.out::println);
    }
}
```

1. skip(1)은 반복을 하는 list인 values에서 첫번째 값을 스킵한다는 뜻이다.
2. take(3)은 반복을 하는 list인 values에서 3개의 값을 가져온다는 뜻이다.
3. 남은 값들은 스킵한다.

