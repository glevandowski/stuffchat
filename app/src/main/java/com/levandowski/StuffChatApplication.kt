package com.levandowski

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class StuffChatApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}