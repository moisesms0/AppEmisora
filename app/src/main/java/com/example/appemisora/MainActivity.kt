package com.example.appemisora

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mensaje = findViewById<EditText>(R.id.mensaje)
        val enviarButton = findViewById<Button>(R.id.enviarButton)

        enviarButton.setOnClickListener {
            val message = mensaje.text.toString()

            val intent = Intent("com.example.appreceptora.ACTION_MESSAGE")
            intent.putExtra("message", message)
            intent.setPackage("com.example.appreceptora") // Paquete de la aplicación receptora
            sendBroadcast(intent)
        }
    }
}