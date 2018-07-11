package tdd.practice;

import java.util.List;

/**
 * Created by jxzhong on 2018/5/15.
 */
public interface Parkable {
    String parking(Vehicle vehicle1);

    Vehicle pickUp(String ticket);

    int getAvailableNums();

    boolean hasVehicle(String ticket);

    ParkingReport generateReport();

}
