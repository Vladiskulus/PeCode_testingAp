package com.vn.iambulance.testingappforprecoding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.core.view.*
import com.vn.iambulance.testingappforprecoding.FragmentAdapter.Companion.i
import com.vn.iambulance.testingappforprecoding.databinding.ActivityMainBinding

class MyFragment : Fragment() {

    private var bind: ActivityMainBinding? = null
    private val binding get() = bind!!

    var number = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = ActivityMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG) }?.apply {
            if (i < 2) {
                binding.minus.isGone
            } else {
                binding.minus.isVisible
            }
            binding.txtNumber.text = getInt(ARG).toString()
            number = getInt(ARG)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}