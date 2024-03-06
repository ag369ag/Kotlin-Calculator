package com.example.testkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.testkotlin.databinding.ActivityMainBinding
import java.lang.Exception
import kotlin.math.log

lateinit var lastNumber : String
lateinit var lastOperation : String
lateinit var firstNumber : String
//lateinit var operation : String

class MainActivity : AppCompatActivity() {

    private lateinit var bind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        lastOperation = ""
        lastNumber = ""
        firstNumber = ""
        bind.btn0.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn0.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn0.text)
            }

        })
        bind.btn1.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn1.text
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn1.text)
            }
        })
        bind.btn2.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn2.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn2.text)
            }
        })
        bind.btn3.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn3.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn3.text)
            }
        })
        bind.btn4.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn4.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn4.text)
            }
        })
        bind.btn5.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn5.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn5.text)
            }
        })
        bind.btn6.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn6.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn6.text)
            }
        })
        bind.btn7.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn7.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn7.text)
            }
        })
        bind.btn8.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn8.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn8.text)
            }
        })
        bind.btn9.setOnClickListener(View.OnClickListener {
            if(bind.screen?.text == "0")
            {
                bind.screen?.text = bind.btn9.text;
            }
            else
            {
                val inputtedNum = bind.screen?.text
                bind.screen?.text = inputtedNum.toString().plus(bind.btn9.text)
            }
        })
        bind.btnDot.setOnClickListener(View.OnClickListener {
                val inputtedNum = bind.screen?.text.toString()
                if(!(inputtedNum.contains(bind.btnDot.text.toString())) || (inputtedNum.contains(bind.btnAdd.text.toString())) || inputtedNum.contains(bind.btnSubtract.text.toString()) || inputtedNum.contains(bind.btnMultiply.text.toString()) || inputtedNum.contains(bind.btnDivide.text.toString()))
                {
                    bind.screen?.text = inputtedNum.plus(bind.btnDot.text)
                }

        })


        bind.btnC.setOnClickListener(View.OnClickListener {
            bind.screen?.text = "0";
        })
        bind.btnAc.setOnClickListener(View.OnClickListener {
            bind.screen?.text = "0";
            lastOperation = ""
            lastNumber = ""
        })

        bind.btnAdd.setOnClickListener(View.OnClickListener {
                bind.screen?.text = bind.screen?.text.toString().removeSuffix(lastOperation)
                firstNumber = bind.screen?.text.toString()
                lastOperation = bind.btnAdd.text.toString()
                bind.screen?.text = firstNumber.plus(bind.btnAdd.text)
        })

        bind.btnSubtract.setOnClickListener(View.OnClickListener {
                bind.screen?.text = bind.screen?.text.toString().removeSuffix(lastOperation)
                firstNumber = bind.screen?.text.toString()
                lastOperation = bind.btnSubtract.text.toString()
                bind.screen?.text = firstNumber.plus(bind.btnSubtract.text)

        })

        bind.btnMultiply.setOnClickListener(View.OnClickListener {
                bind.screen?.text = bind.screen?.text.toString().removeSuffix(lastOperation)
                firstNumber = bind.screen?.text.toString()
                lastOperation = bind.btnMultiply.text.toString()
                bind.screen?.text = firstNumber.plus(bind.btnMultiply.text)

        })

        bind.btnDivide.setOnClickListener(View.OnClickListener {
                bind.screen?.text = bind.screen?.text.toString().removeSuffix(lastOperation)
                firstNumber = bind.screen?.text.toString()
                lastOperation = bind.btnDivide.text.toString()
                bind.screen?.text = firstNumber.plus(bind.btnDivide.text)
        })

        bind.btnEquals.setOnClickListener(View.OnClickListener {
            try{
                val inputString = bind.screen?.text.toString()
                val optr = inputString.removePrefix(firstNumber)
                Log.d("first number", firstNumber)
                Log.d("optr", optr)
                if(firstNumber != "" && lastOperation != "")
                {
                    var data = inputString.removePrefix(firstNumber)
                    data = data.removePrefix(lastOperation)
                    compute(lastOperation, data)
                }
                else
                {
                    continueOperation(lastOperation)
                }

            }
            catch (_: Exception)
            {}

        })
    }

    fun compute(lastOperation : String, input : String){
        when(lastOperation){
            "+" ->
            {
                Log.d("ttest", "test")
                Log.d("first", firstNumber)
                Log.d("last", input)
                try{
                    val last = input.toDouble()
                    val total = firstNumber.toDouble() + last
                    lastNumber = input
                    bind.screen?.text = total.toString()
                    firstNumber = ""
                }catch (_: NumberFormatException){}
                Log.d("last operation", lastOperation)
                Log.d("lastnumber", lastNumber)
            }
            "-" ->
            {
                try{
                    val last = input.toDouble()
                    lastNumber = input
                    val total = firstNumber.toDouble() - last
                    bind.screen?.text = total.toString()
                    firstNumber = ""
                }catch (_: NumberFormatException){}
                Log.d("ttest", "test")
                Log.d("first", firstNumber)
                Log.d("last operation", lastOperation)
                Log.d("lastnumber", lastNumber)
            }

            "*" ->
            {
                try{
                    val last = input.toDouble()
                    lastNumber = input
                    val total = firstNumber.toDouble() * last
                    bind.screen?.text = total.toString()
                    firstNumber = ""
                }catch (_: NumberFormatException){}
                Log.d("ttest", "test")
                Log.d("first", firstNumber)
                Log.d("last operation", lastOperation)
                Log.d("lastnumber", lastNumber)
            }
            "/" ->
            {
                try{
                    val last = input.toDouble()
                    lastNumber = input
                    val total = firstNumber.toDouble() / last
                    bind.screen?.text = total.toString()
                    firstNumber = ""
                }catch (_: NumberFormatException){}
                Log.d("ttest", "test")
                Log.d("first", firstNumber)
                Log.d("last operation", lastOperation)
                Log.d("lastnumber", lastNumber)
                //Log.d("number of add array", addArray.count().toString())
            }
        }
    }

    private fun continueOperation(lastOperation : String){
        when(lastOperation)
        {
            "+" ->
                {
                    val latestOutput = bind.screen?.text.toString().toDouble()
                    bind.screen?.text = ( latestOutput + lastNumber.toDouble()).toString()
                }

            "-" ->
            {
                val latestOutput = bind.screen?.text.toString().toDouble()
                bind.screen?.text = ( latestOutput - lastNumber.toDouble()).toString()
            }

            "*" ->
            {
                val latestOutput = bind.screen?.text.toString().toDouble()
                bind.screen?.text = ( latestOutput * lastNumber.toDouble()).toString()
            }

            "/" ->
            {
                val latestOutput = bind.screen?.text.toString().toDouble()
                bind.screen?.text = ( latestOutput / lastNumber.toDouble()).toString()
            }
        }
    }

}