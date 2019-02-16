package fr.soat.cleancoders.ocp.shapes;

import fr.soat.cleancoders.ocp.shapes.shapes.Shape;
import fr.soat.cleancoders.ocp.shapes.shapes.circle.Circle;
import fr.soat.cleancoders.ocp.shapes.shapes.square.Square;

import java.util.List;

public class DrawAllShapes {

    void drawAllShapes(List<Shape> shapes, int limit) {
        for (int i = 0; i < limit; i++) {
            Shape currentShape = shapes.get(i);
            switch (currentShape.getShapeType()) {
                case CIRCLE:
                    drawCircle(currentShape);
                    break;
                case SQUARE:
                    drawSquare(currentShape);
                    break;
            }
        }
    }

    private void drawSquare(Shape currentShape) {
        Square square = new Square(currentShape.getShapeType());
        square.drawSquare();

    }

    private void drawCircle(Shape currentShape) {
        Circle circle = new Circle(currentShape.getShapeType());

        circle.drawCircle();
    }
}
