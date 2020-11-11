package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var resultTextview: TextView

    private var operand: Double = 0.0
    private var operation: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextview= findViewById(R.id.resultTextView)

        findViewById<TextView>(R.id.clearButton).setOnClickListener{
            resultTextview.text = ""
            operand = 0.0
            operation = ""
       }

        findViewById<TextView>(R.id.deleteButton).setOnClickListener{
            val del = resultTextview.text.toString()
            if(del.isNotEmpty()) {
                resultTextview.text = del.substring(0, del.length-1)
            }
        }

    }


    fun numberClick(view: View) {

        if(view is TextView) {

            val number: String = view.text.toString()
            var result: String =  resultTextview.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextview.text = result + number
        }

    }

    fun operationClick(view: View) {

        if (view is TextView) {

            if(!TextUtils.isEmpty(resultTextview.text)) {
                operand = resultTextview.text.toString().toDouble()
            }

            resultTextview.text = ""

            operation = view.text.toString()

        }
    }

    fun equalsclick(view: View) {

        val secOperand: String = resultTextview.text.toString()
        var secNumber = 0.0

        if(!TextUtils.isEmpty(secOperand)) {
            secNumber = secOperand.toDouble()
        }

        when(operation) {
            "+" -> resultTextview.text = (operand + secNumber).toString()
            "-" -> resultTextview.text = (operand - secNumber).toString()
            "*" -> resultTextview.text = (operand * secNumber).toString()
            "/" -> resultTextview.text = (operand / secNumber).toString()
        }

    }



}