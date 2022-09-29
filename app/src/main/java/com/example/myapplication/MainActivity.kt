package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val ageQuestionOptions = resources.getStringArray(R.array.age_question)
        val ageAdapter = ArrayAdapter(this, R.layout.drop_down_layout, ageQuestionOptions)
        binding.ageQuestionAnswers.setAdapter(ageAdapter)

        val genderQuestionOptions = resources.getStringArray(R.array.gender_question)
        val genderAdapter = ArrayAdapter(this, R.layout.drop_down_layout, genderQuestionOptions)
        binding.genderQuestionAnswers.setAdapter(genderAdapter)

        val weightQuestionOptions = resources.getStringArray(R.array.weight_question)
        val weightAdapter = ArrayAdapter(this, R.layout.drop_down_layout, weightQuestionOptions)
        binding.weightQuestionAnswers.setAdapter(weightAdapter)

        val activityQuestionOptions = resources.getStringArray(R.array.activity_question)
        val acitivityAdapter = ArrayAdapter(this, R.layout.drop_down_layout, activityQuestionOptions)
        binding.activityQuestionAnswers.setAdapter(acitivityAdapter)
    }
}