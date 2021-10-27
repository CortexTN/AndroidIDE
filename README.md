# AndroidIDE
AndroidIDE is an IDE for Android to develop full featured Android apps on Android smartphones.

This repository is used to manage issues, feature requests and discussions related to AndroidIDE.

You should report bugs and suggest features/enhancements [here](https://github.com/itsaky/AndroidIDE/issues).
Describe the issue/request briefly. Provide steps to reproduce the issue. If you need any help, you should discuss it [here](https://t.me/androidide_discussions).

If you open a build related issue, please provide these details:
- Device model
- Android Version
- Full build output with stacktrace.

### Main Features
- Supports Gradle
- Comes with OpenJDK 11.0.12
- Provides auto completion for Java and XML. It also has basic (reserved) completion for Gradle files.

More features will be implemented as we continue to develop this app.

### Features to be implemented
- [x] Advanced Java Auto Complete
- [x] Terminal
- [x] Custom environment variables (for Build & Terminal)
- [x] SDK Manager (Available via terminal)
- [x] Gradlew support (with some limitations)
- [x] API information for classes and their members (since, removed, deprecated).
- [ ] UI Designer
- [ ] Layout Inspector
- [ ] String Translator
- [ ] Asset Studio (Drawable & Icon Maker)
- [ ] Git

### Limitations
- Gradlew is supported. But, it requires that the project's application module is named 'app'. 
- SDK Manager is already included in Android SDK and is accessible in AndroidIDE via its Terminal. But, you cannot use it to install some tools (like NDK) because those tools are not built for Android.
- No official NDK support because we haven't built the NDK for Android.
- No Android Gradle Plugin versions other than v7.0.2 are supported (due to AAPT2).

The app is still being developed actively. It's in beta stage and may not be stable. if you have any issues using the app, please let us know.

### Posts to help you get started
- [Installing AndroidIDE](https://telegra.ph/How-to-install-AndroidIDE-09-11)  
  - Author: [Marvin Stelter](https://github.com/MarvinStelter)
- [Create your first project](https://itsaky.github.io/create-your-first-project-in-androidIDE/)  
  - Author: [Akash Yadav](https://github.com/itsaky)

### Developers
- Akash Yadav ([**@itsaky**](https://github.com/itsaky))
- Marvin Stelter ([**@MarvinStelter**](https://github.com/MarvinStelter))

### Contact Us
- [Website](https://androidide.com)
- [Telegram](https://t.me/androidide_discussions)
- [Email](mailto:contact@androidide.com)
