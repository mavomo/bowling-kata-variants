package fr.soat.cleancoders.ocp.shapes.domain;

public class CircularShape extends Shape {

    @Override
    public String getShapeType() {
        return "circle";
    }

    @Override
    public int getShapeId() {
        return 1;
    }
}
