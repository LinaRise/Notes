package com.example.android.notes.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.notes.models.AppNote
import com.example.android.notes.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AddNewNoteViewModel(application: Application) : AndroidViewModel(application) {

    fun insert(note: AppNote, onSuccess: () -> Unit) =
        try {
            viewModelScope.launch(Dispatchers.Main) {
                REPOSITORY.insert(note) {
                    onSuccess()
                }
            }
        }catch (e:Exception){
            e.stackTrace
        }
}