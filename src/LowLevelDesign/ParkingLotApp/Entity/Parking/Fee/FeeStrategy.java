package LowLevelDesign.ParkingLotApp.Entity.Parking.Fee;

import LowLevelDesign.ParkingLotApp.Entity.Ticket;

public interface FeeStrategy {
    double calculate(Ticket ticket);

}
