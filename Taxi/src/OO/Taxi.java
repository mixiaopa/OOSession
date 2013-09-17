package OO;

public class Taxi {
    private int stopTime;

    public double getFee(double distance) {
        if (distance > 8 )
            return 10.8 + (distance - 8) * 1.2;
        if (distance > 2) {
            return 6 + (distance - 2) * 0.8;
        }
        if (distance == 1 && this.stopTime == 1)
            return 6.25;
        return 6;
    }


    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    public int getStopTime() {
        return stopTime;
    }
}
