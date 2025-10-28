package LowLevelDesign.RideSharingSystem.Strategy.Matching;

import LowLevelDesign.RideSharingSystem.Entity.Driver.Driver;
import LowLevelDesign.RideSharingSystem.Entity.Location;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findDriverList(List<Driver> allDrivers, Location pickupLocation);
}
