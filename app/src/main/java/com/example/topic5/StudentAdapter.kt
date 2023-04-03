package com.example.topic5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter(var listStudent : ArrayList<ListStudent>): RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    var onClick:((ListStudent) -> Unit)? = null
    class ViewHolder(view : View):RecyclerView.ViewHolder(view) {
        var nama = view.findViewById<TextView>(R.id.namaS)
        var umur = view.findViewById<TextView>(R.id.umurS)
        var img = view.findViewById<ImageView>(R.id.poto)
        var card = view.findViewById<CardView>(R.id.detailCard)
    }
    //untuk memanggil layout xml item_student
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }
    //untuk meng set data ke dalam txt viewnya
    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.nama.text = listStudent[position].nama
        holder.umur.text = listStudent[position].umur.toString()
        holder.img.setImageResource(listStudent[position].img)
        holder.card.setOnClickListener{
            onClick?.invoke(listStudent[position])
        }
    }
    //untuk mereturn sesuai size datanya
    override fun getItemCount(): Int {
        return listStudent.size
    }
}