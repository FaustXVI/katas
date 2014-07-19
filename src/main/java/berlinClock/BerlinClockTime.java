package berlinClock;

public class BerlinClockTime {
    private boolean seconds;
    private String topHourRow = "OOOO";
    private String bottomHourRow = "OOOO";

    private String topMinuteRow = "OOOOOOOOOOO";

    private String bottomMinuteRow = "OOOO";

    public boolean getSeconds() {
        return seconds;
    }

    public String getTopHourRow() {
        return topHourRow;
    }

    public String getBottomHourRow() {
        return bottomHourRow;
    }

    public String getTopMinuteRow() {
        return topMinuteRow;
    }

    public String getBottomMinuteRow() {
        return bottomMinuteRow;
    }

    public void setBottomHourRow(String bottomHourRow) {
        this.bottomHourRow = bottomHourRow;
    }

    public void setBottomMinuteRow(String bottomMinuteRow) {
        this.bottomMinuteRow = bottomMinuteRow;
    }

    public void setSeconds(boolean seconds) {
        this.seconds = seconds;
    }

    public void setTopHourRow(String topHourRow) {
        this.topHourRow = topHourRow;
    }

    public void setTopMinuteRow(String topMinuteRow) {
        this.topMinuteRow = topMinuteRow;
    }
}
