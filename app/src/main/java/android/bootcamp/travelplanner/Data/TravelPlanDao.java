package android.bootcamp.travelplanner.Data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TravelPlanDao {
    @Query("SELECT * FROM travel_plan")
    List<TravelPlan> getAll();

    @Insert
    public void insert(TravelPlan travelPlans);
}
