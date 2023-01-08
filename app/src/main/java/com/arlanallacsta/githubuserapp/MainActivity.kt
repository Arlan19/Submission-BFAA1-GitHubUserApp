package com.arlanallacsta.githubuserapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.arlanallacsta.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGitUser.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUserName = resources.getStringArray(R.array.username)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<User>()

            for (i in dataName.indices){
                val user = User(
                    dataName[i],
                    dataUserName[i],
                    dataAvatar.getResourceId(i, -1),
                    dataCompany[i],
                    dataLocation[i],
                    dataRepository[i],
                    dataFollowers[i],
                    dataFollowing[i])
                listUser.add(user)
            }


            return listUser
        }

    private  fun showRecyclerList(){
        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.rvGitUser.layoutManager = GridLayoutManager(this, 2)
        }else{
            binding.rvGitUser.layoutManager = LinearLayoutManager(this)
        }
        val listUserGitAdapter = ListUserGitAdapter(list)
        binding.rvGitUser.adapter = listUserGitAdapter

        listUserGitAdapter.setOnItemClickCallback(object : ListUserGitAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User){
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User){
        val intent = Intent(this@MainActivity, DetaiUser::class.java)
        intent.putExtra(DetaiUser.KEY_USER, user)
        startActivity(intent)
    }
}