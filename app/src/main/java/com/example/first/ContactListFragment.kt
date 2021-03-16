package com.example.first

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

class ContactListFragment : Fragment (R.layout.fragment_contact_list) {

    private var contactListener: IContactClickListener? = null
    private var listFragment: View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is IContactClickListener) {
            contactListener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.contact_list_title)
        listFragment = view.findViewById(R.id.contactListRootLayout)
        listFragment?.setOnClickListener{ contactListener?.navigateToContactDetailsFragment("1") }
    }

    override fun onDestroyView() {
        listFragment = null
        super.onDestroyView()
    }

    override fun onDetach() {
        contactListener = null
        super.onDetach()
    }
}