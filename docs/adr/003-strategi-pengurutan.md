# Judul: ADR 003 Strategi Pengurutan Data (Sorting)

Konteks :
Di panduan tugas, ada syarat untuk menampilkan data secara terurut, misalnya berdasarkan lama vonis. Namun ada batasan tegas: proses pengurutan ini tidak boleh sampai merusak susunan asli (invariant) datanya.

Keputusan :
Biar susunan aslinya tetap aman, saya memutuskan untuk tidak membuat algoritma sorting secara manual di dalam struktur data utamanya. Sebagai gantinya, tugas mengurutkan ini saya serahkan ke bagian antarmuka (UI) menggunakan fitur sorting bawaan dari tabel JavaFX.

Alasan Keputusan :
Kalau saya paksakan datanya diurutkan langsung di dalam array aslinya, indeks posisinya pasti berantakan dan urutan aslinya saat pertama kali diimpor jadi rusak. Panduan tugas hanya meminta tampilan yang terurut. Jadi, dengan mengandalkan tabel UI dari JavaFX, data di layar bisa diurutkan saat user menekan judul kolomnya, sementara data asli di belakang layar tetap murni dan tidak berubah posisinya.

Konsekuensi :
Kode di kelas struktur data menjadi lebih rapi dan bersih dari risiko error akibat pergeseran indeks. Kita tinggal mengandalkan performa dari framework UI yang ternyata sudah sangat lancar untuk menangani perputaran 50 data.