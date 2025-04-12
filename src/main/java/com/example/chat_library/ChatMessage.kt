package com.example.chat_library

data class ChatMessage(
    val id: String = "",
    val sender: String,
    val message: String,
    val timestamp: Long = System.currentTimeMillis()
)
