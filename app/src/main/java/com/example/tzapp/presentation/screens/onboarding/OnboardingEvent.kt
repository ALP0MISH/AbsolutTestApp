package com.example.tzapp.presentation.screens.onboarding

sealed class OnboardingEvent {
    data class OnEmailChange(val value: String) : OnboardingEvent()
    data class OnNameChange(val value: String) : OnboardingEvent()
    data class OnCityChange(val value: String) : OnboardingEvent()
    data class OnAddressChange(val value: String) : OnboardingEvent()
    data class OnAutomationSystemChange(val value: String) : OnboardingEvent()
    data class OnTotalAreaChange(val value: String) : OnboardingEvent()
    data class OnNumberOfSeatsChange(val value: String) : OnboardingEvent()
    data class OnAreaOfHallsChange(val value: String) : OnboardingEvent()
    data class OnKitchenAreaChange(val value: String) : OnboardingEvent()
    data class OnInstitutionNameChange(val value: String) : OnboardingEvent()


    data class OnRestaurantChange(val value: Boolean) : OnboardingEvent()
    data class OnBarChange(val value: Boolean) : OnboardingEvent()
    data class OnCoffeeChange(val value: Boolean) : OnboardingEvent()
    data class OnCanteenChange(val value: Boolean) : OnboardingEvent()
    data class OnCoffeeHouseChange(val value: Boolean) : OnboardingEvent()
    data class OnCookingChange(val value: Boolean) : OnboardingEvent()
    data class OnOthersChange(val value: Boolean) : OnboardingEvent()
    data class OnTakeAwayChange(val value: Boolean) : OnboardingEvent()
    data class OnInInstitutionChange(val value: Boolean) : OnboardingEvent()
    data class OnDeliveryChange(val value: Boolean) : OnboardingEvent()
    data object OnUserSuccess : OnboardingEvent()
}