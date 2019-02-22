package fr.soat.cleancoders.ocp.shapes.no_ocp;

import fr.soat.cleancoders.ocp.shapes.domain.Shape;

/*
* This class knows too well its dependencies.
* If we want to use the logic of the class, we have to package the Drawer class (this one),
* the Shape class and all its infants.
* Otherwise, it won't compile.
*/
class Drawer {
    private Shape shape;

    Drawer(Shape shape) {
        this.shape = shape;
    }

    int getShapeId() {
        if (shape.getShapeType().equals("circle"))
            return 1;

        if (shape.getShapeType().equals("rectangular"))
            return 2;

        if (shape.getShapeType().equals("disc"))
            return 999;

        if (shape.getShapeType().equals("star"))
            return 42;
        return -1;
    }
}
