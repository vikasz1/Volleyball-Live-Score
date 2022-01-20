package com.vikas.realtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Public_Score extends AppCompatActivity {
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_score);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        Button refresh = findViewById(R.id.refresh_public);

        TextView teamname1 = findViewById(R.id.Team1Name);
        TextView teamset1 = findViewById(R.id.team1Name);
        TextView teamset2 = findViewById(R.id.team2Name);


        TextView teamname2 = findViewById(R.id.Team2Name);
        TextView team1wonset = findViewById(R.id.team1wonpublic);
        TextView team2wonset = findViewById(R.id.team2wonpublic);
        TextView setnumberPublic = findViewById(R.id.setnumberPublic);

        // Getting current match from previous intent
        String currentmatch = getIntent().getExtras().getString("MatchSerial","defaultkey");
        Toast.makeText(Public_Score.this, currentmatch, Toast.LENGTH_SHORT).show();

        TextView team1score = findViewById(R.id.Team1scorepublic);
        TextView team2score = findViewById(R.id.Team2scorepublic);

        //Reading and updating the data in the activity
        mDatabase.child(currentmatch).child("Team1Score").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team1score.setText(result);
                }
            }
        });
        mDatabase.child(currentmatch).child("Team2Score").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team2score.setText(result);
                }
            }
        });
        mDatabase.child(currentmatch).child("Team1Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    teamname1.setText(result);
                    teamset1.setText(result);
                }
            }
        });
        mDatabase.child(currentmatch).child("Team2Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    teamname2.setText(result);
                    teamset2.setText(result);
                }
            }
        });
        mDatabase.child(currentmatch).child("CurrentSetNumber").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    setnumberPublic.setText("Set No."+result);
                }
            }
        });
        mDatabase.child(currentmatch).child("SetWonByTeam1").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team1wonset.setText(result);
                }
            }
        });
        mDatabase.child(currentmatch).child("SetWonByTeam2").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team2wonset.setText(result);
                }
            }
        });



        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });



    }
}