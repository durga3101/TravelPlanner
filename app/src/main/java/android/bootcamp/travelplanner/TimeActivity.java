package android.bootcamp.travelplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TimeActivity extends Activity {

    public static final String TIME_WITH_BUFFER = "TIME_WITH_BUFFER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        TextView timeTextView = (TextView) findViewById(R.id.time_new_activity);
        timeTextView.setText((getIntent().getStringExtra("time")));
    }

    public void calculateWithBuffer(View view) {
        TextView timeTextView = (TextView) findViewById(R.id.time_new_activity);
        TextView bufferTextView = (TextView) findViewById(R.id.buffer);
        int timeWithBuffer = Integer.parseInt(timeTextView.getText().toString()) +
                             Integer.parseInt(bufferTextView.getText().toString());

        Intent resultIntent = new Intent();
        resultIntent.putExtra(this.TIME_WITH_BUFFER, String.valueOf(timeWithBuffer));
        setResult(RESULT_OK, resultIntent);
        finish();

    }
}
