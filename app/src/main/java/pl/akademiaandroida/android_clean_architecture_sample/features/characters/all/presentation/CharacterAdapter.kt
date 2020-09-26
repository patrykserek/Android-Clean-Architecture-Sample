package pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.akademiaandroida.android_clean_architecture_sample.core.adapter.BindableAdapter
import pl.akademiaandroida.android_clean_architecture_sample.databinding.ItemCharacterBinding

class CharacterAdapter : BindableAdapter<CharacterDisplayable>,
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters by lazy { mutableListOf<CharacterDisplayable>() }
    private var listener: ((CharacterDisplayable) -> Unit)? = null

    override fun setItems(items: List<CharacterDisplayable>) {
        if (items.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(items)
        notifyDataSetChanged()
    }

    fun setOnCharacterClickListener(listener: (CharacterDisplayable) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, listener)
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            character: CharacterDisplayable,
            listener: ((CharacterDisplayable) -> Unit)?
        ) {
            with(binding) {
                item = character
                listener?.let { root.setOnClickListener { it(character) } }
                executePendingBindings()
            }
        }
    }
}