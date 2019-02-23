package fr.soat.cleancoders.ocp.bowling_kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MartianBowlingShould {

    private static final int MAX_ROLLS = 36;
    private final BowlingGame game = new MartianBowling();

    @Test
    public void should_create_a_martian_game() {

        Assertions.assertThat(game).isNotNull();
    }

    @Test
    public void should_return_6_as_the_score_of_the_frame() {
        game.roll(1);
        game.roll(2);
        game.roll(3);

        for (int i = 0; i < 33; i++) {
            game.roll(0);
        }
        final int frameScore = game.scoreOfFrame(0);

        Assertions.assertThat(frameScore).isEqualTo(6);
    }


    @Test
    public void should_return_15_as_the_score_of_the_frame_when_a_there_is_a_strike() {
        game.roll(10);
        game.roll(2);
        game.roll(3);

        rollNTimes();

        final int frameScore = game.scoreOfFrame(0);

        Assertions.assertThat(frameScore).isEqualTo(15);
    }

    @Test
    public void should_return_the_total_score_given_a_strike_and_two_normal_rolls() {
        game.roll(10);
        game.roll(2);
        game.roll(3);

        rollNTimes();

        final int gameScore = game.score();

        Assertions.assertThat(gameScore).isEqualTo(20);
    }

    private void rollNTimes() {
        for (int i = 0; i < 31; i++) {
            game.roll(0);
        }
    }

    @Test
    public void should_return_16_as_the_score_of_the_frame_with_spare() {
        game.roll(1);
        game.roll(2);
        game.roll(7);
        game.roll(3);

        for (int i = 0; i < 32; i++) {
            game.roll(0);
        }
        final int frameScore = game.scoreOfFrame(0);

        Assertions.assertThat(frameScore).isEqualTo(13);
    }

    @Test
    public void return_a_score_of_36_when_1_pin_per_roll_is_knocked_down_for_the_whole_game() {
        BowlingGame game = new MartianBowling();
        for (int i = 0; i < MAX_ROLLS; i++) {
            game.roll(1);
        }
        final int scoreOfTheGame = game.score();

        Assertions.assertThat(scoreOfTheGame).isEqualTo(36);
    }

    @Test
    public void return_360_as_score_for_the_perfect_game_on_mars() {
        BowlingGame game = new MartianBowling();
        for (int i = 0; i < MAX_ROLLS; i++) {
            game.roll(10);
        }
        final int scoreOfTheGame = game.score();

        Assertions.assertThat(scoreOfTheGame).isEqualTo(360);
    }
}
