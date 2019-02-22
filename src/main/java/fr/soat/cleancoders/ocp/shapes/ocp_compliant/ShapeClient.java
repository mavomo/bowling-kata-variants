package fr.soat.cleancoders.ocp.shapes.ocp_compliant;

import fr.soat.cleancoders.ocp.shapes.domain.Shape;

/**
 * This client doesn't know if the Shape is a concrete class or an abstract one or even
 * an interface.
 * So, it can be moved with this dependency if it's the only necessary one.
 */
class ShapeClient {
    private Shape baseShape;

    ShapeClient(Shape baseShape) {
        this.baseShape = baseShape;

        this.baseShape.move();
    }

    int getShapeId() {
        return baseShape.getShapeId();
    }

    void move() {
        int shapeId = getShapeId();
        drag(shapeId);
        drop(shapeId);
    }

    private void drop(int shapeId) {
        System.out.println("Full implementation for dropping a shape");
    }

    private void drag(int shapeId) {
        System.out.println("Full implementation for dragging a shape");
    }
}
