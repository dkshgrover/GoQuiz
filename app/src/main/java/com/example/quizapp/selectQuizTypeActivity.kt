package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class selectQuizTypeActivity : AppCompatActivity() {
    private var userName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_quiz_questions_type)

        userName = intent.getStringExtra(Constants.USER_NAME)
        var quiz1 = findViewById<Button>(R.id.quiz1)
        var quiz2 = findViewById<Button>(R.id.quiz2)
        var quiz3 = findViewById<Button>(R.id.quiz3)
        var quiz4 = findViewById<Button>(R.id.quiz4)
        var quiz5 = findViewById<Button>(R.id.quiz5)
        var quiz6 = findViewById<Button>(R.id.quiz6)
        var quiz7 = findViewById<Button>(R.id.quiz7)
        var quiz8 = findViewById<Button>(R.id.quiz8)
        var quiz9 = findViewById<Button>(R.id.quiz9)
        var quiz10 = findViewById<Button>(R.id.quiz10)

        quiz1.setOnClickListener {
            val SELECTED_QUIZ: Int = 1
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz2.setOnClickListener {
            val SELECTED_QUIZ: Int = 2
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz3.setOnClickListener {
            val SELECTED_QUIZ: Int = 3
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz4.setOnClickListener {
            val SELECTED_QUIZ: Int = 4
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz5.setOnClickListener {
            val SELECTED_QUIZ: Int = 5
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz6.setOnClickListener {
            val SELECTED_QUIZ: Int = 6
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz7.setOnClickListener {
            val SELECTED_QUIZ: Int = 7
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz8.setOnClickListener {
            val SELECTED_QUIZ: Int = 8
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz9.setOnClickListener {
            val SELECTED_QUIZ: Int = 9
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }
        quiz10.setOnClickListener {
            val SELECTED_QUIZ: Int = 10
            val intent = Intent(this,QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.SELECTED_QUIZ ,SELECTED_QUIZ)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }


    }
}