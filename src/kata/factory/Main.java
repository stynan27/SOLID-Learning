package kata.factory;

public class Main {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle", 5.0);
        System.out.println("Circle Area: " + circle.calculateArea());

        Shape rectangle = ShapeFactory.createShape("rectangle", 4.0, 3.0);
        System.out.println("Rectangle Area: " + rectangle.calculateArea());

        Shape triangle = ShapeFactory.createShape("triangle", 2.0, 6.0);
        System.out.println("Triangle Area: " + triangle.calculateArea());
    }
}
