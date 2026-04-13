# Letterhead Editor {Miracle Suite}

A fully air-gapped, offline-first Android and PC application designed to generate professional stationery and organizational documents.

It allows the user to input dynamic credentials, digital signatures, and local QR codes, outputting a perfect vector-based A4 PDF. All `INTERNET` permissions are stripped from the Android Manifest to ensure it is 100% tamper-proof and offline.

---

## 🚀 Quick Start (For Reviewers)

**Option 1: Test the Android App (Recommended)**
1. Download `LEED.apk` directly from the `main` branch.
2. Install it on an Android device (Minimum Android 7.0 / API 24).
3. **Note the Air-Gap:** Turn on Airplane mode. The app generates QR codes using a localized library and bypasses the standard web-print dialogue to use the native Android PrintManager. 

**Option 2: Test the Desktop Version**
1. Download `index.html` and `qrcode.min.js` from the `main` branch.
2. Download the `fonts` folder from the `master` branch.
3. Keep them in the same directory and open `index.html` in any modern web browser.
*(Notice how the PC version includes a microscopic 0.5pt security thread line at the bottom, while the Android version dynamically hides it using an environment kill-switch to keep the mobile spooler clean! It's optimisation.)*

---

## 📂 Repository Structure (Important)

This project is split across two branches:

**`main` branch (Compiled & Web Assets):**
* `LEED.apk` (Final Android Build)
* `index.html`
* `qrcode.min.js`

**`master` branch (Android Source & Styling):**
* `MainActivity.java`
* `AndroidManifest.xml`
* `activity_main.xml`
* `fonts/` folder (Contains all TTF/WOFF2 fonts and `phosphor.css`)

---

## 🛠️ Building from Source (Android Studio)

If you wish to compile the Android app yourself in Android Studio (Panda 2):

1. **Initialize Project:**
   * Click 'New Project' -> "Empty Views Activity"
   * Name: `Letterhead Editor by Miracle`
   * Package Name: `com.malviya.letterhead`
   * Language: `Java`
   * Minimum SDK: `API 24 (Android 7.0)`
   * Gradle: `Groovy`

2. **Source Code Setup:**
   * Replace `app/java/com/malviya/letterhead/MainActivity.java` with the file from the `master` branch.
   * Replace `app/manifests/AndroidManifest.xml` with the file from the `master` branch.
   * Replace `app/res/layout/activity_main.xml` with the file from the `master` branch.

3. **Assets Setup (The Air-Gap):**
   * In the Project window (left side), right-click on the `app` -> `src` -> `main` folder.
   * Go to **New** -> **Folder** -> **Assets Folder**.
   * Move `index.html` and `qrcode.min.js` (from `main`) into the `assets` folder.
   * Move the entire `fonts/` directory (from `master`) into the `assets` folder.

4. **Testing:**
   * Connect your device (I tested on Samsung M11).
   * For testing locally through USB: In Android Studio, click Tools > SDK Manager. · Click the SDK Tools tab. · Select Google USB Driver and click OK.
   * On mobile device, go to `Settings > Developer options > Turn on USB/Wireless debugging`.
   * Accept USB debug bridge connection request from AS.
   * Build and run!
  
   * For testing on Android Studio: Click on `Run` button in the `top toolbar`
   * Ensure no USB device is connected through AS `USB debug bridge`.

---

## 💡 Developer Notes
Thank you for testing my app! I am still in the learning and testing phases, and I built this purely as a hobby.

I mostly deal in Python, so traversing the wild west of Android WebViews, CSS print media queries, and Java `JavascriptInterface` bridges was a massive challenge. This project wouldn't have been possible without the help of AI (Copilot and GitHub Claude Haiku 4.5 via the GitHub Student Developer Pack, which I've been enjoying for 2+ years). 

Any suggestions or feedback are highly welcome!
