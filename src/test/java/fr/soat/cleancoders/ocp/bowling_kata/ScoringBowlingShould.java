package fr.soat.cleancoders.ocp.bowling_kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ScoringBowlingShould {

    private final BowlingGame bowlingGame = new BowlingGame();

    private void rollNTimes(int limit, int pinsDown) {
        for (int i = 0; i < limit; i++) {
            bowlingGame.roll(pinsDown);
        }
    }

    @Test
    public void create_a_game_to_score_a_bowling_game() {
        Assertions.assertThat(bowlingGame)
                .as("should compiles")
                .isNotNull();
    }

    @Test
    public void return_a_score_of_0_for_the_frame_when_no_pin_is_knocked_down_after_two_roll() {
        rollNTimes(2, 0);

        Assertions.assertThat(bowlingGame.scoreOfFrame())
                .as("no pins down")
                .isEqualTo(0);
    }

    @Test
    public void return_a_score_of_two_for_the_frame_when_1_pin_is_knocked_down_at_reach_roll() {
        rollNTimes(2, 1);

        Assertions.assertThat(bowlingGame.scoreOfFrame())
                .as("1 pin down for each roll")
                .isEqualTo(2);
    }

    @Test
    public void return_the_score_of_0_for_the_whole_game_when_gutter_games() {

        rollNTimes(20, 0);

        Assertions.assertThat(bowlingGame.score())
                .as("score is 0 because it was only gutter games ")
                .isEqualTo(0);
    }

    @Test
    public void return_the_score_of_20_for_the_whole_game_when_a_player_knocks_down_1_pin_per_roll() {

        rollNTimes(20, 1);

        Assertions.assertThat(bowlingGame.score())
                .as("score is 0 because it was only gutter games ")
                .isEqualTo(20);
    }


    private class BowlingGame {
        private int pinsDown;

        void roll(int pinsDown) {
            this.pinsDown += pinsDown;
        }

        int scoreOfFrame() {
            return this.pinsDown;
        }

        public int score() {
            return scoreOfFrame();
        }
    }
}
