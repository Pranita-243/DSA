package LowLevelDesign.RideSharingSystem.Entity.Ride;

import LowLevelDesign.RideSharingSystem.Entity.Driver.Driver;
import LowLevelDesign.RideSharingSystem.Entity.Location;
import LowLevelDesign.RideSharingSystem.Entity.Rider.Rider;

import java.util.UUID;

public class Ride {

    private String  id;
    private Rider rider;
    private Driver driver;
    private Location origin;
    private Location destination;
    private double fare;
    private RideSatus rideSatus;

    public  Ride(Rider rider,Location pick,Location drop,double fare){
        this.id= UUID.randomUUID().toString();
        this.rider=rider;
        this.origin=pick;
        this.destination=drop;
        this.fare=fare;
        this.rideSatus=RideSatus.REQUESTED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public RideSatus getRideSatus() {
        return rideSatus;
    }

    public void setRideSatus(RideSatus rideSatus) {
        this.rideSatus = rideSatus;
    }
}
