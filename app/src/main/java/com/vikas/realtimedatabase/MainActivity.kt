package com.vikas.realtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var button:   Button = findViewById(R.id.btnlg)
        var guest: Button = findViewById(R.id.guest)
        var username: EditText = findViewById(R.id.username)
        var password: EditText = findViewById(R.id.password)


        button.setOnClickListener{

            var passwordText = password.text.toString()
            var usernameText = username.text.toString()

            if (usernameText.isBlank() || passwordText.isBlank()){
                val toast = Toast.makeText(this, "Username/Password are blank", Toast.LENGTH_LONG)
                toast.show()
            }
            else if(usernameText.equals("biet") && passwordText.equals("kalua")){
                val intent = Intent(this, Admin_Score::class.java)
                startActivity(intent)
            }
            else{
                val toast = Toast.makeText(this, "Please enter a valid Username and Password", Toast.LENGTH_LONG)
                toast.show()
            }

        }
        guest.setOnClickListener{
            val intent = Intent(this, Event_Display::class.java)
            startActivity(intent)
        }



    }

    }
