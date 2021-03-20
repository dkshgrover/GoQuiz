package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    private var uname: String? = ""
    private var correctAnswers: Int = 0
    private var totalQuestions: Int = 0

    lateinit var tvUsername: TextView
    lateinit var tvScore: TextView
    lateinit var endBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        tvUsername = findViewById<TextView>(R.id.tvUserName)
        tvScore = findViewById<TextView>(R.id.tvScore)
        endBtn = findViewById<Button>(R.id.endButton)

        uname = intent.getStringExtra(Constants.USER_NAME)
        tvUsername.text = uname
        correctAnswers = intent.getIntExtra(Constants.CORRECT_ANS,0)
        totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        tvScore.text = "Your Score is ${correctAnswers}/${totalQuestions}"

        endBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}