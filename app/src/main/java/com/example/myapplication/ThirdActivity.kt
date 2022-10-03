package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }


    private fun calculateAssesmentResults() {
        val firstPageResults=intent.getParcelableExtra<ResultObjectFromFirstPage>("firstPageResults")
        val secondPageResults=intent.getParcelableExtra<ResultObjectFromSecondPage>("secondPageResults").toString()
    }
}