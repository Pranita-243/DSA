package LowLevelDesign.RideSharingSystem;

import LowLevelDesign.RideSharingSystem.Entity.Driver.Driver;
import LowLevelDesign.RideSharingSystem.Entity.Driver.DriverStatus;
import LowLevelDesign.RideSharingSystem.Entity.Location;
import LowLevelDesign.RideSharingSystem.Entity.Ride.Ride;
import LowLevelDesign.RideSharingSystem.Entity.Rider.Rider;
import LowLevelDesign.RideSharingSystem.Service.DriverService;
import LowLevelDesign.RideSharingSystem.Service.RideService;
import LowLevelDesign.RideSharingSystem.Strategy.Matching.NearestDriverMatchingStrategy;
import LowLevelDesign.RideSharingSystem.Strategy.Payment.DefaultPricingStrategy;

public class RunnerApp {

    private DriverService driverService;

    public static void main(String[] args){
        RideService rideService= RideService.getInstance();

        rideService.setPricingStrategy(new DefaultPricingStrategy());
        rideService.setDriverMatchingStrategy(new NearestDriverMatchingStrategy());

        //Register Driver
        System.out.println("Hii Please register yourself");
        Driver BOB=rideService.registerDriver("BOB","MH12RF5620","9146115122",new Location(1.0,1.0));
        System.out.println("Hii Welcome "+BOB.getName());
        Driver Alice=rideService.registerDriver("Alice","MH12BX3021","7756891942",new Location(2.0,2.0));
        System.out.println("Hii Welcome "+Alice.getName());
        Driver John=rideService.registerDriver("John","MH11BV8919","9960883442",new Location(1.2,1.2));
        System.out.println("please enter your status");
        BOB.setDriverStatus(DriverStatus.ONLINE);
        Alice.setDriverStatus(DriverStatus.ONLINE);
        John.setDriverStatus(DriverStatus.ONLINE);

        System.out.println("BOB is "+ BOB.getDriverStatus());
        System.out.println("Alice is "+Alice.getDriverStatus());

        System.out.println("Register Rider");

        Rider rider=rideService.registerRider("David","7682928345");


        Location pickUpLoc= new Location(0.0,0.0);
        Location dropOff=new Location(5.0,5.0);

        Ride ride=rideService.requestRide(rider.getId(),pickUpLoc,dropOff);
        if(ride!=null){
            //driver will accept ride

            rideService.acceptRide(Alice.getId(), ride.getId());
            //it will satrt the ride

            rideService.startTrip(ride.getId());
            //end the ride

            rideService.endTrip(ride.getId());
        }

    }


}
