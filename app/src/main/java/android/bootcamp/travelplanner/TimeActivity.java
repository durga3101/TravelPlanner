package android.bootcamp.travelplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TimeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        TextView result = (TextView) findViewById(R.id.time);
        String time = getIntent().getStringExtra("time");
        result.setText(time);
    }

    public void timeBufferCalculate(View view) {
        TextView buffer = (EditText) findViewById(R.id.buffer);
        int bufferValue = Integer.parseInt(buffer.getText().toString());
        int time = Integer.parseInt(getIntent().getStringExtra("time"));

        Intent intent = new Intent();
        intent.putExtra("timeWithBuffer", bufferValue+time);
        setResult(RESULT_OK, intent);
        finish();
    }
}
