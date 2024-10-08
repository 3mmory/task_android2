package com.example.myapplication5

import UserListFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // التأكد من عدم إعادة إنشاء الـ Fragment عند إعادة التدوير
        if (savedInstanceState == null) {
            val userListFragment = UserListFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragment_container_view, userListFragment)
            fragmentTransaction.commit()
        }
    }
}
