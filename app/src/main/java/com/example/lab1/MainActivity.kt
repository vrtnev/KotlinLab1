package com.example.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        inpText.setText("")
    }

    fun login(view: View) {
        val wrongPasswordToast = Toast.makeText(
            applicationContext,
            "Введён неверный пароль", Toast.LENGTH_SHORT
        )
        val password = inpText.text.toString()
        if (password == "admin") {
            val intent = Intent(this, ComixListActivity::class.java)
            startActivity(intent)
        } else
            wrongPasswordToast.show()
    }

}
