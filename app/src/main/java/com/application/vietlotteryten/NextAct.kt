package com.application.vietlotteryten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_next.*

class NextAct : AppCompatActivity() {

    private lateinit var myModelList: ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter

    private var nextP : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

            //init actionbar
            loadCards()
            //add page change listener
            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    //change title of actionbar
                    var title = myModelList[position].title
                }
                override fun onPageSelected(position: Int) {
                }
                override fun onPageScrollStateChanged(state: Int) {
                }
            })
        nextP = findViewById(R.id.nextP)
        nextP?.setOnClickListener{
            onBackPressed()}
    }
    private fun loadCards(){
        myModelList = ArrayList()

        myModelList.add(MyModel(
            "Tuổi tác",
        R.string.n1,
            R.drawable.navbar10))

        myModelList.add(MyModel(
            "Vé",
            R.string.n2,
        R.drawable.navbar10))

        myModelList.add(MyModel(
            "Hòa",
            R.string.n3,
            R.drawable.navbar10))

        myModelList.add(MyModel(
            "Giải độc đắc",
            R.string.n4,
            R.drawable.navbar10))

        myModelList.add(MyModel(
            "Hệ số nhân",
            R.string.n5,
            R.drawable.navbar10))

        myModelList.add(MyModel(
            "Cơ hội thứ hai",
            R.string.n6,
            R.drawable.navbar10))

        //setup adapter
        myAdapter = MyAdapter(this, myModelList)

        //set adapter to viewpager
        viewPager.adapter = myAdapter

        // set default padding
        viewPager.setPadding(100,0,100,0)
    }
    }



