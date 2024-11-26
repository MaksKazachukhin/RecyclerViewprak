import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.Pizza

import com.example.recyclerview.databinding.ItemPizzaBinding

class PizzaAdapter(private val pizzas: ArrayList<Pizza>,
                   private val onItemClick: (position: Int)  -> Unit
) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    inner class PizzaViewHolder(val binding: ItemPizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza) {
            binding.textView.text = pizza.name
            Glide.with(binding.imageView).load(pizza.image).into(binding.imageView)


            binding.root.setOnClickListener {
                onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(
            ItemPizzaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = pizzas.size

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(pizzas[position])
    }
}
