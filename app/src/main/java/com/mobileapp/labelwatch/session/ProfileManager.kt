package com.mobileapp.labelwatch.session

import com.mobileapp.labelwatch.data.models.UserProfile

object ProfileManager {

    private var currentProfile = UserProfile()

    fun getProfile(): UserProfile = currentProfile

    fun updateProfile(profile: UserProfile) {
        currentProfile = profile
    }

    fun addAllergy(allergy: String) {
        val updatedAllergies = currentProfile.allergies.toMutableList().apply {
            if (!contains(allergy)) add(allergy)
        }
        currentProfile = currentProfile.copy(allergies = updatedAllergies)
    }

    fun removeAllergy(allergy: String) {
        val updatedAllergies = currentProfile.allergies.toMutableList().apply {
            remove(allergy)
        }
        currentProfile = currentProfile.copy(allergies = updatedAllergies)
    }

    fun hasAllergy(ingredientName: String): Boolean {
        return currentProfile.allergies.any {
            ingredientName.contains(it, ignoreCase = true) ||
                    it.contains(ingredientName, ignoreCase = true)
        }
    }
}