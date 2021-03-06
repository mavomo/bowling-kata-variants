package fr.soat.cleancoders.ocp.shapes.no_ocp;

import fr.soat.cleancoders.ocp.shapes.domain.CircularShape;
import fr.soat.cleancoders.ocp.shapes.domain.DiscShape;
import fr.soat.cleancoders.ocp.shapes.domain.RectangularShape;
import fr.soat.cleancoders.ocp.shapes.domain.Shape;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DrawerTest {

    @Test
    public void should_return_1_when_the_shape_is_a_circle() {
        Shape myCircle = new CircularShape();
        Drawer drawer = new Drawer(myCircle);

        final int idCercle = drawer.getShapeId();

        Assertions.assertThat(idCercle).isEqualTo(1);
    }

    @Test
    public void should_return_2_when_the_shape_is_a_rectangle() {
        Shape myRectangle = new RectangularShape();
        Drawer drawer = new Drawer(myRectangle);

        final int idRectangle = drawer.getShapeId();

        Assertions.assertThat(idRectangle).isEqualTo(2);

    }
   @Test
    public void should_return_42_when_the_shape_is_a_rectangle() {
        Shape starShape = new StarShape();
        Drawer drawer = new Drawer(starShape);

        final int idStar = drawer.getShapeId();

        Assertions.assertThat(idStar).isEqualTo(42);
    }

    @Test
    public void should_return_999_when_the_shape_is_a_disc() {
        Shape disc = new DiscShape();
        Drawer drawer = new Drawer(disc);

        final int idDisc = drawer.getShapeId();

        Assertions.assertThat(idDisc).isEqualTo(999);
    }

    private class StarShape extends Shape {
        @Override
        public String getShapeType() {
            return "star";
        }

        @Override
        public int getShapeId() {
            return 0;
        }
    }
}