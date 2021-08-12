package com.vn.iambulance.testingappforprecoding

import android.os.Bundle
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    companion object{
        var i = 1
    }

    override fun getItemCount(): Int = i

    override fun createFragment(position: Int): Fragment {
        val fragment = MyFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG, position + 1)
        }
        return fragment
    }
}