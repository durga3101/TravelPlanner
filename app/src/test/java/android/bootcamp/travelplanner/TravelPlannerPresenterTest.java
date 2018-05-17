package android.bootcamp.travelplanner;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TravelPlannerPresenterTest {

    @Test
    public void shouldCalculateTimeFromDistanceAndVelocityAndDisplayItOnTheView() {
        TravelPlannerView mockView = mock(TravelPlannerView.class);
        TravelPlannerPresenter presenter =  new TravelPlannerPresenter(mockView);
        presenter.calculate("50", "10");
        verify(mockView).displayTime("5");
    }

    @Test
    public void shouldCalculateTimeAndSendItToTimeActivity(){
        TravelPlannerView mockView = mock(TravelPlannerView.class);
        TravelPlannerPresenter presenter =  new TravelPlannerPresenter(mockView);
        presenter.calculate("50", "10");
        verify(mockView).launchTimeActivityWithTimeParameter("5");
    }

}