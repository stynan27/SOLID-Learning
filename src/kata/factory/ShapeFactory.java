package kata.factory;

//import com.sun.xml.internal.bind.v2.TODO;

public class ShapeFactory {
    public static Shape createShape(String shapeType, double... parameters) {
        // Assume Simple Factory instead of Factory Method
        switch(shapeType) {
            case "circle":
                return new Circle(parameters[0]);
            case "rectangle":
                return new Rectangle(parameters[0], parameters[1]);
            case "triangle":
                return new Triangle(parameters[0], parameters[1]);
            default:
                throw new IllegalArgumentException("Invalid shapeType provided.");
        }
    }
}