package LowLevelDesign.RideSharingSystem.Entity.Rider;

import LowLevelDesign.RideSharingSystem.Entity.Ride.Ride;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Rider {

    private String id;
    private  String name;
    private List<Ride> riderHistory;
    private  String contact;


    public  Rider(String name,String contact){
        this.id= UUID.randomUUID().toString();
        this.name=name;
        riderHistory=new ArrayList<>();
        this.contact=contact;

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

    public List<Ride> getRiderHistory() {
        return riderHistory;
    }

    public void setRide(List<Ride> ride) {
        this.riderHistory = ride;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
