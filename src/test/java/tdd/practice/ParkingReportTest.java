package tdd.practice;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 2018/5/16.
 */
public class ParkingReportTest {
    @Test
    public void should_format_report_when_call_render_report() throws Exception {
        //given
        ParkingReport p1 = new ParkingReport("P", 2);
        ParkingReport p2 = new ParkingReport("P", 2);
        ParkingReport p3 = new ParkingReport("P", 2);
        ParkingReport p4 = new ParkingReport("P", 2);
        ParkingReport b1 = new ParkingReport("B", Arrays.asList(p1));
        ParkingReport b2 = new ParkingReport("B", Arrays.asList(p2, p3));
        ParkingReport m1 = new ParkingReport("M", Arrays.asList(p4, b1, b2));

        String expectedReport = "M 8\r\n" +
                                "  P 2\r\n" +
                                "  B 2\r\n" +
                                "    P 2\r\n" +
                                "  B 4\r\n" +
                                "    P 2\r\n" +
                                "    P 2";
        //when
        String reportText = m1.renderReport("");

        assertThat(reportText, is(expectedReport));

    }
}
