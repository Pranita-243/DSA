package LowLevelDesign.RideSharingSystem.Entity.Driver;

import LowLevelDesign.RideSharingSystem.Entity.Location;
import LowLevelDesign.RideSharingSystem.Entity.Ride.Ride;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Driver {

    private  String id;
    private  String name;
    private Ride ride;
    private  DriverStatus driverStatus;
    private Location currentLocation;
    private  String vehicleNo;
    private  String contactNo;
    List<Ride> rideHistory;

    public Driver(String name,String vehicleNo,String contactNo,Location location){

        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.contactNo=contactNo;
        this.vehicleNo= vehicleNo;
        this.currentLocation=location;
        this.ride=null;
        this.driverStatus=DriverStatus.OFFLINE;
        rideHistory=new ArrayList<>();

    }
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        vehicleNo = vehicleNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setLocation(Location location) {
        this.currentLocation = location;
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(List<Ride> rideHistory) {
        this.rideHistory = rideHistory;
    }
}
