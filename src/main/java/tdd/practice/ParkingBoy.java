package tdd.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingBoy implements Parkable {

    protected final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... initParkingLots) {
        this.parkingLots = Arrays.asList(initParkingLots);
    }


    @Override
    public String parking(Vehicle vehicle1) {
        Optional<ParkingLot> curParkingLot = this.parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.getAvailableNums() > 0)
                .findFirst();
        String ticket = curParkingLot.get().parking(vehicle1);

        return ticket;
    }

    @Override
    public Vehicle pickUp(String ticket) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasVehicle(ticket))
                .findFirst().get().pickUp(ticket);
    }

    @Override
    public int getAvailableNums() {
        return this.parkingLots.stream().mapToInt(parkable -> parkable.getAvailableNums()).sum();
    }

    public boolean hasVehicle(String ticket) {
        return this.parkingLots.stream().anyMatch(parkingLot -> parkingLot.hasVehicle(ticket));
    }

    @Override
    public ParkingReport generateReport() {
        List<ParkingReport> reports = this.parkingLots.stream().map(Parkable::generateReport).collect(Collectors.toList());
        return new ParkingReport("B", reports);
    }


}
