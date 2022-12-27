package com.ahmeteminyilmaz.guesstherightone

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes

class Card(var front: Int, var back: Int) {


}
/*
data class Card(val front: Int, val back: Int)

fun main() {
    val cards = listOf(
        Card(R.drawable.card1_front, R.drawable.card_back),
        Card(R.drawable.card2_front, R.drawable.card_back),
        Card(R.drawable.card3_front, R.drawable.card_back),
        Card(R.drawable.card4_front, R.drawable.card_back)
    )
    val imageViews = listOf(imageView1, imageView2, imageView3, imageView4)

    // Shuffle the cards
    cards.shuffle()

    // Set the images for the image views
    for (i in 0 until imageViews.size) {
        imageViews[i].setImageResource(cards[i].back)
    }

    // Set up the click listeners for the image views
    for (i in 0 until imageViews.size) {
        imageViews[i].setOnClickListener {
            it.setImageResource(cards[i].front)
            // Check if the clicked card matches the previously clicked card
            if (previouslyClickedCard != null && previouslyClickedCard != it) {
                if (cards[i].front == previouslyClickedCard.front) {
                    // The cards match, so make them invisible
                    it.visibility = View.INVISIBLE
                    previouslyClickedCard.visibility = View.INVISIBLE
                } else {
                    // The cards don't match, so change the images back to the back images
                    it.setImageResource(cards[i].back)
                    previouslyClickedCard.setImageResource(previouslyClickedCardIndex.back)
                }
                previouslyClickedCard = null
            } else {
                // This is the first card that was clicked, so remember it for comparison later
                previouslyClickedCard = it
                previouslyClickedCardIndex = i
            }
        }
    }

}

 */