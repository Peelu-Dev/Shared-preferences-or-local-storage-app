package com.example.sharedpreferencesdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameText:EditText
    private lateinit var agetText:EditText
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var sf: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.etName)
        agetText = findViewById(R.id.etAge)
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()
    }

    override fun onPause() {
        super.onPause()
        val name = nameText.text.toString()
        val age = agetText.text.toString().toInt()
        editor.apply{
            putString("sf_name",name)
            putInt("sf_age",age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("sf_name",null)
        val age = sf.getInt("sf_age",0)
        nameText.setText(name)
        if(age!=0){
            agetText.setText(age.toString())
        }
    }
}