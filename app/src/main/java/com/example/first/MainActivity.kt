package com.example.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), IContactClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigateToContactListFragment()
        }
    }

    private fun navigateToContactListFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.mainActivityRootLayout, ContactListFragment())
                .commit()
    }

    override fun navigateToContactDetailsFragment(id: String) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.mainActivityRootLayout, ContactDetailsFragment.newInstance(id))
                .addToBackStack(null)
                .commit()
    }
}