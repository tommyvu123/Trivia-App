package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //Variables for buttons
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button
    private lateinit var questionTextView: TextView

    //List of questions stored in a list
    private val questionBank = listOf(
        Question(R.string.question_olympics, true),
        Question(R.string.question_boxing, true),
        Question(R.string.question_planet, true),
        Question(R.string.question_phone, true),
        Question(R.string.question_heart, false),
        Question(R.string.question_nike, false),
        Question(R.string.question_book, true),
        Question(R.string.question_president, true),
        Question(R.string.question_octopus, true),
        Question(R.string.question_goldfish, false),
        Question(R.string.question_dolphins, true),
        Question(R.string.question_oxford, true),
        Question(R.string.question_broccoli, true),
        Question(R.string.question_beer, false),
        Question(R.string.question_japan, true),
        Question(R.string.question_golf, false),
        Question(R.string.question_card, false),
        Question(R.string.question_porcupine, true),
        Question(R.string.question_cow, true),
        Question(R.string.question_olympics2, false),
        Question(R.string.question_dog, false),
        Question(R.string.question_cookie, false),
        Question(R.string.question_georgia, true),
        Question(R.string.question_spider, false),
        Question(R.string.question_lightning, false),
        Question(R.string.question_potato, false),
        Question(R.string.question_city, true),
        Question(R.string.question_twinkies, true),
        Question(R.string.question_states, true),
        Question(R.string.question_ronald, true),

        )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        prevButton = findViewById(R.id.prev_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        prevButton.setOnClickListener {
            if (currentIndex > 0 )    //Checks if index is negative, does nothing if it is
                currentIndex = (currentIndex - 1) % questionBank.size
            updateQuestion()

        }
        updateQuestion()
    }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}