package fr.soat.cleancoders.ocp.shapes.ocp_compliant;

import fr.soat.cleancoders.ocp.shapes.domain.CircularShape;
import fr.soat.cleancoders.ocp.shapes.domain.RectangularShape;
import fr.soat.cleancoders.ocp.shapes.domain.Shape;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.PrintStream;

public class ShapeClientTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private PrintStream printStream;

    @InjectMocks
    private ShapeClient shapeClient;

    @Before
    public void setUp() {
        System.setOut(printStream);
    }


    @Test
    public void should_return_minus_one_when_it_is_the_base_shape() {
        Shape baseShape = new Shape();
        ShapeClient shape = new ShapeClient(baseShape);

        int id = shape.getShapeId();

        Assertions.assertThat(id).isEqualTo(-1);
    }


    @Test
    public void should_return_1_when_it_is_the_circular_shape() {
        Shape baseShape = new CircularShape();
        ShapeClient shapeUser = new ShapeClient(baseShape);

        int id = shapeUser.getShapeId();

        Assertions.assertThat(id).isEqualTo(1);
    }


    @Test
    public void should_return_2_when_it_is_the_rectangular_shape() {
        Shape baseShape = new RectangularShape();
        ShapeClient shapeUser = new ShapeClient(baseShape);

        int id = shapeUser.getShapeId();

        Assertions.assertThat(id).isEqualTo(2);
    }

    @Test
    public void should_drag_and_drop_a_shape_when_move_is_called() {
        Shape baseShape = new RectangularShape();
        ShapeClient shapeUser = new ShapeClient(baseShape);

        shapeUser.move();



    }
}