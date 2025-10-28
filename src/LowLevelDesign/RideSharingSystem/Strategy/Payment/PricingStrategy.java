package LowLevelDesign.RideSharingSystem.Strategy.Payment;

import LowLevelDesign.RideSharingSystem.Entity.Location;

public interface PricingStrategy {
    double calculateFare(Location pickUp,Location dropOff);
}
