# LoLUserHistory
롤 사용자의 전적과 게임통계를 구하는 api 서버입니다

# Api return

 “/api/summoner/{소환사명}”
 
 ## ReturnRecord20Dto
 ### 20게임 전체 통계와 각20게임의 데이터리스트가 담긴dto 입니다
|자료형|변수명|설명|
|------|---|---|
|String|summonerName|소환사명|
|float|winRate|20게임승률|
|float|aveDuty|20게임 평균 ~인분|
|float|aveKDA|20게임 평균KDA|
|float|aveKills|20게임 평균킬|
|float|aveDeath|20게임 평균데스|
|float|aveAssist|20게임 평균어시스트|
|List[ReturnRecordDto]|returnRecordDtos|각게임별 소환사의 통계데이터|


## ReturnRecordDto
### 각게임별 소환사의 통계와 통계점수등을 보여줍니다
|자료형|변수명|설명|
|------|---|---|
|String|champion|챔피언|
|String|gameMode|게임모드|
|String|gameDuration|게임시간(x분 x초)|
|String|timeStamp|게임끝난시간 "2023-02-09 23:05:21",|
|int|kill|킬|
|int|death|데스|
|int|assist|어시스트|
|boolean|win|승패여부|
|float|KDA|KDA|
|int|KDAScore|KDA기반점수|
|int|VisionScore|시야점수|
|int|growthScore|성장점수|
|int|combatScore|전투점수|
|float|duty|~인분|
|List[MemberDto]|teams|게임 내 유저들의 정보|


## MemberDto
### 게임 내 유저의 정보
|자료형|변수명|설명|
|------|---|---|
|String|name|소환사명|
|String|champion|챔피언|
|int|team|플레이어의소속팀|


# Service Flow
![File](https://user-images.githubusercontent.com/105182277/217821428-ea85edeb-2b46-493d-a6b6-711deca39c7e.jpg)

# 프로젝트에서 신경쓴점
## 이부분을 신경썼습니다.
### 최적의 조회 속도와 데이터의 재사용성
### 1.받아온데이터를 DB에 저장하고 DB에있는 데이터를 사용함으로서  
첫번째 조회평균 4s 의 조회보다  
![image](https://user-images.githubusercontent.com/105182277/217990042-28763939-de50-44ef-9387-6477f3546045.png)  
![image](https://user-images.githubusercontent.com/105182277/217990074-053fece9-1ded-4ef5-bf81-a536e9bfadf7.png)  
두번쨰 조회시 10배정도의 조회성능을 낼수있도록 하였습니다.  

### 2.Sigmoid 함수를 이용하여 ~인분/전투점수/시야점수/성장점수의 지표를 구체화해봤습니다.  
![image](https://user-images.githubusercontent.com/105182277/217994777-fab344ae-71e1-477c-b0a5-db0eba10935e.png)  
패작러들과 트롤들의 특징인 극단적으로 높거나 낮은 kda를 조정하고 팀별로 평균값을 구해 해당유저의 통계점수에 적용하였습니다  

### 3.Spring batch 사이즈를 설정함으로써 Jpa 의 성능을 최적화하여  
차후의 많은 데이터를 핸들링하도록 쿼리성능을 개선하였습니다!  

### 4.조회시 자동으로 추가된 게임만 갱신 및 겹치는게임을 제거하여 불필요한 Riot api 호출을 줄였습니다   
아래는 20게임중 12게임을 같이 플레이한 유저들의 첫조회 처리시간입니다  
![image](https://user-images.githubusercontent.com/105182277/217991412-4b915b00-a24e-4dfa-89ec-1af0b1a0fb30.png)  
![image](https://user-images.githubusercontent.com/105182277/217991533-7fee8879-7ae9-434e-a430-cd3fe0d436e3.png)  
절반가까이 되는 첫조회로직(두번째 유저 조회시 match데이터를 8개만 호출하였습니다)  


### 5.Match 데이터를 객체화 하여 DB 용량을 최적화하였습니다  
플레이어 A와 B가 같이 플레이한게임은 따로 필터링하여 api 호출을 하지않고  
저장된 db 에서 사용하고 Match데이터의 중복을 막았습니다  
![image](https://user-images.githubusercontent.com/105182277/217991063-bb2c3323-3581-4b58-a8e6-245108ddc5d6.png)  
같이 게임을 자주한 2명의 유저를 저장했을때 40게임이 아닌 28게임만 저장하였습니다  

## 이부분이 아쉬웠습니다.
### 1.코틀린코드로 적지못했습니다  
아직 코틀린을 많이 공부하지못해 익숙하지않아 사용하지않았습니다.  
하지만 공부를 해보니 조금만 배운다면 금방 바로 적용할수있습니다.  

아래의 커밋 컨벤션을 기준으로 진행하였습니다
## <b>커밋 컨벤션</b>
### 양식
    [type] 제목
    <BLANK LINE>
    본문
    <BLANK LINE>
    꼬릿말

- type
    - feat : 새로운 기능에 대한 커밋
    - fix : build 파일(배포 된 시점)에 대한 커밋
    - chore : 자잘한 수정에 대한 커밋
    - docs : 문서 수정에 대한 커밋
    - style : 코드 스타일 혹은 포맷 등에 관한 커밋
    - refactor : 코드 리팩토링에 대한 커밋


- 제목
    - 작성 요령
        - type과 제목 사이 공백 한칸 넣기
        - 명령문으로 작성! 과거형 사용x
    - 포함 되어야 할 내용
        - 어디에 ex) 00Controller에서 or 마이페이지에서
        - 무엇을했는가 ex) 00기능을 추가 or ~을 수정


- 본문
    - 제목에 대한 이유가 들어갈 수 있도록 작성

- 꼬릿말
    - 어떤 이슈에서 왔는지와 같은 참조 정보를 추가하는 용도로 사용(추가이기 떄문에 필수가 아님)
    - 이후 이슈번호 관리에 대한 공부 이후 적극적으로 사용할 수 있으면 좋겠다.

### reference
    https://koreapy.tistory.com/1150
