package com.example.horizontalpager.ui.theme

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.horizontalpager.Calc
import com.example.horizontalpager.Calendar
import com.example.horizontalpager.Notepad
import com.example.horizontalpager.R
import com.example.horizontalpager.Settings
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)


sealed class Page {
    object Notepad : Page()
    object Calendar : Page()
    object Calc : Page()
    object Settings: Page()
    }

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    val pagerState = rememberPagerState()
    val matrix = remember { ColorMatrix() }
    val pages = listOf(Page.Notepad,Page.Calendar,Page.Calc,Page.Settings)

Column(modifier = Modifier
    .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    ) {


    Row(
        modifier = Modifier
            .padding(vertical = 0.dp)
            .fillMaxHeight(0.97f),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalPager(
            pageCount = pages.size,
            state = pagerState
        ) {pageIndex ->
            when (pages[pageIndex]) {
                Page.Calendar -> Calendar()
                Page.Calc -> Calc()
                Page.Notepad -> Notepad()
                Page.Settings -> Settings()

            }

        }
    }


    fun PagerState.offsetForPage(page: Int) = (currentPage - page) + currentPageOffsetFraction
    fun PagerState.indicatorOffsetForPage(page: Int) =
        1f - offsetForPage(page).coerceIn(-1f, 1f).absoluteValue


    Row(
        modifier = Modifier

            .width(32.dp * pages.size)
            .height(48.dp)


    ) {
        for (i in 0 until pages.size) {
            val offset = pagerState.indicatorOffsetForPage(i)
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .weight(.5f + (offset * 3f))
                    .height(8.dp)
                    .background(
                        color = Color.Black,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    Modifier
                        .size(
                            lerp(14.dp, 32.dp, offset)
                        )
                        .blur(
                            radius = lerp(0.dp, 16.dp, offset),
                            edgeTreatment = BlurredEdgeTreatment.Unbounded,
                        )
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Cyan,
                                    Color.Magenta,
                                )
                            ),
                            shape = CircleShape
                        )
                )
                Box(
                    Modifier
                        .size(
                            lerp(14.dp, 22.dp, offset)
                        )
                        .background(
                            color = Color.Black,
                            shape = CircleShape,
                        )
                )
            }
        }
    }


}

}

