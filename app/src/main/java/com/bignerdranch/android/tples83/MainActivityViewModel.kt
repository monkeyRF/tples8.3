package com.bignerdranch.android.tples83

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {

    val person = MutableLiveData(Person.getMockPersons())

    fun addPerson() {
        person.value = person.value?.toMutableList()?.apply {
            val tempPerson = Person.getMockPersons().random()
            add(Person(Random.nextLong(), tempPerson.fullName, tempPerson.photoUrl))
        }
    }

    fun deletePerson(position: Int) {
        person.value = person.value?.toMutableList()?.apply {
            removeAt(position)
        }
    }

    fun likePerson(position: Int) {
        val newData = person.value?.toMutableList()
        val isLiked = newData?.get(position)?.like ?: false

        newData?.set(position, newData[position].copy(like = !isLiked))

        person.value = newData

//        person.value = person.value?.toMutableList()?.apply {
//            get(position).like = !get(position).like
//        }
    }

    fun renamePerson(position: Int) {
        val newData = person.value?.toMutableList()

        newData?.set(position, newData[position].copy(fullName = Person.getMockPersons().random().fullName))

        person.value = newData

//        person.value = person.value?.toMutableList()?.apply {
//            get(position).fullName = Person.getMockPersons().random().fullName
//        }
    }
}