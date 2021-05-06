package com.dahlaran.simpleschooleventapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlaran.simpleschooleventapp.data.EventRepository
import com.dahlaran.simpleschooleventapp.models.Item
import com.dahlaran.simpleschooleventapp.models.MonthEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EventListViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    val dataLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    var eventList: MutableLiveData<List<Item>> = MutableLiveData()

    init {
        getEventList()
    }

    fun getEventList() {
        viewModelScope.launch {
            disposable.add(EventRepository.getMonthEventList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { // onNext
                        eventList.postValue(it)
                    },
                    { // onError
                        it.printStackTrace()
                        dataLoading.postValue(false)
                    },
                    { // onComplete
                        dataLoading.postValue(false)
                    }
                ))
        }
    }

    fun updateEventList() {
        if (dataLoading.value == false) {
            dataLoading.postValue(true)
            val coroutineScope = CoroutineScope(Dispatchers.Default + Job())

            coroutineScope.launch {
                disposable.add(EventRepository.updateEventList().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { // onNext
                            eventList.postValue(it)
                        },
                        { // onError
                            it.printStackTrace()
                            dataLoading.postValue(false)
                        },
                        { // onComplete
                            dataLoading.postValue(false)
                        }
                    ))
            }
        }
    }

    override fun onCleared() {
        // Remove observable if viewModel is destroyed
        disposable.dispose()
        super.onCleared()
    }
}