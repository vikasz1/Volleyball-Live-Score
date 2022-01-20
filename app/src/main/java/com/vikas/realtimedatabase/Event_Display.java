package com.vikas.realtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Event_Display extends AppCompatActivity {
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_display);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        TextView team1 = findViewById(R.id.teams1publicName);
        TextView team2 = findViewById(R.id.teams2publicName);
        TextView status = findViewById(R.id.matchStatus);
        TextView timing = findViewById(R.id.timingText);


        mDatabase.child("Match1").child("liveStatus").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    status.setText("Match status: "+result);
                }
            }
        });
        mDatabase.child("Match1").child("Timing").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    timing.setText("Timing: "+result);
                }
            }
        });
        mDatabase.child("Match1").child("Team1Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String resultTeamName1 = String.valueOf(task.getResult().getValue());
                    team1.setText(resultTeamName1+"\nVS");
                }
            }
        });
        mDatabase.child("Match1").child("Team2Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String resultTeamName2 = String.valueOf(task.getResult().getValue());
                    team2.setText(resultTeamName2);
//                    Toast.makeText(Event_Display.this, resultTeamName2, Toast.LENGTH_SHORT).show();
                }
            }
        });


        CardView event1 = findViewById(R.id.event1Card1);

        event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Event_Display.this,Public_Score.class);
                intent.putExtra("MatchSerial", "Match1");
                startActivity(intent);
            }
        });

    }
}