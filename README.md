# 기능 구현 목록

## 입력

- [x] 월/일을 입력받는다.
- [x] 평일 근무자들을 입력받는다.
- [x] 휴일 근무자들을 입력받는다.

## 출력

- [x] 해당 월의 모든 날짜에 대하여 비상근무자 리스트를 작성한다.
  - [x] 평일이면서 법정공휴일인 경우에는 (휴일)을 붙인다.

### 근무자

- [x] 근무자의 이름은 최대 5자이다.

### 근무자들

- [x] 근무자는 5명 ~ 35명이다.
- [x] 중복된 근무자가 있으면 안된다.

### 달력

- [x] 월, 시작요일을 통해 생성된다.
- [x] 해당 월의 날짜를 제공한다.
  - 이 날짜는 평일인지 휴일인지 여부도 같이 포함되어 있다.

### 근무표

- [x] 평일 근무자들과 휴일 근무자들과 달력을 가지고 있는다.
- [x] 달력을 기준으로 근무자들을 배치한다.
  - [x] 연속해서 근무하게 되는 경우 뒷 순번과 순서를 바꾼다.

### 법정공휴일

- [x] 법정공휴일을 기록하고 어떤 날짜가 법정공휴일인지 알 수 있어야 한다.
  - [x] 평일이며 법정공휴일인지 확인할 수 있다.
```markdown
- 1/1 신정
- 3/1 삼일절
- 5/5 어린이날
- 6/6 현충일
- 8/15 광복절
- 10/3 개천절
- 10/9 한글날
- 12/25 성탄절
```

## 재시도

- [x] 입력이 잘못된 경우 `[ERROR]`와 함께 잘못된 부분을 다시 입력받을 수 있어야 한다.
  - [x] 날짜 잘못 입력
  - [x] 근무자들 잘못 입력

# 프로그래밍 요구 사항

- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍했는가?
- [ ] 들여쓰기(indent)를 2단계 이하로 허용했는가?
- [ ] else 예약어를 쓰지 않았는가?
- [ ] 메소드가 한가지 일만 담당하도록 구현했는가?
- [ ] 클래스를 작게 유지하기 위해 노력했는가?

# 좋은 코드를 위한 체크 사항

- [ ] 모든 원시값과 문자열을 포장했는가?
- [ ] 콜렉션에 대해 일급 콜렉션을 적용했는가?
- [ ] 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?
- [ ] 도메인 객체를 getter/setter 없이 구현했는가?
- [ ] 메소드의 인자 수를 3개 이하로 제한했는가?
- [ ] 코드 한 줄에 점(.)을 하나만 허용했는가?
