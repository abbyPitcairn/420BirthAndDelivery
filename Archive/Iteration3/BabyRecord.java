package Archive.Iteration3;

public class BabyRecord {
    private int babyID;
    private int apgarScore;
    private double lengthOfBaby;
    private double babyHeadCircumference;
    private double weight;
    private int latchScoreWithinHour;
    private int latchScoreAfterHour;

    public BabyRecord(int babyID, int apgarScore, double lengthOfBaby, double babyHeadCircumference,
                    double weight, int latchScoreWithinHour, int latchScoreAfterHour) {
        this.babyID = babyID;
        this.apgarScore = apgarScore;
        this.lengthOfBaby = lengthOfBaby;
        this.babyHeadCircumference = babyHeadCircumference;
        this.weight = weight;
        this.latchScoreWithinHour = latchScoreWithinHour;
        this.latchScoreAfterHour = latchScoreAfterHour;
    }

    @Override
    public String toString() {
        return String.format(
            "Baby ID: %d\n  APGAR: %d\n  Length: %.1f cm\n  Head Circumference: %.1f cm\n  Weight: %.2f kg\n  Latch Score (≤1hr): %d\n  Latch Score (>1hr): %d",
            babyID, apgarScore, lengthOfBaby, babyHeadCircumference, weight, latchScoreWithinHour, latchScoreAfterHour
        );
    }
}