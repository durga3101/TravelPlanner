package android.bootcamp.travelplanner;

public class TravelPlannerPresenter {

    private TravelPlannerView view;

    public TravelPlannerPresenter(TravelPlannerView view) {
        this.view = view;
    }

    public void calculate(String distanceString, String velocityString){
        int distance = Integer.parseInt(distanceString);
        int velocity = Integer.parseInt(velocityString);
        int time = distance/velocity;

        view.displayTime(String.valueOf(time));
        view.launchTimeActivityWithTimeParameter(String.valueOf(time));
    }

    public void capture() {
        view.launchCamera();
    }


    public void processBufferReturned(String buffer) {
        view.displayBuffer(buffer);
    }
}


