package com.example.allwidgetsdemo;

import android.app.SearchManager;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.allwidgetsdemo.intent.Next1Activity;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {
    Button NextActivity, EventCalender, WebSearch, WakeUp, SendMessage, PhoneCall, Email, googlemap;
    String Title,address, Location, query, Message, Show, Vibrate, PhoneNumber,Subject;
    int hour, minutes;
    long begin, end;
    Uri geoLocation;

    private void init() {
        NextActivity = findViewById(R.id.NextActivity);
        EventCalender = findViewById(R.id.EventCalender);
        WebSearch = findViewById(R.id.WebSearch);
        WakeUp = findViewById(R.id.WakeUp);
        SendMessage = findViewById(R.id.SendMessage);
        PhoneCall = findViewById(R.id.PhoneCall);
        Email = findViewById(R.id.Email);
        googlemap = findViewById(R.id.googlemap);
        NextActivity.setOnClickListener(this);
        EventCalender.setOnClickListener(this);
        WebSearch.setOnClickListener(this);
        WakeUp.setOnClickListener(this);
        SendMessage.setOnClickListener(this);
        PhoneCall.setOnClickListener(this);
        Email.setOnClickListener(this);
        googlemap.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        init();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.NextActivity:
                Intent intent = new Intent(IntentActivity.this, Next1Activity.class);
                intent.putExtra("PUBG", " Chicken Dinner");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;

            case R.id.EventCalender:
                Intent calender = new Intent(Intent.ACTION_INSERT);
                calender.setData(CalendarContract.Events.CONTENT_URI);
                calender.putExtra(CalendarContract.Events.TITLE, Title);
                calender.putExtra(CalendarContract.Events.EVENT_LOCATION, Location);
                calender.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin);
                calender.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
                if (calender.resolveActivity(getPackageManager()) != null) {
                    startActivity(calender);
                }
                break;

            case R.id.WebSearch:
                Intent websearch = new Intent(Intent.ACTION_WEB_SEARCH);
                websearch.putExtra(SearchManager.QUERY, query);
                if (websearch.resolveActivity(getPackageManager()) != null) {
                    startActivity(websearch);
                }
                break;

            case R.id.WakeUp:
                Intent wakeup = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM)
                        .putExtra(android.provider.AlarmClock.EXTRA_MESSAGE, Message)
                        .putExtra(android.provider.AlarmClock.EXTRA_HOUR, hour)
                        .putExtra(android.provider.AlarmClock.EXTRA_MINUTES, minutes);
                if (wakeup.resolveActivity(getPackageManager()) != null) {
                    startActivity(wakeup);
                } else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.SendMessage:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Life of an Entrepreneur");
                sendIntent.setType("text/plain");
                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
                break;

            case R.id.PhoneCall:
                Intent phoneCall = new Intent(Intent.ACTION_DIAL);
                phoneCall.setData(Uri.parse("tel :"+ PhoneNumber));
                if (phoneCall.resolveActivity(getPackageManager()) !=null)
                {
                    startActivity(phoneCall);
                }break;

            case R.id.Email:
                Intent mail = new Intent(Intent.ACTION_SENDTO);
                mail.setData(Uri.parse("mailto:"));
                mail.putExtra(mail.EXTRA_EMAIL,address);
                mail.putExtra(mail.EXTRA_SUBJECT,Subject);
                if(mail.resolveActivity(getPackageManager()) != null)
            {
                startActivity(mail);
            }break;

            case R.id.googlemap :
                Intent map = new Intent(Intent.ACTION_VIEW);
                map.setData(geoLocation);
                if (map.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(map);
                }break;

        }
    }
}
