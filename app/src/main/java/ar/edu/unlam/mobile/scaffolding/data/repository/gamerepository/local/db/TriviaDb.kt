package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.GameEntity

@Database(entities = [GameEntity::class], version = 1)
abstract class TriviaDb : RoomDatabase(){
    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "trivia_db"
        private var instance: TriviaDb? = null

        fun getInstance(context: Context): TriviaDb = synchronized(this){
            instance?.let { return@synchronized it }
            instance = Room.databaseBuilder(context, TriviaDb::class.java, DATABASE_NAME).build()
            return instance!!
        }
    }
}