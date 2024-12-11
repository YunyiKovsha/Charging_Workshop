# ⚙️ Hướng dẫn tải và cài đặt 🔧

## Bước 1. Tải các file cần thiết 📦

Vào trang [tải xuống](https://github.com/YunyiKovsha/Charging_Workshop/releases) và tải các file sau:
- `Charging_Workshop_2.5.apk`
- `resources.zip`
- `scbg_fhd+.png` (Đây là ảnh nền, không bắt buộc tải)
- `animation_default.mp4` (Đây là ảnh nền động, không bắt buộc tải)

## Bước 2. Cài file `.apk` 📲

Bước này quá cơ bản rồi nên không cần phải thắc mắc nha các bạn.

## Bước 3. Chép file tài nguyên 🗂️ [QUAN TRỌNG❗] 

- Mục đích cuối của bước này đó là chép file tài nguyên (hoạt ảnh và âm thanh) vào thư mục của app.
- Trong file `resources.zip` các bạn đã tải có 2 thư mục `audio` với `video`.
- Các bạn dùng app quản lý file nào truy cập được mấy thư mục hệ thống ấy, như là [ZArchiver](https://play.google.com/store/apps/details?id=ru.zdevs.zarchiver), rồi giải nén 2 thư mục trên vô đường dẫn này:
  `/storage/emulated/0/Android/data/com.su.charging/files/res/`
- Các bạn làm xong thư mục nó sẽ có cấu trúc như vầy:
  ```
  files/
  └── res/
      ├── audio/
      └── video/
  ```
  - Khi mà thấy chính xác như vậy thì đã xong, các bạn vào app dùng nha.

## Bước 4. Phụ thôi, các bạn có thể cài thêm ảnh nền, ảnh nền động 🎉

- Ảnh nền: Tải ảnh `scbg_fhd+.png` về rồi cài ảnh nền, quá đơn giản.
- Ảnh nền động: Tải video `animation_default.mp4` về rồi dùng app [Video Live Wallpaper](https://github.com/cyunrei/Video-Live-Wallpaper) của [Cyunrei](https://github.com/cyunrei) để cài ảnh nền động nha, đối với Samsung thì có thể trực tiếp cài video làm ảnh nền động mà không cần app khác, nhưng chỉ cài được màn hình khoá.
Chúc các bạn vọc vui vẻ 😉
