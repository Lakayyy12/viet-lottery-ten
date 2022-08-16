package com.application.vietlotteryten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_content_inside.*

class ContentInside : AppCompatActivity() {

    private var content : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_inside)

        content = findViewById(R.id.content)

        setContentDetails()
        aback?.setOnClickListener{
            onBackClicked()
        }
    }

    private fun setContentDetails() {
        image?.setBackgroundResource(intent.getIntExtra("image", 0))
        content?.text = Html.fromHtml(resources.getString(intent.getIntExtra("content",0)))
    }
    private fun onBackClicked() {
        onBackPressed()
    }
}