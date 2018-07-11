package tdd.practice;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by jxzhong on 2018/5/16.
 */
public class ParkingDirectorTest {

    @Test
    public void should_get_the_empty_parking_report_when_call_generate_parking_report_with_no_parking_vehicle() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2));
        ParkingManager parkingManager = new ParkingManager(parkingLot, parkingBoy, superParkingBoy);
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);

        //when
        ParkingReport report = parkingDirector.generateReport();

        //then
        assertThat(report.getParkingVehicleNum(), is(0));
        assertThat(report, notNullValue());

    }

    @Test
    public void should_get_the_report_when_every_parking_boy_and_manager_have_parking_vehicles() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2), new ParkingLot(2));
        ParkingManager parkingManager = new ParkingManager(parkingLot, parkingBoy, superParkingBoy);
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);
        parkingLot.parking(new Vehicle());
        parkingBoy.parking(new Vehicle());
        superParkingBoy.parking(new Vehicle());
        superParkingBoy.parking(new Vehicle());

        //when
        ParkingReport report = parkingDirector.generateReport();

        //then
        assertThat(report.getParkingVehicleNum(), is(4));
        assertThat(report.getRoleName(), is("M"));
    }
}
