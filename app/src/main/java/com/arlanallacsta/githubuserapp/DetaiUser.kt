package com.arlanallacsta.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arlanallacsta.githubuserapp.databinding.ActivityDetaiUserBinding
import com.bumptech.glide.Glide

class DetaiUser : AppCompatActivity() {

    companion object{
        const val KEY_USER = "key_user"
    }

    private lateinit var binding: ActivityDetaiUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetaiUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }

    private fun setData() {
        val dataUser = intent.getParcelableExtra<User>(KEY_USER) as User
        with(binding){
            Glide.with(root).load(dataUser.photo).circleCrop().into(imgGambarUserDetail)
            tvNamaPenggunaDetail.text = dataUser.name
            tvUsernamePenggunaDetail.text = dataUser.username
            tvCompanyDetail.text = dataUser.company
            tvLocationDetail.text = dataUser.location
            tvNilaiRepositoryDetail.text = dataUser.repository
            tvNilaiFollowersDetail.text = dataUser.followes
            tvNilaiFollowingDetail.text = dataUser.following
        }
    }
}