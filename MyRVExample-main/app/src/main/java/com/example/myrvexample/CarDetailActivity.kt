package com.example.myrvexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myrvexample.databinding.ActivityCarDetailBinding

class CarDetailActivity : AppCompatActivity() {
    companion object{
        const val CAR_NAME = "car_name"
        const val CAR_SPECS = "car_specs"
        const val CAR_PERFORMANCE = "car_performance"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_car_detail)
        val binding: ActivityCarDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_car_detail)

        val carName = intent.getStringExtra(CAR_NAME)
        val carSpecification = intent.getStringExtra(CAR_SPECS)
        val carPerformance = intent.getStringExtra(CAR_PERFORMANCE)

        binding.nameView.text = carName
        binding.specsView.text = carSpecification
        binding.performanceView.text = carPerformance

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}