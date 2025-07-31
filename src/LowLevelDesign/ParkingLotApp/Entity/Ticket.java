package LowLevelDesign.ParkingLotApp.Entity;

import LowLevelDesign.ParkingLotApp.Entity.Parking.ParkingSpot;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Vehicle;

import java.util.UUID;
import java.util.Date;
public class Ticket {

    private final String id;
    private final Long entryTimeStamp;
    private  Long exitTimestamp;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public Ticket(Vehicle vehicle,ParkingSpot parkingSpot){
        this.id= UUID.randomUUID().toString();
        this.vehicle=vehicle;
        this.parkingSpot=parkingSpot;
        this.entryTimeStamp=new Date().getTime();
    }
    public String getId() {
        return id;
    }

    public Long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public Long getExitTimestamp() {
        return exitTimestamp;
    }

    public void setExitTimestamp() {
        this.exitTimestamp=new Date().getTime();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }


}
