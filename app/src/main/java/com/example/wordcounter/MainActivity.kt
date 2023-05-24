package com.example.wordcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    lateinit var edTxt: EditText
    lateinit var txtFld: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0

        edTxt = findViewById(R.id.edTxt)
        txtFld = findViewById(R.id.txtVw)


        edTxt.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(txt: CharSequence?, start: Int, count: Int, after: Int){}
            override fun onTextChanged(txt: CharSequence, start: Int, count: Int, after: Int){}
            override fun afterTextChanged(ed: Editable?){
                val countStr = ed?.toString()?.split(" ".toRegex())?.size
                val str = ed?.toString()?.trim()
                if (!str.isNullOrEmpty()){
                    var wordCount = (str.split("\\s+".toRegex())?:emptyList()).size

                    if (countStr != null) {
                        if (countStr <= 5){
                            txtFld.text = "Words $wordCount"
                            count = wordCount
                        }else{
                            edTxt.isEnabled = false
                        }
                    }

                }
            }

        })

    }
}