package com.example.hamakeja.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hamakeja.R
import com.example.hamakeja.adapter.TruckAdapter
import com.example.hamakeja.model.Truck

class WantToMoveFragment : Fragment() {
    private val recyclerView: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<TruckAdapter.ViewHolder>? = null

    var mTruckList: List<Truck>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recyclerView?.findViewByPosition(R.id.recyclerView)
        val view = inflater.inflate(R.layout.fragment_want_to_move, container, false)
        val truckAdapter = TruckAdapter(context, mTruckList)
        val linearLayoutManager = LinearLayoutManager(context)
        

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}