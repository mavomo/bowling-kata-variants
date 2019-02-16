package fr.soat.cleancoders.ocp.shapes.shapes.circle;

import fr.soat.cleancoders.ocp.shapes.Point;
import fr.soat.cleancoders.ocp.shapes.shapes.ShapeType;

public class Circle {
    private ShapeType shapeType;
    private double radius;
    private Point center;

    public Circle(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public void drawCircle() {
    }
}
