package fr.soat.cleancoders.ocp.score_bowling;

public class BowlingGame {
    private int currentRoll;
    private int[] rolls = new int[21];
    private int[] frames = new int[10];

    public int scoreOfFrame(int framePosition) {
        this.score();
        return this.frames[framePosition];
    }

    public int score() {
        int rollIdx = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < 10; currentFrame++) {
            if (this.rolls[rollIdx] == 10) { //strike
                score += 10 + rolls[rollIdx + 1] + this.rolls[rollIdx + 2];
                rollIdx++;
            } else {
                if (this.rolls[rollIdx] + rolls[rollIdx + 1] == 10) {//spare
                    score += 10 + this.rolls[rollIdx + 2];
                } else {
                    score += this.rolls[rollIdx] + this.rolls[rollIdx + 1];
                }
                rollIdx += 2;
            }
            this.frames[currentFrame] = score;
        }
        return score;
    }

    public void roll(int pinsDown) {
        this.rolls[this.currentRoll] = pinsDown;
        this.currentRoll++;
    }
}
