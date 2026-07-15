package com.mobileapp.labelwatch.ui.screens.history

import com.mobileapp.labelwatch.data.models.ProductAnalysis

object HistoryManager {
    private val history = mutableListOf<ProductAnalysis>()
    fun addScan (
        analysis: ProductAnalysis
    ) {
        history.add(0, analysis)
    }
    fun getHistory(): List<ProductAnalysis> {
        return history
    }
    fun clear() {
        history.clear()
    }
}