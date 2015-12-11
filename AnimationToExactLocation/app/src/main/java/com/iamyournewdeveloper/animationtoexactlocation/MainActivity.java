package com.iamyournewdeveloper.animationtoexactlocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public void LogInfo(String strMessage) {
        Log.i("Information:", strMessage);
    }

    public void doAnimationMethod(View view) {
        EditText etX = (EditText) findViewById(R.id.etX);
        EditText etY = (EditText) findViewById(R.id.etY);

        float x = Float.parseFloat(etX.getText().toString());
        float y = Float.parseFloat(etY.getText().toString());

        TextView tvPointer = (TextView) findViewById(R.id.tvPointer);

        tvPointer.animate().translationX(x).translationY(y).setDuration(3000);

        LogInfo(Float.toString(x) + "," + Float.toString(y));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
