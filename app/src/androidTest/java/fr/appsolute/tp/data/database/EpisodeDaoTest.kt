package fr.appsolute.tp.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.BeforeClass

class EpisodeDaoTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun selectAll() {
    }

    @Test
    fun insertAll() {
    }

    companion object {

        var database: RickAndMortyDatabase? = null

        @JvmStatic
        @BeforeClass
        fun createDatabase(): RickAndMortyDatabase {
            return database ?: Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getInstrumentation().targetContext,
                RickAndMortyDatabase::class.java
            ).build()
                .also {
                    database = it
                }
        }
    }
}