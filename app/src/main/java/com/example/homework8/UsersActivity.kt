package com.example.homework8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework8.databinding.ActivityUsersBinding

class UsersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsersBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter(
            onEditClick = { user ->
                onEditClick(user)
            },
            onRemoveClick = { user ->
                onRemoveClick(user)
            }
        )
        binding.mRecycler.layoutManager = LinearLayoutManager(this)
        binding.mRecycler.adapter = adapter

        binding.ibAdd.setOnClickListener { onAddClick() }

        adapter.setData(userList.toList())
    }

    private fun onEditClick(user: UserData) {
        val intent = Intent(this, AddActivity::class.java)
        intent.putExtra("userToEdit", user)
        startActivity(intent)
    }

    private fun onRemoveClick(user: UserData) {
        userList.remove(user)
        adapter.setData(userList.toList())
    }

    private fun onAddClick() {
        binding.ibAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.setData(userList.toList())
    }

    companion object {
        var userList = mutableListOf<UserData>()
        var id: Int = 0
    }
}