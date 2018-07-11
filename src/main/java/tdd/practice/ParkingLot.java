package tdd.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingLot implements Parkable {
    private final int totalPlaceNum;
    private static int baseTicket = 100;
    private Map<String, Vehicle> parkingRooms;

    public ParkingLot(int totalParkingRoomNum) {
        this.totalPlaceNum = totalParkingRoomNum;
        this.parkingRooms = new HashMap<>();
//        this.baseTicket = 100;
    }

    public int getAvailableNums() {
        return this.totalPlaceNum - parkingRooms.size();
    }

    @Override
    public String parking(Vehicle vehicle) {

        if (this.parkingRooms.size() >= this.totalPlaceNum) {
            throw new IndexOutOfBoundsException("Parking Rooms are full!");
        }
        String newTicket = String.valueOf(baseTicket++);
        this.parkingRooms.put(newTicket, vehicle);
        return newTicket;
    }

    @Override
    public Vehicle pickUp(String ticket) {
        Vehicle vehicle = this.parkingRooms.get(ticket);
        parkingRooms.remove(ticket);
        return vehicle;
    }

    public boolean hasVehicle(String ticket) {
        return parkingRooms.containsKey(ticket);
    }

    @Override
    public ParkingReport generateReport() {
        return new ParkingReport("P", parkingRooms.size());
    }

    public double getAvailableRate() {
        return this.getAvailableNums() / this.totalPlaceNum;
    }


}
