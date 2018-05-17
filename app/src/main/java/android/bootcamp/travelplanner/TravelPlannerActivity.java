package android.bootcamp.travelplanner;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.bootcamp.travelplanner.Data.AppDatabase;
import android.bootcamp.travelplanner.Data.TravelPlan;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class TravelPlannerActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_travel_planner);
  }

  public void calculate(View view) {

    TextView distance = (EditText) findViewById(R.id.distance);
    int distanceValue = Integer.parseInt(distance.getText().toString());

    TextView velocity = (EditText) findViewById(R.id.velocity);
    int velocityValue = Integer.parseInt(velocity.getText().toString());

    String time = String.valueOf(distanceValue / velocityValue);

    Intent sendTime = new Intent(this, TimeActivity.class);
    sendTime.putExtra("time", time);
    startActivityForResult(sendTime, 1);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   switch (requestCode) {
     case 1: {
       if(data != null) {
         int timeWithBuffer = data.getIntExtra("timeWithBuffer", -1);

         TextView totalTimeView = (TextView) findViewById(R.id.timeWithBuffer);
         totalTimeView.setText(String.valueOf(timeWithBuffer));
       }
       break;
     }
     case 2: {
       if(data != null) {
         displayImage(data);
       }
       break;
     }
     default:
       break;
    }

  }

  private void displayImage(Intent data) {
    ImageView imageView = (ImageView) findViewById(R.id.imageView);
    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
    imageView.setImageBitmap(thumbnail);
  }

  public void captureImage(View view) {
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(intent, 2);
  }


  public void saveData(View view) {
    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
            AppDatabase.class, "travel_plan").allowMainThreadQueries().build();

    TravelPlan travelPlan = new TravelPlan();
    travelPlan.setDistance("1");
    travelPlan.setVelocity("1");
    travelPlan.setTime("1");
    travelPlan.setBuffer("1");
    travelPlan.setTimeWithBuffer("1");

    db.travelPlannerDao().insert(travelPlan);

    List<TravelPlan> all = db.travelPlannerDao().getAll();
    for(TravelPlan travelPlan1: all) {
      System.out.println("=======================");
      System.out.println(travelPlan1.getDistance());
      System.out.println("=======================");
    }
  }
}
