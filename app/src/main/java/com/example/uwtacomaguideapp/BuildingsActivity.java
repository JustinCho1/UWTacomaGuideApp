package com.example.uwtacomaguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BuildingsActivity extends AppCompatActivity implements BuildingRecyclerInterface {

    ArrayList<BuildingNames> buildingNameModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button1;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buildings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.bRecyclerView);

        setUpBuildings();

        BR_RecyclerViewAdapter adapter = new BR_RecyclerViewAdapter(this, buildingNameModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button1 = (Button) findViewById(R.id.homeBtn);
        //TextView textview3 = findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setUpBuildings(){
        String[] buildingNames = getResources().getStringArray(R.array.building_name);
        String[] buildingAddress = getResources().getStringArray(R.array.building_address);
        String[] buildingDetail = getResources().getStringArray(R.array.building_detail);
        String[] buildingRoom = getResources().getStringArray(R.array.building_room);
        String[] buildingOffice = getResources().getStringArray(R.array.building_office);
        String[] buildingMeeting = getResources().getStringArray(R.array.building_meeting);

        for (int i = 0; i< buildingNames.length; i++) {
            buildingNameModels.add(new BuildingNames(buildingNames[i], buildingAddress[i], buildingDetail[i], buildingRoom[i], buildingOffice[i], buildingMeeting[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(BuildingsActivity.this, BuildingInfoActivity.class);

        intent.putExtra("NAME", buildingNameModels.get(position).buildingName);
        intent.putExtra("ADDRESS", buildingNameModels.get(position).buildingAddress);
        intent.putExtra("DETAIL", buildingNameModels.get(position).buildingDetail);
        intent.putExtra("ROOM", buildingNameModels.get(position).buildingRoom);
        intent.putExtra("OFFICE", buildingNameModels.get(position).buildingOffice);
        intent.putExtra("MEETING", buildingNameModels.get(position).buildingMeeting);

        startActivity(intent);
    }
}