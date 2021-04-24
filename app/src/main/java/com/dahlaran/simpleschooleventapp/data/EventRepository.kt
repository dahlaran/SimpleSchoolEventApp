package com.dahlaran.simpleschooleventapp.data

import androidx.lifecycle.MutableLiveData
import com.dahlaran.simpleschooleventapp.models.Event

object EventRepository {

    private val service: NomadEducationApi  = NetworkServices.provideNomadEducationServices()
    private val eventList: MutableLiveData<List<Event>> = MutableLiveData()

    suspend fun getEventList(): MutableLiveData<List<Event>> {
        return eventList
    }

    suspend fun updateEventList() {
        service.getEventsFromJsonFile().doOnNext { setValue(it)}.map {
            println(it.count())
        }.subscribe (
            { // onNext
                println("Next")
            },
            { // onError
                println("Error")
                it.printStackTrace()
            },
            { // onComplete
                println("onComplete")
            }
        )
        }

    fun setValue(it: List<Event>) {
        eventList.postValue(it)
    }
}