package tdd.practice;

import java.util.Comparator;
import java.util.Optional;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(ParkingLot ...parkingLots) {
        super(parkingLots);
    }

    @Override
    public String parking(Vehicle vehicle1) {
        Optional<ParkingLot> curParkingLot = this.parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.getAvailableNums() > 0)
                .sorted(Comparator.comparing(ParkingLot::getAvailableRate).reversed())
                .findFirst();
        String ticket = curParkingLot.get().parking(vehicle1);

        return ticket;
    }
}
