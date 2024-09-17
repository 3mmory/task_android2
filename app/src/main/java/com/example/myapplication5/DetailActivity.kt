package com.example.myapplication5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication5.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // استلام البيانات من Intent
        val name = intent.getStringExtra("EXTRA_NAME") ?: "N/A"
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: "N/A"
        val phone = intent.getStringExtra("EXTRA_PHONE") ?: "N/A"

        // عرض البيانات في واجهة المستخدم
        binding.detailName.text = name
        binding.detailEmail.text = email
        binding.detailPhone.text = phone
    }
}
