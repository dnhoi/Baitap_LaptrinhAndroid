package com.example.bai3


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<Task>
)

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    @SerializedName("status") val status: String,
    @SerializedName("priority") val priority: String,
    @SerializedName("category") val category: String,
    @SerializedName("dueDate") val dueDate: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("subtasks") val subtasks: List<Subtask>? = null,
    @SerializedName("attachments") val attachments: List<Attachment>? = null,
    @SerializedName("reminders") val reminders: List<Reminder>? = null
)

data class Subtask(
    val id: Int,
    val title: String,
    @SerializedName("isCompleted") val isCompleted: Boolean
)

data class Attachment(
    val id: Int,
    @SerializedName("fileName") val fileName: String,
    @SerializedName("fileUrl") val fileUrl: String
)

data class Reminder(
    val id: Int,
    val time: String,
    val type: String
)
