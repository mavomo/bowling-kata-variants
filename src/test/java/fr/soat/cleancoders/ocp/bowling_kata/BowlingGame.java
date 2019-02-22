package fr.soat.cleancoders.ocp.bowling_kata;

class BowlingGame {
    private int currentRoll;
    private int[] rolls = new int[21];
    private int[] frames = new int[10];

    int scoreOfFrame(int framePosition) {
        this.score();
        return this.frames[framePosition];
    }

    int score() {
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

    void roll(int pinsDown) {
        this.rolls[this.currentRoll] = pinsDown;
        this.currentRoll++;
    }
}
