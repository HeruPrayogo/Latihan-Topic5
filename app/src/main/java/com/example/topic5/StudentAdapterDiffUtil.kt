package com.example.topic5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class StudentAdapterDiffUtil() : RecyclerView.Adapter<StudentAdapterDiffUtil.ViewHolder>() {
    var onClick:((ListStudent) -> Unit)? = null
    private var diffCallBack = object:DiffUtil.ItemCallback<ListStudent>(){
        override fun areItemsTheSame(oldItem: ListStudent, newItem: ListStudent): Boolean {
           return oldItem.nama == newItem.nama
        }

        override fun areContentsTheSame(oldItem: ListStudent, newItem: ListStudent): Boolean {
            return  oldItem.hashCode() == newItem.hashCode()
        }

    }
    var differ = AsyncListDiffer(this,diffCallBack)

    fun submitData(value: ArrayList<ListStudent>){
        differ.submitList(value)
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var nama = view.findViewById<TextView>(R.id.namaS)
        var umur = view.findViewById<TextView>(R.id.umurS)
        var img = view.findViewById<ImageView>(R.id.poto)
        var card = view.findViewById<CardView>(R.id.detailCard)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentAdapterDiffUtil.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentAdapterDiffUtil.ViewHolder, position: Int) {
        var data = differ.currentList[position]
        holder.nama.text = data.nama
        holder.umur.text = data.umur.toString()
        holder.img.setImageResource(data.img)
        holder.card.setOnClickListener{
            onClick?.invoke(data)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}