package com.cwirko.testexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EntriesAdapter(context : Context, private val items: ArrayList<Entry>) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(R.layout.item_entry, parent, false)

        view.findViewById<TextView>(R.id.text_score).text = items[position].score.toString()
        view.findViewById<TextView>(R.id.text_game_time).text = items[position].gameTime.toDuration()
        view.findViewById<TextView>(R.id.text_date).text = SimpleDateFormat("MM/dd/yy", Locale.getDefault()).format(items[position].date)
        view.findViewById<TextView>(R.id.text_moves).text = items[position].moves.toString()

        return view
    }
}

fun Int.toDuration() : String {
    val hours = this / 3600
    val minutes = (this - hours * 3600) / 60
    val seconds = this - hours * 3600 - minutes * 60
    return hours.toString().padStart(2, '0') + ":" + minutes.toString().padStart(2, '0') + ":" + seconds.toString().padStart(2, '0')
}