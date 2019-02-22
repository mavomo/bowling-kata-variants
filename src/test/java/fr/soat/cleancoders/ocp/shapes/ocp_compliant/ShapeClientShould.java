package fr.soat.cleancoders.ocp.shapes.ocp_compliant;

import fr.soat.cleancoders.ocp.shapes.domain.CircularShape;
import fr.soat.cleancoders.ocp.shapes.domain.DiscShape;
import fr.soat.cleancoders.ocp.shapes.domain.RectangularShape;
import fr.soat.cleancoders.ocp.shapes.domain.Shape;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ShapeClientShould {

    @Test
    public void return_minus_one_as_id_when_it_is_the_default_shape() {
        Shape baseShape = new DefaultShape();
        ShapeClient shape = new ShapeClient(baseShape);

        int id = shape.getShapeId();

        Assertions.assertThat(id)
                .as("id for base shape should be -1")
                .isEqualTo(-1);
    }


    @Test
    public void return_1_as_id_when_it_is_the_circular_shape() {
        Shape baseShape = new CircularShape();
        ShapeClient shapeUser = new ShapeClient(baseShape);

        int id = shapeUser.getShapeId();

        Assertions.assertThat(id)
                .as("id for the circular shape should be 1")
                .isEqualTo(1);
    }


    @Test
    public void should_return_2_when_it_is_the_rectangular_shape() {
        Shape baseShape = new RectangularShape();
        ShapeClient shapeUser = new ShapeClient(baseShape);

        int id = shapeUser.getShapeId();

        Assertions.assertThat(id)
                .as("id for the rectangular shape should be 2")
                .isEqualTo(2);
    }

    @Test
    public void should_return_21_when_it_is_the_Disc_shape() {
        Shape baseShape = new DiscShape();
        ShapeClient shapeUser = new ShapeClient(baseShape);

        int id = shapeUser.getShapeId();

        Assertions.assertThat(id)
                .as("id for the disc shape should be 999")
                .isEqualTo(999);
    }
/*
    @Test
    public void should_drag_and_drop_a_shape_when_move_is_called() {
        Shape baseShape = new RectangularShape();
        ShapeClient shapeUser = new ShapeClient(baseShape);

        shapeUser.move();
    }*/

    private class DefaultShape extends Shape {
        @Override
        public String getShapeType() {
            return "";
        }

        @Override
        public int getShapeId() {
            return -1;
        }
    }
}