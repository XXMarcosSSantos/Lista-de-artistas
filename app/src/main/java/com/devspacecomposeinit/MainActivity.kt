package com.devspacecomposeinit

import android.os.Bundle
import android.provider.MediaStore.Audio.Artists
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devspacecomposeinit.ui.theme.ComposeInitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeInitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val leonardo = Artist(
                        name = "Leonardo Da Vinci",
                        lastSeenOnline = "3 Minutes ago",
                        image = R.drawable.ic_leonardo_da_vinci,
                        art = R.drawable.ic_mona_lisa
                    )
                    val picasso = Artist(
                        name = "Pablo Picasso",
                        lastSeenOnline = "5 Minutes ago",
                        image = R.drawable.ic_pablo_picasso,
                        art = R.drawable.ic_beijo
                    )

                    val salvador = Artist(
                        name = "Salvador Dali",
                        lastSeenOnline = "7 Minutes ago",
                        image = R.drawable.ic_salvador_dali,
                        art = R.drawable.ic_persistence_of_memory
                    )

                    val vanGogh = Artist(
                        name = "Vincent Van Gogh",
                        lastSeenOnline = "10 Minutes ago",
                        image = R.drawable.ic_vincent_van_gogh,
                        art = R.drawable.ic_starry_night
                    )

                    val artists = listOf(vanGogh, leonardo, salvador, picasso)

                    LazyColumn {
                        items(artists){ artist ->
                            ArtistCard(
                                artist = artist,
                            onclick = {
                                println("text" + artist.name)
                            }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ArtistCard(
    artist: Artist,
    onclick: () -> Unit
    ){
    Column (
        modifier = Modifier.padding(8.dp)
            .clickable(onClick = onclick)

    )
    {
    Row(verticalAlignment = Alignment.CenterVertically){
        Image(
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = artist.image),
            contentDescription = "Artist image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.size(16.dp))


        Column {
            Text (
                text =  artist.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                 text = artist.lastSeenOnline,
                 color = Color.Gray

            )
            }
        }
        Card(
            modifier = Modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ){
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = artist.art),
                contentDescription = "Artist Art")
        }
    }
}

data class Artist(
    val name: String,
    val lastSeenOnline: String,
   @DrawableRes val image: Int,
   @DrawableRes val art: Int
)

@Preview(showBackground = true)
@Composable
fun ArtistCardPreview() {
    ComposeInitTheme {
        val artist= Artist(
            name = "Leonardo Da Vinci",
            lastSeenOnline = "3 Minutos agora",
            image = R.drawable.ic_leonardo_da_vinci,
            art = R.drawable.ic_mona_lisa
        )

        ArtistCard(
           artist = artist,
            onclick = {
            })
    }
}







