package snowfall;

// Represents a snowfall logger
public class SnowfallLogger {
    public static final int THRESHOLD = 15;  // threshold snowfall amount in cms for a snow day
    double amount;
    int sDay;
    int sRecord;



    // EFFECTS: constructs snowfall logger with no snowfall records
    public SnowfallLogger() {
        amount = 0;
        sDay = 0;
        sRecord = 0;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: records a snowfall of amount centimetres; if amount is at least THRESHOLD cms, records a snow day
    public void addSnowfallRecord(int amount) {
        this.amount = this.amount + amount;
        if (amount >= THRESHOLD){
            sDay++;
        }
        sRecord++;
    }

    // MODIFIES: this
    // EFFECTS: resets the logger so that no snowfall records are recorded
    public void reset() {
        amount = 0;
        sDay = 0;
        sRecord = 0;
    }

    // REQUIRES: getNumSnowfallRecords() > 0
    // EFFECTS: returns the average snowfall across all records added
    public double getAverageSnowfall() {
        return amount/sRecord;
    }

    // EFFECTS: returns the number of snowfall records added
    public int getNumSnowfallRecords() {
        return sRecord;
    }

    // EFFECTS: returns the number of snow days based on snowfall records added
    public int getNumSnowDays() {
        return sDay;
    }
}
