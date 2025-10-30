## HumbleBot (Android)

HumbleBot is a minimal Android app scaffold that talks to Google Gemini using Retrofit. It includes a simple data layer and Compose setup so you can quickly build a chat-style AI client.

### Features
- **Gemini integration**: Calls `gemini-2.5-flash:generateContent` via the Generative Language API
- **Kotlin + Coroutines**: Simple suspending `sendMessage` API
- **Retrofit + OkHttp**: Typed networking with optional logging
- **Jetpack Compose ready**: App theme and `MainActivity` are Compose-enabled (UI is intentionally minimal)

### Tech stack
- **Language**: Kotlin (JVM target 11)
- **UI**: Jetpack Compose, Material 3
- **Networking**: Retrofit 2, Gson converter, OkHttp
- **Async**: Kotlin Coroutines
- **Build**: Gradle, Android Gradle Plugin

### App configuration
- Namespace: `com.humblecoders.humblebot`
- Min SDK: 24
- Target/Compile SDK: 35
- Permission: `android.permission.INTERNET`

### Project structure (high-level)
- `app/src/main/java/com/humblecoders/humblebot/api/`
  - `NetworkClient.kt`: Creates Retrofit client for Gemini
  - `GeminiApi.kt`: Retrofit interface for `generateContent`
- `app/src/main/java/com/humblecoders/humblebot/repository/`
  - `ChatRepository.kt`: Builds requests and parses responses
- `app/src/main/java/com/humblecoders/humblebot/model/`
  - Request/response models for Gemini (`GeminiRequest`, `GeminiResponse`, etc.)
- `app/src/main/java/com/humblecoders/humblebot/`
  - `MainActivity.kt`: Compose entry point (UI placeholder)

### Prerequisites
- Android Studio (Giraffe+ recommended) with Android SDK 35
- JDK 11
- A Google Gemini API key with access to the Generative Language API

### Getting started
1) Clone the repository
```bash
git clone https://github.com/Humble-Coders/HumbleBot.git
cd HumbleBot
```

2) Open the project in Android Studio and let it sync.

3) Add your Gemini API key
- Open `app/src/main/java/com/humblecoders/humblebot/repository/ChatRepository.kt`
- Update the `apiKey` argument passed to `geminiApi.generateContent(...)`:
  - Current placeholder is empty: `apiKey = ""`
  - Replace with your key: `apiKey = "YOUR_API_KEY"`

4) Run the app
- Select a device/emulator
- Press Run ▶ in Android Studio

### Using the data layer
`ChatRepository.sendMessage(message: String)` builds a `GeminiRequest` and returns a `Result<String>` with the model’s first reply text when successful. You can wire this into your Compose UI or ViewModel of choice.

### Notes and limitations
- The UI layer is intentionally minimal; you can add a chat screen on top of the existing repository and models.
- Network logging is enabled via OkHttp logging interceptor in `NetworkClient.kt`.

### Troubleshooting
- 401/403 errors: Verify you set a valid API key and that it has access to the Gemini model `gemini-2.5-flash`.
- Build issues: Ensure Android Studio uses JDK 11 and that Gradle sync completes without errors.
- Connectivity: The app requires internet permission (already declared in `AndroidManifest.xml`).

### Roadmap ideas
- Add a Compose chat UI with message history
- Stream responses and partial rendering
- Persist conversation to local storage
- Error and retry UI states

### License
Specify a license for this project (e.g., MIT) or add a `LICENSE` file.


