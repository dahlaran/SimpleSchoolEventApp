package com.dahlaran.simpleschooleventapp.data

import com.dahlaran.simpleschooleventapp.data.database.EventDatabase
import com.dahlaran.simpleschooleventapp.data.remote.NetworkServices
import com.dahlaran.simpleschooleventapp.data.remote.NomadEducationApi
import com.dahlaran.simpleschooleventapp.models.Event
import com.dahlaran.simpleschooleventapp.models.MonthEvent
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.runBlocking

object EventRepository {

    private val service: NomadEducationApi = NetworkServices.provideNomadEducationServices()

    private val eventDB = EventDatabase.getInstance()

    suspend fun getMonthEventList(): Flowable<List<MonthEvent>> {
        return eventDB.eventDao().getAll().flatMap { eventList ->
            if (eventList.isEmpty()) {
                service.getEventsFromJsonFile()
                    .subscribeOn(Schedulers.io())
                    // save data to room
                    .subscribe(
                        { // onNext
                            saveIntoDatabase(it)
                        },
                        { // onError
                            println("Error")
                            it.printStackTrace()
                        },
                        { // onComplete
                            println("onComplete")
                        });
            }
            Flowable.just(seperateListIntoMonthEvent(eventList))
        }
    }

    suspend fun updateEventList(): Observable<List<MonthEvent>> {
        return service.getEventsFromJsonFile().map {
            seperateListIntoMonthEvent(saveIntoDatabase(it))
        }
    }

    fun seperateListIntoMonthEvent(eventListToSeperate: List<Event>): List<MonthEvent> {
        val monthEventList: MutableList<MonthEvent> = mutableListOf()
        if (eventListToSeperate.size > 0) {

            var tmpEventList: MutableList<Event> = mutableListOf()
            var eventYear = eventListToSeperate[0].getEventYear()
            var eventMonth = eventListToSeperate[0].getEventMonth()

            eventListToSeperate.forEach {
                if (it.getEventYear() == eventYear && it.getEventMonth() == eventMonth) {
                    tmpEventList.add(it)
                } else {
                    monthEventList.add(MonthEvent(tmpEventList, eventYear, eventMonth))
                    tmpEventList = mutableListOf()
                    tmpEventList.add(it)
                    eventYear = it.getEventYear()
                    eventMonth = it.getEventMonth()
                }
            }
            monthEventList.add(MonthEvent(tmpEventList, eventYear, eventMonth))
        }
        return monthEventList
    }

    suspend fun getEvent(eventId: String): Event {
        return eventDB.eventDao().getEvent(eventId)
    }

    private fun saveIntoDatabase(list: List<Event>): List<Event> {
        // Generate date
        list.forEach {
            it.generateDate()
        }
        // Sort by decending date (recent are first)
        val sortedList = list.sortedByDescending {
            it.eventDateStart!!.time
        }
        runBlocking {
            // TODO: Make delete more cleaner (it remove all and add all) remove only thos who need to be
            //eventDB.eventDao().deleteAll()
            eventDB.eventDao().insertAll(sortedList)
        }
        return sortedList
    }
}