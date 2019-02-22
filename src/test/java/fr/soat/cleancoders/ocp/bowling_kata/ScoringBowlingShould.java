package fr.soat.cleancoders.ocp.bowling_kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ScoringBowlingShould {

    @Test
    public void shoul_create_a_game_to_score_a_bowling_game() {
        BowlingGame bowlingGame = new BowlingGame();
        Assertions.assertThat(bowlingGame).isNotNull();
    }

    private class BowlingGame {
    }
}
