package LowLevelDesign.ParkingLotApp.Runner;

import LowLevelDesign.ParkingLotApp.Entity.Parking.*;
import LowLevelDesign.ParkingLotApp.Entity.Parking.Fee.VehicleBasedFeeStrategy;
import LowLevelDesign.ParkingLotApp.Entity.Ticket;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Bike;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Car;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Truck;
import LowLevelDesign.ParkingLotApp.Entity.Vehicle.Vehicle;

import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args){
        ParkingLot parkingLot=ParkingLot.getInstance();
        System.out.println("Add the parking eligible spots");
        List<ParkingSpot> parkingSpotListFloor1= Arrays.asList(ParkingSpotFactory.createParkingSpot(ParkingSpotType.BIKE,"101"),
                                                            ParkingSpotFactory.createParkingSpot(ParkingSpotType.COMPACT,"102"),
                                                            ParkingSpotFactory.createParkingSpot(ParkingSpotType.LARGE,"103"));


         List<ParkingSpot> parkingSpotListFloor2=Arrays.asList(ParkingSpotFactory.createParkingSpot(ParkingSpotType.BIKE,"201"),
                                                                ParkingSpotFactory.createParkingSpot(ParkingSpotType.COMPACT,"202"),
                                                                 ParkingSpotFactory.createParkingSpot(ParkingSpotType.LARGE,"203"));


        ParkingFloor floor1=new ParkingFloor(1,parkingSpotListFloor1);
        ParkingFloor floor2=new ParkingFloor(2,parkingSpotListFloor2);

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        Vehicle car1=new Car("XYZ8919");
        Vehicle car2=new Car("ABC3021");
        Vehicle Bike1=new Bike("VYX7207");
        Vehicle truck=new Truck("AB8602");

        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());


        try
        {
            Ticket parkingTicket= parkingLot.parkVehicle(car1);
            System.out.println("car1 Parked,TicketId:-,"+parkingTicket.getId()+ " "+parkingTicket.getVehicle().getVehicleNo()+" "+parkingTicket.getParkingSpot().getVehicle().getVehicleNo());

            Ticket parkingTicket2=parkingLot.parkVehicle(car2);
            System.out.println("car1 Parked,TicketId:-,"+parkingTicket2.getId()+ " "+parkingTicket2.getVehicle().getVehicleNo()+" "+parkingTicket2.getParkingSpot().getVehicle().getVehicleNo());

            Ticket parkingTicket3=parkingLot.parkVehicle(Bike1);
            System.out.println("car1 Parked,TicketId:-,"+parkingTicket3.getId()+ " "+parkingTicket3.getVehicle().getVehicleNo()+" "+parkingTicket3.getParkingSpot().getId());



        }catch(Exception e){
            System.out.println("Exception "+e.getMessage());


        }

        try{
            double fee=parkingLot.unparkVehicle(car1.getVehicleNo());
            System.out.println("car1 "+car1.getVehicleNo()+" fee "+fee);

            double fee1=parkingLot.unparkVehicle(Bike1.getVehicleNo());
            System.out.println("car1 "+Bike1.getVehicleNo()+" fee "+fee1);



        } catch (Exception e) {
            System.out.println("Exception"+e.getMessage());
        }

    }
}
