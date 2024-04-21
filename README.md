# CustomException과 ResponseType 정의

## [✨ ErrorType Interface 생성](https://github.com/Dongjin113/Some-Where-BE/commit/61b1470b23068e01e09c1c4e997314bfa9eb6b7c) 

### ErrorType Interface
- ErrorCode와 ErrorResult의 statusCode, code, message를 부모 인터페이스를 통해 가져와서 타입을 유연하게 사용하기 위해 생성
  ![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/37c681c3-1128-4e18-ba05-cd4b35830302)

## [✨ ErrorData Interface 생성](https://github.com/Dongjin113/Some-Where-BE/commit/6bba5319775cfc3975335a091259baa6c0fab436) 
### ErrorData Interface
- 에러에 대한 추가적인 메시지 정보를 보내줄 클래스를 생성할때 부모인터페이스로 사용하기위해 구축

## [✨ ErrorResult 생성](https://github.com/Dongjin113/Some-Where-BE/commit/9794101999a437b85cdd804b0940329ef48e6390) 
## [✨ ErrorCode EnumClass 생성](https://github.com/Dongjin113/Some-Where-BE/commit/eab448476632df5db24a435b93e347231fdcf154) 
### ErrorCode
- CustomException의 Http 상태코드, 직접 지정한 상태코드, 상태 메시지를 지정해둔 Class
![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/e733c762-701e-42ba-8e05-69c812020d61)

### ErrorResult
- ErrorCode에서 선언한 message를 변경 시 EnumType이기 때문에 선언해둔 메시지가 영구적으로 변경되는 버그를 방지하기위해 메시지 변경시 메시지만 변경한 ErrorResult라는 새로운 객체를 만들어서 보내기 위해 생성
![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/3535a7ec-8d2d-4fc0-a088-150e17bcbac4)

## [✨ CustomException 생성](https://github.com/Dongjin113/Some-Where-BE/commit/eaf8f944012d1873be4a05e621c07ae746a2bb0b) 
![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/0472f7da-cabb-463f-9c06-b77c22d3d8a1)

### CustomException
- RuntimeException 에러들을 Custom 하기 위한 추상 클래스

#### 세가지 타입
- [ ] ErrorCode 에서 선언해둔 message와 errorCode를 클라이언트에 반환
- [ ] ErrorCode 에서 선언해둔 message만을 변경해서 클라이언트에 반환
- [ ] ErrorCode 에서 선언해둔 message와 errorCode를 반환하고 추가적으로 Error에 대한 데이터를 반환


## [✨ ExceptionControllerAdvice 구축](https://github.com/Dongjin113/Some-Where-BE/commit/bad22ac7b96b55b2e4e8c88a07a943bf7a793c14)
- 에러를 핸들링해 클라이언트에 반환하기 위한 클래스 

#### customExceptionHandler
![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/155dc172-63de-41e4-9604-4866ecdb3387)
- 선언해둔 CustomException 핸들링하기 위함
- error 발생 시 errormessage log로 남김

#### validationHandler
![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/b391dc61-4a20-46cb-a0e7-bb03789a792e)
- 요청이 들어올 때 validation을 통해 검증 중 발생하는 에러를 핸들링 


## [✨ Status Class 생성](https://github.com/Dongjin113/Some-Where-BE/commit/0c655344d29b306b4a592e22bb739168a95c793e)
### Status
- 상태코드와 메시지를 담는 Status Class 생성

## [✨ Error 발생시 응답 값 구축](https://github.com/Dongjin113/Some-Where-BE/commit/ac83bcd718ff56368e41edd9c41c72559fa73553)
### ErrorResponse
- 에러 발생시 두 가지 타입의 응답값을 반환
- [ ] ErrorCode에 지정해둔 ErrorCode 반환
- [ ] ErrorCode에 지정해둔 ErrorCode 와 Error에 대한 추가 정보가 담긴 ErrorData 반환

## [✨ ApiResponse 응답의 타입을 지정한 Class 선언](https://github.com/Dongjin113/Some-Where-BE/commit/d99ce438a319e60bb4db5e9fd98e3908282888cd)
### ApiResponse

![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/67b303fc-53d2-4ca9-82c5-2d914e7d9543)
#### Status
- 상태코드와 메시지를 담는 Class
- T Generic 을 사용함으로 써 정상응답시에는 객체를 담고 Error 발생시에는 ErrorData를 담음


## [✨ 지역별 캠핑장 정보 검색 기능 추가](https://github.com/Dongjin113/Some-Where-BE/commit/853e339fa770d7c7e2130b8420df70f2fc0e087c)
- 지역명을 통해 캠핑장 정보를 검색해오는 기능 추가
- JPQL의 FetchJoin을 통해 N+1 문제를 해결
- ![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/b3e1683e-9046-44c2-b0ba-f61dc2d05665)


## [✅ 지역별 캠핑장 정보 검색 기능 단위 테스트 추가](https://github.com/Dongjin113/Some-Where-BE/commit/c5c852d6e7c3e7ecbb9baf70d2816d1dd9940dbc)
- 캠핑장 데이터 지역으로 조회하는 단위 테스트 추가
- ![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/28b9c4b8-aa29-4d07-b380-a5f774d1d1eb)


## [✅ 지역별 캠핑장 정보 검색 기능 통합 테스트, 문서화](https://github.com/Dongjin113/Some-Where-BE/commit/31a3832dd378321fff231c30ffa39788f1f82ea3)
- Spring Rest doc을 이용해 통합테스트와 문서화 진행

![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/1a7b5fe0-5410-428b-8bd2-19782a8345b6)
![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/32307b16-00aa-4437-9a01-e46678a31937)
![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/53e761be-08b6-4efe-915e-b1b3edfe88db)
![image](https://github.com/Dongjin113/Some-Where-BE/assets/104759062/7b902572-afb0-437f-998c-ba1a244a8d31)




