package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendInfo(View v) {
// getting a reference to my edit text fields
        EditText myName = (EditText) findViewById(R.id.myName);
        EditText myAge = (EditText) findViewById(R.id.myAge);
// extracting the text from those edit text fields
        String myNameStr = myName.getText().toString();
        String myAgeStr = myAge.getText().toString();
// Creating the intent object so I can send data
        Intent intent = new Intent(this, InfoActivity.class);
// putting data from edit text fields into intent to send to other activity
// MY_Name and MY_AGE are public constants in InfoActivity class
        intent.putExtra(InfoActivity.MY_NAME, myNameStr);
        intent.putExtra(InfoActivity.MY_AGE, myAgeStr);
// loads the next activity
        startActivity(intent);
    }

    public void shareInfo(View v) {
// getting a reference to my edit text fields
        EditText myName = (EditText) findViewById(R.id.myName);
        EditText myAge = (EditText) findViewById(R.id.myAge);
// extracting the text from those edit text fields
        String myNameStr = myName.getText().toString();
        String myAgeStr = myAge.getText().toString();
        String myMessage = "My name is " + myNameStr + " and I am " + myAgeStr + " years old.";
// These three lines can send the image to any app through any app that sends messages
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, myMessage);
// declare the title for when pulling up all the apps
        String chooserTitle = getString(R.string.chooser);
// the createChooser method will select all the apps that are able to send messages
// and will list them along with the title specified above. Whichever one you select
// is returned, and then that activity is launched with the info passed.
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}
