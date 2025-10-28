package LowLevelDesign.RideSharingSystem.Service;

import LowLevelDesign.RideSharingSystem.Entity.Rider.Rider;

import java.util.HashMap;
import java.util.Map;

public class Riderservice {
    Map<String, Rider> riders;

    public  Riderservice(){
        riders=new HashMap<>();
    }

    //register Rider

    public  Rider registerRider(String name,String contact){
        Rider rider=new Rider(name,contact);
        if(riders.containsKey(rider)){
            System.out.println("rider already present/registered");
        }
        riders.put(rider.getId(),rider);
        return  rider;
    }


    public  Rider getRider(String id){
        if(!riders.containsKey(id)){
            System.out.println("rider not registerd,Please Register");
        }

        return  riders.get(id);
    }
}
