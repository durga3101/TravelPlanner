package android.bootcamp.travelplanner;

public interface TravelPlannerView {

    void displayTime(String time);

    void launchTimeActivityWithTimeParameter(String time);

    void launchCamera();
}
