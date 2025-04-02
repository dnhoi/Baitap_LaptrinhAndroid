package com.example.bai2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bai2.NavigationGraph
import com.example.bai2.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(navController: NavController) {
    val auth = FirebaseAuth.getInstance()
    val user = auth.currentUser

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Nút back
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(

                        painter = painterResource(R.drawable.arrow_back2),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color(0xFF2196F3), shape = RoundedCornerShape(10.dp))
                            .padding(8.dp)
                    )
                }

                // Tiêu đề
                Text(
                    text = "Profile",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2196F3),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Ảnh đại diện
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                user?.let {
                    AsyncImage(
                        model = it.photoUrl,
                        contentDescription = "User Image",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                }
                IconButton(
                    onClick = { /* Xử lý chọn ảnh */ },
                    modifier = Modifier
                        .size(32.dp)

                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_camera),
                        contentDescription = "Change Photo",
                        tint = Color.DarkGray,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            user?.let {
                // Trường nhập liệu
                ProfileTextField(label = "Name", value = it.displayName.toString())
                Spacer(modifier = Modifier.height(8.dp))

                ProfileTextField(label = "Email", value = it.email.toString())
                Spacer(modifier = Modifier.height(8.dp))
            }
            // Chọn ngày sinh
            DateOfBirthPicker()

            Spacer(modifier = Modifier.height(32.dp))
        }
        // Nút quay lại
        Button(
            onClick = { navController.popBackStack() },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF007BFF)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.BottomCenter) // Đặt nút xuống cuối màn hình
        ) {
            Text(
                text = "Back",
                color = Color.White,
                fontWeight = FontWeight(700),
                fontSize = 20.sp
            )
        }

    }
}

// Composable cho ô nhập liệu
@Composable
fun ProfileTextField(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

// Composable cho chọn ngày sinh
@Composable
fun DateOfBirthPicker() {
    var dateOfBirth by remember { mutableStateOf("25/07/2004") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Date of Birth",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = dateOfBirth,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            trailingIcon = {
                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "Dropdown")
            }
        )
    }
}

