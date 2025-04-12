package com.example.chat_library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.chat_library.ui.theme.ChatTheme

class ChatActivity : ComponentActivity() {

    private lateinit var chatWebSocket: ChatWebSocket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("username") ?: "User"
        val messages = mutableStateListOf<ChatMessage>()

        chatWebSocket = ChatWebSocket { msg, isSender ->
            val sender = if (isSender) username else "Server"
            messages.add(ChatMessage(sender = sender, message = msg))
        }

        chatWebSocket.connect()

        setContent {
            ChatTheme {
                ChatScreen(
                    username = username,
                    messages = messages,
                    onSend = { message -> chatWebSocket.sendMessage(message) }
                )
            }
        }
    }

    override fun onDestroy() {
        chatWebSocket.close()
        super.onDestroy()
    }
}
