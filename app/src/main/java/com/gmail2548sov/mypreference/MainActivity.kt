package com.gmail2548sov.mypreference

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mPref:SharedPreferences

    val SAVED_TEXT:String = "saved_text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSave.setOnClickListener(this)
        btnLoad.setOnClickListener(this)
        load_text()

    }

    override fun onDestroy() {
        save_text()
        super.onDestroy()

    }

    fun save_text() {
        mPref = getPreferences(Context.MODE_PRIVATE)
        val ed:Editor?= mPref?.edit()
        ed?.putString(SAVED_TEXT, etText.getText().toString())
        ed?.commit()
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }

    fun load_text() {

        mPref = getPreferences(Context.MODE_PRIVATE)
        val savedText: String = mPref?.getString(SAVED_TEXT, "")?:""
        etText.setText(savedText)
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnSave -> {
                save_text()

            }
            R.id.btnLoad -> {

                load_text()
            }

            else -> { Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show()}

        }



    }


}