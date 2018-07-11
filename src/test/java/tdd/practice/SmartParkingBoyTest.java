package tdd.practice;


import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class SmartParkingBoyTest {


    @Test
    public void should_parking_car_when_this_parking_lot_has_most_available_parking_rooms() throws Exception {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Vehicle vehicle1 = new Vehicle();

        //when
        String ticket1 = smartParkingBoy.parking(vehicle1);


        //then
        assertThat(parkingLot1.getAvailableNums(), is(1));
        assertThat(parkingLot2.getAvailableNums(), is(1));

    }
}
