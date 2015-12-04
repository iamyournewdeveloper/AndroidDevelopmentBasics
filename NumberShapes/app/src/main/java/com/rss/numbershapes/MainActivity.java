package com.rss.numbershapes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number
    {
        int number;

        public boolean isSquare()
        {
            double squareRoot = Math.sqrt(number);
            return squareRoot == Math.floor(squareRoot);
        }

        public boolean isTriangular()
        {
            int x = 1;

            int triangularNumber = 1;

            while(triangularNumber < number)
            {
                x++;
                triangularNumber+= x;

            }
            return triangularNumber== number;
        }
    }

    public void testNumber(View view)
    {
        EditText usersNumber = (EditText)findViewById(R.id.etUserNumber);
        String sMessage = "";
        if(!usersNumber.getText().toString().isEmpty() && usersNumber.getText().toString() != null) {

            Number myNumber = new Number();


            myNumber.number = Integer.parseInt(usersNumber.getText().toString());

            if(myNumber.isSquare()) {
                if (myNumber.isTriangular()) {
                    sMessage = myNumber.number + " is both a triangular and a square number.";
                }
                else {
                    sMessage =  myNumber.number + " is a square number.";
                }
            }
            else if(myNumber.isTriangular())
            {
                    sMessage = myNumber.number + " is a triangular number.";
            }
            else
            {
                sMessage = myNumber.number + " is neither a triangular or a square number";
            }
        }
        else
        {
            sMessage = "Please enter some number to check.";
        }
        System.out.println(sMessage);
        Toast.makeText(getApplicationContext(), sMessage, Toast.LENGTH_LONG).show();
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
