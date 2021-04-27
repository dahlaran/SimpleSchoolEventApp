package com.dahlaran.simpleschooleventapp

import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

class SimpleSchoolEventApplication : Application() {
    companion object {
        var context: WeakReference<Context?> = WeakReference(null)
    }

    override fun onCreate() {
        super.onCreate()
        context = WeakReference(this)
    }
}