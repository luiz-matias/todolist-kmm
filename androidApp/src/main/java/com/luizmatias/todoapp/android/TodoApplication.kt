package com.luizmatias.todoapp.android

import android.app.Application
import com.luizmatias.todoapp.android.di.appModule
import com.luizmatias.todoapp.di.commonModule
import com.luizmatias.todoapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class TodoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TodoApplication)
            modules(appModule, commonModule)
        }
    }

}