package ar.com.thecoininspector.coininspector.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(context: Context, message:String?, lengthLong:Boolean = false){

    if (lengthLong){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }else{
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}