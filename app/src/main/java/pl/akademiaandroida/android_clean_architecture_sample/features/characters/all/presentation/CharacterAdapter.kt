package pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_character.view.*
import pl.akademiaandroida.android_clean_architecture_sample.R

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters by lazy { mutableListOf<CharacterDisplayable>() }
    private var listener: ((CharacterDisplayable) -> Unit)? = null

    fun setCharacters(characters: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    fun setOnCharacterClickListener(listener: (CharacterDisplayable) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_character, parent, false)

        return CharacterViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, listener)
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            character: CharacterDisplayable,
            listener: ((CharacterDisplayable) -> Unit)?
        ) {
            listener?.let { itemView.setOnClickListener { it(character) } }
            with(itemView) {
                Glide.with(this)
                    .load(character.image)
                    .into(characterImage)

                characterName.text = character.name
            }
        }
    }
}