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
                .as("should compile")
                .isNotNull();
    }

    @Test
    public void return_a_score_of_0_for_the_frame_when_no_pin_is_knocked_down_after_two_roll() {
        rollNTimes(2, 0);

        Assertions.assertThat(bowlingGame.scoreOfFrame(2))
                .as("no pins down")
                .isEqualTo(0);
    }

    @Test
    public void return_a_score_of_two_for_the_frame_when_1_pin_is_knocked_down_at_reach_roll() {
        rollNTimes(2, 1);

        Assertions.assertThat(bowlingGame.scoreOfFrame(2))
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

    @Test
    public void add_the_number_of_pins_down_on_third_roll_when_there_is_a_spare() {

        bowlingGame.roll(6);
        bowlingGame.roll(4);
        bowlingGame.roll(4);
        bowlingGame.roll(4);

        rollNTimes(16, 0);

        final int scoreForFrame = bowlingGame.scoreOfFrame(1);

        Assertions.assertThat(scoreForFrame)
                .as("score is 14 it is a spare: R1  + R2 + R3 (bonus) = 6+4+4 = 14 pts ")
                .isEqualTo(14);
    }

    @Test
    public void count_the_bonus_points_from_the_spare_game() {

        bowlingGame.roll(6);
        bowlingGame.roll(4);
        bowlingGame.roll(4);
        bowlingGame.roll(4);

        rollNTimes(16, 0);

        final int scoreOfTheGame = bowlingGame.score();

        Assertions.assertThat(scoreOfTheGame)
                .as("score is 18 because:" +
                        " F1 is a spare =  R1  + R2 + R3 (bonus) = 6+4+4 = 14 pts " +
                        " F2 is a normal game = R3 + R4 = 8")
                .isEqualTo(22);
    }


    private class BowlingGame {
        private int currentRoll;
        private int[] rolls = new int[20];

        void roll(int pinsDown) {
            this.rolls[this.currentRoll] = pinsDown;
            this.currentRoll++;
        }

        int scoreOfFrame(int framePosition) {
            int frameScore = 0;
            int rollIdx = 0;
            if (this.rolls[rollIdx] + rolls[rollIdx + 1] == 10) {
                frameScore += this.rolls[rollIdx] + rolls[rollIdx + 1] + this.rolls[rollIdx + 2];
            } else {
                frameScore += this.rolls[rollIdx] + this.rolls[rollIdx + 1];
            }
            return frameScore;
        }

        int score() {
            int rollIdx = 0;
            int score = 0;
            for (int currentFrame = 0; currentFrame < 10; currentFrame++) {
                if (this.rolls[rollIdx] + rolls[rollIdx + 1] == 10) {
                    score += this.rolls[rollIdx] + rolls[rollIdx + 1] + this.rolls[rollIdx + 2];
                } else {
                    score += this.rolls[rollIdx] + this.rolls[rollIdx + 1];
                }
                rollIdx += 2;
            }
            return score;
        }
    }
}
