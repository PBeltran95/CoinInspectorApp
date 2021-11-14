package ar.com.thecoininspector.coininspector.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest

fun toast(context: Context, message: String?, lengthLong: Boolean = false){

    if (lengthLong){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }else{
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}

fun ImageView.loadUrl(url:String) {
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry { add(SvgDecoder(context)) }
        .build()

    val request = ImageRequest.Builder(context)
        .crossfade(true)
        .crossfade(500)
        .data(url)
        .target(this)
        .build()

    imageLoader.enqueue(request)

}