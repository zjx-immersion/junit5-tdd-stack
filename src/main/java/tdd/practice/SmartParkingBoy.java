package tdd.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... initParkingLots) {
        super(initParkingLots);
    }

    @Override
    public String parking(Vehicle vehicle1) {
        Optional<ParkingLot> curParkingLot = this.parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.getAvailableNums() > 0)
                .sorted((parkingLot1, parkingLot2) -> parkingLot2.getAvailableNums() - parkingLot1.getAvailableNums())
                .findFirst();
        String ticket = curParkingLot.get().parking(vehicle1);

        return ticket;
    }

}
