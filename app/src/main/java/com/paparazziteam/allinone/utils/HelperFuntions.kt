package com.paparazziteam.allinone.utils

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.paparazziteam.allinone.R
import com.paparazziteam.allinone.activities.MainActivity
import androidx.databinding.BindingAdapter as BindingAdapter1

//set string
val String.Companion.Empty: String
    get() = ""


//To binding imageView on layout
@BindingAdapter1("src")
fun setImageSrc(imageView: ImageView, src: String?) {
    if (src != null) {
        Glide.with(imageView.context)
            .load(src)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }
    else {
        imageView.setImageResource(R.drawable.ic_launcher_background)
    }
}
