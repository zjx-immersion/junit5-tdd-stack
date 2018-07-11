package tdd.practice;

/**
 * Created by jxzhong on 2018/5/16.
 */
public class ParkingDirector {
    private final ParkingManager parkingManager;

    public ParkingDirector(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public ParkingReport generateReport() {
        return parkingManager.generateReport();
    }
}
