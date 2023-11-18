import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.R
import com.example.tp4.busschedule.Entites.Schedule


class BusClassAdapter() : RecyclerView.Adapter<BusClassAdapter.ViewHolder>() {
    private var dataSet : List<Schedule>  = listOf<Schedule>();

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stopText: TextView
        val timeText: TextView

        init {
            stopText = view.findViewById(R.id.stop)
            timeText = view.findViewById(R.id.time)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.bus_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.stopText.text = dataSet.get(position).stopName
        viewHolder.timeText.text = dataSet.get(position).arrivalTime.toString()
    }

    override fun getItemCount() = dataSet.size

    fun updateList(dataList: List<Schedule>){
        this.dataSet = dataList;
    }
}
