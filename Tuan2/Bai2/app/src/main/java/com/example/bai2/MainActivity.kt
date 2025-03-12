package com.example.bai2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val bookList: MutableList<String> = mutableListOf("Sách 1", "Sách 2")
    private lateinit var bookAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // Xử lý padding cho system bars
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences("LibraryPrefs", Context.MODE_PRIVATE)

        // Load tên nhân viên đã lưu
        val savedName = sharedPreferences.getString("employee_name", "")
        binding.edtNameEmployee.setText(savedName)

        // Khởi tạo Adapter cho ListView
        bookAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            bookList
        )
        binding.lvBook.adapter = bookAdapter

        // Gán sự kiện
        setupEventListeners()
    }

    private fun setupEventListeners() {
        // Thêm sách
        binding.btnAddBook.setOnClickListener {
            addBook()
        }

        // Cập nhật tên nhân viên
        binding.btnNameEmployee.setOnClickListener {
            updateEmployeeName()
        }

        // Sự kiện cho thanh điều hướng
        binding.navQuanly.setOnClickListener {
            Toast.makeText(this, "Đã chọn: Quản lý", Toast.LENGTH_SHORT).show()
        }

        binding.navSach.setOnClickListener {
            Toast.makeText(this, "Đã chọn: DS Sách", Toast.LENGTH_SHORT).show()
        }

        binding.navNhanvien.setOnClickListener {
            Toast.makeText(this, "Đã chọn: Nhân viên", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addBook() {
        val bookName = binding.edtNameBook.text.toString().trim()
        if (bookName.isNotEmpty()) {
            bookList.add(bookName)
            bookAdapter.notifyDataSetChanged()
            binding.edtNameBook.text.clear()
            binding.edtNameBook.requestFocus()
            Toast.makeText(this, "Đã thêm sách: $bookName", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Vui lòng nhập tên sách!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateEmployeeName() {
        val employeeName = binding.edtNameEmployee.text.toString().trim()
        if (employeeName.isNotEmpty()) {
            with(sharedPreferences.edit()) {
                putString("employee_name", employeeName)
                apply()
            }
            Toast.makeText(this, "Đã cập nhật tên: $employeeName", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Vui lòng nhập tên nhân viên!", Toast.LENGTH_SHORT).show()
        }
    }
}