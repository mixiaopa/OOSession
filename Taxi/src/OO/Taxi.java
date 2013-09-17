package OO;

import java.math.BigDecimal;

public class Taxi {
    public static final int FLAG_FEE = 6;
    public static final int FLAG_MILES = 2;
    public static final int FAR_DISTANCE_MILES = 8;
    public static final double STOP_TIME_FEE = 0.25;
    public static final double RATE_FOR_FAR_DISTANCE = 1.2;
    public static final double RATE_FOR_SHORT_DISTANCE = 0.8;
    public static final double FLAG_FEE_FOR_FAR_DISTANCE = 10.8;
    private int stopTime;

    public double getFee(double distance) {
        double finalFee = FLAG_FEE;
        if (distance > FAR_DISTANCE_MILES)
            finalFee = FLAG_FEE_FOR_FAR_DISTANCE + (distance - FAR_DISTANCE_MILES) * RATE_FOR_FAR_DISTANCE;
        if (FLAG_MILES < distance && distance <= FAR_DISTANCE_MILES) {
            finalFee = FLAG_FEE + (distance - FLAG_MILES) * RATE_FOR_SHORT_DISTANCE;
        }
        if (this.stopTime > 0)
            finalFee += STOP_TIME_FEE * stopTime;
        return finalFee;
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    public String getFinalCharge(int distance) {
        String finalFee = new BigDecimal(getFee(distance)).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        return finalFee;
    }

    public double convertMilesToInteger(double distanceDecimal) {
        return Math.ceil(distanceDecimal);
    }
}
