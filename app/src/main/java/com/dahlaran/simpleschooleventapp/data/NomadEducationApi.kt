package com.dahlaran.simpleschooleventapp.data

import com.dahlaran.simpleschooleventapp.models.Event
import io.reactivex.Observable
import retrofit2.http.GET

interface NomadEducationApi {
    @GET("/nomadeducation/raw/upload/v1510821111/events_uqwefr.json")
    fun getEventsFromJsonFile(): Observable<List<Event>>
}