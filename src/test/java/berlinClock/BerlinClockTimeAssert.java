package berlinClock;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class BerlinClockTimeAssert extends GenericAssert<BerlinClockTimeAssert, BerlinClockTime> {
    
    protected BerlinClockTimeAssert( BerlinClockTime actual) {
        super(BerlinClockTimeAssert.class, actual);
    }

    public static BerlinClockTimeAssert assertThat(BerlinClockTime actual) {
        return new BerlinClockTimeAssert(actual);
    }

    public BerlinClockTimeAssert secondsAreOff() {
        Assertions.assertThat(actual.getSeconds()).isFalse();
        return this;
    }

    public BerlinClockTimeAssert secondsAreOn() {
        Assertions.assertThat(actual.getSeconds()).isTrue();
        return this;
    }

    public BerlinClockTimeAssert topHourRowIs(String topHourRow) {
        Assertions.assertThat(actual.getTopHourRow()).isEqualTo(topHourRow);
        return this;
    }

    public BerlinClockTimeAssert bottomHourRowIs(String bottomHourRow) {
        Assertions.assertThat(actual.getBottomHourRow()).isEqualTo(bottomHourRow);
        return this;
    }

    public BerlinClockTimeAssert topMinuteRowIs(String topMinuteRow) {
        Assertions.assertThat(actual.getTopMinuteRow()).isEqualTo(topMinuteRow);
        return this;
    }

    public BerlinClockTimeAssert bottomMinuteRowIs(String bottomMinuteRow) {
        Assertions.assertThat(actual.getBottomMinuteRow()).isEqualTo(bottomMinuteRow);
        return this;
    }
}
