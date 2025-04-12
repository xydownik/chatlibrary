package com.example.chat_library

import android.content.Context
import android.content.Intent

object ChatLauncher {

    fun start(context: Context, username: String) {
        val intent = Intent(context, ChatActivity::class.java).apply {
            putExtra("username", username)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}
