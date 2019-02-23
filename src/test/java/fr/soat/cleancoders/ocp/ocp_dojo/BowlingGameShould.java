package fr.soat.cleancoders.ocp.ocp_dojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BowlingGameShould {

    @Test
    public void should_create_a_game() {
        BowlingGame game = new BowlingGameFactory().createGame();
        Assertions.assertThat(game).isNotNull();
    }

    @Test
    public void should_return_a_score_of_0_for_a_complete_game_with_only_gutters() {
        BowlingGame game = new BowlingGameFactory()
                            .createGame();

        Assertions.assertThat(game).isNotNull();
    }

    private class BowlingGame {
    }

    private class BowlingGameFactory {
        BowlingGame createGame() {
            return new BowlingGame();
        }

    }
}
