package tdd.practice;


import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingLotTest {

    @Test
    public void should_get_1_available_parking_room_when_parking_lot_is_empty_and_1_total_place() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        //when
        int availableNum = parkingLot.getAvailableNums();

        //then
        assertThat(availableNum, is(1));
    }

    @Test
    public void should_parking_vehicle_success_when_call_packing() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle vehicle = new Vehicle();
        //when
        String ticket1 = parkingLot.parking(vehicle);
        String ticket2 = parkingLot.parking(vehicle);

        //then
        assertThat(ticket1.length(), is(3));
        assertThat(ticket2.length(), is(3));
        assertThat(ticket2, not(ticket1));
        assertThat(ticket1.length(), is(3));
    }

    @Test
    public void should_get_indicated_vehicle_when_get_vehicle_via_park_ticket_and_not_only_one_car_in_lot() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        String ticket1 = parkingLot.parking(vehicle1);
        String ticket2 = parkingLot.parking(vehicle2);
        //when
        Vehicle pickedVehicle = parkingLot.pickUp(ticket1);

        //then
        assertThat(pickedVehicle, is(vehicle1));
        assertThat(parkingLot.getAvailableNums(), is(1));

    }

    @Test
    public void should_throw_outofrange_exception_when_parking_vehicle_more_than_total_room_num() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle vehicle = new Vehicle();
        //when
        parkingLot.parking(vehicle);
        parkingLot.parking(vehicle);

        //then
        assertThrows(IndexOutOfBoundsException.class, () -> parkingLot.parking(vehicle));
    }

    //测测是可以删除
    @Test
    public void should_get_2_available_parking_room_when_parking_lot_has_3_rooms_with_two_vehicle_parked() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot(3);
        Vehicle vehicle = new Vehicle();
        String ticket1 = parkingLot.parking(vehicle);

        //when
        int availableNum = parkingLot.getAvailableNums();

        //then
        assertThat(availableNum, is(2));

    }

}
