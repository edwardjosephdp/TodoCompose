package com.edwardjdp.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.edwardjdp.todocompose.ui.theme.*

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(MediumGray),
}
