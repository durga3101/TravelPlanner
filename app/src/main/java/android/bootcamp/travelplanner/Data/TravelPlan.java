package android.bootcamp.travelplanner.Data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "travel_plan")
public class TravelPlan {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "distance")
    private String distance;

    @ColumnInfo(name = "velocity")
    private String velocity;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "buffer")
    private String buffer;

    @ColumnInfo(name = "time_with_buffer")
    private String timeWithBuffer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public String getTimeWithBuffer() {
        return timeWithBuffer;
    }

    public void setTimeWithBuffer(String timeWithBuffer) {
        this.timeWithBuffer = timeWithBuffer;
    }
}
