package com.example.navcomponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController, userName: String?) {

    val itemList = remember { generateDummyList() }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to $userName",
            Modifier.padding(10.dp),
            color = Color.Black
        )


        LazyColumn {
            items(itemList) { item ->
                CustomListItemRow(item = item, onItemClick = { selectedItem ->

                    val model = navController.currentBackStackEntry?.arguments?.putParcelable(
                        "Model", selectedItem )
                    navController.navigate("${Routes.Details.route}/${model}")
                })
            }
        }

    }
}

@Composable
fun CustomListItemRow(item: PlayerModel, onItemClick: (PlayerModel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .padding(4.dp),
        elevation = 4.dp
    ) {
        Column(  modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = item.img),
                    contentDescription = null, // Provide a content description if needed
                    modifier = Modifier
                        .weight(0.25f)
                        .height(50.dp),
                    contentScale = ContentScale.Inside
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier =
                    Modifier.weight(0.75f)
                ) {
                    Text(text = item.name, style = TextStyle(fontWeight = FontWeight.Bold))
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Experience :"+item.experience, modifier = Modifier.padding(top = 4.dp),
                style = TextStyle(fontSize = 12.sp))
            Text(text = "Age :"+item.age, modifier = Modifier.padding(top = 4.dp),
                style = TextStyle(fontSize = 12.sp))
            Text(text = "Weight: ${item.weight} ", modifier = Modifier.padding(top = 4.dp),
                style = TextStyle(fontSize = 12.sp))
        }

    }
}


fun generateDummyList(): List<PlayerModel> {
    return listOf(
        PlayerModel(
            1,
            "MALIK BEASLEY",
            R.drawable.img,
            "1.93m",
            "26 years",
            "187lb (85kg)",
            "7 Years",
            "The son of Michael and Deena Beasley… Family is very important to Malik… Education and receiving his degree from Florida State was very important to Malik and his parents… His father played professional basketball in Chili, the Dominican Republic and Puerto Rico before Malik was born… Grandfather, father and mother are all actors… Chose Florida State over Maryland, St. John’s, UCLA, UConn, VCU, Oregon, Wake Forest and Georgia… As a junior in high school, averaged 19.1 points, 8.3 rebounds, 2.4 assists and 2.1 steals in leading St. Francis to the state"
        ),
        PlayerModel(
            2,
            "STEVEN ADAMS",
            R.drawable.img1,
            "2.11m",
            "30 years",
            "265lb (120kg)",
            "10 Years",
            "Born July 20, 1993 in Rotorua, New Zealand… First lottery pick and first round pick to come out of New Zealand in NBA Draft history… One of 18 siblings, six of whom played basketball for New Zealand… All of his brothers stand between 6-10 to 6-11 and his sisters between 6-5 and 6-6… Half-sister Dame Valerie is a 2008 and 2016 Olympic champion and four-time world champion in the shot put… Favorite movie is “Nacho Libre” and favorite song is “Bohemian Rhapsody”… Plays guitar."
        ),
        PlayerModel(
            3,
            "SANTI ALDAMA",
            R.drawable.img_2,
            "2.13m",
            "22 years",
            "215lb (98kg)",
            "2 Years",
            "Born Jan. 10, 2001 in Las Palmas, Spain… Full name is Santiago Aldama Toledo… Son of Maria Isabel Toledo Jimenez and Santiago Aldama Aleson… His father was a professional basketball player in Spain and Portugal and a longtime member of the Spanish National Team who played in the 1992 Olympics in Barcelona… His uncle, Santiago Toledo, also played basketball professionally in Spain, Portugal and Italy."
        ),
        PlayerModel(
            4,
            "GIANNIS ANTETOKOUNMPO",
            R.drawable.img_4,
            "2.13m",
            "28 years",
            "243lb (110kg)",
            "10 Years",
            "2019 FIBA World Cup: Averaged 14.8 points, 8.8 rebounds and 2.4 assists in 5 games, leading Greece to the Second Round ... shot 52.5% from the field ... 2016 Olympic Qualifying: In 3 Olympic Qualifying games for Greece he averaged 15.3 points, 5.7 rebounds, 2.0 assists and a tournament-high 2.0 blocks per game ... 2014 FIBA World Cup: Averaged 6.3 points, 4.3 rebounds and 0.3 assists in 16.0 minutes for his native Greece ... posted highs of 15 points against Puerto Rico, and 6 rebounds against the Philippines and Argentina ... 2013 U20 European Championships: Played in 10 games for Greece’s U20 National Team and averaged 8.0 points, 7.6 rebounds and 2.2 assists ... ranked second for the tournament in defensive rebounds (7.0) and 7th in blocked shots (1.4) ... Greece finished the tournament in fifth place with an 8-2 record ... 2012-13: Played in 26 games for Filathlitikos AO (A2, second division) and averaged 9.5 points, 5.0 rebounds and 1.4 assists ... shot 62.1% from 2-point field goal range ... selected to play in the Greek League All-Star Game and scored 8 points ... grabbed a season-high 10 rebounds vs. GS Laviro on 2/23 ... posted a career-high 23 points vs. Irakleuo Crete on 3/2 ... had 13 points, 7 rebounds and a season-high 4 blocks vs. Ermis Lagkada on 4/13."
        ),
        // Add more items as needed
    )
}