package com.cwirko.testexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.cwirko.testexercise.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max
import kotlin.random.Random

const val MAX_ENTRIES = 10

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val entries = ArrayList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonDone.setOnClickListener { addEntry() }
        binding.listEntries.adapter = EntriesAdapter(this, entries)
    }

    private fun addEntry() {
        val score = Random.nextInt(1000)

        if(entries.size == MAX_ENTRIES) {
            entries.removeAt(MAX_ENTRIES - 1)
        }

        entries.add(Entry(
            score,
            Random.nextInt(60, 7201),
            Calendar.getInstance().time,
            max(Random.nextInt(score - 100, score + 101), 0)
        ))

        entries.sortWith(entriesComparator())

        binding.listEntries.adapter = EntriesAdapter(this, entries)
    }
}