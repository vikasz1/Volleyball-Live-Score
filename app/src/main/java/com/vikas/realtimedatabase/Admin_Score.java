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

public class Admin_Score extends AppCompatActivity {
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_admin);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        DatabaseReference team1score = database.getReference("team1");
//        DatabaseReference team2score = database.getReference("team2");



        TextView team1Score = findViewById(R.id.team1score);
        TextView team2Score = findViewById(R.id.team2score);
        TextView matchtext = findViewById(R.id.matchnotext);
        TextView setstext = findViewById(R.id.setnotext);
        TextView team1text = findViewById(R.id.team1text);
        TextView team2text = findViewById(R.id.team2text);


        TextView team1SetWon = findViewById(R.id.team1SetWon);
        TextView team2setWon = findViewById(R.id.team2setWon);

        Button team1Plus = findViewById(R.id.team1plus);
        Button team2Plus = findViewById(R.id.team2plus);
        Button team1Minus = findViewById(R.id.team1minus);
        Button team2Minus = findViewById(R.id.team2minus);

        Button matchplus = findViewById(R.id.matchplus);
        Button matchminus = findViewById(R.id.matchminus);
        Button setnoplus = findViewById(R.id.setnoplus);
        Button setnominus = findViewById(R.id.setnominus);

        Button swbtn1Plus = findViewById(R.id.setWonTeam1Plus);
        Button swbtn1Minus = findViewById(R.id.setWonTeam1Minus);
        Button swbtn2Plus = findViewById(R.id.setWonTeam2Plus);
        Button swbtn2Minus = findViewById(R.id.setWonTeam2Minus);
        Button updatetoFirebase = findViewById(R.id.updateFire);

        // String match = "x",set1,set2,set3;
        String match = matchtext.getText().toString();
        String currentMatch = "Match"+ match;
        Toast.makeText(Admin_Score.this, currentMatch, Toast.LENGTH_LONG).show();


        //Reading and Updating score before before everything

        mDatabase.child(currentMatch).child("Team1Score").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team1Score.setText(result);
                }
            }
        });
        mDatabase.child(currentMatch).child("Team2Score").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team2Score.setText(result);
                }
            }
        });
        mDatabase.child(currentMatch).child("Team1Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team1text.setText(result);
                }
            }
        });
        mDatabase.child(currentMatch).child("Team2Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team2text.setText(result);
                }
            }
        });
        mDatabase.child(currentMatch).child("CurrentSetNumber").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    setstext.setText(result);
                }
            }
        });
        mDatabase.child(currentMatch).child("SetWonByTeam1").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team1SetWon.setText(result);
                }
            }
        });
        mDatabase.child(currentMatch).child("SetWonByTeam2").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    String result = String.valueOf(task.getResult().getValue());
                    team2setWon.setText(result);
                }
            }
        });




        //team
        team1Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team1Score.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score+1;
                team1Score.setText(String.valueOf(UpdatedScore));
//                Toast.makeText(Score_Display.this,""+UpdatedScore,Toast.LENGTH_SHORT).show();
            }
        });

        team2Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team2Score.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score+1;
                team2Score.setText(String.valueOf(UpdatedScore));
            }
        });

        team2Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team2Score.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score+1;
                team2Score.setText(String.valueOf(UpdatedScore));
            }
        });

        team1Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team1Score.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score-1;
                if(score<1){
                    Toast.makeText(Admin_Score.this, "Score can not go below 0", Toast.LENGTH_SHORT).show();
                }
                else{
                team1Score.setText(String.valueOf(UpdatedScore));
                    }

            }
        });

        team2Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team2Score.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score-1;
                if(score<1){
                    score = 0;
                    Toast.makeText(Admin_Score.this, "Score can not go below 0", Toast.LENGTH_SHORT).show();
                }
                else{
                team2Score.setText(String.valueOf(UpdatedScore));
                }
            }
        });


        //match
        matchplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = matchtext.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score+1;
                matchtext.setText(String.valueOf(UpdatedScore));

            }
        });

        matchminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = matchtext.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score-1;
                if(score<1){
                    score = 0;
                    Toast.makeText(Admin_Score.this, "Score can not go below 0", Toast.LENGTH_SHORT).show();
                }
                else{
                    matchtext.setText(String.valueOf(UpdatedScore));
                }

            }
        });

        //set number
        setnoplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = setstext.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score+1;
                setstext.setText(String.valueOf(UpdatedScore));
            }
        });

        setnominus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = setstext.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score-1;
                if(score<1){
                    score = 0;
                    Toast.makeText(Admin_Score.this, "Score can not go below 0", Toast.LENGTH_SHORT).show();
                }
                else{
                setstext.setText(String.valueOf(UpdatedScore));
                }
            }
        });

        swbtn1Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team1SetWon.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score+1;
                team1SetWon.setText(String.valueOf(UpdatedScore));
            }
        });

        //set won by each team
        swbtn1Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team1SetWon.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score-1;
                if(score<1){
                    score = 0;
                    Toast.makeText(Admin_Score.this, "Score can not go below 0", Toast.LENGTH_SHORT).show();
                }
                else{
                    team1SetWon.setText(String.valueOf(UpdatedScore));
                }
            }
        });

        swbtn2Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team2setWon.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score+1;
                team2setWon.setText(String.valueOf(UpdatedScore));
            }
        });

        swbtn2Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = team2setWon.getText().toString();
                int score  = Integer.parseInt(string);
                int UpdatedScore = score-1;
                if(score<1){
                    score = 0;
                    Toast.makeText(Admin_Score.this, "Score can not go below 0", Toast.LENGTH_SHORT).show();
                }
                else{
                    team2setWon.setText(String.valueOf(UpdatedScore));
                }
            }
        });



        updatetoFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String match = "x",set1,set2,set3;
                String match = matchtext.getText().toString();
                String currentMatch = "Match"+ match;
                Toast.makeText(Admin_Score.this, currentMatch, Toast.LENGTH_LONG).show();

                //Getting reference from firebase
                DatabaseReference team1name = database.getReference().child(currentMatch).child("Team1Name");
                DatabaseReference team2name = database.getReference().child(currentMatch).child("Team2Name");
                DatabaseReference team1score = database.getReference().child(currentMatch).child("Team1Score");
                DatabaseReference team2score = database.getReference().child(currentMatch).child("Team2Score");
                DatabaseReference setnumber = database.getReference().child(currentMatch).child("CurrentSetNumber");
                DatabaseReference setwon1 = database.getReference().child(currentMatch).child("SetWonByTeam1");
                DatabaseReference setwon2 = database.getReference().child(currentMatch).child("SetWonByTeam2");

                //Getting values from the views
                String score1 = team1Score.getText().toString();
                String score2 = team2Score.getText().toString();
                String set = setstext.getText().toString();
                String setwonteam1 = team1SetWon.getText().toString();
                String setwonteam2 = team2setWon.getText().toString();

//                assigning firebase variable to values of given views
                //pushing data to firebase
                team1score.setValue(score1);
                team2score.setValue(score2);
                setnumber.setValue(set);
                setwon1.setValue(setwonteam1);
                setwon2.setValue(setwonteam2);



//                myRef.setValue("volleyBall");
//                team1.setValue(score1);
//                team2.setValue(score2);


                Toast.makeText(Admin_Score.this, "Updated", Toast.LENGTH_SHORT).show();

            }
        });


    }
}