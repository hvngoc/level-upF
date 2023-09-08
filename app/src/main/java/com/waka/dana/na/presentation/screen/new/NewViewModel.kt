package com.waka.dana.na.presentation.screen.new

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waka.dana.na.domain.model.NewUser
import com.waka.dana.na.domain.usecase.CheckReferralUserUseCase
import com.waka.dana.na.domain.usecase.SaveNewUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

/**
 * Created by hvngoc on 7/29/22
 */
class NewViewModel(
    private val checkReferralUserUseCase: CheckReferralUserUseCase,
    private val saveNewUserUseCase: SaveNewUserUseCase,
) : ViewModel(), KoinComponent {

    private val _checkUser = MutableLiveData<Boolean>()
    val checkUser: LiveData<Boolean> = _checkUser

    private val _saveUser = MutableLiveData<Boolean>()
    val saveUser: LiveData<Boolean> = _saveUser

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

    fun saveNewUser(referral: Int?, name: String?, price: String?, sell: String?) {
        val param = NewUser(referral, name, price, sell)
        viewModelScope.launch {
            val save = saveNewUserUseCase.loadData(param)
            _saveUser.value = save ?: false
        }
    }
}