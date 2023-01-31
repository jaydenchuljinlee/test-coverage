
plugins {
	java
	id("org.springframework.boot") version "2.7.7"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	jacoco
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	runtimeOnly("com.h2database:h2")

	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {

	extensions.configure(JacocoTaskExtension::class) {
		destinationFile = file("$buildDir/jacoco/jacoco.exec")
	}
	finalizedBy("jacocoTestReport")
}

jacoco {
	toolVersion = "0.8.5"
}

tasks.jacocoTestReport {
	reports {
		html.isEnabled = true
		xml.isEnabled = false
		csv.isEnabled = false
	}

	finalizedBy("jacocoTestCoverageVerification")
}

tasks.jacocoTestCoverageVerification {
	violationRules {

		rule {
			// 룰을 간단히 켜고 끌 수 있다.
			enabled = true

			// 룰을 체크할 단위는 클래스 단위
			element = "CLASS"

			// 브랜치 커버리지를 최소한 90% 만족시켜야 한다.
			limit {
				counter = "BRANCH"
				value = "COVEREDRATIO"
				minimum = "0.80".toBigDecimal()
			}

			// 라인 커버리지를 최소한 80% 만족시켜야 한다.
			limit {
				counter = "LINE"
				value = "COVEREDRATIO"
				minimum = "0.80".toBigDecimal()
			}

			// 빈 줄을 제외한 코드의 라인수를 최대 200라인으로 제한한다.
			limit {
				counter = "LINE"
				value = "TOTALCOUNT"
				maximum = "200".toBigDecimal()
			}

			// 커버리지 체크를 제외할 클래스들
			excludes = listOf(
				"*.Branch*"
			)
		}
	}
}

val testCoverage by tasks.registering {
	group = "verification"
	description = "Runs the unit tests with coverage"

	dependsOn(":test",
			":jacocoTestReport",
			":jacocoTestCoverageVerification")

	tasks["jacocoTestReport"].mustRunAfter(tasks["test"])
	tasks["jacocoTestCoverageVerification"].mustRunAfter(tasks["jacocoTestReport"])
}



