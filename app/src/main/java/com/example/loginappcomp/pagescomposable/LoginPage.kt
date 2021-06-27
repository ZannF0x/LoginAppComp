package com.example.loginappcomp.pagescomposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.loginappcomp.R
import com.example.loginappcomp.ui.theme.primaryColor
import com.example.loginappcomp.ui.theme.whiteBackgroundColor
import androidx.compose.material.Icon as Icon

@Composable
fun LoginPage() {
    val image: Painter = painterResource(id = R.drawable.login_img)

    val emailValue = remember{ mutableStateOf("")}
    val passwordValue = remember{ mutableStateOf("")}

    val passwordVisibility = remember{ mutableStateOf(false)}

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){

        Box( // image in box
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            contentAlignment = Alignment
                .TopCenter){

            Image(
                painter = image,
                contentDescription = "login_img",
                modifier = Modifier.height(200.dp).fillMaxWidth().padding(top = 20.dp)
                )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .background(whiteBackgroundColor)
                .padding(10.dp)
        ) {

            Text(
                text = "Sign In",
                style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 0.2.em),
                fontSize = 30.sp
            )
            
            Spacer(modifier = Modifier.padding(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                OutlinedTextField(
                     value = emailValue.value,
                     onValueChange = {emailValue.value = it},
                     label = {(Text(text = "Email Address"))},
                    placeholder = {(Text(text = "Email Address"))},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                OutlinedTextField(value = passwordValue.value,
                    onValueChange = {passwordValue.value = it},
                    label = {(Text(text = "Password"))},
                    placeholder = {(Text(text = "Password"))},
                    modifier = Modifier.fillMaxWidth(0.8f),
                    trailingIcon = {
                        IconButton(onClick = {

                            passwordVisibility.value = !passwordVisibility.value

                        }) {

                            Icon(painter = painterResource(id =  R.drawable.ic_eye_password),
                                contentDescription = null,
                                tint = if (passwordVisibility.value) primaryColor else Color.Gray
                                )

                        }
                    },
                    singleLine = true,
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation()
                    )

                Spacer(modifier = Modifier.padding(10.dp))

                Button(onClick = {

                },modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)) {
                    
                    Text(text = "Sign In", fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.padding(5.dp))

                Text(text = "New around here? Create a new Account",
                    modifier = Modifier.clickable {}
                    )

                Spacer(modifier = Modifier.padding(20.dp))
            }

        }
    }
}