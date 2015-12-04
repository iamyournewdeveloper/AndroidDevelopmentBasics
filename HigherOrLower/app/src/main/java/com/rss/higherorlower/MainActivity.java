package com.rss.higherorlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void GenerateRandomNumber(int Max)
    {
        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(21);
    }

    public void GenerateNewRandomNumber(View view)
    {
        GenerateRandomNumber(21);
        System.out.println(randomNumber);
    }
    public void checkGuess(View view)
    {
        String sMessage = "";
        EditText guessedNumberText = (EditText)findViewById(R.id.etGuessedNumber);
        java.lang.String strNumber = guessedNumberText.getText().toString();
        System.out.println(strNumber);

        if(!strNumber.isEmpty() && strNumber != null) {
            int guessNumber = Integer.parseInt(guessedNumberText.getText().toString());

            if (guessNumber > randomNumber) {
                sMessage = "Number is higher";
            } else if (guessNumber < randomNumber) {
                sMessage = "Number is lower";
            } else {
                sMessage = "YOU GUESSED IT";
            }
        }
        else
        {
            sMessage = "Type a number.";
        }

        Toast.makeText(getApplicationContext(), sMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        GenerateRandomNumber(21);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
