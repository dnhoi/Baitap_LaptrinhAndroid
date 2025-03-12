package com.example.bai1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addEvents()
    }

    private fun addEvents() {
        xulyCheck()
    }

    private fun xulyCheck() {
        binding.btnKiemTra.setOnClickListener {
            val ten = binding.edtHoVaTen.text.toString()
            val ageText = binding.edtTuoi.text.toString()
            if (ageText.isEmpty()) {
                Toast.makeText(this, "Vui long nhap tuoi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val age = ageText.toIntOrNull()
            if (age == null) {
                Toast.makeText(this, "Tuoi phai la so", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val category = when {
                age > 65 -> "Người già"
                age in 6..65 -> "Người lớn"
                age in 2..6 -> "Trẻ em"
                age > 0 -> "Em bé"
                else -> "Tuổi không hợp lệ"
            }
            binding.edtHienThi.setText("$ten thuộc nhóm: $category")
            binding.edtTuoi.setText("")
            binding.edtHoVaTen.setText("")
        }
    }
}