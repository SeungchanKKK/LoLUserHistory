# YourggAssign
롤 전적 20게임을 구하는 과제입니다

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
