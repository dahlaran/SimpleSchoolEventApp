package com.dahlaran.simpleschooleventapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dahlaran.simpleschooleventapp.models.Event
import io.reactivex.Flowable

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(events: List<Event>)

    @Query("DELETE FROM event_table")
    suspend fun deleteAll()

    // TODO: Check why can't put suspend to return a flowable
    @Query("SELECT * FROM event_table")
    fun getAll(): Flowable<List<Event>>

    @Query("SELECT * FROM event_table WHERE id=:eventId")
    suspend fun getEvent(eventId: String): Event
}