package com.bignerdranch.android.tples83

import android.util.Log
import androidx.recyclerview.widget.DiffUtil

class PersonsDiffUtilCallback(
    private val oldList: List<Person>,
    private val newList: List<Person>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        //Log.i("TTT", "areContentsTheSame $oldItemPosition - $newItemPosition")
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {false}
            oldList[oldItemPosition].fullName != newList[newItemPosition].fullName -> {false}
            oldList[oldItemPosition].like != newList[newItemPosition].like -> {false}
            else -> true
        }

    }
}