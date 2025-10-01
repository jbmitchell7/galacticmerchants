package dev.thundercloud.galacticmerchants.ui.reflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.thundercloud.galacticmerchants.network.SpaceTradersApi
import kotlinx.coroutines.launch

class ReflowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is reflow Fragment"
    }
    val text: LiveData<String> = _text

    init {
        getServerStatus()
    }

    private fun getServerStatus() {
        viewModelScope.launch {
            try {
                val statusResponse = SpaceTradersApi.retrofitService.getServerStatus()
                _text.value = statusResponse.status
            } catch (e: Exception) {
                println(e.message)
                _text.value = "Failed to get server status"
            }
        }
    }
}