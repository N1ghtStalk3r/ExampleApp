package com.example.exampleapp

import android.app.Application
import com.example.exampleapp.data.dataModule
import com.example.exampleapp.di.allModules
import com.example.exampleapp.domain.domain
import com.example.exampleapp.ui.presentation
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ExApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //androidLogger(Level.DEBUG)
            androidContext(this@ExApp)
            //androidFileProperties()
            //modules(allModules)
            modules(dataModule, domain, presentation)
        }
    }
}