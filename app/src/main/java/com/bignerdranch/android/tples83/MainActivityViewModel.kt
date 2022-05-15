package com.bignerdranch.android.tples83

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    val person = MutableLiveData(Person.getMockPersons())

    fun addPerson() {
        person.value = person.value?.toMutableList()?.apply {
            add(Person.getMockPersons().random())
        }
    }

    fun deletePerson(position: Int) {
        person.value = person.value?.toMutableList()?.apply {
            removeAt(position)
        }
    }

    fun likePerson(position: Int) {
        person.value = person.value?.toMutableList()?.apply {
            get(position).like = !get(position).like
        }
    }

    fun renamePerson(position: Int) {
        person.value = person.value?.toMutableList()?.apply {
            get(position).fullName = Person.getMockPersons().random().fullName
        }
    }
}