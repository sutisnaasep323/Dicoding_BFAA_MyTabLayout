package com.example.mytablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class HomeFragment : Fragment() {

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        /*
        memasukkan parameter yang dikirimkan ke dalam Bundle sesuai dengan tipe datanya dengan
        format Key-Value, dengan ARG_SECTION_NUMBER bertindak sebagai key dan index sebagai value.
         */
        @JvmStatic
        fun newInstance(index: Int) =
            HomeFragment().apply {
                // Kemudian setArgument digunakan untuk mengirimkan data bundle tersebut ke fragment
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvLabel: TextView = view.findViewById(R.id.section_lable)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0) // mendapatkan data yang dikirimkan
        tvLabel.text = getString(R.string.content_tab_text, index)
    }
}