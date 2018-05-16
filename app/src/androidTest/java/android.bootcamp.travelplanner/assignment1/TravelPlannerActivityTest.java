package android.bootcamp.travelplanner.assignment1;


import android.app.Activity;
import android.app.Instrumentation;
import android.bootcamp.travelplanner.R;
import android.bootcamp.travelplanner.TravelPlannerActivity;
import android.bootcamp.travelplanner.assignment1.matchers.DrawableMatcher;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class TravelPlannerActivityTest {

    @Rule
    public android.support.test.rule.ActivityTestRule<TravelPlannerActivity> activityTestRule =
            new IntentsTestRule<>(TravelPlannerActivity.class);

    @Test
    public void calculateTimeTakenByDividingDistanceByVelocity() {
        onView(withId(android.bootcamp.travelplanner.R.id.distance)).perform(typeText("333"));
        onView(withId(android.bootcamp.travelplanner.R.id.velocity)).perform(typeText("10"));

        onView(withId(android.bootcamp.travelplanner.R.id.calculate)).perform(click());
        onView(withId(R.id.time)).check(matches(withText(("33"))));

        onView(withId(R.id.buffer)).perform(typeText("10"));
        onView(withId(R.id.timeBufferCalculate)).perform(click());

        onView(withId(R.id.timeWithBuffer)).check(matches(withText(("43"))));
    }

    @Test
    public void openCamera() {
        Bitmap icon = BitmapFactory.decodeResource(
                InstrumentationRegistry.getTargetContext().getResources(),
                R.mipmap.ic_launcher);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra("data", icon);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(2, intent);

        intending(hasAction(MediaStore.ACTION_IMAGE_CAPTURE)).respondWith(result);

        onView(withId(R.id.captureImage)).perform(click());

        onView(withId(R.id.imageView)).check(matches(new DrawableMatcher(R.mipmap.ic_launcher)));
    }

}