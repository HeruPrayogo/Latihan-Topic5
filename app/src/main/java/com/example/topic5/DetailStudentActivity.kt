package com.example.topic5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.topic5.databinding.ActivityDetailStudentBinding

@Suppress("DEPRECATION")
class DetailStudentActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var getDataDetail = intent.getSerializableExtra("detailStudent") as ListStudent
        binding.imageView.setImageResource(getDataDetail.img)
        binding.textNama.text = getDataDetail.nama
        binding.textTanggal.text = getDataDetail.umur.toString()
        binding.textAlamat.text = getDataDetail.alamat

    }
}