package DiegoZ.cetesd

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CDViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvc= itemView.findViewById<TextView>(R.id.tvc)
    val tvg=itemView.findViewById<TextView>(R.id.tvg)
    val tvi=itemView.findViewById<TextView>(R.id.tvi)
    var tvm=itemView.findViewById<TextView>(R.id.tvm)
}