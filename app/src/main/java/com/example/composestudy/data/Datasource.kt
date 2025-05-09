package com.example.composestudy.data

import com.example.composestudy.R
import com.example.composestudy.model.Affirmation
import com.example.composestudy.model.Topic

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.dice_1, R.drawable.dice_1),
            Affirmation(R.string.dice_2, R.drawable.dice_2),
            Affirmation(R.string.dice_3, R.drawable.dice_3),
            Affirmation(R.string.dice_4, R.drawable.dice_4),
            Affirmation(R.string.dice_5, R.drawable.dice_5),
            Affirmation(R.string.dice_6, R.drawable.dice_6)
        )
    }
}

