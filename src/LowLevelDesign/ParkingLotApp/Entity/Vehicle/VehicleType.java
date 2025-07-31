package LowLevelDesign.ParkingLotApp.Entity.Vehicle;

public enum VehicleType {
    CAR("CAR"),
    BIKE("BIKE"),
    TRUCK("TRUCK");
    String value;
    VehicleType(String val) {
        this.value=val;
    }
}
