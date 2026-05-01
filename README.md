# 📱 Seminar Registration App

## 📌 Deskripsi Aplikasi

Seminar Registration App adalah aplikasi Android sederhana yang digunakan untuk melakukan pendaftaran seminar.
Aplikasi ini dibuat menggunakan **Kotlin** dan menerapkan konsep **Material Design**, validasi input, serta navigasi antar activity.

---

## 🎯 Tujuan

Aplikasi ini dibuat untuk memenuhi tugas UTS dengan ketentuan:

* Menggunakan Material Design
* Memiliki validasi input
* Menggunakan dialog konfirmasi
* Menampilkan hasil input user

---

## 🧩 Fitur Utama

### 🔐 1. Login

* Login menggunakan data sederhana (hardcode)
* Username: `admin`
* Password: `123`
* Menyimpan username menggunakan **SharedPreferences**

---

### 📝 2. Register

* Form registrasi sederhana
* Redirect ke halaman login setelah register

---

### 🏠 3. Halaman Utama (Main Activity)

* Menampilkan nama user yang login
* Tombol untuk menuju form pendaftaran seminar

---

### 📋 4. Form Pendaftaran

User mengisi data:

* Nama
* Email
* Nomor HP
* Jenis Kelamin (RadioButton)
* Pilihan Seminar (Spinner)
* Checkbox persetujuan

---

### ⚠️ 5. Validasi Input

Validasi yang diterapkan:

* Semua field wajib diisi
* Email harus mengandung `@`
* Nomor HP:

  * Hanya angka
  * Diawali dengan `08`
  * Panjang 10–13 digit
* Gender wajib dipilih
* Checkbox wajib dicentang

✔ Mendukung **real-time validation** menggunakan `TextWatcher`

---

### 💬 6. Dialog Konfirmasi

Setelah klik submit:

* Muncul dialog:

  * "Apakah data sudah benar?"
* Pilihan:

  * Ya → lanjut ke hasil
  * Tidak → kembali ke form

---

### 📊 7. Halaman Hasil

Menampilkan:

* Nama
* Email
* Nomor HP
* Gender
* Seminar yang dipilih

Terdapat tombol untuk kembali ke halaman utama

---

## 🔄 Alur Aplikasi

Login → Main → Form → Result → Main

---

## 🧠 Teknologi yang Digunakan

* Kotlin
* Android Studio
* Material Design Components
* SharedPreferences
* Intent (untuk perpindahan activity)
* AlertDialog
* TextWatcher (real-time validation)
* Regex (validasi nomor HP)

---

## ⚙️ Cara Menjalankan Aplikasi

1. Buka project di Android Studio
2. Tunggu Gradle selesai build
3. Jalankan di emulator / device
4. Login menggunakan:

   * Username: `admin`
   * Password: `123`

---

## 🎥 Demo Aplikasi (YouTube)

Link video demo dapat dilihat di bawah ini:

👉 **https://youtu.be/seb5i1RkHfU?si=TFKt90DbDnDEV4TV**

---

## 👨‍💻 Author

Nama: Muharafi Dalilah
Kelas: TIF K 24 A
Nim: 24552011150
Mata Kuliah: Pemrograman Mobile 1

---
