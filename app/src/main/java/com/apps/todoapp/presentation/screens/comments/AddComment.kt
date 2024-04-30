package com.apps.todoapp.presentation.screens.comments


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.apps.todoapp.presentation.screens.components.CustomTextField
import com.apps.todoapp.R
import com.apps.todoapp.domain.model.Comment
import com.apps.todoapp.presentation.screens.comments.components.CommentCard
import com.apps.todoapp.storage.UserDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddComment(
    thoughtId : String ,
    commentViewModel: CommentViewModel = CommentViewModel(),
    onDismissRequest: () -> Unit) {
    var comment by remember{ mutableStateOf("") }
    val lifecycle = LocalLifecycleOwner.current
    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        modifier = Modifier.fillMaxSize()
    ) {
        Column (modifier = Modifier
            .verticalScroll(rememberScrollState())
            .align(Alignment.CenterHorizontally)){
            Text(
                text = "Comments",
                style = TextStyle(
                    fontWeight = FontWeight(1000),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter_extrabold))
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            CustomTextField(
                labelText = "Add a comment",
                value = comment,
                onTextChange = {
                    comment = it
                },
                trailingIcon = {
                    IconButton(onClick = { if(comment.isNotEmpty()){
                        commentViewModel.writeComment(thoughtId, Comment(comment = comment, commentedBy = UserDetails.username ?: ""))
                        Log.e("TAG", "AddComment: added", )
                    } }) {
                        Icon(painter = painterResource(id = R.drawable.send), contentDescription = null )
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                onClick = {

                }
            )

            commentViewModel.getComments(thoughtId)


        }
        commentViewModel.getComments(thoughtId)
        LazyColumn {
            commentViewModel.comments.observe(lifecycle, Observer {
                    items(it.size) {index->
                        Log.e("TAG", "AddComment:${commentViewModel.comments.value?.get(index)?.comment} ", )
                        Log.e("TAG", "AddComment:${commentViewModel.comments.value?.get(index)?.commentedBy} ", )
                        CommentCard(
                            commenter = commentViewModel.comments.value?.get(index)?.commentedBy ?: "",
                            comment = commentViewModel.comments.value?.get(index)?.comment ?: ""
                        )
                    }

            })
        }

    }
}