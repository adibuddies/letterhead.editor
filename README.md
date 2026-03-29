For using download the apk file.

For Android App development——
Initialise your app in Android Studio Panda 2:
  1. Click 'New Project'
  2. Select "Empty Views Activity"
  3. Name: Letterhead Editor by Miracle
  4. Package Name: com.malviya.letterhead
  5. Language: Java * Minimum SDK: API 24 (Android 7.0)
  6. Gradle: Groovy

Assets folder creation:
  1. In the Project window (left side), right-click on the app folder.
  2. Go to New or + icon > Enter `assets`
  3. Now move the downloaded index.html from main branch into this assets folder using File Explorer.

Code base:
  1. Replace everything in `app/java/com/malviya/letterhead/MainActivity.java` with the `java file` in downloaded zip folder.
  2. Replace everything in `app/manifests/AndroidManifest.xml` with `xml file` in downloaded zip folder.
  3. Replace everything in `app/res/layout/activity_main.xml` with `activity_main.xml in the zip folder.


I used Google USB Drive in SDK Tools of AS Panda2 to connect my Samsung M11 for testing the app.
You can use Wi-Fi connection to do the same.
  ```1. Settings > Software information > click 'Build Number' 7 times > Developer mode on

      2. Settings > Developer options > Turn on Wireless (a) or USB (b) debugging (whatever you wish to use)
      2.a. > click on the text "Wireless debugging" > select either option - QR or pairing code {connect using QR on the AS}
      
      2.b. Just turn on, no more steps.
  ```
      
// ---------------------------------------------------------------------------------------------------------------------------------------------- //
// ------------------------------------- INDEX.HTML corrections for CSS, font styling, etc. below this line ------------------------------------- //
// ---------------------------------------------------------------------------------------------------------------------------------------------- //


Add these below <style> tag in index.html (main branch of this repo):
     ```@font-face {
            font-family: 'Playfair Display';
            src: url('fonts/PlayfairDisplay-SemiBold.ttf') format('truetype');
            font-weight: 600;
        }
        @font-face {
            font-family: 'EB Garamond';
            src: url('fonts/EBGaramond-Regular.ttf') format('truetype');
            font-weight: 400;
        }
        @font-face {
            font-family: 'EB Garamond';
            src: url('fonts/EBGaramond-Italic.ttf') format('truetype');
            font-style: italic;
        }
     ```


Replace `<link href="font url is here in the file">` in index.html with:
        `<link href="css/phosphor.css" rel="stylesheet">`


Replace ln283 to 285 in the current index.html (main branch of this repo) with:
   ```closeModal();
      setTimeout(() => {
          if (window.AndroidPrint) {
              window.AndroidPrint.printPage();
          } else {
              window.print();
          }
      }, 150);
   ```
    
Thankyou for using my app! Any suggestions are welcome, I am still in learning and testing phases. Do this purely as a hobby.
Wouldn't have been possible for me to do xml or java without AI Copilot or GitHub Claude Haiku 4.5 (part of free GitHub Student Dev Pack that I am enjoying for 2+ years) help. I mostly deal in python.
