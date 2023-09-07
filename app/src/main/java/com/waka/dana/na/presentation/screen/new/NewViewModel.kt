package com.waka.dana.na.presentation.screen.new

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waka.dana.na.domain.response.DataResult
import com.waka.dana.na.domain.usecase.CheckReferralUserUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

/**
 * Created by hvngoc on 7/29/22
 */
class NewViewModel(
    private val checkReferralUserUseCase: CheckReferralUserUseCase
) : ViewModel(), KoinComponent {

    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        _data.value = DataResult.Error(error)
    }

    private val _data = MutableLiveData<DataResult>()
    val data: LiveData<DataResult> = _data

    private val _checkUser = MutableLiveData<Boolean>()
    val checkUser: LiveData<Boolean> = _checkUser

    fun loadData(query: String?) {
        viewModelScope.launch(Dispatchers.Main + exceptionHandler) {

        }
    }

    fun checkUserId(referralId: Int?) {
        referralId?.let { id ->
            viewModelScope.launch(Dispatchers.IO) {
                val check = checkReferralUserUseCase.loadData(id)
                _checkUser.value = check ?: false
            }
        } ?: run {
            _checkUser.value = true
        }
    }
}