package com.dahlaran.simpleschooleventapp.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.dahlaran.simpleschooleventapp.SimpleSchoolEventApplication
import com.dahlaran.simpleschooleventapp.data.database.EventDatabase
import com.dahlaran.simpleschooleventapp.data.remote.NetworkServices
import com.dahlaran.simpleschooleventapp.data.remote.NomadEducationApi
import com.dahlaran.simpleschooleventapp.models.Event
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.runBlocking
import java.util.*

object EventRepository {

    private val service: NomadEducationApi = NetworkServices.provideNomadEducationServices()

    private val eventDB = EventDatabase.getInstance()

    suspend fun getEventList(): Flowable<List<Event>> {
        return eventDB.eventDao().getAll().flatMap { eventList ->
            if (eventList.isEmpty()) {
                service.getEventsFromJsonFile()
                    .subscribeOn(Schedulers.io())
                    // save data to room
                    .subscribe(
                        { // onNext
                            runBlocking {
                                eventDB.eventDao().insertAll(it)
                            }
                        },
                        { // onError
                            println("Error")
                            it.printStackTrace()
                        },
                        { // onComplete
                            println("onComplete")
                        });
            }
            Flowable.just(eventList)
        }
    }

    suspend fun updateEventList(): Observable<List<Event>> {
        return service.getEventsFromJsonFile().map {
            // Generate date
            it.forEach {
                it.generateDate()
            }
            // Sort by decending date (recent are first)
            val sortedList = it.sortedByDescending {
                it.eventDateStart!!.time
            }
            runBlocking {
                eventDB.eventDao().deleteAll()
                eventDB.eventDao().insertAll(sortedList)
            }
            sortedList
        }
    }
}