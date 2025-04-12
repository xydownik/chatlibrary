package com.example.chat_library

data class ChatMessage(
    val id: String = System.currentTimeMillis().toString(),
    val sender: String,
    val message: String,
    val timestamp: Long = System.currentTimeMillis()
)
