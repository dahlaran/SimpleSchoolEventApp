package com.dahlaran.simpleschooleventapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlaran.simpleschooleventapp.data.EventRepository
import com.dahlaran.simpleschooleventapp.models.Event
import com.dahlaran.simpleschooleventapp.models.MonthEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class EventViewModel: ViewModel() {
    private val disposable = CompositeDisposable()
    var event: MutableLiveData<Event> = MutableLiveData()

    fun getEvent(eventId: String){
        viewModelScope.launch {
            event.postValue(EventRepository.getEvent(eventId))
        }
    }

    override fun onCleared() {
        // Remove observable if viewModel is destroyed
        disposable.dispose()
        super.onCleared()
    }
}