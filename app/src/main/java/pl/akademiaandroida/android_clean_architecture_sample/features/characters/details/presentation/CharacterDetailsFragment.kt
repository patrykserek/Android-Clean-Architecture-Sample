package pl.akademiaandroida.android_clean_architecture_sample.features.characters.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.viewBinding
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentCharacterDetailsBinding
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharacterDisplayable

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel>(R.layout.fragment_character_details) {

    private val binding by viewBinding(FragmentCharacterDetailsBinding::bind)
    override val viewModel: CharacterDetailsViewModel by lifecycleScope.viewModel(this)

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacter()
    }

    private fun observeCharacter() {
        viewModel.character.observe(this) { showCharacter(it) }
    }

    private fun showCharacter(character: CharacterDisplayable) {
        with(binding) {
            Glide.with(this@CharacterDetailsFragment)
                .load(character.image)
                .into(characterImage)

            val nameLabel = getString(R.string.character_name)
            characterName.text = String.format(nameLabel, character.name)

            val originLabel = getString(R.string.character_origin)
            characterOrigin.text = String.format(originLabel, character.originName)

            val locationLabel = getString(R.string.character_current_location)
            characterCurrentLocation.text = String.format(locationLabel, character.locationName)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let { viewModel.onCharacterPassed(it) }
    }
}