package android.bootcamp.travelplanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TravelPlannerPresenterTest {

    @Mock
    private TravelPlannerView mockView;
    private TravelPlannerPresenter presenter;

    @Before
    public void setup(){
        presenter = new TravelPlannerPresenter(mockView);
    }
    @Test
    public void shouldCalculateTimeFromDistanceAndVelocityAndDisplayItOnTheView() {
        TravelPlannerPresenter presenter =  new TravelPlannerPresenter(mockView);
        presenter.calculate("50", "10");
        verify(mockView).displayTime("5");
    }

    @Test
    public void shouldCalculateTimeAndSendItToTimeActivity(){
        presenter.calculate("50", "10");
        verify(mockView).launchTimeActivityWithTimeParameter("5");
    }

    @Test
    public void shouldLaunchCameraOnClickingCapture(){
        presenter.capture();
        verify(mockView).launchCamera();

    }

}