package fr.soat.cleancoders.ocp.bowling_kata;

class BowlingGame {
    private static final int NB_FRAMES = 10;
    private static final int MAX_BONUS_POINT = 10;
    private static final int MAX_ROLLS = 21;
    private int currentRoll;
    protected int[] rolls;
    protected int[] frames;


    public BowlingGame() {
        this.rolls = new int[MAX_ROLLS];
        this.frames = new int[NB_FRAMES];
    }

    int scoreOfFrame(int framePosition) {
        this.score();
        return this.frames[framePosition];
    }

    int score() {
        int rollIdx = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < getTotalFrames(); currentFrame++) {
            if (isAStrike(rollIdx)) {
                score += computeScoreForStrike(rollIdx);
                rollIdx++;
            } else {
                if (isASpare(rollIdx)) {
                    score += getScoreForASpare(rollIdx);
                } else {
                    score += getScoreOfNormalGame(rollIdx);
                }
                rollIdx += 2;
            }

            this.getFrames()[currentFrame] = score;
        }
        return score;
    }

    protected int computeScoreForStrike(int rollIdx) {
        return 10 + addNextTwoRolls(rollIdx);
    }

    protected int getScoreForASpare(int rollIdx) {
        return 10 + pinsInfirstRollOfNextFrame(rollIdx);
    }

    protected int getScoreOfNormalGame(int rollIdx) {
        return this.getRolls()[rollIdx] + getRolls()[rollIdx + 1];
    }

    protected int[] getRolls() {
        return rolls;
    }

    public int[] getFrames() {
        return frames;
    }

    private int getMaxBonusPoint() {
        return MAX_BONUS_POINT;
    }

    protected int getTotalFrames() {
        return NB_FRAMES;
    }

    private int pinsInfirstRollOfNextFrame(int rollIdx) {
        return this.rolls[rollIdx + 2];
    }

    private int addNextTwoRolls(int rollIdx) {
        return rolls[rollIdx + 1] + this.rolls[rollIdx + 2];
    }

    private boolean isAStrike(int rollIdx) {
        return this.rolls[rollIdx] == 10;
    }

    protected boolean isASpare(int rollIdx) {
        return this.rolls[rollIdx] + rolls[rollIdx + 1] == 10;
    }

    void roll(int pinsDown) {
        this.rolls[this.currentRoll] = pinsDown;
        this.currentRoll++;
    }


}
