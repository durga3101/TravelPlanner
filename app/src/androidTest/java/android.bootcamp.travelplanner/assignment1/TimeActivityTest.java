package android.bootcamp.travelplanner.assignment1;

import android.bootcamp.travelplanner.TimeActivity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class TimeActivityTest {

    @Rule
    public android.support.test.rule.ActivityTestRule<TimeActivity> activityTestRule =
            new ActivityTestRule<>(TimeActivity.class);

    @Test
    public void displayTimeBuffer() {
        onView(withId(android.bootcamp.travelplanner.R.id.buffer)).perform(typeText("333"));
        onView(withId(android.bootcamp.travelplanner.R.id.timeBufferCalculate)).perform(click());
    }
}