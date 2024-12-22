package com.android.sampleapplication1.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BadgedBox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.sampleapplication1.ui.theme.SampleApplication1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun UiComponenets() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        CheckBoxes()
        CheckboxMinimalExample()
        MySwitch()
        Spacer(modifier = Modifier.height(16.dp))
        //  BadgeComposable()
        //  ChipComposable()
        //   Spacer(modifier = Modifier.height(16.dp))
        //   HorizontalDividerComposable()
        //  Spacer(modifier = Modifier.height(16.dp))
        //  VerticalDividerComposable()
        //   FloatingActionButtonComposable()
      //  ProgressindicatorComposable()
        IndeterminateCircularIndicator()
        LinearDeterminateIndicator()
    }
}
@Composable
fun LinearDeterminateIndicator() {
    var currentProgress by remember { mutableStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope() // Create a coroutine scope

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
//                for (i in 1..100) {
//                    currentProgress=(i.toFloat() / 100)
//                    delay(100)
//                }
                loading = false // Reset loading when the coroutine finishes
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            LinearProgressIndicator(
                progress = { currentProgress },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

/** Iterate the progress value */
suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndeterminateCircularIndicator() {
    var loading by remember { mutableStateOf(false) }

    Button(onClick = { loading = true }, enabled = !loading) {
        Text("Start loading")
    }

    if (!loading) return

    LinearProgressIndicator(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
        gapSize = ProgressIndicatorDefaults.LinearTrackStopIndicatorSize
    )
}

@Composable
fun ProgressindicatorComposable() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(
            modifier = Modifier.size(100.dp),
            color = Color.Red,
            strokeWidth = 5.dp,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round
        )
        Spacer(modifier = Modifier.height(16.dp))
        var progress by remember { mutableStateOf(0.1f) }
        val animatedProgress by
        animateFloatAsState(
            targetValue = progress,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(
                progress = animatedProgress,
                modifier = Modifier.size(100.dp),
                color = Color.Red,
                strokeWidth = 5.dp,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Round
            )
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedButton(onClick = { if (progress < 1f) progress += 0.1f }) { Text("Increase") }

        }


    }
}

@Composable
fun FloatingActionButtonComposable() {
    var count1 by remember { mutableStateOf(0) }
    var count2 by remember { mutableStateOf(0) }
    var count3 by remember { mutableStateOf(0) }
    var count4 by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Floating Action Button Clicked $count1 times")
        Spacer(modifier = Modifier.height(16.dp))
        FloatingActionButton(
            contentColor = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(6.dp),
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            onClick = {
                count1++
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                tint = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(" Small Floating Action Button Clicked $count2 times")
        Spacer(modifier = Modifier.height(16.dp))
        SmallFloatingActionButton(
            contentColor = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(6.dp),
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            onClick = {
                count2++
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                tint = Color.Blue
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(" Large Floating Action Button Clicked $count3 times")
        Spacer(modifier = Modifier.height(16.dp))
        LargeFloatingActionButton(
            contentColor = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(6.dp),
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            onClick = {
                count3++
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                tint = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(" Large Floating Action Button Clicked $count4 times")
        Spacer(modifier = Modifier.height(16.dp))
        ExtendedFloatingActionButton(
            contentColor = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(6.dp),
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            onClick = {
                count4++
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                    tint = Color.Blue
                )
                Text(text = "Extended FAB")
            }

        }
    }

}

@Composable
fun VerticalDividerComposable() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Vertical Divider1")
        VerticalDivider(
            thickness = 2.dp,
            color = Color.Red
        )
        Text("Vertical Divider2")
        VerticalDivider(
            thickness = 2.dp,
            color = Color.Red
        )
    }
}

@Composable
fun HorizontalDividerComposable() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Horizontal Divider", modifier = Modifier.padding(start = 36.dp))
        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp),
            color = Color.Red
        )
        Text("Horizontal Divider with Padding", modifier = Modifier.padding(start = 36.dp))
        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp),
            color = Color.Red
        )
    }
}

@Composable
fun ChipComposable() {
    TODO("Not yet implemented")
}

@Composable
fun BadgeComposable() {
    var itemCount by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("$itemCount")
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Shopping Cart"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            itemCount++
        }) {
            Text("Add to Cart")
        }
    }
}


@Preview
@Composable
private fun SelectionUiComponentPreview() {
    SampleApplication1Theme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            UiComponenets()
        }
    }

}

data class ToggleableInfo(
    val text: String,
    val isChecked: Boolean
)

@Composable
fun MySwitch() {
    var checked by remember { mutableStateOf(ToggleableInfo(text = "DarkMode", isChecked = true)) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = checked.text,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = checked.isChecked,
            onCheckedChange = { checked = checked.copy(isChecked = it) },
            thumbContent = {
                Icon(
                    imageVector = if (checked.isChecked) {
                        Icons.Default.Check
                    } else {
                        Icons.Default.Close
                    },
                    contentDescription = "Switch Icon"
                )
            }
        )

    }


}

@Composable
fun CheckboxMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Minimal checkbox"
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }

    Text(
        if (checked) "Checkbox is checked" else "Checkbox is unchecked"
    )
}

@Composable
fun CheckBoxes() {
    val checkboxes = remember {
        mutableStateListOf(
            ToggleableInfo("Checkbox 1", true),
            ToggleableInfo("Checkbox 2", false),
            ToggleableInfo("Checkbox 3", false),
            ToggleableInfo("Checkbox 4", false)
        )
    }

    var triState by remember { mutableStateOf(ToggleableState.Indeterminate) }

    val toggleTriState = {
        triState = when (triState) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
        checkboxes.indices.forEach { index ->
            checkboxes[index] = checkboxes[index].copy(isChecked = triState == ToggleableState.On)
        }
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        TriStateCheckbox(
            state = triState,
            onClick = toggleTriState
        )
        Text(text = "File Type")
    }

    checkboxes.forEachIndexed { index, info ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    checkboxes[index] = info.copy(isChecked = !info.isChecked)
                }
        ) {
            Checkbox(
                checked = info.isChecked,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red,
                    checkmarkColor = Color.Green
                ),
                onCheckedChange = { ischecked ->
                    checkboxes[index] = info.copy(isChecked = ischecked)
                }
            )
            Text(
                text = info.text,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 10.dp)
            )

        }


    }
}