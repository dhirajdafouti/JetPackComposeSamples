package com.android.sampleapplication1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.sampleapplication1.ui.theme.SampleApplication1Theme


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