package com.example.myapplication.chapterTwo

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TodoTop() {
    val (getText, setText) = remember { mutableStateOf("") }
    val todoList = remember { mutableStateListOf<ToDoData>() }
    // mutableStateList가 추가,삭제, 변경 되어씅ㄹ 경우에만
    val onSummit: (String) -> Unit = {text ->
        val key = (todoList.lastOrNull()?.key ?: 0) + 1
        todoList.add(ToDoData(key, text))
        setText("")
    }

    val onToggle: (Int, Boolean) -> Unit = {key, check ->
        val i = todoList.indexOfFirst { it.key == key }
        todoList[i] = todoList.get(i).copy(done = check)
    }

    val onDelete: (Int) -> Unit = {key ->
        val i = todoList.indexOfFirst { it.key == key }
        todoList.removeAt(i)
    }

    val onEdit: (Int, String) -> Unit = {key, text ->
        val i = todoList.indexOfFirst { it.key == key }
        todoList[i] = todoList.get(i).copy(text = text)
    }

    Scaffold {
        Column(
            modifier = Modifier.padding(it)
        ) {
            inputRow(getText, setText, onSummit)

            LazyColumn {
                items(todoList, key = {it.key}) { index ->
                    Todo(index,
                        onToggle = onToggle,
                        onDelete = onDelete,
                        onEdit = onEdit
                    )
                }
            }
        }
    }


}

@Composable
fun Todo(
    toDoData : ToDoData,
    onEdit: (key : Int, text: String) -> Unit = {_, _ ->},
    onToggle: (key : Int, check:Boolean) -> Unit = {_, _ ->},
    onDelete: (key : Int) -> Unit = {}
){
    var isEditing by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {


        Crossfade(targetState = isEditing) {
            when(it){
                false -> {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text(text = "완료")
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { check ->
                                onToggle(toDoData.key, check)
                            }
                        )


                        Button(onClick = {
                            isEditing = true
                        }) {
                            Text(text = "수정")
                        }

                        Button(onClick = {
                            onDelete(toDoData.key)
                        }) {
                            Text(text = "삭제")
                        }
                    }
                }
                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        val (newText, setNewText) = remember { mutableStateOf(toDoData.text) }
                        OutlinedTextField(
                            value = newText,
                            onValueChange = setNewText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            onEdit(toDoData.key, newText)
                            isEditing = false
                        }) {
                            Text(text = "완료")
                        }

                    }
                }
            }
        }

    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)

@Composable
fun inputRow(textInput : String,
             onChange: (String) -> Unit,
             onSummit : (String) -> Unit
             ){
    Row(
        Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = textInput,
            onValueChange = onChange,
            placeholder = { Text("input") },
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Button(
            onClick = { onSummit(textInput) },
            modifier = Modifier.height(IntrinsicSize.Max)
        ) {
            Text(text = "입력")
        }
    }
}



@Composable
@Preview(showBackground = true)
fun TodoPreview() {
    TodoTop()

}

@Composable
@Preview(showBackground = true)
fun TodoPreview2() {
    Todo(ToDoData(0 ,"asd", false))

}