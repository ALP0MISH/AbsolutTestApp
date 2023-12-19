package com.example.tzapp.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tzapp.presentation.theme.LightBlue

private const val BackgroundOpacity = 0.25f
private const val NumberOfSegments = 8
private val StrokeWidth = 4.dp
private val SegmentGap = 8.dp
const val MAX_PROGRESS = 1f

@Composable
fun SegmentedProgress(
    segmentsSize: Float,
    progress: Float,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        SegmentedProgressIndicator(
            progress = progress,
            modifier = Modifier,
            color = LightBlue,
            backgroundColor = LightGray,
            strokeWidth = 6.dp,
            numberOfSegments = segmentsSize.toInt(),
            segmentGap = 4.dp
        )
    }
}

@Composable
fun SegmentedProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = color.copy(alpha = BackgroundOpacity),
    strokeWidth: Dp = StrokeWidth,
    numberOfSegments: Int = NumberOfSegments,
    segmentGap: Dp = SegmentGap
) {
    val gap: Float
    val stroke: Float
    with(LocalDensity.current) {
        gap = segmentGap.toPx()
        stroke = strokeWidth.toPx()
    }
    Canvas(
        modifier
            .progressSemantics(progress)
            .fillMaxWidth()
            .height(strokeWidth)
            .focusable()
    ) {
        drawSegments(MAX_PROGRESS, backgroundColor, stroke, numberOfSegments, gap)
        drawSegments(progress, color, stroke, numberOfSegments, gap)
    }
}

private fun DrawScope.drawSegments(
    progress: Float,
    color: Color,
    strokeWidth: Float,
    segments: Int,
    segmentGap: Float,
) {
    val width = size.width
    val start = 0f
    val gaps = (segments - 1) * segmentGap
    val segmentWidth = (width - gaps) / segments
    val barsWidth = segmentWidth * segments
    val end = barsWidth * progress + (progress * segments).toInt() * segmentGap

    repeat(segments) { index ->
        val offset = index * (segmentWidth + segmentGap)
        if (offset < end) {
            val barEnd = (offset + segmentWidth).coerceAtMost(end)
            drawLine(
                color,
                Offset(start + offset, 0f),
                Offset(barEnd, 0f),
                strokeWidth
            )
        }
    }
}