package fr.soat.cleancoders.ocp.bowling_kata;

class MartianBowling extends BowlingGame {

    static final int MAX_NB_FRAMES = 12;
    static final int MAX_ROLLS = 37;

    MartianBowling() {
        this.rolls = new int[MAX_ROLLS];
        this.frames = new int[MAX_NB_FRAMES];

    }

    @Override
    protected int getTotalFrames() {
        return MAX_NB_FRAMES;
    }

    @Override
    protected int getScoreOfNormalGame(int rollIdx) {
        final int scoreForTwoRoll = super.getScoreOfNormalGame(rollIdx);
        return scoreForTwoRoll + this.getRolls()[rollIdx + 2];
    }

    @Override
    protected boolean isASpare(int rollIdx) {
        return getRolls()[rollIdx] + getRolls()[rollIdx + 1] + getRolls()[2] == 10;
    }

    @Override
    protected int getScoreForASpare(int rollIdx) {
        final int martianSpareScore = 10 + getRolls()[rollIdx + 3];
        return martianSpareScore;
    }

    @Override
    protected int computeScoreForStrike(int rollIdx) {
        final int terrianStrikeScore = super.computeScoreForStrike(rollIdx);
        return terrianStrikeScore;
    }
}
