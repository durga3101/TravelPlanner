package android.bootcamp.travelplanner;

import static java.lang.Integer.parseInt;

public class TravelPlannerPresenter {

    private TravelPlannerView view;
    private TravelPlannerRepository repository;

    public TravelPlannerPresenter(TravelPlannerView view, TravelPlannerRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void calculate(String distanceString, String velocityString){
        int distance = parseInt(distanceString);
        int velocity = parseInt(velocityString);
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

    public void save(String distance, String velocity, String time, String timeWithBuffer) {
        repository.savePlan(new TravelPlan(parseInt(distance), parseInt(velocity), parseInt(time), parseInt(timeWithBuffer)));
    }
}


