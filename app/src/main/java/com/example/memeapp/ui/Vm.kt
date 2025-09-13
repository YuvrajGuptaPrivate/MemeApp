package com.example.memeapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memeapp.data.MemeFromInternet
import com.example.memeapp.data.RetrofitInstance
import com.example.memeapp.data.model.MEME
import kotlinx.coroutines.launch

class Vm : ViewModel() {

    private lateinit var apiInterface : MemeFromInternet

    private var _name = MutableLiveData<MemeUiState>()
    val name: LiveData<MemeUiState> = _name



    var isloading : Boolean = false


     fun loadMeme(){
        apiInterface = RetrofitInstance.getInstance().create(MemeFromInternet::class.java)
        viewModelScope.launch{

            _name.value = MemeUiState(memes = emptyList(),isLoading = true)
            try{
                val result = apiInterface.getMeme()
                _name.value = MemeUiState(memes = result.memes, isLoading = false)
            }catch (e: Exception){
                _name.value = MemeUiState(error = e.message ?:"Error errror", memes = emptyList(), isLoading = false)
            }

        }
    }

    fun nextMeme(){

        viewModelScope.launch{
            //_name.value = MemeUiState(memes = emptyList(),isLoading = true)
            isloading = true

            try{
                val result = apiInterface.getMeme()

                val currentMemes = _name.value?.memes ?: emptyList()

                val combinedMemes = currentMemes + result.memes

                isloading = false

                _name.value = MemeUiState(memes = combinedMemes, isLoading = false)

            }catch (e: Exception){
                isloading = false

                _name.value = MemeUiState(error = e.message ?:"Error errror", memes = emptyList(), isLoading = false)
            }

        }

    }


}

data class MemeUiState(
    val memes: List<MEME>,
    val isLoading : Boolean,
    val  error: String? = null
)