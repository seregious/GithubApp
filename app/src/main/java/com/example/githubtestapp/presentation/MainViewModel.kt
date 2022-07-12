package com.example.githubtestapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtestapp.data.Constants
import com.example.githubtestapp.data.DownloadReadme
import com.example.githubtestapp.data.DownloadReps
import com.example.githubtestapp.domain.ReadMe
import com.example.githubtestapp.domain.Rep
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {

    var repList = MutableLiveData<List<Rep>>()

    val selectedRep: MutableLiveData<Rep> by lazy {
        MutableLiveData<Rep>()
    }

    val readMe: MutableLiveData<ReadMe> by lazy {
        MutableLiveData<ReadMe>()
    }

    val networkStatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getRepList() {
        var list: List<Rep>
        viewModelScope.launch {
            try {
                list = DownloadReps.getReps.getReps()
                repList.postValue(list)
                networkStatus.value = Constants.NETWORK_OK
            } catch(e: Exception) {
                networkStatus.value = Constants.NETWORK_NOT_OK
            }
        }
    }

    fun getReadme() {
        var readme: ReadMe?
        viewModelScope.launch {
            try {
                readme = selectedRep.value?.let { DownloadReadme.getReadme.getReadme(it.url) }
                readMe.value = readme
                networkStatus.value = Constants.NETWORK_OK
            } catch(e: Exception) {
                networkStatus.value = Constants.NETWORK_NOT_OK
            }
        }
    }
}