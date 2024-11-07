package com.example.myrvexample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrvexample.R
import com.example.myrvexample.CarDetailActivity
import com.example.myrvexample.model.Car

class ItemAdapter(private val data: List<Car>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var car: Car

        val nameView: TextView = view.findViewById(R.id.nameTV)
        val performanceView: TextView = view.findViewById(R.id.performanceTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showCarIntent = Intent(context, CarDetailActivity::class.java)
                showCarIntent.putExtra(CarDetailActivity.CAR_NAME, car.name)
                showCarIntent.putExtra(CarDetailActivity.CAR_SPECS, car.specs)
                showCarIntent.putExtra(CarDetailActivity.CAR_PERFORMANCE, car.performance)
                context.startActivity(showCarIntent)
            }
        }
        fun bind(car:Car){
            this.car = car
            nameView.text = car.name
            performanceView.text = car.performance
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val car = data[position]
        holder.bind(car)
//        holder.nameView.text = car.name
//        holder.performanceView.text = car.performance
    }
}