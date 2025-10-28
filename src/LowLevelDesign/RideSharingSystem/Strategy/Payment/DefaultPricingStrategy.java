package LowLevelDesign.RideSharingSystem.Strategy.Payment;

import LowLevelDesign.RideSharingSystem.Entity.Location;

public class DefaultPricingStrategy implements  PricingStrategy{
    private  static  final double BASE_FARE=5.0;
    private  static  final  double FLAT_RATE=1.5;
    @Override
    public double calculateFare(Location pickUp, Location dropOff) {
        double distance= pickUp.distanceTo(dropOff);
        return  BASE_FARE+FLAT_RATE* distance;

    }
}
