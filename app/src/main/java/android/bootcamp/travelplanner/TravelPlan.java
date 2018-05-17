package android.bootcamp.travelplanner;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Objects;

@Entity
public class TravelPlan {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    private int distance;
    private int velocity;
    private int time;
    private int timeWithBuffer;

    public TravelPlan(int distance, int velocity, int time, int timeWithBuffer) {
        this.distance = distance;
        this.velocity = velocity;
        this.time = time;
        this.timeWithBuffer = timeWithBuffer;
    }

    public int getUid() { return uid;}
    public void setUid(int uid) {this.uid = uid;}
    public int getDistance() {return distance;}
    public void setDistance(int distance) {this.distance = distance;}
    public int getVelocity() {return velocity;}
    public void setVelocity(int velocity) {this.velocity = velocity;}
    public int getTime() {return time;}
    public void setTime(int time) { this.time = time;}
    public int getTimeWithBuffer() { return timeWithBuffer; }
    public void setTimeWithBuffer(int timeWithBuffer) { this.timeWithBuffer = timeWithBuffer; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelPlan that = (TravelPlan) o;
        return distance == that.distance &&
                velocity == that.velocity &&
                time == that.time &&
                timeWithBuffer == that.timeWithBuffer;
    }

    @Override public int hashCode() { return Objects.hash(distance, velocity, time, timeWithBuffer); }
}