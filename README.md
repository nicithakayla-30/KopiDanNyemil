# Kopi dan Nyemil ☕🍪

Aplikasi mobile Android pemesanan kopi dan makanan ringan yang modern, minimalis, dan mudah digunakan, dikembangkan menggunakan Android Studio dengan Kotlin dan XML Layouts.

## 📱 Tentang Aplikasi
**Kopi dan Nyemil** adalah aplikasi e-commerce sederhana untuk memesan menu kopi dan makanan ringan favorit. Aplikasi ini dirancang untuk tugas UTS Pemrograman Mobile dengan antarmuka yang menarik sesuai dengan skema warna yang ditentukan, serta menggunakan penyimpanan lokal (`SharedPreferences`) untuk manajemen akun, profil, dan riwayat pesanan pengguna.

## ✨ Fitur Utama
1. **Splash Screen / Welcome**:
   - Menampilkan ilustrasi/logo kopi, nama aplikasi "Kopi dan Nyemil", tagline *"Get a taste of your wish"*, dan tombol "Start Now".
2. **Halaman Sign Up**:
   - Pilihan untuk menuju halaman Register atau Login.
3. **Halaman Login**:
   - Autentikasi pengguna dengan username dan password yang divalidasi melalui penyimpanan lokal (`SharedPreferences`).
4. **Halaman Register**:
   - Pendaftaran akun baru (Nama Lengkap, Username, Password) dengan validasi input dan penyimpanan lokal.
5. **Halaman Home**:
   - Sapaan dinamis "Halo, [Nama Pengguna]".
   - Menampilkan daftar menu makanan dan minuman (minimal 5 produk) menggunakan `RecyclerView`.
6. **Halaman Riwayat Pesanan (History)**:
   - Menampilkan daftar seluruh pesanan yang pernah dilakukan pengguna secara real-time menggunakan `SharedPreferences`.
   - Dilengkapi status pesanan dengan badge berwarna (Diproses, Sedang dikirim, Selesai).
   - Kondisi kosong dengan ilustrasi dan tombol "Mulai Belanja".
   - Klik item riwayat untuk membuka **Detail Pesanan** lengkap.
7. **Halaman Profile**:
   - Menampilkan informasi profil pengguna dan memungkinkan pengubahan serta penyimpanan nama lengkap secara real-time via `SharedPreferences`.
8. **Halaman Alamat Pengiriman (Order)**:
   - Form pengisian alamat pengiriman lengkap (Nama Penerima, Alamat, Patokan/Detail Lokasi) dengan validasi wajib diisi serta ringkasan pesanan dan harga produk.
9. **Halaman Konfirmasi Pesanan**:
   - Menampilkan status sukses dengan ikon centang, pesan konfirmasi pesanan, otomatis menyimpan transaksi ke riwayat, dan tombol kembali ke Home.

## 🛠️ Teknologi yang Digunakan
- **Bahasa**: Kotlin
- **UI**: XML Layouts (Material Components, CardView, RecyclerView)
- **Minimum SDK**: API 27 (mendukung minSdk 23+)
- **Penyimpanan Lokal**: SharedPreferences & JSON
- **Navigasi**: Intent antar-Activity & Bottom Navigation (Home, History, Order, Profile)

## 📂 Struktur Folder Project
```text
app/src/main/
├── java/lat/pam/kopidannyemil/
│   ├── MainActivity.kt
│   ├── SignUpActivity.kt
│   ├── LoginActivity.kt
│   ├── RegisterActivity.kt
│   ├── HomeActivity.kt
│   ├── ProfileActivity.kt
│   ├── OrderActivity.kt
│   ├── ConfirmationActivity.kt
│   ├── HistoryActivity.kt
│   ├── OrderDetailActivity.kt
│   ├── adapter/
│   │   ├── ProductAdapter.kt
│   │   └── HistoryAdapter.kt
│   ├── data/
│   │   └── DummyData.kt
│   ├── model/
│   │   └── OrderModel.kt
│   └── utils/
│       ├── SessionManager.kt
│       └── OrderHistoryManager.kt
└── res/
    ├── drawable/
    ├── layout/
    └── values/
```

## 🚀 Cara Menjalankan Aplikasi
1. Buka **Android Studio**.
2. Pilih **Open an Existing Project** dan arahkan ke folder `KopiDanNyemil`.
3. Tunggu proses **Gradle Sync** selesai.
4. Hubungkan perangkat Android fisik atau jalankan **Android Emulator** (AVD).
5. Klik tombol **Run** (`Shift + F10`) untuk mengompilasi dan menjalankan aplikasi.

## Screenshoot Tampilan Halaman

### Splash Screen
![Splash Screen](screenshots/splash.png)

### Sign Up
![Sign Up](screenshots/signup.png)

### Login
![Login](screenshots/login.png)

### Register
![Register](screenshots/register.png)

### Home
![Home](screenshots/home.png)

### Profile
![Profile](screenshots/profile.png)

### Alamat Pengiriman
![Alamat](screenshots/alamat.png)

### Konfirmasi Pesanan
![Konfirmasi](screenshots/konfirmasi.png)

### Riwayat Pesanan
![History](screenshots/history.png)
