package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.dataObjects.AllOptionsFromTheAssesment
import com.example.myapplication.dataObjects.ResultObjectFromFirstPage
import com.example.myapplication.dataObjects.ResultObjectFromSecondPage
import com.example.myapplication.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

   private lateinit var binding:ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calculateAssesmentResults()
        createArrayFromArrayStrings()
    }


    private fun calculateAssesmentResults() {
        val firstPageResults=intent.getParcelableExtra<ResultObjectFromFirstPage>("firstPageResults")
        val secondPageResults=intent.getParcelableExtra<ResultObjectFromSecondPage>("secondPageResults").toString()
        val options=createArrayFromArrayStrings()

    }

    private fun something(optionsList: List<String>){
        val options=optionsList
        val optionValue= arrayOf(1,2,3,4,5,6)

    }


    private fun createArrayFromArrayStrings(): AllOptionsFromTheAssesment {
      val ageArray=ArrayList(resources.getStringArray(R.array.age_question).toMutableList())
        val genderArray=ArrayList(resources.getStringArray(R.array.gender_question).toMutableList())
        val weightArray=ArrayList(resources.getStringArray(R.array.weight_question).toMutableList())
        val activityArray=ArrayList(resources.getStringArray(R.array.activity_question).toMutableList())
        val cigaretteArray=ArrayList(resources.getStringArray(R.array.cigarette_question).toMutableList())
        val pressureQuestionArray=ArrayList(resources.getStringArray(R.array.pressure_question).toMutableList())
        val heartDiseaseArray=ArrayList(resources.getStringArray(R.array.heart_disease_question).toMutableList())
        val cholesterolArray=ArrayList(resources.getStringArray(R.array.cholesterol_question).toMutableList())
      return AllOptionsFromTheAssesment(
            ageArray,
            genderArray,
            weightArray,
            activityArray,
            cigaretteArray,
            pressureQuestionArray,
            heartDiseaseArray,
            cholesterolArray
        )
    }
}