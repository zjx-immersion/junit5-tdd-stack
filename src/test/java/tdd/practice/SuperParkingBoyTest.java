package tdd.practice;


import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class SuperParkingBoyTest {

    @Test
    public void should_parking_car_when_this_parking_lot_has_most_available_rate_of_parking_rooms() throws Exception {
        //given
        ParkingLot parkingLot1 = new ParkingLot(6);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        Vehicle vehicle1 = new Vehicle();

        //when

        IntStream.rangeClosed(1, 3).forEach(x -> superParkingBoy.parking(vehicle1));


        //then
        assertThat(parkingLot1.getAvailableNums(), is(4));
        assertThat(parkingLot2.getAvailableNums(), is(1));



    }
}
