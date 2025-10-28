package LowLevelDesign.RideSharingSystem.Service;

import LowLevelDesign.RideSharingSystem.Entity.Driver.Driver;
import LowLevelDesign.RideSharingSystem.Entity.Driver.DriverStatus;
import LowLevelDesign.RideSharingSystem.Entity.Location;
import LowLevelDesign.RideSharingSystem.Entity.Ride.Ride;
import LowLevelDesign.RideSharingSystem.Entity.Ride.RideSatus;
import LowLevelDesign.RideSharingSystem.Entity.Rider.Rider;
import LowLevelDesign.RideSharingSystem.Strategy.Matching.DriverMatchingStrategy;
import LowLevelDesign.RideSharingSystem.Strategy.Payment.PricingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideService {

    private Map<String, Ride> rides;
    private  DriverService driverService;
    private Riderservice riderservice;
    private DriverMatchingStrategy driverMatchingStrategy;
    private PricingStrategy pricingStrategy;
    private static RideService rideService ;

    private RideService(){
        this.riderservice=new Riderservice();
        this.driverService=new DriverService();
        this.rides=new HashMap<>();

    }

    public static RideService getInstance(){

        if(rideService==null){
              rideService=new RideService();
        }
        return rideService;

    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public DriverMatchingStrategy getDriverMatchingStrategy() {
        return driverMatchingStrategy;
    }

    public void setDriverMatchingStrategy(DriverMatchingStrategy driverMatchingStrategy) {
        this.driverMatchingStrategy = driverMatchingStrategy;
    }


    public  Driver registerDriver(String name, String contact, String vehicleNo, Location initailLocation){
       return driverService.registerDriver(name,contact,vehicleNo,initailLocation);

    }

    public Rider registerRider(String name, String contact){
       return riderservice.registerRider(name,contact);
    }

    public Ride requestRide(String riderId,Location pickup,Location dropOff){
        Rider rider1=riderservice.getRider(riderId);
        System.out.println("new ride request from Rider1 "+rider1.getName());

        //available Drivers
        List<Driver> nearestDriver= driverMatchingStrategy.findDriverList(driverService.getAvailableDrivers(),pickup);
        if(nearestDriver.isEmpty()){
            System.out.println("No driver Available");
            return  null;
        }

        System.out.println("drivers available are "+nearestDriver.size());

        //Calculate fare
        double fare= pricingStrategy.calculateFare(pickup,dropOff);
        System.out.println("Estimated Fare is"+fare);

        Ride ride=new Ride(rider1,pickup,dropOff,fare);
        rides.put(ride.getId(),ride);

        System.out.println("Notifying nearby drivers ride is requested");
        for(Driver driver:nearestDriver){
            System.out.println("Notifying  "+driver.getName()+" at "+ driver.getCurrentLocation());
            driverService.onUpdate(ride,driver);
        }

        return ride;


    }

    public void acceptRide(String driverId,String tripId){
        Driver driver=driverService.getDriver(driverId);
        Ride ride=rides.get(tripId);
        if(driver==null || ride ==null){
            System.out.println("Driver not found");
            return;
        }

        System.out.println("\n trip accepted by driver "+driver.getName());
        driver.setDriverStatus(DriverStatus.ACCEPTED);
        ride.setRideSatus(RideSatus.ACCEPTED);
        ride.setDriver(driver);

    }

    public void startTrip(String tripId){
        Ride ride=rides.get(tripId);
        if(ride==null){
            System.out.println("No such trip found");
            return;
        }
        ride.setRideSatus(RideSatus.INPROGRESS);
        Rider rider=ride.getRider();
        Driver driver =ride.getDriver();
        driver.setDriverStatus(DriverStatus.IN_TRIP);
        System.out.println("Trip started for the  rider  "+ rider.getName() +" and driver "+driver.getName() );

    }

    public  void endTrip(String tripId){

        Ride ride=rides.get(tripId);
        if(ride==null){
            System.out.println("No such trip found");
            return;
        }
        Rider rider=ride.getRider();
        Driver driver =ride.getDriver();
        driver.setDriverStatus(DriverStatus.ONLINE);
        driver.setLocation(ride.getDestination());
        ride.setRideSatus(RideSatus.COMPLETED);

        List<Ride> driverHistory=driver.getRideHistory();
        driverHistory.add(ride);
        List<Ride> riderHistory=rider.getRiderHistory();
        riderHistory.add(ride);

        System.out.println("please pay the fare RS "+ ride.getFare());
        rides.remove(ride.getId());


    }




}
