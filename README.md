# ⚡ Charging Workshop - Bring Shark Chan charging animations to your Android, and lots of charging sounds 🦈🦈🦈

**Xem hướng dẫn tiếng Việt [tại đây](https://github.com/YunyiKovsha/Charging_Workshop/blob/master/README_VIE.md).**

I recommend you read all of the information below first. But just in case, here is the download link:

[![Downloads](https://img.shields.io/github/downloads/YunyiKovsha/Charging_Workshop/total)](https://github.com/YunyiKovsha/Charging_Workshop/releases/)

Simply use the `.apk` file, or download the source code to explore and modify it yourself. Build information is provided below.  
**Use at your own risk, good luck!**

# 📌 Information

This project is a fork of [ChargingWorkshop](https://github.com/RyensX/ChargingWorkshop), originally created by [RyensX](https://github.com/RyensX). I am not affiliated with the original author, and any modifications in this version are my own.

> [!WARNING]
> **Liability Disclaimer:**  
> This project is provided "as-is" without any guarantees or warranties, whether express or implied. I am not responsible for any damages, losses, or issues arising from the use of this project. Users assume all risks associated with using this version.

# 📝 About This Fork

- Translate the entire application into English to make it easier for everyone to use.
- Fixed a minor bug affecting the `tap-to-close` feature.
- The new `Unlock Style` feature replaces the previous `tap-to-close`, providing users with a smoother and more seamless unlocking experience.
- And a few other minor changes.

# 🚀 Quick Start Guide

## 👉 Step 1. Download needed files

Go to [releases](https://github.com/YunyiKovsha/Charging_Workshop/releases/) page and download these files:
- `Charging_Workshop_2.5.apk`
- `resources.zip`
- `scbg_fhd+.png` (Optional, this is Shark Chan wallpaper)
- `animation_default.mp4` (Optional, this is Shark Chan live wallpaper)

## 👉 Step 2. Install `.apk` file

- No need to explain further, right?

## 👉 Step 3. Set-up resource files [IMPORTANT]

- The ultimate goal of this step is to place the resource files in the application's directory.
- In the `resources.zip` file you just downloaded, you can see 2 folders: `audio` and `video`.
- Use a file manager app that can access system directories, such as [ZArchiver](https://play.google.com/store/apps/details?id=ru.zdevs.zarchiver), to extract two folders above to the following path:
  `/storage/emulated/0/Android/data/com.su.charging/files/res/`
- The folder structure after completion is as follows:
  ```
  files/
  └── res/
      ├── audio/
      └── video/
  ```
- Once you've confirmed, open the app and enjoy!

## 👉 Step 4. Other things you can tinker with!

- Shark Chan wallpaper: Simply download `scbg_fhd+.png` and set it.
- Shark Chan live wallpaper: Download `animation_default.mp4` and use with [Video Live Wallpaper](https://github.com/cyunrei/Video-Live-Wallpaper) made by [Cyunrei](https://github.com/cyunrei).

# 🛠️ Modify & Build For Yourself

If you want to build this project yourself, I recommend using the following settings:
- `Gradle 7.2` and `Android Gradle Plugin 7.1.1`.
- `JDK 11` or `JDK 8` but you can try `JDK 17`.
- And you should test/debug on `Android 8.0 "Oreo" - API 26` or above.

# 📄 License

This project is licensed under the GNU General Public License v3.0 (GPL-3.0). You are free to modify, distribute, and use the code, but it must remain under the same license. Any derivative work must also be licensed under GPL-3.0, and you must provide a copy of this license with any redistribution. For more details, please refer to the [LICENSE](https://github.com/YunyiKovsha/Charging_Workshop/blob/master/LICENSE) file.
