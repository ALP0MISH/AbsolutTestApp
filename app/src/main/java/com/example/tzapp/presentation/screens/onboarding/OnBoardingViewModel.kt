package com.example.tzapp.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tzapp.domain.models.UserDomain
import com.example.tzapp.domain.use_case.ShowToastUseCase
import com.example.tzapp.domain.use_case.UserRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userRegisterUseCase: UserRegisterUseCase,
    private val showToastUseCase: ShowToastUseCase,

    ) : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.OnAddressChange -> doAddressChange(event)
            is OnboardingEvent.OnAreaOfHallsChange -> doAreaOfHallsChange(event)
            is OnboardingEvent.OnAutomationSystemChange -> doAutomationSystemChange(event)
            is OnboardingEvent.OnBarChange -> doBarChange(event)
            is OnboardingEvent.OnCanteenChange -> doCanteenChange(event)
            is OnboardingEvent.OnCityChange -> doCityChange(event)
            is OnboardingEvent.OnCoffeeChange -> doCoffeeChange(event)
            is OnboardingEvent.OnCoffeeHouseChange -> doCoffeeHouseChange(event)
            is OnboardingEvent.OnCookingChange -> doCookingChange(event)
            is OnboardingEvent.OnEmailChange -> doEmailChange(event)
            is OnboardingEvent.OnInInstitutionChange -> dpInInstitutionChange(event)
            is OnboardingEvent.OnKitchenAreaChange -> doKitchenAreaChange(event)
            is OnboardingEvent.OnNameChange -> doNameChange(event)
            is OnboardingEvent.OnNumberOfSeatsChange -> doNumberOfSeatsChange(event)
            is OnboardingEvent.OnOthersChange -> doOthersChange(event)
            is OnboardingEvent.OnRestaurantChange -> doRestaurantChange(event)
            is OnboardingEvent.OnTakeAwayChange -> doTakeAwayChange(event)
            is OnboardingEvent.OnTotalAreaChange -> doTotalAreaChange(event)
            is OnboardingEvent.OnInstitutionNameChange -> doInstitutionNameChange(event)
            is OnboardingEvent.OnDeliveryChange -> doDeliveryChange(event)
            is OnboardingEvent.OnUserSuccess -> saveUser()
        }
    }

    private fun saveUser() {
        viewModelScope.launch {
            userRegisterUseCase.saveUser(_uiState.value.toUserDomain())
            showToastUseCase.showToast("Ваша регистреция прошла успешно")
        }
    }


    private fun OnboardingUiState.toUserDomain(): UserDomain =
        this.run {
            UserDomain(
                id = id,
                name = name,
                emailOrNumber = emailOrNumber,
                institutionName = institutionName,
                cityName = cityName,
                address = address,
                totalArea = totalArea,
                numberOfSeats = numberOfSeats,
                areaOfHalls = areaOfHalls,
                areaKitchen = areaKitchen,
                automationSystem = automationSystem,
                restaurant = restaurant,
                bar = bar,
                coffee = coffee,
                coffeeHouse = coffeeHouse,
                canteen = canteen,
                cooking = cooking,
                other = other,
                takeAway = takeAway,
                delivery = delivery,
                inInstitution = inInstitution
            )
        }

    private fun doAddressChange(event: OnboardingEvent.OnAddressChange) {
        _uiState.update { uiState ->
            uiState.copy(address = event.value)
        }
    }

    private fun doAreaOfHallsChange(event: OnboardingEvent.OnAreaOfHallsChange) {
        _uiState.update { uiState ->
            uiState.copy(areaOfHalls = event.value)
        }
    }

    private fun doAutomationSystemChange(event: OnboardingEvent.OnAutomationSystemChange) {
        _uiState.update { uiState ->
            uiState.copy(automationSystem = event.value)
        }
    }

    private fun doBarChange(event: OnboardingEvent.OnBarChange) {
        _uiState.update { uiState ->
            uiState.copy(bar = event.value)
        }
    }

    private fun doCanteenChange(event: OnboardingEvent.OnCanteenChange) {
        _uiState.update { uiState ->
            uiState.copy(canteen = event.value)
        }
    }

    private fun doCityChange(event: OnboardingEvent.OnCityChange) {
        _uiState.update { uiState ->
            uiState.copy(cityName = event.value)
        }
    }

    private fun doCoffeeChange(event: OnboardingEvent.OnCoffeeChange) {
        _uiState.update { uiState ->
            uiState.copy(coffee = event.value)
        }
    }

    private fun doCoffeeHouseChange(event: OnboardingEvent.OnCoffeeHouseChange) {
        _uiState.update { uiState ->
            uiState.copy(coffeeHouse = event.value)
        }
    }

    private fun doCookingChange(event: OnboardingEvent.OnCookingChange) {
        _uiState.update { uiState ->
            uiState.copy(cooking = event.value)
        }
    }

    private fun doEmailChange(event: OnboardingEvent.OnEmailChange) {
        _uiState.update { uiState ->
            uiState.copy(emailOrNumber = event.value)
        }
    }

    private fun dpInInstitutionChange(event: OnboardingEvent.OnInInstitutionChange) {
        _uiState.update { uiState ->
            uiState.copy(inInstitution = event.value)
        }
    }

    private fun doKitchenAreaChange(event: OnboardingEvent.OnKitchenAreaChange) {
        _uiState.update { uiState ->
            uiState.copy(areaKitchen = event.value)
        }
    }

    private fun doNameChange(event: OnboardingEvent.OnNameChange) {
        _uiState.update { uiState ->
            uiState.copy(name = event.value)
        }
    }

    private fun doNumberOfSeatsChange(event: OnboardingEvent.OnNumberOfSeatsChange) {
        _uiState.update { uiState ->
            uiState.copy(numberOfSeats = event.value)
        }
    }

    private fun doOthersChange(event: OnboardingEvent.OnOthersChange) {
        _uiState.update { uiState ->
            uiState.copy(other = event.value)
        }
    }

    private fun doRestaurantChange(event: OnboardingEvent.OnRestaurantChange) {
        _uiState.update { uiState ->
            uiState.copy(restaurant = event.value)
        }
    }

    private fun doTakeAwayChange(event: OnboardingEvent.OnTakeAwayChange) {
        _uiState.update { uiState ->
            uiState.copy(takeAway = event.value)
        }
    }

    private fun doTotalAreaChange(event: OnboardingEvent.OnTotalAreaChange) {
        _uiState.update { uiState ->
            uiState.copy(totalArea = event.value)
        }
    }

    private fun doInstitutionNameChange(event: OnboardingEvent.OnInstitutionNameChange) {
        _uiState.update { uiState ->
            uiState.copy(institutionName = event.value)
        }
    }

    private fun doDeliveryChange(event: OnboardingEvent.OnDeliveryChange) {
        _uiState.update { uiState ->
            uiState.copy(delivery = event.value)
        }
    }
}