package com.canete.activity3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<MyData>
    private lateinit var imageId: Array<Int>
    private lateinit var nameDesc: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Replace these IDs with actual unique resource IDs
        imageId = arrayOf(
            R.drawable.a,
            R.drawable.a,
            R.drawable.a,
            R.drawable.a,
            R.drawable.a,
            R.drawable.a,
            R.drawable.a,
            R.drawable.a

        )

        nameDesc = arrayOf(
            getString(R.string.desc_a),
            getString(R.string.desc_b),
            getString(R.string.desc_c),
            getString(R.string.desc_d),
            getString(R.string.desc_e),
            getString(R.string.desc_f),
            getString(R.string.desc_g),
            getString(R.string.desc_h),
            getString(R.string.desc_i),
            getString(R.string.desc_j),
            getString(R.string.desc_k),
            getString(R.string.desc_l),
            getString(R.string.desc_m),
            getString(R.string.desc_o),
            getString(R.string.desc_p),
            getString(R.string.desc_q),
            getString(R.string.desc_r),
            getString(R.string.desc_s),
            getString(R.string.desc_t)
        )

        // Check if arrays have elements
        if (imageId.isNotEmpty() && nameDesc.isNotEmpty()) {
            newRecyclerView = findViewById(R.id.recyclerView)
            newRecyclerView.layoutManager = LinearLayoutManager(this)
            newRecyclerView.setHasFixedSize(true)

            newArrayList = arrayListOf<MyData>()
            getUserdata()
        } else {
            // Handle the case when arrays are empty
            Toast.makeText(this, "Arrays are empty", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUserdata() {
        // Check if arrays have the same length
        if (imageId.size != nameDesc.size) {
            // Handle the mismatch, maybe log an error or show a message
            Toast.makeText(this, "Arrays have different lengths", Toast.LENGTH_SHORT).show()
            return
        }

        for (i in imageId.indices) {
            val name = MyData(imageId[i], nameDesc[i])
            newArrayList.add(name)
        }

        val adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "You clicked $position", Toast.LENGTH_SHORT).show()
            }
        })
    }
}