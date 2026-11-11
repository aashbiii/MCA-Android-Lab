package com.example.communicationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber, smsMessage;
    EditText email, subject, emailMessage;
    EditText callNumber;

    Button sendSmsButton, sendEmailButton, makeCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.phoneNumber);
        smsMessage = findViewById(R.id.smsMessage);

        email = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        emailMessage = findViewById(R.id.emailMessage);

        callNumber = findViewById(R.id.callNumber);

        sendSmsButton = findViewById(R.id.sendSmsButton);
        sendEmailButton = findViewById(R.id.sendEmailButton);
        makeCallButton = findViewById(R.id.makeCallButton);
    }

    public void showSMS(View view) {

        hideAll();

        phoneNumber.setVisibility(View.VISIBLE);
        smsMessage.setVisibility(View.VISIBLE);
        sendSmsButton.setVisibility(View.VISIBLE);
    }

    public void showEmail(View view) {

        hideAll();

        email.setVisibility(View.VISIBLE);
        subject.setVisibility(View.VISIBLE);
        emailMessage.setVisibility(View.VISIBLE);
        sendEmailButton.setVisibility(View.VISIBLE);
    }

    public void showCall(View view) {

        hideAll();

        callNumber.setVisibility(View.VISIBLE);
        makeCallButton.setVisibility(View.VISIBLE);
    }

    public void hideAll() {

        phoneNumber.setVisibility(View.GONE);
        smsMessage.setVisibility(View.GONE);
        sendSmsButton.setVisibility(View.GONE);

        email.setVisibility(View.GONE);
        subject.setVisibility(View.GONE);
        emailMessage.setVisibility(View.GONE);
        sendEmailButton.setVisibility(View.GONE);

        callNumber.setVisibility(View.GONE);
        makeCallButton.setVisibility(View.GONE);
    }

    public void sendSMS(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" +
                phoneNumber.getText().toString()));
        intent.putExtra("sms_body",
                smsMessage.getText().toString());

        startActivity(intent);
    }

    public void sendEmail(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" +
                email.getText().toString()));

        intent.putExtra(Intent.EXTRA_SUBJECT,
                subject.getText().toString());

        intent.putExtra(Intent.EXTRA_TEXT,
                emailMessage.getText().toString());

        startActivity(intent);
    }

    public void makeCall(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" +
                callNumber.getText().toString()));

        startActivity(intent);
    }
}