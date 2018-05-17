package android.bootcamp.travelplanner;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class TravelPlan {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "distance")
    private String distance;

    @ColumnInfo(name = "velocity")
    private String velocity;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "buffer")
    private String buffer;

    @ColumnInfo(name = "time_with_buffer")
    private String time_with_buffer;
}
