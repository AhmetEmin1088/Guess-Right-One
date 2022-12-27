package com.ahmeteminyilmaz.guesstherightone

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game_page.*

class GamePageActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)

        object : CountDownTimer(60500,1000){
            override fun onTick(p0: Long) {

                timeText.setText("Time : " + p0 / 1000)

            }

            override fun onFinish() {

                val alert = AlertDialog.Builder(this@GamePageActivity)

                alert.setTitle("Restart Game")
                    .setMessage("Do you want to play again? (If you want to quit the game please press No button.)")
                    .setPositiveButton("Yes"){ _ , _ ->
                        val intent = Intent(this@GamePageActivity,GamePageActivity::class.java)
                        finish()
                        startActivity(intent)
                    }
                    .setNegativeButton("No") { _ , _ ->

                        finish()

                    }
                    .create()
                    .show()

            }

        }.start()



        val cards = arrayListOf(
            Card(R.drawable.bir, R.color.purple_500),
            Card(R.drawable.iki, R.color.purple_500),
            Card(R.drawable.uc, R.color.purple_500),
            Card(R.drawable.dort, R.color.purple_500),
            Card(R.drawable.bes, R.color.purple_500),
            Card(R.drawable.alti, R.color.purple_500),
            Card(R.drawable.bir, R.color.purple_500),
            Card(R.drawable.iki, R.color.purple_500),
            Card(R.drawable.uc, R.color.purple_500),
            Card(R.drawable.dort, R.color.purple_500),
            Card(R.drawable.bes, R.color.purple_500),
            Card(R.drawable.alti, R.color.purple_500)
        )

        var images = listOf(
            birView, ikiView, ucView, dortView, besView, altiView,
            birIkiView, ikiIkiView, ucIkiView, dortIkiView, besIkiView, altiIkiView
        )

        for (i in 0 until images.size) {
            images[i].setImageResource(cards[i].back)
        }

        var previouslyClickedCard: Card? = null
        var previouslyClickedView: ImageView? = null
        var score : Int = 0
        var matchedCardsCounter = 0

        for(i in 0 until images.size) {

            cards.shuffle()

            val cardIndex = i

            images[i].setOnClickListener {

                var newCard = cards[cardIndex]
                val newView = images[i]

                newView.setImageResource(cards[cardIndex].front)

                if (previouslyClickedCard == null) {
                    // This is the first card that has been clicked
                    previouslyClickedCard = newCard
                    previouslyClickedView = newView
                } else {
                    // Compare the previously clicked card to the new card
                    if (newCard.front == previouslyClickedCard!!.front) {
                        // The cards match
                        val handler = Handler()
                        handler.postDelayed({
                            newView.setImageResource(R.color.white)
                            previouslyClickedView!!.setImageResource(R.color.white)
                            newView.visibility = View.INVISIBLE
                            previouslyClickedView!!.visibility = View.INVISIBLE
                            score += 2
                            scoreText.text = "Score : $score"
                        }, 1000)

                        matchedCardsCounter += 1

                        if(matchedCardsCounter == cards.size) {

                            val alert = AlertDialog.Builder(this@GamePageActivity)

                            alert.setTitle("Restart Game")
                                .setMessage("Do you want to play again? (If you want to quit the game please press No button.)")
                                .setPositiveButton("Yes"){ _ , _ ->
                                    val intent = Intent(this@GamePageActivity,GamePageActivity::class.java)
                                    finish()
                                    startActivity(intent)
                                }
                                .setNegativeButton("No") { _ , _ ->

                                    finish()

                                }
                                .create()
                                .show()

                        }

                        // Increment score, reveal the cards, etc.
                    } else {
                        // The cards do not match
                        // Hide the cards, etc.
                        val handler = Handler()
                        handler.postDelayed({
                            newView.setImageResource(cards[cardIndex].back)
                            previouslyClickedView!!.setImageResource(cards[cardIndex].back)
                        }, 1000)
                    }
                    previouslyClickedCard = null  // Reset the previously clicked card

                }
            }
        }



        /*
        for(i in 0 until images.size) {

            cards.shuffle()

            images[i].setOnClickListener {

                var newCard = cards[i]

                images[i].setImageResource(cards[i].front)

                //onCardClicked(cards[i])

                if (previouslyClickedCard == null) {
                    // This is the first card that has been clicked
                    previouslyClickedCard = newCard
                } else {
                    // Compare the previously clicked card to the new card
                    if (newCard.front == previouslyClickedCard!!.front) {
                        // The cards match
                        images[i].setImageResource(R.color.white)
                        it.visibility = View.INVISIBLE
                        scoreText.setText("Score : " + score + 2)
                        // Increment score, reveal the cards, etc.
                    } else {
                        // The cards do not match
                        // Hide the cards, etc.
                        println("else durumu")
                        images[i].setImageResource(cards[i].back)
                    }
                    previouslyClickedCard = null  // Reset the previously clicked card
                }

            }

        }

         */

    }


/*
    fun onCardClicked(newCard: Card) {
        if (previouslyClickedCard == null) {
            // This is the first card that has been clicked
            previouslyClickedCard = newCard
        } else {
            // Compare the previously clicked card to the new card
            if (newCard.front == previouslyClickedCard!!.front) {
                // The cards match

                scoreText.setText("Score : " + score + 2)
                // Increment score, reveal the cards, etc.
            } else {
                // The cards do not match
                // Hide the cards, etc.
                println("else durumu")

            }
            previouslyClickedCard = null  // Reset the previously clicked card
        }
    }

 */



    }

