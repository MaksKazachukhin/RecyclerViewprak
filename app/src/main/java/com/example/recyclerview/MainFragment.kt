package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PizzaAdapter
    private var pizzaList: ArrayList<Pizza> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initRecyclerView()
    }

    private fun loadData() {
        pizzaList.add(Pizza("Margherita", "https://i.pinimg.com/originals/38/51/a9/3851a97a1feb7bf3b75344a48c479e9f.jpg"))
        pizzaList.add(Pizza("4 Cheese", "https://nauglax.ru/wp-content/uploads/2024/02/chetyre-syra-dorblju-chedder-jemmental-mocarella-2048x1365.jpg"))
        pizzaList.add(Pizza("Hawaiian", "https://get.wallhere.com/photo/pizza-olives-tomatoes-basil-1306121.jpg"))
        pizzaList.add(Pizza("Pepperoni", "https://nauglax.ru/wp-content/uploads/2024/02/Pepperoni.jpg"))
        pizzaList.add(Pizza("Four Seasons", "https://imageproxy.wolt.com/assets/66aa98cfeae92a5a25ce1d9c"))
        pizzaList.add(Pizza("For Kids", "https://mig.pics/x/uploads/posts/2022-09/1663755293_45-mykaleidoscope-ru-p-pitstsa-iz-solenogo-testa-yeda-vkontakte-49.jpg"))
    }

    private fun initRecyclerView() {
        adapter = PizzaAdapter(pizzaList)
        binding.rvPizza.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
