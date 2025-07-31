package LowLevelDesign.ParkingLotApp.Entity.Parking;

import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Vehicle;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.VehicleType;

public class CompactSpot extends ParkingSpot {

    public CompactSpot(String spotID){
        super(spotID);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        VehicleType type=vehicle.getVehicleType();
        return type==VehicleType.CAR;
    }
}
