package LowLevelDesign.ParkingLotApp.Entity.Parking;

import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Vehicle;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.VehicleType;

public abstract class ParkingSpot {
    private final String id;

    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(String  id){
        this.id=id;
        isOccupied=false;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }



    public abstract boolean canFitVehicle(Vehicle vehicle);


    //park()
    public boolean assignVehicle(Vehicle vehicle){
        if(isOccupied){
            return false;
        }
        this.vehicle=vehicle;
        isOccupied=true;
        return true;

    }



    //unpark()
    public void removevehicle(){
        isOccupied=false;
        vehicle=null;
    }
}
