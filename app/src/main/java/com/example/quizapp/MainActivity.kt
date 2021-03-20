package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var btnStart = findViewById<Button>(R.id.startBtn)
        btnStart.setOnClickListener {
            var tv_Name = findViewById<TextView>(R.id.tv_Name)
            if(tv_Name.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter your name!",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,selectQuizTypeActivity::class.java)
                intent.putExtra(Constants.USER_NAME, tv_Name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}