# API GATEWAY

* 2018 Naver Campus Hackday Naver-Feed-Api-Gateway
* 각 스키마는 오직 각 컴포넌트만 접근이 가능하다 (컨텐츠 스키마는 오직 컨텐츠 컴포넌트에서만 가능하다)
* 따라서 컨텐츠 컴포넌트에서 댓글 정보를 얻어오기 위해선 댓글 컴포넌트에 댓글 정보를 요청해야 한다.(시스템 콜)
* 각 도메인별 기능 정의를 해야 한다
* 플랫폼 입장에서 기능 정의와 명세를 해야 한다
* 다른 사람이 와서 이어서 개발을 하는데 어떤 의문을 가지지 않게 해야 한다(트럭 지수)
* 형용사보단 명사가 이해하기 좋다
* 각 컴포넌트가 기능 명세를 정확히 해 줘야 API에서 그것을 URI로 설계할 수 있다
* 커뮤니케이션을 통해 각 컴포넌트의 기능 명세를 정확히 해야 한다
* 해당 기능을 사용하는 사람이 그것을 정확히 인지하고, 더 필요한게 있으면 요청을 해서 가능 여부를 판단하고 개발 혹은 다른 방법을 제시하는 과정의 커뮤니케이션이 중요하다
* 각각의 컴포넌트는 담당자가 주체적으로 이슈등을 이끌어 가야 한다
* 네이밍이 직관적이여야 한다
* 각 컴포넌트 별로 기능 명세가 필요하다
* 도메인을 명확히 나누고 받아야할 정보가 무엇인지 생각해야 한다
* 각 기능에 대해 어떤 값이 필요한 지는 각 기능 담당자가 명확히 해야 한다
* API Gateway는 각 컴포넌트가 어떤 구성, 어떤 스키마등 내용을 알 필요가 없다. 오직 기능만 알고 있으면 된다. 다시 말하면 각 컴포넌트에선 API Gateway에게 기능만 알려주면 될 정도로 기능이 명확해야 한다.
*  URI 어떤 Resource의 위치를 의미하고 Method가 그 위치에 대한 행위를 뜻 한다
* API Gateway는 프론트 엔드 혹은 다른 플랫폼이 들어오는 출입구다. 오직 API Gateway를 통해서만 정보를 얻는다. 그 내부가 어떤 구조, 어떤 통신, 스키마 설계 등은 중요하지 않다
* Http 통신으로 들어온 요청을 다른 프로토콜로 변환해서 통신이 가능해야 한다
* API Gateway입장에선 내부를 생각하는 것 보단 외부에서 볼때 어떤 의미로 나뉘는지가 중요하다. 그렇지 않으면 API Gateway를 쓸 필요가 없다
* 사용자 입장에서는 컴포넌트를 알 필요가 없다
* Spring Zuul은 오직 http라우팅만 해 주는 라이브러리로써 API Gateway에 사용하기엔 기능적으로 부족하다
* Spring Zuul은 내부적으로 ZuulController을 생성한다
* 자신이 사용하려는 라이브러리 혹은 프레임워크에 대한 정확한 이해, 사전 조사가 필요하다
* 항상 객관적으로 설계 해야한다. 편협적인, 좁은 시야는 지양해야 한다

## Contents

| 메소드 | 경로                                                        | 설명                   |
| ------ | ----------------------------------------------------------- | ---------------------- |
| Get    | /contents/{content_id}                                      | 컨텐츠 조회            |
| Get    | users/{user_id}/contents?offset={page_no}&limit={page_size} | 작성자id로 컨텐츠 조회 |
| Post   | /contents                                                   | 컨텐츠 작성            |
| Put    | /contents/{content_id}                                      | 해당 컨텐츠 수정       |
| Delete | /contents/{content_id}                                      | 해당 컨텐츠 삭제       |

## Following

| 메소드 | 경로                                                         | 설명                         |
| ------ | ------------------------------------------------------------ | ---------------------------- |
| Post   | /users/{user_id}/following/{following_id}                    | 팔로우                       |
| Delete | /users/{user_id}/following/{following_id}                    | 상대방 팔로우 해제           |
| Get    | /users/{user_id}/following?offset={page_no}&limit={page_size} | 내가 팔로우한 사람 명단 조회 |
| Get    | /users/{user_id}/following/count                             | 내가 팔로우한 사람 수 조회   |

## Followers

| 메소드 | 경로                                                         | 설명                         |
| ------ | ------------------------------------------------------------ | ---------------------------- |
| Get    | /users/{user_id}/followers?offset={page_no}&limit={page_size} | 나를 팔로우한 사람 명단 조회 |
| Get    | /users/{user_id}/followers/count                             | 나를 팔로우한 사람 수 조회   |

## Feeds

| 메소드 | 경로                                                      | 설명         |
| ------ | --------------------------------------------------------- | ------------ |
| Get    | /users/{user_id}/feeds?offset={page_no}&limit={page_size} | 내 피드 조회 |

## 시작하기

### MAVEN을 이용한 의존성 프로젝트 추가

이 프로젝트에서는 아래 같은 **의존성 프로젝트**가 포함되어있습니다. 

**pom.xml** 파일에 아래와 같이 **의존성 프로젝트**를 추가해 주세요.

```
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>
        
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.6.1</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.6.1</version>
        </dependency>
        
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.4</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <repositories>
        <repository>
            <id>spring-snapshots</id>
            <name>Spring Snapshots</name>
            <url>https://repo.spring.io/snapshot</url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>
```

## 실행하기

- mvn package
- Java -jar `.jar`
- 데몬 실행 : nohup java -jar `.jar` &

## 개발 환경

- Windows 10
- [JAVA](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) 8
- [Spring-boot](https://projects.spring.io/spring-boot/) 2.0.2 - Spring-boot Web Framework
- [Maven](https://maven.apache.org/) - 의존성 관리 프로그램
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) 2018.1 - IDEA
- [lombok](https://projectlombok.org/)
- [Swagger](https://swagger.io/) - Swagger2

## 저자

- **배다슬** - [bghgu](https://github.com/bghgu)

[기여자 목록](https://github.com/bghgu/hackday-feed-api-gateway/graphs/contributors)을 확인하여 이 프로젝트에 참가하신 분들을 보실 수 있습니다.