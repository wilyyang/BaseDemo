package com.example.basedemo.ui.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.basedemo.R
import com.example.basedemo.ui.common.theme.BaseDemoTheme
import com.example.basedemo.ui.common.theme.Typo

@Composable
private fun TopBar(
    title : String? = null,
    height : Dp = 56.dp,
    iconId : Int? = null,
    onClickNavigation : (() -> Unit) = { }
) {
    title?.let {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            // 드로어 아이콘
            iconId?.let {

                IconButton(
                    onClick = { onClickNavigation() },
                    enabled = true,
                    modifier = Modifier.size(height)
                ) {
                    Image(
                        painter = painterResource(id = iconId),
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .fillMaxHeight(),
                        contentScale = ContentScale.None,
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.black))
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))
            }

            // 타이틀
            Text(
                text = title,
                style = Typo.s1.style,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTopBar(){
    BaseDemoTheme {
        Column {
            TopBar(
                title = "타이틀",
                iconId = R.drawable.ic_arrow_left_48px
            )
        }
    }
}