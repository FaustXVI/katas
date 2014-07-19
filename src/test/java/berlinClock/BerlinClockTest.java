package berlinClock;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class BerlinClockTest {

    public static final String DEFAULT_TOP_HOURS = "OOOO";

    public static final String DEFAULT_BOTTOM_HOURS = "OOOO";

    public static final String DEFAULT_TOP_MINUTES = "OOOOOOOOOOO";

    public static final String DEFAULT_BOTTOM_MINUTES = "OOOO";

    BerlinClock berlinClock = new BerlinClock();

    @Test
    public void shouldAllBeOffAtMidnight() {
        LocalTime time = LocalTime.MIDNIGHT;
        BerlinClockTime actual = berlinClock.translateTime(time);
        BerlinClockTimeAssert.assertThat(actual)
                .isNotNull()
                .secondsAreOff()
                .topHourRowIs(DEFAULT_TOP_HOURS)
                .bottomHourRowIs(DEFAULT_BOTTOM_HOURS)
                .topMinuteRowIs(DEFAULT_TOP_MINUTES)
                .bottomMinuteRowIs(DEFAULT_BOTTOM_MINUTES);
    }

    @DataProvider(name = "secondsOn")
    public Object[][] getSecondsOn() {
        return new Object[][]{
                {1},
                {3},
        };
    }

    @Test(dataProvider = "secondsOn")
    public void onlySecondsShouldBeOnAtMidnightAndASecond(int seconds) {
        LocalTime time = LocalTime.MIDNIGHT;
        time = time.plusSeconds(seconds);
        BerlinClockTime actual = berlinClock.translateTime(time);
        BerlinClockTimeAssert.assertThat(actual)
                .isNotNull()
                .secondsAreOn()
                .topHourRowIs(DEFAULT_TOP_HOURS)
                .bottomHourRowIs(DEFAULT_BOTTOM_HOURS)
                .topMinuteRowIs(DEFAULT_TOP_MINUTES)
                .bottomMinuteRowIs(DEFAULT_BOTTOM_MINUTES);
    }

    @DataProvider(name = "hoursDatas")
    public Object[][] getHoursDatas() {
        return new Object[][]{
                {1, "OOOO", "ROOO"},
                {2, "OOOO", "RROO"},
                {3, "OOOO", "RRRO"},
                {4, "OOOO", "RRRR"},
                {5, "ROOO", "OOOO"},
                {6, "ROOO", "ROOO"},
                {7, "ROOO", "RROO"},
                {8, "ROOO", "RRRO"},
                {9, "ROOO", "RRRR"},
                {10, "RROO", "OOOO"},
                {11, "RROO", "ROOO"},
                {15, "RRRO", "OOOO"},
                {16, "RRRO", "ROOO"},
                {20, "RRRR", "OOOO"},
        };
    }

    @Test(dataProvider = "hoursDatas")
    public void hoursLightShouldReflectRealHours(int hours, String topHourRow, String bottomHourRow) {
        LocalTime time = LocalTime.MIDNIGHT;
        time = time.plusHours(hours);
        BerlinClockTime actual = berlinClock.translateTime(time);
        BerlinClockTimeAssert.assertThat(actual)
                .isNotNull()
                .secondsAreOff()
                .topHourRowIs(topHourRow)
                .bottomHourRowIs(bottomHourRow)
                .topMinuteRowIs(DEFAULT_TOP_MINUTES)
                .bottomMinuteRowIs(DEFAULT_BOTTOM_MINUTES);
    }

    @DataProvider(name = "minutesDatas")
    public Object[][] getMinutesDatas() {
        return new Object[][]{
                {1, DEFAULT_TOP_MINUTES, "YOOO"},
                {2, DEFAULT_TOP_MINUTES, "YYOO"},
                {3, DEFAULT_TOP_MINUTES, "YYYO"},
                {4, DEFAULT_TOP_MINUTES, "YYYY"},
                {5, "YOOOOOOOOOO", "OOOO"},
                {10, "YYOOOOOOOOO", "OOOO"},
                {15, "YYROOOOOOOO", "OOOO"},
                {16, "YYROOOOOOOO", "YOOO"},
                {20, "YYRYOOOOOOO", "OOOO"},
                {30, "YYRYYROOOOO", "OOOO"},
                {45, "YYRYYRYYROO", "OOOO"},
        };
    }

    @Test(dataProvider = "minutesDatas")
    public void minutesLightShouldReflectRealMinutes(int minutes, String topMinuteRow, String bottomMinuteRow) {
        LocalTime time = LocalTime.MIDNIGHT;
        time = time.plusMinutes(minutes);
        BerlinClockTime actual = berlinClock.translateTime(time);
        BerlinClockTimeAssert.assertThat(actual)
                .isNotNull()
                .secondsAreOff()
                .topHourRowIs(DEFAULT_TOP_HOURS)
                .bottomHourRowIs(DEFAULT_BOTTOM_HOURS)
                .topMinuteRowIs(topMinuteRow)
                .bottomMinuteRowIs(bottomMinuteRow);
    }
}
