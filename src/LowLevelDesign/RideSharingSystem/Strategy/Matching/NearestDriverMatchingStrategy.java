package LowLevelDesign.RideSharingSystem.Strategy.Matching;

import LowLevelDesign.RideSharingSystem.Entity.Driver.Driver;
import LowLevelDesign.RideSharingSystem.Entity.Driver.DriverStatus;
import LowLevelDesign.RideSharingSystem.Entity.Location;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NearestDriverMatchingStrategy implements DriverMatchingStrategy{
    private  static  final double MAX_DIST_KM=5;
    @Override
    public List<Driver> findDriverList(List<Driver> allDrivers, Location pickupLocation) {
        return allDrivers.stream()
                .filter(driver -> driver.getDriverStatus()== DriverStatus.ONLINE)
                .filter(driver -> pickupLocation.distanceTo(driver.getCurrentLocation())<MAX_DIST_KM)
                .sorted(Comparator.comparingDouble(driver-> pickupLocation.distanceTo(driver.getCurrentLocation())))
                .collect(Collectors.toList());

    }
}
