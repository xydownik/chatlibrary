package com.example.chat_library

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class ChatWebSocket(
    private val onMessageReceived: (String, Boolean) -> Unit
) {
    private val client = OkHttpClient()
    private var webSocket: WebSocket? = null

    fun connect() {
        val request = Request.Builder()
            .url("wss://echo.websocket.org")
            .build()

        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                if (text == "203 = 0xcb") {
                    onMessageReceived("📩 Special message on 203", false)
                } else {
                    onMessageReceived(text, false)
                }
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                val text = bytes.utf8()
                onMessage(webSocket, text)
            }
        })
    }

    fun sendMessage(message: String) {
        webSocket?.send(message)
        onMessageReceived(message, true)
    }

    fun close() {
        webSocket?.close(1000, null)
        client.dispatcher.executorService.shutdown()
    }
}
