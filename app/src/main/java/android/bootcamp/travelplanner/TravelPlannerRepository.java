package android.bootcamp.travelplanner;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

class TravelPlannerRepository {
    private final TravelPlannerDatabase db;

    public TravelPlannerRepository(Context applicationContext) {

        db = Room.databaseBuilder(applicationContext,
                TravelPlannerDatabase.class, "travelplanner").allowMainThreadQueries().build();
    }

    public void savePlan(TravelPlan travelPlan) {


        db.travelPlanDao().insertAll(travelPlan);

        List<TravelPlan> travelPlanList =  db.travelPlanDao().getAll();
        System.out.println("******************" + travelPlanList.get(travelPlanList.size()-1).getDistance());
        System.out.println("******************" + travelPlanList.get(travelPlanList.size()-1).getVelocity());
        System.out.println("******************" + travelPlanList.get(travelPlanList.size()-1).getTime());
        System.out.println("******************" + travelPlanList.get(travelPlanList.size()-1).getTimeWithBuffer());
    }
}
