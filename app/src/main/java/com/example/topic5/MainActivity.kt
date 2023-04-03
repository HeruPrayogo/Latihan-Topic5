package com.example.topic5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topic5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaStudent = arrayListOf(
            ListStudent("Heru", 20, R.drawable.ic_profile_foreground, "Jakarta"),
            ListStudent("Ogi", 19, R.drawable.ic_profile_foreground,"Bandung"),
            ListStudent("ridwan", 23, R.drawable.ic_profile_foreground,"Bogor"),
            ListStudent("panca",19,R.drawable.ic_profile_foreground,"Jakarta"),
            ListStudent("Farid", 20,R.drawable.ic_profile_foreground,"Yogyakarta"),
            ListStudent("rio", 21,R.drawable.ic_profile_foreground,"Bali"),
            ListStudent("Hafiz",20,R.drawable.ic_profile_foreground,"Bandung")
        )
        var adapterStudent =  StudentAdapter(namaStudent)
        //mengatur tata letak dari Rycycler view
        val ls = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.student.layoutManager = ls
        binding.student.adapter = adapterStudent
        binding.updatebtn.setOnClickListener{
            namaStudent[2] = ListStudent("Dewa",20,R.drawable.ic_profile_foreground,"Jakarta")
            var adapterStudentdiff: StudentAdapterDiffUtil
            adapterStudentdiff = StudentAdapterDiffUtil()
            //adapterStudent = StudentAdapter(namaStudent)
            binding.student.adapter = adapterStudentdiff
            //adapterStudent.notifyDataSetChanged()
            adapterStudentdiff.submitData(namaStudent)
            adapterStudentdiff.onClick = {
                var pindah = Intent(this, DetailStudentActivity::class.java)
                pindah.putExtra("detailStudent", it)
                startActivity(pindah)
            }
        }

        adapterStudent.onClick = {
            var pindah = Intent(this, DetailStudentActivity::class.java)
            pindah.putExtra("detailStudent", it)
            startActivity(pindah)
        }

    }
}