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

# Giải thích một số cài đặt trong app 🛠

- Charging Guardian: Bật hoạt ảnh sạc, chắc chắn phải mở rồi.
- Set as foreground service: Bật thì nó đặt app thành chạy trực tiếp, giúp nó không bị hệ thống tắt (do phát hiện chạy ngầm). Có cái bất tiện là lúc nào nó cũng hiện cái thông báo.
- Screen-on animation: Nếu tắt cái này thì hoạt ảnh sạc chỉ chạy đúng 1 lần cắm sạc, sau này không hiện nữa.
- Always on display: Bật cái này thì nếu không chủ động tắt màn hình, thì nó sẽ sáng hoài không tắt.
- Unlock Style: Kiểu mở khoá, bật thì lúc mở khoá nó sẽ tắt hoạt ảnh trước khi mở màn hình nhập mật khẩu. Còn tắt thì nó sẽ giữ nguyên, nhập mật khẩu xong mở khoá nó mới tắt.
- Do not disturb: Bật lên thì nó sẽ không hiện hoạt ảnh sạc nếu đang sài ứng dụng full màn (chơi game).
- Auto start: Tự khởi động khi mở nguồn điện thoại.
- Charging Guardian voice: Bật âm thanh sạc, có 5 trạng thái âm thanh. Chi tiết tự nghiên cứu trong nút chấm hỏi nha.
- Audio list: Danh sách các file âm thanh đã import, có thể tự chỉnh từng âm cho các trạng thái sạc khác nhau.
- Hide from recent apps: Ẩn app khỏi menu đa nhiệm.
