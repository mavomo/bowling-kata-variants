package fr.soat.cleancoders.ocp.shapes.domain;

public abstract class Shape {
    public abstract String getShapeType();

    public abstract int getShapeId();

    public void move(){
        final int shapeId = getShapeId();
        drag(shapeId);
        drop(shapeId);


    }

    private void drop(int shapeId) {
        System.out.println("dsfsfdsfsfs");
    }

    private void drag(int shapeId) {
        System.out.println("dskjfsjkfksdfjskfjds");
    }
}
