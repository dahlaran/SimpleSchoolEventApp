package com.dahlaran.simpleschooleventapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlaran.simpleschooleventapp.data.EventRepository
import com.dahlaran.simpleschooleventapp.models.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EventListViewModel : ViewModel() {

    val dataLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    var eventList: MutableLiveData<List<Event>> = MutableLiveData()

    init {
        getEventList()
    }

    fun getEventList() {
        viewModelScope.launch {
            eventList = EventRepository.getEventList()
        }
    }

    fun updateEventList() {
        if (dataLoading.value == false) {
            dataLoading.postValue(true)
            val coroutineScope = CoroutineScope(Dispatchers.Default + Job())

            coroutineScope.launch {
                EventRepository.updateEventList()
                dataLoading.postValue(false)
            }
        }
    }
}