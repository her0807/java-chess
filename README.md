# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 1단계 체스판 초기화 요구사항 도출

## 흐름

- [ ]  게임 시작 안내문을 출력한다. (체스 게임을 시작합니다.)
- [ ]  게임 메뉴를 입력받는다.(start/end)
- [ ] `end` 면 게임을 종료한다.
- [ ] `start` 면 게임을 시작한다.
- [ ] 체스판을 생성한다.
    - [ ] 가로를 `Row` 라고 하며, abcdefgh 로 이뤄져있다.
    - [ ]  세로를 `Column` 이라고 하며 12345678 로 이뤄져있다.
    - [ ] 체스판 한칸은 고유한 위치를 가진다. (Position) -> Map 의 Key 로 고유성 보장
- [ ] 색깔 생성
    - [ ] `흑과 백`으로 색깔을 생성한다.(enum)
- [ ] 말 생성
    - [ ] 말의 종류는 0(king), 3(bishop), 3(pawn), 5(rook), 9(queen) 총 6가지가 있다.
    - [ ] 말은 이름과 색깔을 가지고 있다.
- [ ] 말 배치
    - [ ] 체스 룰에 맞춰 배치한다.
    - [ ] 흑은 상단, 백은 하단에 배치한다.
- [ ] 체스 판 출력
    - [ ] 체스판 전체를 출력한다.
    - [ ] 흑말은 대문자로 표기하고, 백말은 소문자로 표기한다.

## 2단계 말 이동

- [ ] `move 현재위치 도착위치`를 입력받는다.
    - [ ] [예외] 입력 형식과 다르면 예외를 던진다.
    - [ ] Row 와 Column 범위 내에 있어야 한다.
    - [ ] [예외] 현재 위치에 본인 말이 없으면 예외를 던진다.
- [ ] 현재 위치에 있는 말에게 도착 위치로 이동 명령을 내린다.
    - [ ] 도착 위치에 말이 움직을 수 있으면 움직인다.
    - [ ] [예외] 움직일 수 없으면 예외를 던진다.
- [ ] 말 이동 가능 여부 확인 로직을 수행한다.
    - [ ] `Rook, Bishop, Queen` (여러칸 이동 가능)
        - [ ] 현재 위치 -> 도착위치의 이동 경로를 구한다.(ex 위, 왼, 위, 왼)
            - [ ] [예외] 말의 규칙과 경로가 일치하지 않으면 예외를 던진다.
            - [ ] [예외] 이동 경로에 다른 말이 있다면 예외를 던진다.
            - [ ] [예외] 도착 위치에 같은 팀의 말이 있다면 예외를 던진다.
        - [ ] 도착 위치에 있던 말 대신, `이동한 말을 위치시킨다.`
    - [ ] `Knight` (말을 뛰어넘을 수 있음)
        - [ ] 현재 위치 -> 도착위치의 이동 경로를 구한다.(ex 위, 위, 오)
            - [ ] [예외] 말의 규칙과 경로가 일치하지 않으면 예외를 던진다.
            - [ ] [예외] 도착 위치에 같은 팀의 말이 있다면 예외를 던진다.
        - [ ] 도착 위치에 있던 말 대신, `이동한 말을 위치시킨다.`
    - [ ] `Pawn`
        - [ ] 현재 위치 -> 도착위치의 이동 경로를 구한다.(ex 위, 왼, 위, 왼)
        - [ ] [예외] 말의 규칙과 경로가 일치하지 않으면 예외를 던진다.
        - [ ] 앞으로 전진
            - [ ] [예외] 도착 위치에 상대방 말이 있으면 예외를 던진다.
            - [ ] [예외] 도착 위치에 같은 팀의 말이 있다면 예외를 던진다.
        - [ ] 대각선 전진
            - [ ] [예외] 도착 위치에 `상대편 팀의 말이 없다면` 예외를 던진다.
            - [ ] [예외] 도착 위치에 같은 팀의 말이 있다면 예외를 던진다.
        - [ ] 도착 위치에 있던 말 대신, `이동한 말을 위치시킨다.`
    - [ ] `King`
        - [ ] 현재 위치 -> 도착위치의 이동 경로를 구한다.(ex 위, 왼, 위, 왼)
            - [ ] [예외] 말의 규칙과 경로가 일치하지 않으면 예외를 던진다.
            - [ ] [예외] 이동 경로에 다른 말이 있다면 예외를 던진다.
            - [ ] [예외] 도착 위치에 같은 팀의 말이 있다면 예외를 던진다.
        - [ ] 도착 위치에 있던 말 대신, `이동한 말을 위치시킨다.`
        - [ ] `체크`
            - [ ] 상대편 말 중 현재 킹 위치에 올 수 있는 말이 있는지 검사한다.
        - [ ] `체크 메이트`
            - [ ] `체크 상태일 때` 이동 가능 범로 이동했을 때 체크 상태를 벗어 날 수 있는지 검사한다.
            

### 입력

- [ ] start/end 를 입력받아 게임을 시작하거나, 종료한다.
    - [ ] [ 예외 ] start/end 외에 다른 문자가 올 경우 에러를 던진다.
    - [ ] 대소문자 구분 없이 입력 가능하도록 한다.

## 진행

- [ ] 보드판을 생성한다.
- [ ] 보드판에 말을 초기화한다.

## 출력

- [ ] 게임 시작 안내 메세지를 출력한다. (체스 게임을 시작합니다. 게임 시작은 start, 종료는 end 명령을 입력하세요.)
- [ ] 입력 명령어를 받은 후, 보드판 상태를 출력한다

## 보드판

- 가로(Row)
    - [x] a,b,c,d,e,f,g,h 로 이뤄져 있다.
    - [ ] [ 예외 ] a,b,c,d,e,f,g,h 외에 다른 문자가 올 경우 에러를 던진다.

- 세로(Column)
    - [x] 1,2,3,4,5,6,7,8 로 이뤄져 있다.
    - [ ] [ 예외 ] 1,2,3,4,5,6,7,8 외에 다른 문자가 올 경우 에러를 던진다.

## 페어 프로그래밍 룰

- 타이머는 10분으로 한다.
