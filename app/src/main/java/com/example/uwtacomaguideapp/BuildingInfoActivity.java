package com.example.uwtacomaguideapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class BuildingInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button1;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_building_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name = getIntent().getStringExtra("NAME");
        String address = getIntent().getStringExtra("ADDRESS");
        String detail = getIntent().getStringExtra("DETAIL");
        String room = getIntent().getStringExtra("ROOM");
        String office = getIntent().getStringExtra("OFFICE");
        String meeting = getIntent().getStringExtra("MEETING");


        // Searches for textview ID
        TextView buildingTextView = findViewById(R.id.BuildingID);
        TextView addressTextView = findViewById(R.id.AddressID);
        TextView detailTextView = findViewById(R.id.DetailID);

        // Classrooms
        TextView spaceTextView = findViewById(R.id.SpaceID);
        TextView roomTextView = findViewById(R.id.RoomID);

        // Office
        TextView serviceTextView = findViewById(R.id.ServicesID);
        TextView serviceRoomTextView = findViewById(R.id.ServicesRoomID);

        // Meetings
        TextView meetingTextView = findViewById(R.id.MeetingID);
        TextView meetingRoomTextView = findViewById(R.id.MeetingRoomID);

        buildingTextView.setText(name);
        addressTextView.setText(address);
        detailTextView.setText(detail);
        roomTextView.setText(room);
        serviceRoomTextView.setText(office);
        meetingRoomTextView.setText(meeting);

        // Grabs text about a room and turns it into a string
        String spaceChange = buildingTextView.getText().toString();

        List<String> classroomSubstrings = Arrays.asList("Court 17", "(WPH)", "(SNO)", "(UWY)");
        List<String> officeSubstrings = Arrays.asList("(BB)", "(BHS)", "(JOY)", "(KEY)","(SCI)", "(TPS)", ("WHT)"));
        List<String> meetingSubstrings = Arrays.asList("(BB)", "(BHS)", "Court 17", "(DOU)", "(KEY)", "(MLG)", "(SNO)", "(TLB)","(WG)", "(WHT)");

        boolean containsClassroom = false;
        for (String substring : classroomSubstrings) {
            if (spaceChange.contains(substring)) {
                containsClassroom = true;
                break;
            }
        }
        boolean containsOffice = false;
        for (String substring : officeSubstrings) {
            if (spaceChange.contains(substring)) {
                containsOffice = true;
                break;
            }
        }
        boolean containsMeeting = false;
        for (String substring : meetingSubstrings) {
            if (spaceChange.contains(substring)) {
                containsMeeting = true;
                break;
            }
        }

        // Changes a text based on a building

        // Hides Classrooms Header
        if (containsClassroom) {
            spaceTextView.setVisibility(View.GONE);
            roomTextView.setVisibility(View.GONE);
        }

        // Hides Offices Header
        if (containsOffice) {
            serviceTextView.setVisibility(View.GONE);
            serviceRoomTextView.setVisibility(View.GONE);
        }

        // Hides Meetings Header
        if (containsMeeting) {
            meetingTextView.setVisibility(View.GONE);
            meetingRoomTextView.setVisibility(View.GONE);
        }


        button1 = (Button) findViewById(R.id.backBtn);
        //TextView textview3 = findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}