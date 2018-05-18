# API GATEWAY

* 2018 Naver Campus Hackday Naver-Feed-Api-Gateway

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