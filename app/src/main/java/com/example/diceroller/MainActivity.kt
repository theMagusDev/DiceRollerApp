package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the Dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create the new Dice objects with 6 sides
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        // Roll them
        val dice1Roll = dice1.roll()
        val dice2Roll = dice2.roll()

        // Find the dice1 and dice2 ImageViews in the layout
        val dice1Image: ImageView = findViewById(R.id.imageView)
        val dice2Image: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice1 and dice2 roll
        val drawable1Resource = when (dice1Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawable2Resource = when (dice2Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageViews with the correct drawable resource ID
        dice1Image.setImageResource(drawable1Resource)
        dice2Image.setImageResource(drawable2Resource)

        // Update the content description
        dice1Image.contentDescription = dice1Roll.toString()
        dice2Image.contentDescription = dice2Roll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}