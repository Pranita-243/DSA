package LowLevelDesign.RideSharingSystem.Service;

import LowLevelDesign.RideSharingSystem.Entity.Driver.Driver;
import LowLevelDesign.RideSharingSystem.Entity.Driver.DriverStatus;
import LowLevelDesign.RideSharingSystem.Entity.Location;
import LowLevelDesign.RideSharingSystem.Entity.Ride.Ride;
import LowLevelDesign.RideSharingSystem.Entity.Ride.RideSatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DriverService {
    Map<String, Driver> drivers;

    // register Driver
    //update driver Status
    //getDrivers
    public  DriverService(){
        this.drivers=new HashMap<>();
    }

    public Driver registerDriver(String name, String contact, String vehicleNo, Location initailLocation){
        Driver driver1=new Driver(name,vehicleNo,contact,initailLocation);
        drivers.put(driver1.getId(),driver1);
        return driver1;
    }

    public List<Driver> getAvailableDrivers(){
        return new ArrayList<>(drivers.values());
    }

    public void onUpdate(Ride ride,Driver driver){

        System.out.println("Notification for driver "+ driver.getName());
        System.out.println("Trip and status "+ride.getId()+"  "+ride.getRideSatus());
        if(ride.getRideSatus()== RideSatus.REQUESTED){
            System.out.println("new ride is available for you to accept");
        }
        System.out.println("------------------------\n");

    }

    public  Driver getDriver(String driverId){
        return  drivers.get(driverId);
    }


}
