package com.tatuas.android.optionalcoresample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.tatuas.android.optional.core.Optional

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "log"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt1: Optional<String> = Optional.ofNullable(null)
        val txt2: Optional<String> = Optional.of("hello")
        val txt3: Optional<String> = Optional.empty()

        Log.d(TAG, "txt1: " + txt1.orElse("").toString())
        Log.d(TAG, "txt2: " + if (txt2.isPresent()) txt2.value else "empty")
        Log.d(TAG, "txt3: " + txt3.value.toString())
    }
}
