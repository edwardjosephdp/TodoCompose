package com.edwardjdp.todocompose.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.edwardjdp.todocompose.data.models.Priority
import com.edwardjdp.todocompose.data.models.TodoTask
import com.edwardjdp.todocompose.ui.viewmodels.SharedViewModel
import com.edwardjdp.todocompose.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: TodoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context = context)
                        }
                    }

                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChanged = sharedViewModel::updateTitle,
                description = description,
                onDescriptionChanged = {
                    sharedViewModel.description.value = it
                },
                priority = priority,
                onPrioritySelected = {
                    sharedViewModel.priority.value = it
                }
            )
        },
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty.",
        Toast.LENGTH_SHORT
    ).show()
}
