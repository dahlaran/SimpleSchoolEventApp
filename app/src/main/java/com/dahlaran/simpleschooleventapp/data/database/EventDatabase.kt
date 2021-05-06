package com.dahlaran.simpleschooleventapp.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dahlaran.simpleschooleventapp.SimpleSchoolEventApplication
import com.dahlaran.simpleschooleventapp.models.Event

@Database(entities = arrayOf(Event::class), version = 2)
@TypeConverters(TypeConverter::class)
abstract class EventDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao

    companion object {
        @Volatile
        private var instance: EventDatabase? = null

        fun getInstance(): EventDatabase {
            synchronized(this) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        SimpleSchoolEventApplication.context.get()!!,
                        EventDatabase::class.java, "eventDatabase"
                    ).build()
                }
                return instance!!
            }
        }
    }
}