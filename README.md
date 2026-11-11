# MCA 307: Mobile Application Development (Android)

> **Master of Computer Applications (MCA) — Semester 3**  
> **Course Code:** MCA 307 | **Subject:** Android Application Development Laboratory  
> **Institution:** Department of Computer Science, Rajagiri College of Social Sciences (Autonomous), Kalamassery  
> **Student:** Ashbi Saju  

---

## Repository Overview

This repository contains **35 Standalone Android Studio Projects** and the **Semester Capstone Project** developed for the Mobile Application Development Laboratory.

> **Clean Repository Notice:** All temporary build files, intermediate compile caches (`build/`, `.gradle/`, `.idea/`), and APK binaries have been purged to keep the repository lightweight and version-control clean. Projects are fully buildable upon opening in Android Studio.

---

## Table of Contents

- [Curriculum Architecture & Categorization](#curriculum-architecture--categorization)
- [Complete Android Applications Index (Q1 – Q35)](#complete-android-applications-index-q1--q35)
- [Semester Capstone Project](#semester-capstone-project)
- [Importing & Building in Android Studio](#importing--building-in-android-studio)

---

## Curriculum Architecture & Categorization

| Tier | Topic Area | Questions |
| :--- | :--- | :--- |
| **Tier 1: UI & Layouts** | TextView, EditText, Button, Layouts, Pickers, Alerts & Menus | Q1 – Q9, Q12 – Q14 |
| **Tier 2: Multimedia & Web** | Audio/Video Playback & Remote Video Streaming | Q10 – Q11 |
| **Tier 3: Multi-Activity & Intents** | Explicit Intents, Intent Extras, Multi-screen workflows | Q15 – Q17, Q23 – Q24 |
| **Tier 4: System Integration** | Custom Broadcasts, System Broadcasts (Airplane Mode, Battery Low) | Q18 – Q20 |
| **Tier 5: Alarms & Background** | AlarmManager, Timed Alarms, Asynchronous Tasks | Q21, Q30 |
| **Tier 6: Adapter Views & SQLite** | ListView, GridView, SQLite Database CRUD operations | Q22, Q25 – Q27, Q31 |
| **Tier 7: Device Hardware APIs** | Text-to-Speech, Flashlight Torch, Accelerometer, SensorManager | Q28 – Q29, Q32 – Q35 |
| **Tier 8: Capstone Project** | Hall Booking System | Q36 |

---

## Complete Android Applications Index (Q1 – Q35)

| Sl. No. | Application Title & Problem Statement | Project Directory | Category |
| :---: | :--- | :--- | :--- |
| 1 | Display Name and Email ID on button click using TextView & EditText | [`1. NameDisplay`](./1.%20NameDisplay) | Basic UI |
| 2 | Calculate Sum and Average marks of three subjects with validation | [`2. MarksCalculate`](./2.%20MarksCalculate) | Event Handling |
| 3 | Demonstrate Android Layouts (LinearLayout, RelativeLayout, ConstraintLayout) | [`3. AndroidLayouts`](./3.%20AndroidLayouts) | UI Layouts |
| 4 | Interactive Arithmetic Calculator Application | [`4. Calculator`](./4.%20Calculator) | App Logic |
| 5 | Dynamically modify TextView text size and color on user interaction | [`5. TextColorChange`](./5.%20TextColorChange) | Dynamic Styling |
| 6 | Implement interactive DatePickerDialog and TimePickerDialog | [`6. DateTimeLinear`](./6.%20DateTimeLinear) | Pickers & Dialogs |
| 7 | Display short and long duration Toast notification messages | [`7. ToastMessage`](./7.%20ToastMessage) | Notifications |
| 8 | Display AlertDialog with positive, negative, and neutral action buttons | [`8. AlertBox`](./8.%20AlertBox) | Dialogs |
| 9 | Design a personalized Digital Greeting Card UI with custom typography | [`9. GreetingCard`](./9.%20GreetingCard) | UI Design |
| 10 | Media Player application playing local Audio (MediaPlayer) and Video (VideoView) | [`10. PlayAudioVideo`](./10.%20PlayAudioVideo) | Multimedia |
| 11 | Stream and playback remote video content from URL | [`11. OnlineVideo`](./11.%20OnlineVideo) | Media Streaming |
| 12 | Implement Options Menu with menu items and selection callbacks | [`12. OptionsMenu`](./12.%20OptionsMenu) | Android Menus |
| 13 | Implement floating Context Menu triggered on long press | [`13. ContextMenu`](./13.%20ContextMenu) | Android Menus |
| 14 | Form controls with RadioGroup, RadioButtons, and CheckBoxes | [`14. CheckBoxRadioButton`](./14.%20CheckBoxRadioButton) | Form Widgets |
| 15 | Launch a second Activity on button click using explicit Intents | [`15. ButtonClickNewActivity`](./15.%20ButtonClickNewActivity) | Intents & Navigation |
| 16 | Capture student profile and pass data between activities using Intent Extras | [`16. StudentActivity`](./16.%20StudentActivity) | Intent Extras |
| 17 | Calculate employee salary components and pass across activities | [`17. EmployeeActivity`](./17.%20EmployeeActivity) | Intent Extras |
| 18 | Register and trigger a Custom Broadcast Intent with BroadcastReceiver | [`18. CustomBroadcast`](./18.%20CustomBroadcast) | BroadcastReceivers |
| 19 | BroadcastReceiver listening for System Intent: Airplane Mode Changes | [`19. AirplaneMode`](./19.%20AirplaneMode) | System Broadcasts |
| 20 | BroadcastReceiver listening for System Intent: Battery Low Event | [`20. BatteryLow`](./20.%20BatteryLow) | System Broadcasts |
| 21 | Alarm Clock Application scheduling notifications with AlarmManager | [`21. AlarmClock`](./21.%20AlarmClock) | Services & Alarms |
| 22 | Display a simple Contacts List using ListView and ArrayAdapter | [`22. ContactDisplay`](./22.%20ContactDisplay) | AdapterView |
| 23 | Food Ordering System spanning three activities with dynamic bill total | [`23. Food Order App`](./23.%20Food%20Order%20App) | Multi-Activity Flow |
| 24 | Three Activities application integrating Explicit Intents, Extras, and Options Menu | [`24. Three Activity App`](./24.%20Three%20Activity%20App) | Multi-Activity Flow |
| 25 | SQLite Database: Insert and View Student Name and Age records | [`25. Student Database`](./25.%20Student%20Database) | SQLite Database |
| 26 | Library Management System with SQLite CRUD (Add, View, Update, Delete Books) | [`26. Library Management`](./26.%20Library%20Management) | SQLite Database |
| 27 | Product Database viewing catalog items in ListView and GridView layouts | [`27. Product Database`](./27.%20Product%20Database) | SQLite & GridView |
| 28 | Interactive Counter Application with increment, decrement, and reset states | [`28. CounterApp`](./28.%20CounterApp) | State & UI |
| 29 | Text-to-Speech (TTS) synthesizer vocalizing user input text | [`29. TextToSpeechApp`](./29.%20TextToSpeechApp) | Hardware & Audio API |
| 30 | Asynchronous Background Processing using Background Worker / AsyncTask | [`30. AsynchronousTask`](./30.%20AsynchronousTask) | Concurrency |
| 31 | User Authentication System with SQLite Registration, Password Hashing & Login | [`31. LoginRegistration`](./31.%20LoginRegistration) | SQLite Authentication |
| 32 | Flashlight Application controlling camera hardware flash torch | [`32. FlashLIghtApp`](./32.%20FlashLIghtApp) | Camera2 API |
| 33 | Dynamic background color changer triggered by physical Shake / Tilt motion | [`33. ShakeColorApp`](./33.%20ShakeColorApp) | Accelerometer Sensor |
| 34 | Communication App invoking implicit intents for SMS, Email, and Phone Dialing | [`34. CommunicationApp`](./34.%20CommunicationApp) | Implicit Intents |
| 35 | Environmental Hardware Sensor Suite reading Light, Pressure, and Humidity | [`35. SensorsApp`](./35.%20SensorsApp) | SensorManager API |
| 36 | PROJECT: College Auditorium / Hall Booking System | [`Hall Booking System`](./Hall%20Booking%20System) | Capstone Project |

---

## Semester Capstone Project

- **Project Title:** College Auditorium / Hall Booking System
- **Key Modules:**
  - Auditorium availability calendar & slot selection
  - Departmental booking request submission
  - Admin approval/rejection workflow
  - SQLite persistent storage for reservations
  - Notification alert generation for approved bookings

---

## Importing & Building in Android Studio

1. Open **Android Studio** (Hedgehog / Iguana / Jellyfish or later).
2. Click **File > Open...** and select any project folder (e.g., `4. Calculator`).
3. Android Studio will automatically resolve Gradle dependencies, generate build directories, and configure SDK settings.
4. Connect an Android device (via USB Debugging or Wi-Fi) or launch an Android Virtual Device (AVD).
5. Click **Run > Run 'app'** (`Shift + F10`).

---

## Official Record Verification
The verified lab record front sheet is preserved as [`1. Android LAB FRONT.pdf`](./1.%20Android%20LAB%20FRONT.pdf).
