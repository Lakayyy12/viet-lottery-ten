package com.application.vietlotteryten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.vietlotteryten.Navigator.Navigator
import com.application.vietlotteryten.Navigator.Navigator.Companion.openPage
import com.application.vietlotteryten.Navigator.Navigator.Companion.showInfoDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_layout.*
import kotlinx.android.synthetic.main.card_layout.cdView

class MainActivity : AppCompatActivity(), OnContentClickListener, View.OnClickListener {

    private var exit = 0

    private var layoutManager: RecyclerView.LayoutManager? = null

    private val onItemClicked by lazy { this }

    private var btnG : Button? = null
    private var fab : FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initOnClicked()
        initComponents()
        initListener()

        btnG = findViewById(R.id.btnG)
        btnG?.setOnClickListener{
            val intent = Intent(this, NextAct::class.java)
            startActivity(intent)
        }
    }
    private fun initRecyclerView(){
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = RecyclerAdapter(onItemClicked)
    }
    private fun initOnClicked(){
        cdView?.setOnClickListener {
            openPage(this, ContentInside::class.java)
        }
    }
    private fun initComponents(){
        fab = findViewById(R.id.fab)
    }
    private fun initListener(){
        fab?.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.fab -> showInfoDialog(this)
        }
    }
    override fun OnContentItemClicked(image: Int, content: Int) {
        openPage(this, ContentInside::class.java, image, content)
    }
    override fun onBackPressed() {
        if (exit == 0) {
            exit = 1
            Toast.makeText(this, "Nhấp lại để thoát!", Toast.LENGTH_SHORT).show()
        }else{
            super.finishAffinity()
        }
    }

}