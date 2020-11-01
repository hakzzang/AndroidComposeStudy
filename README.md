# AndroidComposeStudy
안드로이드 컴포즈에 대해서 공부하기 위해서 만드는 레파지토리.

[공부자료] : https://www.raywenderlich.com/7032631-jetpack-compose-tutorial-for-android-getting-started)

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
 
 3. 시작 방법
  현재, 해당 프로젝트의 안드로이드 버전은 `Android Studio 4.2, Canary 12` 입니다.
  ![image](https://user-images.githubusercontent.com/22374750/97795163-2a6ce480-1c46-11eb-9f83-6153f639057d.png)
