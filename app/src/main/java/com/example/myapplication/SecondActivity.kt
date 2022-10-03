package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ArrayAdapter
import com.example.myapplication.dataObjects.ResultObjectFromFirstPage
import com.example.myapplication.dataObjects.ResultObjectFromSecondPage
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:  ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createDropDowns()

        binding.buttonNextScreen.setOnClickListener{
            sendResultValues()
        }
    }

    private fun createDropDowns() {
        binding.cigaretteQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.cigarette_question)))
        binding.pressureQuestionAnswer.setAdapter(createArrayAdapter(resources.getStringArray(R.array.pressure_question)))
        binding.heartQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.heart_disease_question)))
        binding.cholesterolQuestionAnswer.setAdapter(createArrayAdapter(resources.getStringArray(R.array.cholesterol_question)))
    }

    private fun createArrayAdapter(options: Array<String>): ArrayAdapter<String> {
        return ArrayAdapter(this, R.layout.drop_down_layout, options)
    }

    private fun getValuesFromFirstPage(): Parcelable? {
      return  intent.getParcelableExtra("valuesFromFirstPage")
    }

    private fun getResultsFromSecondPage(): ResultObjectFromSecondPage {
      return ResultObjectFromSecondPage(arrayOf(
          binding.cigaretteQuestionAnswers.text.toString(),
            binding.pressureQuestionAnswer.text.toString(),
            binding.heartQuestionAnswers.text.toString(),
            binding.cholesterolQuestionAnswer.text.toString()))
    }

    private fun sendResultValues(){
        var intent=Intent(this, ThirdActivity::class.java)
        intent.putExtra("firstPageResults", getValuesFromFirstPage())
        intent.putExtra("secondPageResults", getResultsFromSecondPage())
        startActivity(intent)
    }
}