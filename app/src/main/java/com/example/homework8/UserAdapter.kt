package com.example.homework8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework8.databinding.ListItemBinding

class UserAdapter(
    private val onEditClick: (UserData) -> Unit,
    private val onRemoveClick: (UserData) -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var list: List<UserData>? = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = list?.get(position)
        user?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = list?.size ?: 0

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserData) {
            binding.apply {
                tvFirstName.text = user.firstName
                tvLastName.text = user.lastName
                tvMail.text = user.email

                btnEdit.setOnClickListener { onEditClick(user) }
                btnRemove.setOnClickListener { onRemoveClick(user) }
            }
        }
    }

    fun setData(newUserList: List<UserData>) {
        val diffUtil = DiffUtil(oldList = list, newList = newUserList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        list = newUserList
        diffResult.dispatchUpdatesTo(this)
    }

}