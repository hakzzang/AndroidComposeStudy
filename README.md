# AndroidComposeStudy
안드로이드 컴포즈에 대해서 공부하기 위해서 만드는 레파지토리.

[공부자료] : https://www.raywenderlich.com/7032631-jetpack-compose-tutorial-for-android-getting-started)

### 구현 리스트 ✔️✔️
[ ] Modifier
[x] Chpater1
[x] Chapter2
[x] Chapter3

### 메인 화면

![image](https://user-images.githubusercontent.com/22374750/98081160-f1d54100-1eb9-11eb-9a99-a902f2295d7e.png)

### 1. 서론
모바일 앱 개발은 자주 트렌드가 바뀐다. 퍼포먼스, 안전성, 안정성 등이 중요하기 때문에 이 트렌드들을 아는 것은 중요합니다.
MVC/MVP에서 MVVM의 아키텍처로 사용되어지는 이유는 리액티브한 접근 때문일 지도 모릅니다. 뷰모델의 데이터스트림에 의해서 ui가 다시 그려지는 것은 MVVM의 장점이기 때문입니다.
그 외에도 에러처리, 쉬운 테스트 등의 이유가 있습니다.

최근 모바일 트렌드는 React와 Flutter와 같은 프레임워크, 프론트엔드 툴킷이 날이 갈수록 성장하고 있습니다.
지난 2019, 구글 I/O에서는 Jetpack Compose가 처음 소개되었고, Jetpack Compose는 declarative UI 프레임워크의 유행에 일치합니다.

### 2. Compose의 3가지 장점
- Declarative
 Jetpack Compose는 선언형 UI 프레임워크이빈다. 기존의 명령형 프로그래밍 개념에 의존하지 않고, 뷰를 그릴 수 있습니다.
 View를 숨겨야하는 예제에서는, 기존에는 findViewById()를 통해 view에 접근해서, setVisibility()를 호출해야합니다.
 이 선언형 UI인 Compose에서는 별도로 객체에 접근하는 것이 아니라, 기존에 작성해놓은 코드를 다시 실행시켜서 이를 해결할 수 있고,
 기존에 View를 접근하는 방법을 통해서 뷰를 수정하지 않을 수 있다.
 
- Independent
 만약에 LinearLayout의 새 버전이 나왔다고 하면, 새 버전의 OS가 필요했다. 이것은 조각화 문제로 인해서 운영체제가 다르더라도, 최신 UI를 사용하지 못 하는 현상을 해결할 수 있다.
Jetpack Compose를 사용하게 되면, 개발자가 OS 버전을 변경하지 않더라도, 새로운 기능을 추가할 수 있습니다. 사용자 기기의 운영 체제에 관계 없이 작동에 의존할 수 있습니다.
기존의 안드로이드 UI 키트에서 벗어나므로, View 계층으로 있는 오래된 문제를 해결하기 위한 시작점입니다.

- Composable
 Android는 10년이 넘게 출시되면서, View 클래스에서만 1만줄 이상의 코드가 있게 되었습니다. 이는 레거시 코드이며, 이를 해결하기 위해서 Compose를 사용해서 처음부터 시작할 수 있습니다.
 
 ### 3. 시작 방법
- 현재, 해당 프로젝트의 안드로이드 버전은 `Android Studio 4.2, Canary 12` 입니다.
![image](https://user-images.githubusercontent.com/22374750/97795163-2a6ce480-1c46-11eb-9f83-6153f639057d.png)

- app/build.gradle
``` gradle

buildFeatures {
  compose true
}
//...

dependencies{
  //현재 1.0.0-alpha06 버전
  implementation "androidx.compose.ui:ui:1.0.0-alpha06"
  implementation "androidx.compose.material:material:1.0.0-alpha06"
  implementation "androidx.ui:ui-tooling:1.0.0-alpha06"
}
```
- 기본 Android 코드
``` kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```

- 시작화면 결과

![image](https://user-images.githubusercontent.com/22374750/97795446-9bfa6200-1c49-11eb-8c00-1b5aed59814d.png)

### 챕터1
* 목표 : 챕터1에서는 Compose를 통해서 Text를 만들고, Text의 스타일을 추가해줍니다.

- ChapterOneCompose
 ChapterOneCompose는 챕터별로 컴포즈를 꾸밀 수 있도록 코드를 나누기 위해서 1,2,3,4... 순으로 컴포즈 클래스를 만들 예정
 단순히, 메소드를 만드는 것을 통해서 Compose 뷰를 만든다는 것에 있어서, 클래스를 나누면서 좋은 의미를 발견했습니다.
 
 해당 코드의 의미는 Compose의 Text를 이용해서 4개의 Text 뷰를 만들었으며, ColorTextStyle을 통해서 TextStyle을 별도로 만들 수 있다는 것을 알게되는 코드입니다.
 
```
class ChapterOneCompose : ChapterCompose() {
    @Composable
    fun ColorTextStyle(color: Color): TextStyle {
        return TextStyle(color = color, fontSize = 16.sp)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeStudyTheme {
            ContentView("감자튀김!")
        }
    }

    @Composable
    override fun ContentView(name : String) {
        Text(text = "Hello1 $name!", style = ColorTextStyle(Color.Black))
        Text(text = "Hello2 $name!", style = ColorTextStyle(Color.Yellow))
        Text(text = "Hello3 $name!", style = ColorTextStyle(Color.Red))
        Text(text = "Hello4 $name!", style = ColorTextStyle(Color.Gray))
    }
}
```
- ChapterFactory
위에서 만들게 되는 컴포즈들을 생성하는 팩토리 클래스입니다.

```
sealed class ChapterType {
    object One : ChapterType()
}

interface ChapterFactory {
    fun makeChapter(chapterType: ChapterType): ChapterCompose
}

class ChapterFactoryImpl : ChapterFactory{

    override fun makeChapter(chapterType: ChapterType): ChapterCompose {
        return when (chapterType) {
            ChapterType.One -> {
                ChapterOneCompose()
            }
        }
    }

}
```
- MainActivity
별도로, 메소드로 컴포즈를 만들더라도 정상적으로 작동하는 것을 알 수 있습니다.
```
class MainActivity : AppCompatActivity() {
    private val chapterFactory = ChapterFactoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val chapterCompose= chapterFactory.makeChapter(ChapterType.One)
                    chapterCompose.ContentView(name = "감자튀김")
                }
            }
        }
    }
}
```
- 결과

![image](https://user-images.githubusercontent.com/22374750/97832074-41c6d300-1d15-11eb-884f-124085cec05b.png)

### 챕터2
* 목표 : 챕터1에서 만든 Text를 리스트 형식으로 보여줍니다.

- ChapterTwoCompose
 해당 컴포즈에서는 기존에 만든 4개의 Text에 Column을 감싸줌으로 인해서 세로형 리스트로 만드는 것을 보여줍니다.

```

class ChapterTwoCompose : ChapterCompose() {
    @Composable
    fun ColorTextStyle(color: Color): TextStyle {
        return TextStyle(color = color, fontSize = 16.sp)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeStudyTheme {
            ContentView("감자튀김!")
        }
    }

    @Composable
    override fun ContentView(name : String) {
        Column {
            Text(text = "Hello1 $name!", style = ColorTextStyle(Color.Black))
            Text(text = "Hello2 $name!", style = ColorTextStyle(Color.Yellow))
            Text(text = "Hello3 $name!", style = ColorTextStyle(Color.Red))
            Text(text = "Hello4 $name!", style = ColorTextStyle(Color.Gray))
        }
    }
}
```

- 결과

![image](https://user-images.githubusercontent.com/22374750/97834414-2a8ae400-1d1b-11eb-97b1-6edce0059e71.png)

### 챕터3
* 목표 : 카드 모양의 아이템을 갖고 있는 리스트뷰를 만들기

- ChapterThreeCompose
 튜토리얼을 따라하면서, 챕터3를 만들었는데 컴포즈의 변화에 대해서 느낄 수 있었습니다. 해당 튜토리얼 코드가 1월에 작성되었는데, 1월에서 11월이 되는 동안 정말 많은 변화가 있었다는 것을 체감할 수 있었습니다.
 FoodCard를 가운데에 놓기 위해서 LinearLayout에서 뷰를 그리는 것을 생각하게 되었습니다. Spacer,Card,Spacer 순으로 뷰가 만들어질 때 각 값에 weight을 줘서, 가운데 정렬을 그렸습니다. 그리고 카드뷰로 그리기 위해서 Card 뷰 안에 Column을 둬서 세로형으로 Image, Text를 정렬했습니다. 그리고, 카드 모양으로 주기 위해서 RoundedCornerShapre를 주었고, elevation을 통해서 입체감을 형성시켰습니다.
 튜토리얼을 보면서 뷰를 그리고 있었는데, 많은 부분 변화했고 검색을 통해서 비슷하게나마 만들다 보니까, 해당 뷰를 작성하는 시간이 오래 걸렸었습니다.
 챕터3를 만들면서 느낀 점은 튜토리얼을 통해서 접근하기에는 리소스도 적고, 원리를 이해하는 것이 힘들다는 것을 알게 되었습니다. 그래서 각 뷰를 1개씩 그릴 수 있는 튜토리얼을 진행하고자 합니다.
 
```
class ChapterThreeCompose : ChapterCompose() {
    @Composable
    fun ColorTextStyle(color: Color): TextStyle {
        return TextStyle(color = color, fontSize = 16.sp)
    }

    @Composable
    fun FoodCard(food: Food, onClick: (Food) -> Unit) {
        val cardPadding = 16.dp
        val foodImage = imageResource(food.imageResource)
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.weight(8f)
            ) {
                Column(
                    Modifier
                        .clickable(onClick = {
                            onClick(food)
                        })
                        .padding(cardPadding)
                        .fillMaxWidth()
                ) {
                    Image(
                        foodImage,
                        modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column {
                        Text(food.name)
                        Text(food.content)
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeStudyTheme {
            ContentView("감자튀김!", makeFoodItems())
        }
    }

    @Composable
    override fun ContentView(name: String, foodItems: List<Food>) {
        ScrollableColumn(Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
            foodItems.forEach { food ->
                Spacer(Modifier.padding(16.dp))
                FoodCard(food, onClick = { food ->

                })
            }
        }
    }

    private fun makeFoodItems(): List<Food> {
        return listOf(
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            )
        )
    }
}
```

- 결과

![image](https://user-images.githubusercontent.com/22374750/98066971-d52a1080-1e9b-11eb-8028-1e3474c48f36.png)
