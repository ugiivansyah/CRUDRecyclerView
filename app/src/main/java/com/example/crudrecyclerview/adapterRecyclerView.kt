package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterRecyclerView (private val dataset: MutableList<SiswaData>):
        RecyclerView.Adapter<adapterRecyclerView.SiswaHolder>(){
    class SiswaHolder(view: View):RecyclerView.ViewHolder(view){
        val nis = view.findViewById<TextView>(R.id.tx_NIS)
        val nama = view.findViewById<TextView>(R.id.tx_Nama)
        val jekel = view.findViewById<TextView>(R.id.tx_JK)
        val hapus = view.findViewById<Button>(R.id.btHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiswaHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_recycler_view,parent,false
        )
       return SiswaHolder(view)
    }

    override fun onBindViewHolder(holder: SiswaHolder, position: Int) {
        holder.nis.text = dataset[position].nama_siswa.toString()
        holder.nama.text = dataset[position].nama_siswa
        holder.jekel.text = dataset[position].jenis_kelamin
        holder.hapus.setOnClickListener {
            dataset.removeAt(position)
            notifyItemRangeRemoved(position, dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
       return dataset.size
    }

}
