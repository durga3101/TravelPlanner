package android.bootcamp.travelplanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TravelPlannerPresenterTest {

    @Mock
    private TravelPlannerView mockView;
    private TravelPlannerPresenter presenter;
    @Mock
    private TravelPlannerRepository repository;

    @Before
    public void setup(){
        presenter = new TravelPlannerPresenter(mockView, repository);
    }
    @Test
    public void shouldCalculateTimeFromDistanceAndVelocityAndDisplayItOnTheView() {
        TravelPlannerPresenter presenter =  new TravelPlannerPresenter(mockView, repository);
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

    @Test
    public void displayBufferOnBeingReturnedFromTimeActivity(){
        presenter.processBufferReturned("30");
        verify(mockView).displayBuffer("30");
    }

    @Test
    public void saveToRepositoryOnClickingSave(){
        presenter.save("10", "3", "3", "6");
        verify(repository).savePlan(new TravelPlan(10, 3, 3, 6));

    }

}