package tdd.practice;

import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by jxzhong on 2018/5/16.
 */
public class ParkingReport {
    private final List<ParkingReport> reports;
    private int parkingVehicleNum;
    private String roleName;

    public ParkingReport(String roleName, List<ParkingReport> reports) {
        this.roleName = roleName;
        this.reports = reports;
        this.parkingVehicleNum = this.reports.stream().mapToInt(ParkingReport::getParkingVehicleNum).sum();
    }

    public ParkingReport(String roleName, int parkingVehicleNum) {
        this.roleName = roleName;
        this.parkingVehicleNum = parkingVehicleNum;
        this.reports = null;
    }

    public int getParkingVehicleNum() {
        return parkingVehicleNum;
    }

    public String getRoleName() {
        return roleName;
    }

    public String renderReport(String prefix) {

        String reportLine = this.roleName + " " + this.parkingVehicleNum;
        String toNextLine = "\r\n";
        String lineHeader = "  ";
        String subReportLines = "";
        if (this.reports != null) {
            subReportLines = this.reports.stream()
                    .map(report -> toNextLine + report.renderReport(prefix + lineHeader)).collect(joining());
        }
        return prefix + reportLine + subReportLines;
    }
}
