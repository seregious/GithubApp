package com.example.githubtestapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtestapp.data.Constants
import com.example.githubtestapp.data.NetworkManager
import com.example.githubtestapp.domain.Rep
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {

    var repList = MutableLiveData<List<Rep>>()

    val networkStatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getRepList() {
        var list: List<Rep>
        viewModelScope.launch {
            try {
                list = NetworkManager.getReps.getReps()
                repList.postValue(list)
                networkStatus.value = Constants.NETWORK_OK
            } catch(e: Exception) {
                networkStatus.value = Constants.NETWORK_NOT_OK
            }
        }
    }
}