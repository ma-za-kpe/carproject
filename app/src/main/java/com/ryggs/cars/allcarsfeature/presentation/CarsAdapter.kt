package com.ryggs.cars.allcarsfeature.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ryggs.cars.allcarsfeature.domain.model.UIAllCars
import com.ryggs.cars.core.utils.setImage
import com.ryggs.cars.databinding.CarsBinding

class CarsAdapter(
  private val showCarDetails: (Any) -> Unit
): ListAdapter<UIAllCars, CarsAdapter.CarsViewHolder>(ITEM_COMPARATOR) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
    val binding = CarsBinding
        .inflate(LayoutInflater.from(parent.context), parent, false)

    return CarsViewHolder(binding)
  }

  override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
    val item: UIAllCars = getItem(position)

    holder.bind(item, showCarDetails)
  }

  inner class CarsViewHolder(
      private val binding: CarsBinding
  ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UIAllCars, showCarDetails: (Any) -> Unit) {
      binding.roundCardView.setOnClickListener {
        showCarDetails(item)
      }

      binding.ategoryTitle.text = item.name
      binding.milage.text =  "milage ${item.milage} km"
      binding.price.text =  "$${item.price}"
      binding.categoryPic.setImage(item.photo)
    }
  }
}

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<UIAllCars>() {
  override fun areItemsTheSame(oldItem: UIAllCars, newItem: UIAllCars): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: UIAllCars, newItem: UIAllCars): Boolean {
    return oldItem == newItem
  }
}
