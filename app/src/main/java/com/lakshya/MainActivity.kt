package com.lakshya

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice: LottieAnimationView = findViewById(R.id.dice)
        val textView: TextView = findViewById(R.id.textView)

        dice.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                hideDice()
                val random = (1..6).random()
                textView.text = random.toString()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        })
    }

    private fun showDice() {
        val dice: LottieAnimationView = findViewById(R.id.dice)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.rollDice)

        dice.visibility = View.VISIBLE
        textView.visibility = View.GONE
        button.isEnabled = false
    }

    private fun hideDice() {
        val dice: LottieAnimationView = findViewById(R.id.dice)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.rollDice)

        dice.visibility = View.GONE
        textView.visibility = View.VISIBLE
        button.isEnabled = true
    }

    fun rollDiceClicked(view: View) {
        val dice: LottieAnimationView = findViewById(R.id.dice)

        showDice()
        dice.playAnimation()
    }
}