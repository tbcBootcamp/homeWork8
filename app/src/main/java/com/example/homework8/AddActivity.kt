package com.example.homework8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework8.UsersActivity.Companion.id
import com.example.homework8.UsersActivity.Companion.userList
import com.example.homework8.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userToEdit = intent.extras?.getParcelable<UserData>("userToEdit")
        with(binding) {
            btnSave.setOnClickListener {
                if (userToEdit == null) {
                    addUser(
                        tietName.text.toString(),
                        tietSurname.text.toString(),
                        tietEmail.text.toString()
                    )
                } else {
                    updateUser(
                        userToEdit,
                        tietName.text.toString(),
                        tietSurname.text.toString(),
                        tietEmail.text.toString()
                    )
                }
            }
            userToEdit?.let {
                tietName.setText(it.firstName)
                tietSurname.setText(it.lastName)
                tietEmail.setText(it.email)
            }
            intent.removeExtra("userToEdit")
        }
    }

    private fun addUser(name: String, lastName: String, email: String) {
        userList.add(UserData(id = id, firstName = name, lastName = lastName, email = email))
        id++
        val msg = "User added successfully"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun updateUser(user: UserData, firstName: String, lastName: String, email: String) {
        if (userList.contains(user)) {
            val index = userList.indexOf(user)
            if (index != -1) {
                userList[index] =
                    user.copy(firstName = firstName, lastName = lastName, email = email)
            }
        }
        finish()
    }
}