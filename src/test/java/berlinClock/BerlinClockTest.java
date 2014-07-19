package berlinClock;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class BerlinClockTest {

    BerlinClock berlinClock = new BerlinClock();

    @DataProvider(name = "secondsOn")
    public Object[][] getSecondsOn() {
        return new Object[][]{
                {0},
                {2},
                {4},
        };
    }

    @Test(dataProvider = "secondsOn")
    public void secondsLightShouldBeOnIfSecondsAreEven(int seconds) {
        LocalTime time = LocalTime.MIDNIGHT;
        time = time.plusSeconds(seconds);
        BerlinClockTime actual = berlinClock.translateTime(time);
        BerlinClockTimeAssert.assertThat(actual)
                .isNotNull()
                .secondsAreOn();
    }

    @DataProvider(name = "secondsOff")
    public Object[][] getSecondsOff() {
        return new Object[][]{
                {1},
                {3},
                {5},
        };
    }

    @Test(dataProvider = "secondsOff")
    public void secondsLightShouldBeOffIfSecondsAreOdd(int seconds) {
        LocalTime time = LocalTime.MIDNIGHT;
        time = time.plusSeconds(seconds);
        BerlinClockTime actual = berlinClock.translateTime(time);
        BerlinClockTimeAssert.assertThat(actual)
                .isNotNull()
                .secondsAreOff();
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
                .topHourRowIs(topHourRow)
                .bottomHourRowIs(bottomHourRow);
    }

    @DataProvider(name = "minutesDatas")
    public Object[][] getMinutesDatas() {
        return new Object[][]{
                {1, "OOOOOOOOOOO", "YOOO"},
                {2, "OOOOOOOOOOO", "YYOO"},
                {3, "OOOOOOOOOOO", "YYYO"},
                {4, "OOOOOOOOOOO", "YYYY"},
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
                .topMinuteRowIs(topMinuteRow)
                .bottomMinuteRowIs(bottomMinuteRow);
    }

    @DataProvider(name = "integrationDatas")
    public Object[][] getIntegrationDatas() {
        return new Object[][]{
                {LocalTime.MIDNIGHT,
                        true,
                        "OOOO",
                        "OOOO",
                        "OOOOOOOOOOO",
                        "OOOO"
                },
                {LocalTime.of(13, 17, 1),
                        false,
                        "RROO",
                        "RRRO",
                        "YYROOOOOOOO",
                        "YYOO"
                },
                {LocalTime.of(23, 59, 59),
                        false,
                        "RRRR",
                        "RRRO",
                        "YYRYYRYYRYY",
                        "YYYY"
                },
        };
    }

    @Test(dataProvider = "integrationDatas")
    public void lightsShouldReflectRealTime(LocalTime time, boolean secondsLightOn, String topHourRow, String bottomHourRow, String topMinuteRow, String bottomMinuteRow) {
        BerlinClockTime actual = berlinClock.translateTime(time);
        BerlinClockTimeAssert.assertThat(actual)
                .secondsAre(secondsLightOn)
                .topHourRowIs(topHourRow)
                .bottomHourRowIs(bottomHourRow)
                .topMinuteRowIs(topMinuteRow)
                .bottomMinuteRowIs(bottomMinuteRow);
    }
}
