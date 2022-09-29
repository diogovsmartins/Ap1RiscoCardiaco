package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.myapplication.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createDropDowns()

    }
    private fun createDropDowns (){
        binding.ageQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.cigarette_question)))
        binding.genderQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.gender_question)))
        binding.weightQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.weight_question)))
        binding.activityQuestionAnswers.setAdapter(createArrayAdapter(resources.getStringArray(R.array.activity_question)))
    }

    private fun createArrayAdapter(options: Array<String>): ArrayAdapter<String> {
        return ArrayAdapter(this, R.layout.drop_down_layout, options)
    }

    private fun getValuesFromFirstPage(){
        val results=ResultObject(binding.textInputForAge.toString())
        var intent= Intent(this, SecondActivity::class.java)
        intent.putExtra("valuesFromFirstPage", results)
        startActivity(intent)
}