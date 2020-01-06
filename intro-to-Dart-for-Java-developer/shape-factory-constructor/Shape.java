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
