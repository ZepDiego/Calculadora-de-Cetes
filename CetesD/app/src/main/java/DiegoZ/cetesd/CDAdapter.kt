package DiegoZ.cetesd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CDAdapter(val meses:List<CDMes>): RecyclerView.Adapter<CDViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CDViewHolder {
        val vista= LayoutInflater.from(parent.context).inflate(
            R.layout.cardv,
            parent,
            false
        )
        return CDViewHolder(vista)
    }

    override fun getItemCount(): Int= meses.size

    override fun onBindViewHolder(holder: CDViewHolder, position: Int) {
        holder.tvc.text= "$${String.format("%.2f",meses[position].monto)}"
        holder.tvi.text= "${String.format("%.2f",meses[position].interes)}%"
        holder.tvg.text= "$${String.format("%.2f",meses[position].ganancia)}"
        holder.tvm.text= meses[position].mes.toString()
    }
}