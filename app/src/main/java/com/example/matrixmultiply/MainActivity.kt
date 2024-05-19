package com.example.matrixmultiply

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matrixmultiply.ui.theme.MatrixMultiplyTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatrixMultiplyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigator()
                }
            }
        }
    }
}

@Composable
fun MatrixMultiplierScreen() {
    val context = LocalContext.current

    var s11 by remember { mutableStateOf(0) }
    var s12 by remember { mutableStateOf(0) }
    var s13 by remember { mutableStateOf(0) }
    var s21 by remember { mutableStateOf(0) }
    var s22 by remember { mutableStateOf(0) }
    var s23 by remember { mutableStateOf(0) }
    var s31 by remember { mutableStateOf(0) }
    var s32 by remember { mutableStateOf(0) }
    var s33 by remember { mutableStateOf(0) }
    var t11 by remember { mutableStateOf(0) }
    var t12 by remember { mutableStateOf(0) }
    var t13 by remember { mutableStateOf(0) }
    var t21 by remember { mutableStateOf(0) }
    var t22 by remember { mutableStateOf(0) }
    var t23 by remember { mutableStateOf(0) }
    var t31 by remember { mutableStateOf(0) }
    var t32 by remember { mutableStateOf(0) }
    var t33 by remember { mutableStateOf(0) }

    var p11 by remember { mutableStateOf(0) }
    var p12 by remember { mutableStateOf(0) }
    var p13 by remember { mutableStateOf(0) }
    var p21 by remember { mutableStateOf(0) }
    var p22 by remember { mutableStateOf(0) }
    var p23 by remember { mutableStateOf(0) }
    var p31 by remember { mutableStateOf(0) }
    var p32 by remember { mutableStateOf(0) }
    var p33 by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Matrix Multiplier",
            modifier = Modifier.padding(10.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        MatrixInput(title = "Matrix S", values = listOf(
            listOf(s11, s12, s13),
            listOf(s21, s22, s23),
            listOf(s31, s32, s33)
        ), onClick = { row, col, value ->
            when {
                row == 0 && col == 0 -> s11 = value
                row == 0 && col == 1 -> s12 = value
                row == 0 && col == 2 -> s13 = value
                row == 1 && col == 0 -> s21 = value
                row == 1 && col == 1 -> s22 = value
                row == 1 && col == 2 -> s23 = value
                row == 2 && col == 0 -> s31 = value
                row == 2 && col == 1 -> s32 = value
                row == 2 && col == 2 -> s33 = value
            }
        })

        Spacer(modifier = Modifier.height(10.dp))

        Text("x", fontSize = 30.sp, color = MaterialTheme.colorScheme.onBackground)

        Spacer(modifier = Modifier.height(10.dp))

        MatrixInput(title = "Matrix T", values = listOf(
            listOf(t11, t12, t13),
            listOf(t21, t22, t23),
            listOf(t31, t32, t33)
        ), onClick = { row, col, value ->
            when {
                row == 0 && col == 0 -> t11 = value
                row == 0 && col == 1 -> t12 = value
                row == 0 && col == 2 -> t13 = value
                row == 1 && col == 0 -> t21 = value
                row == 1 && col == 1 -> t22 = value
                row == 1 && col == 2 -> t23 = value
                row == 2 && col == 0 -> t31 = value
                row == 2 && col == 1 -> t32 = value
                row == 2 && col == 2 -> t33 = value
            }
        })

        Spacer(modifier = Modifier.height(30.dp))

        Text("=", fontSize = 30.sp, color = MaterialTheme.colorScheme.onBackground)

        Spacer(modifier = Modifier.height(30.dp))

        MatrixOutput(values = listOf(
            listOf(p11, p12, p13),
            listOf(p21, p22, p23),
            listOf(p31, p32, p33)
        ))

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(
                onClick = {
                    p11 = (s11 * t11 + s12 * t21 + s13 * t31) % 10
                    p12 = (s11 * t12 + s12 * t22 + s13 * t32) % 10
                    p13 = (s11 * t13 + s12 * t23 + s13 * t33) % 10

                    p21 = (s21 * t11 + s22 * t21 + s23 * t31) % 10
                    p22 = (s21 * t12 + s22 * t22 + s23 * t32) % 10
                    p23 = (s21 * t13 + s22 * t23 + s23 * t33) % 10

                    p31 = (s31 * t11 + s32 * t21 + s33 * t31) % 10
                    p32 = (s31 * t12 + s32 * t22 + s33 * t32) % 10
                    p33 = (s31 * t13 + s32 * t23 + s33 * t33) % 10
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Calculate")
            }
            Button(
                onClick = {
                    s11 = 0; s12 = 0; s13 = 0
                    s21 = 0; s22 = 0; s23 = 0
                    s31 = 0; s32 = 0; s33 = 0
                    t11 = 0; t12 = 0; t13 = 0
                    t21 = 0; t22 = 0; t23 = 0
                    t31 = 0; t32 = 0; t33 = 0
                    p11 = 0; p12 = 0; p13 = 0
                    p21 = 0; p22 = 0; p23 = 0
                    p31 = 0; p32 = 0; p33 = 0
                    Toast.makeText(context, "All Reset", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Reset")
            }
        }
    }
}

@Composable
fun MatrixInput(title: String, values: List<List<Int>>, onClick: (Int, Int, Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(title, fontSize = 18.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(8.dp))
        values.forEachIndexed { rowIndex, row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                row.forEachIndexed { colIndex, value ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.secondary)
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable { onClick(rowIndex, colIndex, (value + 1) % 10) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = value.toString(), fontSize = 18.sp, color = MaterialTheme.colorScheme.onSecondary)
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun MatrixOutput(values: List<List<Int>>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Text("Result", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(8.dp))
        values.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                row.forEach { value ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.secondary)
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = value.toString(), fontSize = 18.sp, color = MaterialTheme.colorScheme.onSecondary)
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen(onTimeout = {}) // No-op for preview
}
@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val timeoutMillis = 1000L // 3 seconds
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(timeoutMillis)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(bottom = 100.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.monster),
                contentDescription = "Splash Image",
                modifier = Modifier
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Matrix Multiply",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
        }
    }
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(onTimeout = {
                navController.navigate("main") {
                    popUpTo("splash") { inclusive = true }
                }
            })
        }
        composable("main") {
            MatrixMultiplierScreen()
        }
    }
}

