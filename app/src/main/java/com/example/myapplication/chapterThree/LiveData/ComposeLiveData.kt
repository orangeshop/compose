package com.example.myapplication.chapterThree.LiveData

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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.chapterThree.VIewModel.TodoTopViewModel


class ToDoViewModel : ViewModel(){
    private val _text = MutableLiveData("")
    val text : LiveData<String> get() = _text

//    val todoList = mutableStateListOf<ToDoData>()

    private val _rawtodoList = mutableListOf<ToDoData>()
    private val _todoList = MutableLiveData<List<ToDoData>>(_rawtodoList)
    val todoList : LiveData<List<ToDoData>> get() = _todoList

    // mutalbeStateListof - 추가, 삭제 , 대입 -> UI 가 갱신됨, 각 항목의 필드가 바뀌었을 때 -> 갱신이 안됨
    // LiveData<List<X>>.observeAsState() - list가 통채로 다른 list로 바뀌었을 때만 State가 갱신됨
    val onSummit: (String) -> Unit = {text ->
        val key = (_rawtodoList.lastOrNull()?.key ?: 0) + 1
        _rawtodoList.add(ToDoData(key, text))
        _todoList.value = _rawtodoList.toMutableList().apply {
            this.addAll(_rawtodoList)
        }
        textUpdate(text)
    }

    val onToggle: (Int, Boolean) -> Unit = {key, check ->
        val i = _rawtodoList.indexOfFirst { it.key == key }
        _rawtodoList[i] = _rawtodoList.get(i).copy(done = check)
        _todoList.value = _rawtodoList.toMutableList().apply {
            this.addAll(_rawtodoList)
        }
    }

    val onDelete: (Int) -> Unit = {key ->
        val i = _rawtodoList.indexOfFirst { it.key == key }
        _rawtodoList.removeAt(i)
        _todoList.value = _rawtodoList.toMutableList().apply {
            this.addAll(_rawtodoList)
        }
    }

    val onEdit: (Int, String) -> Unit = {key, text ->
        val i = _rawtodoList.indexOfFirst { it.key == key }
        _rawtodoList[i] = _rawtodoList.get(i).copy(text = text)
        _todoList.value = _rawtodoList.toMutableList().apply {
            this.addAll(_rawtodoList)
        }
    }

    fun textUpdate(newText:String){
        _text.value = newText
    }
}

@Composable
fun TodoTopLivedata(viewModel: ToDoViewModel = viewModel()) {

    Scaffold {
        Column(
            modifier = Modifier.padding(it)
        ) {
            inputRow(
                viewModel.text.observeAsState("").value,
                { viewModel.textUpdate(it) },
                viewModel.onSummit
            )

            val items = viewModel.todoList.observeAsState(emptyList()).value
            LazyColumn {
                items(items , key = {it.key}) { index ->
                    Todo(
                        index,
                        onToggle = viewModel.onToggle,
                        onDelete = viewModel.onDelete,
                        onEdit = viewModel.onEdit
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
    TodoTopViewModel()

}

@Composable
@Preview(showBackground = true)
fun TodoPreview2() {
    Todo(ToDoData(0, "asd", false))

}