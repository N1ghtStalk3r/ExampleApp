package com.example.exampleapp.data

import android.content.Context
import android.widget.Toast
import com.example.exampleapp.R

class ConstantsProvider {
    companion object {
        fun getBaseUrl() = "jsonplaceholder.typicode.com"

        // Аргументы?
        const val POST_ID_ARG = "postId"

        fun makeToast(context: Context, resId: Int) {
            Toast.makeText(context, resId, Toast.LENGTH_SHORT)
        }
    }
}