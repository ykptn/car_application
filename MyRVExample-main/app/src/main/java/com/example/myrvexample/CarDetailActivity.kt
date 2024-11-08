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

        if (carName != null) {
            binding.carImageView.setImageResource(getCarImageResource(carName))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getCarImageResource(carModel: String): Int {
        return when (carModel) {
            "i10" -> R.drawable.car_i10
            "i20" -> R.drawable.car_i20
            "Elantra" -> R.drawable.car_elantra
            "i20 N" -> R.drawable.car_i20_n
            "Bayon" -> R.drawable.car_bayon
            "Kona" -> R.drawable.car_kona
            "Kona Hybrid" -> R.drawable.car_kona_hybrid
            "Tucson" -> R.drawable.car_tucson
            "Tucson Hybrid" -> R.drawable.car_tucson_hybrid
            "Santa Fe Hybrid" -> R.drawable.car_santa_fe_hybrid
            "Kona Electric" -> R.drawable.car_kona_electric
            "IONIQ 5" -> R.drawable.car_ioniq_5
            "IONIQ 6" -> R.drawable.car_ioniq_6
            "STARIA" -> R.drawable.car_staria
            else -> R.drawable.hyundai_logo
        }
    }
}