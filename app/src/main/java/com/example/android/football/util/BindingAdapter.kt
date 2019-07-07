package com.example.android.football.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.football.R

@BindingAdapter("visible")
fun loadingVisibility(view: ProgressBar, it: Any?) {
    view.visibility = if (it != null) View.GONE else View.VISIBLE
}

@BindingAdapter("visibleUnless")
fun show(view: TextView, it: Boolean) {
    view.visibility = if (it) View.VISIBLE else View.GONE
}

@BindingAdapter("setImage")
fun setImage(view: ImageView, name: String) {
    view.setImageResource(
        when (name) {
            "ManU" -> R.drawable.manchester_united
            "Chelsea" -> R.drawable.chelsea
            "Man City" -> R.drawable.manchester_city
            "Spurs" -> R.drawable.tottenham_hotspur
            "Arsenal" -> R.drawable.arsenal
            "Liverpool" -> R.drawable.liverpool
            "Barcelona" -> R.drawable.barcelona
            "Realmadrid" -> R.drawable.realmadrid
            else -> R.drawable.ball
        }
    )
}