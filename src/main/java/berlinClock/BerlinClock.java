package berlinClock;

import java.time.LocalTime;

public class BerlinClock {

    public static final char LIGHT_OFF = 'O';

    public static final char YELLOW_LIGHT_ON = 'Y';

    public static final char RED_LIGHT_ON = 'R';

    public static final int SHORT_LINE_SIZE = 4;

    public static final int LONG_LINE_SIZE = 11;

    public BerlinClockTime translateTime(LocalTime time) {
        BerlinClockTime berlinClockTime = new BerlinClockTime();
        handleSeconds(time, berlinClockTime);
        handleMinutes(time, berlinClockTime);
        handleHours(time, berlinClockTime);
        return berlinClockTime;
    }

    private void handleSeconds(LocalTime time, BerlinClockTime berlinClockTime) {
        berlinClockTime.setSeconds(areSecondsEven(time));
    }

    private boolean areSecondsEven(LocalTime time) {
        return time.getSecond() % 2 == 0;
    }

    private void handleMinutes(LocalTime time, BerlinClockTime berlinClockTime) {
        int minutes = time.getMinute();
        manageBottomMinuteLine(berlinClockTime, minutes);
        manageTopMinuteLine(berlinClockTime, minutes);
    }

    private void manageTopMinuteLine(BerlinClockTime berlinClockTime, int minutes) {
        String line = createYellowLongLightLine(minutes / 5);
        line = handleQuarters(line);
        berlinClockTime.setTopMinuteRow(line);
    }

    private String handleQuarters(String line) {
        char[] chars = line.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            char light = chars[i];
            if (isQuarterLight(i) && isYellow(light)) {
                light = RED_LIGHT_ON;
            }
            result += light;
        }
        return result;
    }

    private boolean isYellow(char light) {
        return light == YELLOW_LIGHT_ON;
    }

    private boolean isQuarterLight(int lightIndex) {
        return lightIndex % 3 == 2;
    }

    private void manageBottomMinuteLine(BerlinClockTime berlinClockTime, int minutes) {
        String line = createYellowShortLightLine(minutes % 5);
        berlinClockTime.setBottomMinuteRow(line);
    }

    private void handleHours(LocalTime time, BerlinClockTime berlinClockTime) {
        manageBottomHourRow(time.getHour(), berlinClockTime);
        manageTopHourRow(time.getHour(), berlinClockTime);
    }

    private void manageTopHourRow(int hours, BerlinClockTime berlinClockTime) {
        int hoursDivideByFive = hours / 5;
        String line = createRedLightLine(hoursDivideByFive);
        berlinClockTime.setTopHourRow(line);
    }

    private void manageBottomHourRow(int hours, BerlinClockTime berlinClockTime) {
        int hoursModFive = hours % 5;
        String line = createRedLightLine(hoursModFive);
        berlinClockTime.setBottomHourRow(line);
    }

    private String createRedLightLine(int nbRedLight) {
        int size = SHORT_LINE_SIZE;
        char color = RED_LIGHT_ON;
        return createLightLine(nbRedLight, size, color);
    }

    private String createYellowShortLightLine(int nbRedLight) {
        int size = SHORT_LINE_SIZE;
        return createYellowLine(nbRedLight, size);
    }

    private String createYellowLine(int nbRedLight, int size) {
        char color = YELLOW_LIGHT_ON;
        return createLightLine(nbRedLight, size, color);
    }

    private String createYellowLongLightLine(int nbRedLight) {
        int size = LONG_LINE_SIZE;
        return createYellowLine(nbRedLight, size);
    }

    private String createLightLine(int nbRedLight, int size, char color) {
        String line = "";
        for (int i = 0; i < size; i++) {
            if (i < nbRedLight) {
                line += color;
            } else {
                line += LIGHT_OFF;
            }
        }
        return line;
    }
}
