package com.ryggs.cars.popularmakesfeature.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ryggs.cars.allcarsfeature.domain.model.UIAllCars
import com.ryggs.cars.allcarsfeature.domain.model.UICarCategory
import com.ryggs.cars.core.utils.setImage
import com.ryggs.cars.databinding.CarCategoryBinding
import com.ryggs.cars.databinding.CarsBinding

class CarPopularCategoryAdapter(): ListAdapter<UICarCategory, CarPopularCategoryAdapter.CarsViewHolder>(ITEM_COMPARATOR) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
    val binding = CarCategoryBinding
        .inflate(LayoutInflater.from(parent.context), parent, false)

    return CarsViewHolder(binding)
  }

  override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
    val item: UICarCategory = getItem(position)

    holder.bind(item)
  }

  inner class CarsViewHolder(
      private val binding: CarCategoryBinding
  ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UICarCategory) {
      binding.ategoryTitle.text = item.name
      binding.categoryPic.setImage(item.photo)
    }
  }
}

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<UICarCategory>() {
  override fun areItemsTheSame(oldItem: UICarCategory, newItem: UICarCategory): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: UICarCategory, newItem: UICarCategory): Boolean {
    return oldItem == newItem
  }
}
