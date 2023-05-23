@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalTextApi::class,
    ExperimentalFoundationApi::class
)

package com.example.horizontalpager.calculatorfiles

import android.graphics.BitmapFactory
import android.graphics.Color.parseColor
import android.media.Image
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


@Composable

fun Calculator(
    state:CalculatorState,
    modifier:Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit

) {


    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState ()




    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {





}





Box(modifier = modifier) {

 val context = LocalContext.current





  Column(
      modifier = Modifier
          .fillMaxWidth()
          .align(Alignment.BottomCenter)
          .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(buttonSpacing)
  ) {


      var text by remember { mutableStateOf("") }



      TextField(

          value = state.number1 + (state.operation?.symbol ?: "") + state.number2,
          onValueChange = {},
          textStyle = TextStyle(
              fontSize = 70.sp,
              fontStyle = FontStyle.Italic,
              color = Color.White,
              textAlign = TextAlign.End,

          ),
          colors = TextFieldDefaults.textFieldColors(containerColor = Transparent,
              disabledIndicatorColor = Transparent,
              unfocusedIndicatorColor = Transparent,
              focusedIndicatorColor = Transparent ),
          maxLines = 2,
          readOnly = true,
          modifier = Modifier.fillMaxWidth(),


      )



      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
      ) {
          CalculatorButton(symbol = "AC",
              modifier = Modifier
                  .background(Color.Red)
                  .aspectRatio(2f)
                  .weight(2f),
              onClick = {
                  onAction(CalculatorAction.Clear)
              }
          )
          CalculatorButton(symbol = "Del",
              modifier = Modifier
                  .background(Color.Red)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Delete)
              }
          )
          CalculatorButton(symbol = "/",
              modifier = Modifier
                  .background(Color.Green)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
              }
          )
      }
      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
      ) {
          CalculatorButton(symbol = "7",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(7))
              }
          )
          CalculatorButton(symbol = "8",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(8))
              }
          )
          CalculatorButton(symbol = "9",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(9))
              }
          )
          CalculatorButton(symbol = "x",
              modifier = Modifier
                  .background(Color.Green)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
              }
          )
      }
      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
      ) {
          CalculatorButton(symbol = "4",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(4))
              }
          )
          CalculatorButton(symbol = "5",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(5))
              }
          )
          CalculatorButton(symbol = "6",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(6))
              }
          )
          CalculatorButton(symbol = "-",
              modifier = Modifier
                  .background(Color.Green)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
              }
          )
      }
      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
      ) {
          CalculatorButton(symbol = "1",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(1))
              }
          )
          CalculatorButton(symbol = "2",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(2))
              }
          )
          CalculatorButton(symbol = "3",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Number(3))
              }
          )
          CalculatorButton(symbol = "+",
              modifier = Modifier
                  .background(Color.Green)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Operation(CalculatorOperation.Add))
              }
          )
      }
      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
      ) {
                          CalculatorButton(symbol = "0",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(2f)
                  .weight(2f),
              onClick = {
                  onAction(CalculatorAction.Number(0))
              }
          )
          CalculatorButton(symbol = ".",
              modifier = Modifier
                  .background(Color.Blue)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Decimal)
              }
          )
          CalculatorButton(symbol = "=",
              modifier = Modifier
                  .background(Color.Green)
                  .aspectRatio(1f)
                  .weight(1f),
              onClick = {
                  onAction(CalculatorAction.Calculate)
              }
          )
      }


  }
}
}



