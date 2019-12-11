package fr.appsolute.tp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bumptech.glide.Glide
import fr.appsolute.tp.R
import fr.appsolute.tp.data.model.Episode
import fr.appsolute.tp.ui.activity.MainActivity
import fr.appsolute.tp.ui.viewmodel.CharacterViewModel
import fr.appsolute.tp.ui.viewmodel.EpisodeViewModel
import kotlinx.android.synthetic.main.fragment_character_detail.*
import kotlinx.android.synthetic.main.fragment_character_detail.view.*

class CharacterDetailFragment : Fragment() {

    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var episodeViewModel: EpisodeViewModel
    private var characterId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.run {
            characterViewModel = ViewModelProvider(this, CharacterViewModel).get()
            episodeViewModel = ViewModelProvider(this, EpisodeViewModel).get()
        } ?: throw IllegalStateException("Invalid Activity")
        characterId =
            arguments?.getInt(ARG_CHARACTER_ID_KEY) ?: throw IllegalStateException("No ID found")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterViewModel.getCharacterDetails(characterId) {
            (activity as? MainActivity)?.supportActionBar?.apply {
                this.title = it.name
            }
            view.apply {
                this.txtId.text = "id: " + it.id.toString()
                this.txtCreated.text = "created " + it.created
                this.txtSpecies.text = "SPECIES     " + it.species
                this.txtStatus.text = "STATUS   " + it.status
                this.txtGender.text = "GENDER   " + it.gender
                Glide.with(this)
                    .load(it.image)
                    .into(this.imageView)
            }
        }

        btnListEpisode.setOnClickListener {
            var listEpisode = episodeViewModel.listEpisode {
                Toast.makeText(this.activity, it?.get(10)?.name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val ARG_CHARACTER_ID_KEY = "arg_character_id_key"
    }
}