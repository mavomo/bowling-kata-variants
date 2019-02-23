package fr.soat.cleancoders.ocp.bowling_kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TerrianBowlingShould {

    private final BowlingGame bowlingGame = new BowlingGame(21, 10);

    @Test
    public void return_a_score_of_0_for_a_frame_when_no_pin_is_knocked_down_after_two_roll() {
        rollSameNumberOfPinsTimes(2, 0);

        final int scoreOfFrame = bowlingGame.scoreOfFrame(2);

        assertThat(scoreOfFrame)
                .as(" 0 pins down in two rolls")
                .isEqualTo(0);
    }

    @Test
    public void return_a_score_of_2_for_a_frame_when_1_pin_is_knocked_down_per_roll() {
        rollSameNumberOfPinsTimes(2, 1);

        final int scoreOfFrame = bowlingGame.scoreOfFrame(2);

        assertThat(scoreOfFrame)
                .as("1 pin down per roll")
                .isEqualTo(2);
    }

    @Test
    public void return_the_score_of_0_for_the_whole_game_when_there_are_only_gutter_games() {

        rollSameNumberOfPinsTimes(20, 0);

        final int scoreOfTheGame = bowlingGame.score();

        assertThat(scoreOfTheGame)
                .as("score should be 0 because it was only gutter games ")
                .isEqualTo(0);
    }

    @Test
    public void return_the_score_of_20_for_the_whole_game_when_a_player_knocks_down_1_pin_per_roll() {

        rollSameNumberOfPinsTimes(20, 1);

        final int scoreOfTheGame = bowlingGame.score();

        assertThat(scoreOfTheGame)
                .as("score is 0 because it was only gutter games ")
                .isEqualTo(20);
    }

    @Test
    public void add_the_number_of_pins_down_in_the_first_roll_of_next_frame_when_scoring_frame_with_a_spare() {
        rollSpareWith(6, 4);
        bowlingGame.roll(4);

        rollSameNumberOfPinsTimes(16, 0);

        final int scoreForFrame = bowlingGame.scoreOfFrame(0);

        assertThat(scoreForFrame)
                .as("score is 14 it is a spare: R1  + R2 + R3 (bonus) = 6+4+4 = 14 pts ")
                .isEqualTo(14);
    }

    @Test
    public void count_the_spare_bonus_point_when_scoring_a_whole_game_with_a_spare() {
        rollSpareWith(6, 4);
        bowlingGame.roll(4);
        bowlingGame.roll(4);
        rollSameNumberOfPinsTimes(16, 0);

        final int scoreOfTheGame = bowlingGame.score();

        assertThat(scoreOfTheGame)
                .as("score is 18 because:" +
                        " R1 + R2 is a spare. score (F1) =  R1  + R2 + R3 (bonus) = 6+4+4 = 14 pts " +
                        " F2 is a normal game = R3 + R4 = 8")
                .isEqualTo(22);
    }


    @Test
    public void add_the_number_of_pins_down_in_the_first_2_rolls_of_next_frame_when_there_score_frame_with_a_strike() {
        rollAStrike();
        bowlingGame.roll(4);
        bowlingGame.roll(5);

        rollSameNumberOfPinsTimes(16, 0);

        final int scoreOfTheGame = bowlingGame.scoreOfFrame(0);

        assertThat(scoreOfTheGame)
                .as("score of the first frame is 19 because:" +
                        " R1 is a strike =  R1  + R2 + R3 (bonus) + R4 (bonus) = 10 + 4 + 5 = 19 pts ")
                .isEqualTo(19);
    }

    @Test
    public void return_the_score_of_the_whole_game_counting_stikes() {
        rollAStrike();
        bowlingGame.roll(4);
        bowlingGame.roll(5);

        rollSameNumberOfPinsTimes(16, 0);

        final int scoreOfTheGame = bowlingGame.score();

        assertThat(scoreOfTheGame)
                .as("score of the first frame is 19 because:" +
                        " R1 is a strike =  R1  + R2 + R3 (bonus) + R4 (bonus) = 10 + 4 + 5 = 19 pts ")
                .isEqualTo(28);
    }

    @Test
    public void return_300_for_the_perfect_game() {

        rollSameNumberOfPinsTimes(21, 10);

        final int scoreOfTheGame = bowlingGame.score();

        assertThat(scoreOfTheGame).isEqualTo(300);
    }


    private void rollSameNumberOfPinsTimes(int limit, int pinsDown) {
        for (int i = 0; i < limit; i++) {
            bowlingGame.roll(pinsDown);
        }
    }

    private void rollSpareWith(int firstRound, int secondRoll) {
        bowlingGame.roll(firstRound);
        bowlingGame.roll(secondRoll);
    }

    private void rollAStrike() {
        bowlingGame.roll(10);
    }
}
