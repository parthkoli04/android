package com.developernotfound.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootComplete: BroadcastReceiver()
{
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED == p1?.action)
        {
            Log.d("System","Boot Completed!")
        }
    }

}