package com.example.appemisora

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, mensaje.text.toString())
                type = "text/plain"
            }

            val chooser = Intent.createChooser(sendIntent, "Abrir URL con:")

            try{
                startActivity(chooser)
            } catch (e: ActivityNotFoundException){

            }
        }
    }
}