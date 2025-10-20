package com.example.myapplication.ui.screen

import android.util.Log
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.myapplication.model.Book
import com.example.myapplication.model.Student
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ManageScreen() {
    val scrollState = rememberScrollState()
    val books = remember { mutableStateListOf<Book>() }
    val student = Student("Nguyen Van B")

    Box(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 20.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text= "Hệ thống",
                    fontWeight = FontWeight.Bold,
                    fontSize = 23.sp
                )
                Text(
                    text= "Quản lý Thư Viện",
                    fontWeight = FontWeight.Bold,
                    fontSize = 23.sp
                )
            }
            Spacer(modifier= Modifier.height(40.dp))
            Column {
                Text(
                    text= "Sinh viên",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    OutlinedTextField(
                        value = student.name,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        singleLine = true,
                        shape = RoundedCornerShape(36.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        modifier = Modifier.height(56.dp),
                        onClick = { }
                    ) {
                        Text("Thay đổi")
                    }
                }
                Text(
                    text = "Danh sách sách",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 10.dp)
                )
                Surface(
                    color = Color(0xFFF3F3F3),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 200.dp, max = 400.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 20.dp)
                            .verticalScroll(scrollState)
                    ) {
                        if (books.isNotEmpty()) {
                            books.forEachIndexed { index, book ->
                                BookCard(book)
                                if (index != books.size - 1) {
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                            }
                        } else {
                            Text("Bạn chưa mượn quyển sách nào")
                            Text(
                                "Nhấn 'Thêm' để bắt đầu hành trình đọc sách!",
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }
                }
                Button(
                    onClick = {
                        books.add(Book("${books.size + 1}"))
                        student.addBook(Book("${books.size + 1}"))
                        Log.d("Test", student.getBooks().toString())
                    },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(0.5f)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text("Thêm")
                }
            }
        }
    }
}

@Composable
fun BookCard(book: Book) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(10.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Checked",
            tint = Color.Green
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text("Sách ${book.name}")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ManageScreenPreview() {
    MyApplicationTheme {
        ManageScreen()
    }
}