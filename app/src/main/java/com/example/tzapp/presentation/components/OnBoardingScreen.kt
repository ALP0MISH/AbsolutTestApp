package com.example.tzapp.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.example.tzapp.R

enum class OnboardingType {
    WELCOME,
    CREATE,
    SELECT_INSTITUTION,
    INSTITUTION,
    PROVIDE_INSTITUTION, LAST;
    fun shouldShowMissText() = this != WELCOME && this != CREATE && this != LAST
}

@Immutable
sealed class OnBoardingScreen(
    @StringRes open val compName: Int,
    open val compIcon: Int,
    val onboardingType: OnboardingType,
) {
    @Immutable
    data class WelcomeTypeItem(
        @StringRes override val compName: Int,
        @DrawableRes override val compIcon: Int,
        @StringRes val title: Int,
        @StringRes val description: Int,
    ) : OnBoardingScreen(
        compName = compName,
        compIcon = compIcon,
        onboardingType = OnboardingType.WELCOME,
    )

    @Immutable
    data class CreateTypeItem(
        @StringRes override val compName: Int,
        @DrawableRes override val compIcon: Int,
        @StringRes val title: Int,
        @StringRes val description: Int,
        @StringRes val checkBoxTitle: Int,
        @StringRes val checkBoxDescription: Int
    ) : OnBoardingScreen(
        compName = compName,
        compIcon = compIcon,
        onboardingType = OnboardingType.CREATE,
    )

    @Immutable
    data class SelectInstitutionTypeItem(
        @StringRes override val compName: Int,
        @DrawableRes override val compIcon: Int,
        @StringRes val title: Int,
        @StringRes val description: Int,
    ) : OnBoardingScreen(
        compName = compName,
        compIcon = compIcon,
        onboardingType = OnboardingType.SELECT_INSTITUTION,
    )

    @Immutable
    data class InstitutionTypeItem(
        @StringRes override val compName: Int,
        @DrawableRes override val compIcon: Int,
        @StringRes val title: Int,
    ) : OnBoardingScreen(
        compName = compName,
        compIcon = compIcon,
        onboardingType = OnboardingType.INSTITUTION,
    )

    @Immutable
    data class ProvideInstitutionTypeItem(
        @StringRes override val compName: Int,
        @DrawableRes override val compIcon: Int,
        @StringRes val title: Int,
    ) : OnBoardingScreen(
        compName = compName,
        compIcon = compIcon,
        onboardingType = OnboardingType.PROVIDE_INSTITUTION,
    )

    @Immutable
    data class LastTypeItem(
        @StringRes override val compName: Int,
        @DrawableRes override val compIcon: Int,
        @StringRes val title: Int,
        @StringRes val description: Int,
    ) : OnBoardingScreen(
        compName = compName,
        compIcon = compIcon,
        onboardingType = OnboardingType.LAST,
    )


    companion object {
        fun onBoardingType() = listOf(
            WelcomeTypeItem(
                compName = R.string.absolude_pos,
                compIcon = R.drawable.absolude,
                title = R.string.first_onboarding_title,
                description = R.string.first_onboarding_des,
            ),
            CreateTypeItem(
                compName = R.string.dwdw,
                compIcon = R.drawable.absolude,
                title = R.string.second_onboarding_title,
                description = R.string.second_onboarding_des,
                checkBoxTitle = R.string.second_onboarding_checkbox,
                checkBoxDescription = R.string.second_onboarding_check_des
            ),
            SelectInstitutionTypeItem(
                compName = R.string.absolude_pos,
                compIcon = R.drawable.absolude,
                title = R.string.third_onboarding_title,
                description = R.string.third_onboarding_des,
            ),
            InstitutionTypeItem(
                compName = R.string.absolude_pos,
                compIcon = R.drawable.absolude,
                title = R.string.fourth_onboarding_title
            ),
            ProvideInstitutionTypeItem(
                compName = R.string.absolude_pos,
                compIcon = R.drawable.absolude,
                title = R.string.fifth_onboarding_title
            ),
            LastTypeItem(
                compName = R.string.absolude_pos,
                compIcon = R.drawable.absolude,
                title = R.string.last_onboarding_title,
                description = R.string.last_onboarding_des
            ),
        )
    }
}