package tdd.practice;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingBoyTest {

    @Test
    public void should_call_parking_of_parkonglot_when_parking_a_vehicle() throws Exception {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        //when
        String ticket1 = parkingBoy.parking(vehicle1);
        String ticket2 = parkingBoy.parking(vehicle2);
        //then
        assertThat(ticket1.length(), is(3));
        assertThat(ticket2.length(), is(3));
    }

    @Test
    public void should_get_parking_car_when_it_parking_in_any_parking_lot_boy_manage() throws Exception {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        String ticket1 = parkingBoy.parking(vehicle1);
        String ticket2 = parkingBoy.parking(vehicle2);
        //when
        Vehicle pickedVehicle2 = parkingBoy.pickUp(ticket2);
        Vehicle pickedVehicle1 = parkingBoy.pickUp(ticket1);

        //then
        assertThat(vehicle1, is(pickedVehicle1));
        assertThat(vehicle2, is(pickedVehicle2));
        assertThat(ticket1, not(ticket2));
    }


}
