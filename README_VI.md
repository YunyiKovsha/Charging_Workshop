# ⚙️ Hướng dẫn tải về và cài đặt 🔧

## Bước 1. Tải các file cần thiết 📦

Vào trang [tải xuống](https://github.com/YunyiKovsha/Charging_Workshop/releases) và tải các file sau:
- `Charging_Workshop_2.5.apk`
- `resources.zip`
- `scwp_fhd+.png` (Đây là ảnh nền, không bắt buộc)
- `sclivewp_fhd+.mp4` (Đây là ảnh nền động, không bắt buộc)

## Bước 2. Cài file `.apk` 📲

Bước này quá cơ bản rồi nên không cần phải thắc mắc nhỉ 😉

## Bước 3. Chép file tài nguyên 🗂️ [QUAN TRỌNG❗] 

- Mục đích cuối của bước này là đưa các file tài nguyên (hoạt ảnh và âm thanh) vào thư mục của app.
- Trong file `resources.zip` đã tải có 2 thư mục `audio` và `video`.
- Hãy dùng những app quản lý file nào truy cập được vào thư mục hệ thống, chẳng hạn [ZArchiver](https://play.google.com/store/apps/details?id=ru.zdevs.zarchiver), sau đó giải nén 2 thư mục trên vào đường dẫn dưới đây:
  `/storage/emulated/0/Android/data/com.su.charging/files/res/`
- Sau khi giải nén, cây thư mục phải có cấu trúc như sau:
  ```
  files/
  └── res/
      ├── audio/
      └── video/
  ```
  - Khi kiểm tra lại chính xác như vậy, thì đã xong, hãy vào app và tận hưởng!

# Tuỳ chỉnh hoạt ảnh & âm thanh 🪄

- Ngoài hoạt ảnh của Shark Chan, có thể tự tuỳ chỉnh thành bất cứ video nào miễn là đổi tên video chính xác thành `normal_charging.mp4` và `quick_charging.mp4`, sau đó chuyển vào thư mục: `/files/res/video`
- Lưu ý rằng `normal_charging.mp4` và `quick_charging.mp4` không đề cập đến việc sạc nhanh hay chậm; thay vào đó, nó là 2 hoạt ảnh sạc khi thiết bị ≤ 20% và > 20% pin.
- Không biết vì sao tác giả gốc lại dặt tên như vậy, nhưng hãy cứ để yên nó như thế 😉
- Đối với âm thanh, không cần phải đổi tên, chỉ cần chuyển vào thư mục: `/files/res/audio`

# Vọc vạch thêm 🎉

- Ảnh nền: Tải ảnh `scwp_fhd+.png`, sau đó cài ảnh nền, quá đơn giản.
- Ảnh nền động: Tải video `sclivewp_fhd+.mp4`, sau đó dùng app [Video Live Wallpaper](https://github.com/cyunrei/Video-Live-Wallpaper) của [Cyunrei](https://github.com/cyunrei) để cài, đối với Samsung thì có thể trực tiếp cài video làm ảnh nền mà không cần app khác, nhưng chỉ cài được màn hình khoá.  
**Chúc các bạn vọc vui vẻ 😉**

# Giải thích một số cài đặt 🛠

- Charging Guardian: Hoạt ảnh sạc, chắc chắn phải bật.
- Set as foreground service: Bật sẽ giúp app tránh bị hệ thống tắt đi. Nhược điểm là sẽ có 1 thông báo luôn hiện.
- Screen-on animation: Khi bật, hoạt ảnh sạc sẽ hiện mỗi lần mở sáng màn hình (trong khi sạc); khi tắt, hoạt ảnh chỉ hiện 1 lần duy nhất lúc cắm sạc.
- Always on display: Khi bật, màn hình sẽ luôn giữ trạng thái sáng (trong khi sạc) nếu không chủ động tắt màn hình.
- Unlock Style: Khi bật, hoạt ảnh sẽ tắt trước khi mở màn hình nhập mật khẩu; khi tắt, hoạt ảnh sẽ giữ nguyên, và chỉ tắt sau khi mở khoá thành công.
- Do not disturb: Khi bật, hoạt ảnh sạc sẽ không hiện nếu cắm sạc khi đang dùng ứng dụng toàn màn hình (vd: game).
- Auto start: Tự khởi động khi mở nguồn điện thoại.
- Charging Guardian voice: Âm thanh sạc, có 5 trạng thái âm thanh. Chi tiết được ghi trong nút `❔`
- Audio list: Danh sách các file âm thanh đã import, có thể tự chỉnh từng âm cho các trạng thái sạc khác nhau.
- Hide from recent apps: Ẩn app khỏi menu đa nhiệm.
