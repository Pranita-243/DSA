package LowLevelDesign.ParkingLotApp.Entity.Parking;

import static LowLevelDesign.ParkingLotApp.Entity.Parking.ParkingSpotType.*;


public class ParkingSpotFactory {

    public static ParkingSpot createParkingSpot(ParkingSpotType parkingType, String id ){


        if(parkingType.equals(BIKE)){
            return new BikeSpot(id);
        } else if (parkingType.equals(COMPACT)) {
            return new CompactSpot(id);
        } else if (parkingType.equals(LARGE)) {
            return new LargeSpot(id);
        }else{
            throw  new IllegalArgumentException("Unknown Parking Spot Type:"+parkingType);
        }

    }
}
