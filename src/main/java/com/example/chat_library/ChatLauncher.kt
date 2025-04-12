package com.example.chat_library

import android.app.Activity
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf

object ChatLauncher {

    fun launchChat(activity: ComponentActivity, username: String) {
        val messageList = mutableStateListOf<ChatMessage>()

        activity.setContent {
            ChatScreen(
                username = username,
                messages = messageList
            ) { newText ->
                messageList.add(ChatMessage(sender = username, message = newText))
            }
        }
    }
}
