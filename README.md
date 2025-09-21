참고: https://www.ghosind.com/
------------------------------------------------------------------------------------------- 
< 프로젝트 환경 구성 참조 >
1) 루비 설치
Ruby+Devkit 3.x 

설치후 버전 확인
ruby -v
gem -v


2) Jekyll & Bundler 설치
gem install jekyll bundler


3) Spring Boot 연동 
3-1) gradle 의존성 추가 

plugins {
    id 'java'
    id 'org.springframework.boot' version '3.3.3'
    id 'io.spring.dependency-management' version '1.1.5'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.register("jekyllBuild", Exec) {
    description = "Run Jekyll build to generate static site"
    group = "build"

    workingDir = project.projectDir
    commandLine "jekyll", "build"

    doLast {
        println "Jekyll build completed!"
    }
}

tasks.register("copyJekyllToStatic", Copy) {
    dependsOn "jekyllBuild"
    from("${project.projectDir}/_site")   // Jekyll 빌드 결과
    into("${project.projectDir}/src/main/resources/static") // Spring Boot 정적 리소스 폴더
}

tasks.named("processResources") {
    dependsOn("copyJekyllToStatic")
}

3-2)빌드 실행
bundle exec jekyll build
이제 _site/ 디렉토리에 HTML 결과물이 생김...  
이것들을 다 resources/static 밑으로 이동시킨다. 	
 
