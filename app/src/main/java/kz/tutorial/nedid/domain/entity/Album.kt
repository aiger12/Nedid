package kz.tutorial.nedid.domain.entity

data class Album(
    val userId: Int,
    val id: Int,
    val title: String,
    val username: String,
    val photoUrl: String,
)