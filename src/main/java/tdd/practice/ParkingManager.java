package tdd.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingManager {
    private final List<Parkable> parkableList;

    public ParkingManager(Parkable... parkables) {
        this.parkableList = Arrays.asList(parkables);
    }

    public String parking(Vehicle vehicle) {
        return parkableList.stream()
                .filter(parkable -> isFull(parkable))
                .findFirst().get().parking(vehicle);
    }

    private boolean isFull(Parkable parkable) {
        return parkable.getAvailableNums() > 0;
    }

    public Vehicle pickUp(String ticket) {
        return parkableList.stream()
                .filter(parkable -> parkable.hasVehicle(ticket))
                .findFirst().get()
                .pickUp(ticket);
    }

    public ParkingReport generateReport() {
        List<ParkingReport> reports = this.parkableList.stream().map(Parkable::generateReport)
                .collect(Collectors.toList());
        return new ParkingReport("M", reports);
    }
}
