package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recyclerview.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val args = DetailFragmentArgs.fromBundle(requireArguments()).pizzaName
            textView.text = args

            textView1.setClickText("Ingredients")
            textView2.setClickText("Ingredients")
        }
        }
    }

    fun TextView.setClickText(text: String) {
        this.text = text
        this.setOnClickListener {
            this.text = "Ingridients"
            this.setTextColor(resources.getColor(R.color.purrrrrrr))
        }
    }