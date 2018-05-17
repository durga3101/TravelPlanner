package android.bootcamp.travelplanner.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {TravelPlan.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TravelPlanDao travelPlannerDao();
}
