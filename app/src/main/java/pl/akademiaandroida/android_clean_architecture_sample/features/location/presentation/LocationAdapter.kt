package pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.inflate
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.makeVisible
import pl.akademiaandroida.android_clean_architecture_sample.databinding.ItemLocationBinding

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val locations = mutableListOf<LocationDisplayable>()

    fun setItems(locations: List<LocationDisplayable>) {
        if (locations.isNotEmpty()) this.locations.clear()

        this.locations.addAll(locations)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            parent.inflate(R.layout.item_location)
        )
    }

    override fun getItemCount() = locations.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val episode = locations[position]
        holder.bind(episode)
    }

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLocationBinding.bind(itemView)

        fun bind(location: LocationDisplayable) {
            with(binding) {
                name.text = location.name
                type.text = location.type
                location.dimension?.let {
                    dimension.text = it
                    dimension.makeVisible()
                }
            }
        }
    }
}