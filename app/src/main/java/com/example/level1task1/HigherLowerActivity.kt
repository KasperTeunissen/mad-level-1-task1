package com.example.level1task1

/**
 * @author Kasper Teunissen
 * The higher-lower dice game
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.level1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
}

    /**
     * set onclick listeners for the three buttons
     */
    private fun initViews() {
        binding.btnHigher.setOnClickListener { onHigherClick() }
        binding.btnLower.setOnClickListener { onLowerClick() }
        binding.btnEquals.setOnClickListener { onEqualsClick() }
        updateUI()
    }

    /**
    Update the image and text in the view
     **/
    fun updateUI(){
        binding.tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when(currentThrow) {
            1 -> binding.imageView.setImageResource(R.drawable.dice1)
            2 -> binding.imageView.setImageResource(R.drawable.dice2)
            3 -> binding.imageView.setImageResource(R.drawable.dice3)
            4 -> binding.imageView.setImageResource(R.drawable.dice4)
            5 -> binding.imageView.setImageResource(R.drawable.dice5)
            6 -> binding.imageView.setImageResource(R.drawable.dice6)
        }
    }

    /**
     * rolls randomly between 1 and 6, update ui to reflect roll
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * user made a choice, roll dice and see if user was correct
     */
    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }
    private fun onEqualsClick() {
        rollDice()

        if(currentThrow == lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }
    private fun onHigherClick() {
        rollDice()

        if(currentThrow > lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * functions handling correct and incorrect answers by displaying a toast
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getText(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getText(R.string.correct), Toast.LENGTH_SHORT).show()
    }

}
