package ad.cfp.viatges

import ad.cfp.viatges.databinding.ViatgeItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViatgesAdapter(
    val llista: List<Viatge>,
    val listener: ViatgesAdapterActions
) : RecyclerView.Adapter<ViatgesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(llista[position])
    }

    override fun getItemCount(): Int {
        return llista.size
    }

    class ViewHolder(val binding: ViatgeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viatge: Viatge) {

            binding.preu.text = "${viatge.preu} €"
            binding.destinacio.text = viatge.destinacio
            binding.dataSortida.text = viatge.dataSortida
            binding.dataTornada.text = viatge.dataTornada


        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ViatgeItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }
}

interface ViatgesAdapterActions {
    fun click(viatge: Viatge)
}



