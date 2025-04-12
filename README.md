# 📦 Подключение библиотеки chat:1.0.2 с GitHub Packages
1. Добавь GitHub Packages в settings.gradle.kts
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/xydownik/chatlibrary")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}
```
2. Укажи свои GitHub credentials в local.properties
   ⚠️ Не коммить файл local.properties в GitHub!


3. Добавь зависимость в build.gradle.kts модуля app:
```kotlin
implementation("com.github.xydownik:chat:1.0.2")
```

4. Готово! Теперь можно использовать библиотеку:
```kotlin
import com.example.chat_library.ChatLauncher
   ....
   ChatLauncher.start(this, username = "YourName")
```
5. Демонстрационный проект:
```shell
https://github.com/xydownik/ChatApp
```