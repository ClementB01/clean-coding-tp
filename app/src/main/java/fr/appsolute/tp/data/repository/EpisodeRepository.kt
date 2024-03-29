package fr.appsolute.tp.data.repository

import androidx.paging.PagedList
import fr.appsolute.tp.data.model.Episode
import fr.appsolute.tp.data.networking.HttpClientManager
import fr.appsolute.tp.data.networking.api.EpisodeAPI
import fr.appsolute.tp.data.networking.createApi
import kotlinx.coroutines.CoroutineScope

private class EpisodeRepositoryImpl(
    private val api: EpisodeAPI
) : EpisodeRepository {

    /*override fun getPaginatedList(scope: CoroutineScope): PagedList<Episode> {
        return ""
    }*/

}

interface EpisodeRepository {

    /**
     * Return a LiveData (Observable Design Pattern) of a Paged List of Character
     */
    //fun getPaginatedList(scope: CoroutineScope): PagedList<Episode>

    //suspend fun getCharacterDetails(id: Int): Character?

    companion object {
        /**
         * Singleton for the interface [EpisodeRepository]
         */
        val instance: EpisodeRepository by lazy {
            // Lazy means "When I need it" so here this block will be launch
            // the first time you need the instance,
            // then, the reference will be stored in the value `instance`
            EpisodeRepositoryImpl(HttpClientManager.instance.createApi())
        }
    }

}