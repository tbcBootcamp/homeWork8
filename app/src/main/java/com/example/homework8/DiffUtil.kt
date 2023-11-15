package com.example.homework8

import androidx.recyclerview.widget.DiffUtil

class DiffUtil(private val oldList: List<UserData>?, private val newList: List<UserData>?) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newList?.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList?.get(oldItemPosition)?.id ?: 0) == (newList?.get(newItemPosition)?.id ?: 0)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            (oldList?.get(oldItemPosition)?.id ?: 0) != (newList?.get(newItemPosition)?.id
                ?: 0) -> false
            (oldList?.get(oldItemPosition)?.firstName ?: 0) != (newList?.get(newItemPosition)?.firstName
                ?: 0) -> false
            (oldList?.get(oldItemPosition)?.lastName ?: 0) != (newList?.get(newItemPosition)?.lastName
                ?: 0) -> false
            (oldList?.get(oldItemPosition)?.email ?: 0) != (newList?.get(newItemPosition)?.email
                ?: 0) -> false
            else -> true

        }
    }

}