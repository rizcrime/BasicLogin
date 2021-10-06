package learn.idn.beginingproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterRecyclerView(private val context:Context,
                          private val dataGambar: Array<String>,
                          private val dataJudul: Array<String>,
                          private val dataBuyer: Array<String>) :
    RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val bindGambar: ImageView = view.findViewById(R.id.img)
        val bindJudul: TextView = view.findViewById(R.id.judul)
        val bindBuyer: TextView = view.findViewById(R.id.jml)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view =  LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.model_rv, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Glide
            .with(context) // untuk meberitahu activity yang sedang digunakan
            .load(dataGambar[position]) // untuk memuat dari target data(url/link gambar)
            .centerCrop() // untuk memangkas secara otomatis dengan perbandingan tertentu
            .placeholder(R.drawable.ic_waiting) // ketika data kosong sementara
            .into(viewHolder.bindGambar); // untuk memberitahu dimana gambar akan dimuat
        viewHolder.bindJudul.text = dataJudul[position]
        viewHolder.bindBuyer.text = dataBuyer[position]
    }

    // Return the size of your collections data (invoked by the layout manager)
    override fun getItemCount() = dataGambar.size

}