package dev.thundercloud.galacticmerchants.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.thundercloud.galacticmerchants.network.SpaceTradersApi
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface ServerStatusState {
    data class Success(val status: String) : ServerStatusState
    object Error : ServerStatusState
    object Loading : ServerStatusState
}

class ServerStatusViewModel: ViewModel() {
    var serverStatusState: ServerStatusState by mutableStateOf(ServerStatusState.Loading)
        private set

    init {
        getServerStatus()
    }

    fun getServerStatus() {
        viewModelScope.launch {
            serverStatusState = ServerStatusState.Loading
            serverStatusState = try {
                val result = SpaceTradersApi.retrofitService.getServerStatus()
                ServerStatusState.Success(
                    result.status
                )
            } catch (e: HttpException) {
                ServerStatusState.Error
            } catch (e: IOException) {
                ServerStatusState.Error
            }
        }
    }
}