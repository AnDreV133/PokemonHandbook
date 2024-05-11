package com.example.pokemonhandbook

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ApiExceptionDialogFragment() : DialogFragment() {
    var answer: DialogAnswer = DialogAnswer.NOTHING
        get() {
            val temp = field
            field = DialogAnswer.NOTHING
            return temp
        }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Trouble with connection to API")
                .setPositiveButton("Try Again") { _, _ ->
                    answer = DialogAnswer.TRY_AGAIN
                }
                .setNegativeButton("Cancel") { _, _ ->
                    answer = DialogAnswer.CANCEL
                }.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

enum class DialogAnswer {
    TRY_AGAIN,
    CANCEL,
    NOTHING
}