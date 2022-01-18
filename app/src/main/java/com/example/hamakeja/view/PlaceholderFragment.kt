package com.example.hamakeja.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hamakeja.databinding.FragmentHomeBinding

class PlaceholderFragment: Fragment() {
    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentHomeBinding?= null


    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER)?: 3)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root

        val  textView: TextView = binding.sectionLabel
        pageViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment  {

            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
