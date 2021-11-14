package ar.com.thecoininspector.coininspector.presentation.remote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import ar.com.thecoininspector.coininspector.core.Response
import ar.com.thecoininspector.coininspector.domain.remote.CoinRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor (private val repo:CoinRepositoryImpl) : ViewModel() {

    fun fetchCoins() = liveData(viewModelScope.coroutineContext + Dispatchers.IO){
        emit(Response.Loading())
        try {
            emit(Response.Success(repo.getCoins()))
        }catch (e:Exception){
            emit(Response.Failure(e))
        }
    }

    fun fetchNews() = liveData(viewModelScope.coroutineContext + Dispatchers.IO){
        emit(Response.Loading())
        try {
            emit(Response.Success(repo.getNews()))
        }catch (e:Exception){
            emit(Response.Failure(e))
        }
    }
}