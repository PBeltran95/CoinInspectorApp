package ar.com.thecoininspector.coininspector.data.models

data class News(
    val status: String = "",
    val totalResults: Int = 0,
    val results : ArrayList<Result>
)

data class Result(
    val title:String,
    val link: String,
    val source_id:String,
    val keywords:ArrayList<String>,
    val image_url: String,
    val video_url:String,
    val description:String,
    val pubDate:String,
    val content:String
)
