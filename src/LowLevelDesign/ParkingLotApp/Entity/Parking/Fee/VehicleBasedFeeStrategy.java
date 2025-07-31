package LowLevelDesign.ParkingLotApp.Entity.Parking.Fee;

import LowLevelDesign.ParkingLotApp.Entity.Ticket;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy{

    private final Map<VehicleType,Double> map=Map.of(
            VehicleType.BIKE,10.0,
            VehicleType.CAR,20.0,
            VehicleType.TRUCK,30.0
    );
    @Override
    public double calculate(Ticket ticket) {
        long duration= ticket.getExitTimestamp()-ticket.getEntryTimeStamp();
        long hours=(duration/(1000*60*60))+1;
        return  hours*map.get(ticket.getVehicle().getVehicleType());
    }
}
