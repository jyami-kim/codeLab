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


