package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.dataObjects.ResultObjectFromFirstPage
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createDropDowns()
        binding.buttonNextScreen.setOnClickListener{
            getValuesFromFirstPage()
        }
    }

    private fun createDropDowns (){
        binding.ageQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.age_question)))
        binding.genderQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.gender_question)))
        binding.weightQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.weight_question)))
        binding.activityQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.activity_question)))
    }

    private fun createArrayAdapter(options: Array<String>): ArrayAdapter<String> {
        return ArrayAdapter(this, R.layout.drop_down_layout, options)
    }

    private fun getValuesFromFirstPage(){
        val firstPageValues=ResultObjectFromFirstPage(
            arrayOf(binding.ageQuestionAnswers.text.toString(),
            binding.genderQuestionAnswers.text.toString(),
            binding.weightQuestionAnswers.text.toString(),
            binding.activityQuestionAnswers.text.toString()))

        var intent= Intent(this, SecondActivity::class.java)
        intent.putExtra("valuesFromFirstPage", firstPageValues)
        startActivity(intent)
    }
}