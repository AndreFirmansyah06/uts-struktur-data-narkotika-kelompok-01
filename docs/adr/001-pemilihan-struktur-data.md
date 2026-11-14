# Judul: ADR 001 Pemilihan Struktur Data Utama dan Sekunder

Konteks :
Di tugas ini, aplikasi harus bisa menyimpan 50 data putusan pengadilan. Syarat utamanya, kita tidak diperbolehkan menggunakan koleksi bawaan dari Java seperti ArrayList atau LinkedList. Jadi, harus benar-benar menggunakan struktur data buatan sendiri.

Keputusan :
Untuk penyimpanan data utama, saya memutuskan menggunakan array dinamis (DynamicArray). Sedangkan untuk mencatat riwayat aktivitas (audit log), saya menggunakan Stack yang juga berbasis array.

Alasan Keputusan :
Saya memilih DynamicArray karena datanya relatif tetap, yaitu sekitar 50 record setelah file diimpor. Dengan menggunakan array, akses datanya lewat indeks jadi jauh lebih cepat, apalagi saat kita butuh mencari atau memfilter data.

Untuk Stack, struktur ini sangat cocok dipakai buat fitur riwayat atau log. Karena sifat dasarnya yang LIFO (Last In First Out), aktivitas yang paling baru dilakukan pasti selalu muncul di urutan paling atas.

Konsekuensi :
Konsekuensinya, setiap kali ada data yang dihapus dari DynamicArray, elemen di sebelah kanannya harus digeser ke kiri supaya tidak ada memori yang kosong atau bolong. Biar lebih aman, saya juga menambahkan fungsi untuk mengecek kalau-kalau datanya rusak. Sementara untuk Stack, saya sengaja mengunci aksesnya agar penambahan dan penghapusan cuma bisa dilakukan dari tumpukan paling atas saja.