package com.bignerdranch.android.tples83

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
        var flag = false
        if (oldList[oldItemPosition].fullName == newList[newItemPosition].fullName || oldList[oldItemPosition].like == newList[newItemPosition].like) flag = true
        return flag

    }
}