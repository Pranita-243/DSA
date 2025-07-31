package LowLevelDesign.ParkingLotApp.Entity.Parking;

import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {

    private final int number;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber,List<ParkingSpot> parkingSpotsList){
        this.number=floorNumber;
        this.parkingSpots=parkingSpotsList;
    }

    public int getNumber() {
        return number;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle){
        return parkingSpots.stream().filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle)).findFirst();
    }


}
