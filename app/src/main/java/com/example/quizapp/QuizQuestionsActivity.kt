package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity() {

    private var questionsList = ArrayList<Question>()
    private var currentPosition: Int = 1
    private var selectedOption: Int = 0
    private var nextQuestion: Boolean = false
    private var correctAnswers: Int = 0
    private var userName: String? = null

    lateinit var tvQuestionId: TextView
    lateinit var progressBar: ProgressBar
    lateinit var tv_progressBar: TextView
    lateinit var op1: TextView
    lateinit var op2: TextView
    lateinit var op3: TextView
    lateinit var op4: TextView
    lateinit var img: AppCompatImageView
    lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        userName = intent.getStringExtra(Constants.USER_NAME)
        tvQuestionId = findViewById<TextView>(R.id.tvQuestionId)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        tv_progressBar = findViewById<TextView>(R.id.tvProgress)
        op1 = findViewById<TextView>(R.id.op1)
        op2 = findViewById<TextView>(R.id.op2)
        op3 = findViewById<TextView>(R.id.op3)
        op4 = findViewById<TextView>(R.id.op4)
        img = findViewById<AppCompatImageView>(R.id.sportImage)
        submitBtn = findViewById<Button>(R.id.submitBtn)

        val SELECTED_QUIZ = intent.getIntExtra(Constants.SELECTED_QUIZ,0)
        if(SELECTED_QUIZ == 1){
            questionsList = Constants.getQuestionsQuiz1()
        }else if (SELECTED_QUIZ == 2){
            questionsList = Constants.getQuestionsQuiz2()
        }else if (SELECTED_QUIZ == 3){
            questionsList = Constants.getQuestionsQuiz3()
        }else if (SELECTED_QUIZ == 4){
            questionsList = Constants.getQuestionsQuiz4()
        }else if (SELECTED_QUIZ == 5){
            questionsList = Constants.getQuestionsQuiz5()
        }else if (SELECTED_QUIZ == 6){
            questionsList = Constants.getQuestionsQuiz6()
        }else if (SELECTED_QUIZ == 7){
            questionsList = Constants.getQuestionsQuiz7()
        }else if (SELECTED_QUIZ == 8){
            questionsList = Constants.getQuestionsQuiz8()
        }else if (SELECTED_QUIZ == 9){
            questionsList = Constants.getQuestionsQuiz9()
        }else if (SELECTED_QUIZ == 10){
            questionsList = Constants.getQuestionsQuiz10()
        }

        setQuestion()

        op1.setOnClickListener {
            if (!nextQuestion)
                selectedOptionsView(op1, 1)
        }
        op2.setOnClickListener {
            if (!nextQuestion)
                selectedOptionsView(op2, 2)
        }
        op3.setOnClickListener {
            if (!nextQuestion)
                selectedOptionsView(op3, 3)
        }
        op4.setOnClickListener {
            if (!nextQuestion)
                selectedOptionsView(op4, 4)
        }
        submitBtn.setOnClickListener {
            if (nextQuestion) {
                when {
                    currentPosition <= questionsList.size -> {
                        setQuestion()
                    }
                }
            } else if (selectedOption == 0) {
                Toast.makeText(this, "Select an option first!", Toast.LENGTH_SHORT).show()
            } else {
                var question = questionsList.get(currentPosition - 1)
                if (selectedOption != question.ans) {
                    answerView(selectedOption, R.drawable.wronganswer)
                } else {
                    correctAnswers++
                }
                answerView(question.ans, R.drawable.correctanswer)
                if (currentPosition == questionsList.size) {
                    var intent = Intent(this, FinalActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, userName)
                    intent.putExtra(Constants.TOTAL_QUESTIONS, (questionsList!!.size))
                    intent.putExtra(Constants.CORRECT_ANS, correctAnswers)
                    startActivity(intent)
                    finish()
                } else {
                    nextQuestion = true
                    submitBtn.text = "GO TO NEXT QUESTION"
                }
                currentPosition++
            }
        }
    }

    private fun setQuestion() {
        if (currentPosition != questionsList.size) {
            selectedOption = 0
            nextQuestion = false
            submitBtn.text = "SUBMIT"
        } else {
            selectedOption = 0
            nextQuestion = false
            submitBtn.text = "FINISH"
        }
        defaultOptionsView()
        var ques = questionsList[currentPosition - 1]

        progressBar.progress = currentPosition
        tv_progressBar.text = "${currentPosition}/10"
        tvQuestionId.text = ques.question

        op1.text = ques.op1
        op2.text = ques.op2
        op3.text = ques.op3
        op4.text = ques.op4
        img.setImageResource(ques.img)
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, op1)
        options.add(1, op2)
        options.add(2, op3)
        options.add(3, op4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#A9A9A9"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.defaultborder_bg)
        }
    }

    private fun selectedOptionsView(tv: TextView, selectedOp: Int) {
        defaultOptionsView()
        selectedOption = selectedOp
        tv.setTextColor(Color.parseColor("#000000"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this, R.drawable.selectedborder_bg)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                op1.background = ContextCompat.getDrawable(this, drawableView)
                op1.typeface = Typeface.DEFAULT_BOLD
            }
            2 -> {
                op2.background = ContextCompat.getDrawable(this, drawableView)
                op2.typeface = Typeface.DEFAULT_BOLD
            }
            3 -> {
                op3.background = ContextCompat.getDrawable(this, drawableView)
                op3.typeface = Typeface.DEFAULT_BOLD
            }
            4 -> {
                op4.background = ContextCompat.getDrawable(this, drawableView)
                op4.typeface = Typeface.DEFAULT_BOLD
            }
        }
    }
}