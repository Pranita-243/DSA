package LowLevelDesign.ParkingLotApp.Entity.Parking;

import LowLevelDesign.ParkingLotApp.Entity.Parking.Fee.FeeStrategy;
import LowLevelDesign.ParkingLotApp.Entity.Ticket;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Vehicle;

import java.util.*;

public class ParkingLot {
    private  static final ParkingLot parkingLot=new ParkingLot();
    private final List<ParkingFloor> floors=new ArrayList<>();
    private final Map<String, Ticket> activeTickets=new HashMap<>();
    private FeeStrategy feeStrategy;

    private  ParkingLot(){
        //feeStrategy
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }




    public static ParkingLot getInstance(){
        return parkingLot;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) throws Exception{
        for(ParkingFloor floor:floors){
            Optional<ParkingSpot> spots=floor.getAvailableSpot(vehicle);
            if(spots.isPresent()){
                ParkingSpot spot= spots.get();
                if(spot.assignVehicle(vehicle)){
                    Ticket ticket=new Ticket(vehicle,spot);
                    activeTickets.put(vehicle.getVehicleNo(),ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No Available spot for th Parking"+vehicle.getVehicleType());
    }


    public double unparkVehicle(String vehicleNO) throws  Exception{
        Ticket ticket=activeTickets.remove(vehicleNO);
        if(ticket==null){
            throw new Exception("ticket Not Found");

        }
        ticket.getParkingSpot().removevehicle();
        ticket.setExitTimestamp();
       // System.out.println(ticket.getEntryTimeStamp() +" "+ ticket.getExitTimestamp());
        return feeStrategy.calculate(ticket);
    }




}
