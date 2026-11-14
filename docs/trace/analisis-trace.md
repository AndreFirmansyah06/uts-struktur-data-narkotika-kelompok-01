# Judul: Analisis Kompleksitas Waktu dan Trace Manual

**Bagian 1: Analisis Kompleksitas Waktu**
Di bagian ini, saya mau membedah seberapa cepat struktur data yang saya buat (DynamicArray dan ArrayStack) saat menjalankan operasi-operasi utamanya.

1. Operasi Tambah Data (Add / Push)
   Untuk DynamicArray, menambahkan data ke urutan paling belakang itu butuh waktu O(1) atau sangat cepat. Tapii, kalau kapasitas array-nya kebetulan sudah penuh, fungsi ensureCapacity() akan jalan buat menggandakan ukuran array dan memindahkan semua data lama. Proses pemindahan ini butuh waktu O(n). Hal yang sama persis juga berlaku buat fungsi push di ArrayStack saya.

2. Operasi Ambil Data (Get / Peek)
   Akses data di array itu selalu O(1). Karena kita langsung tembak indeksnya di memori, prosesnya langsung seketika tanpa harus muter-muter mencari datanya dulu.

3. Operasi Cari Data (Search)
   Karena saya pakai algoritma Linear Search, fungsi pencarian bakal ngecek data dari indeks ke-0 sampai terakhir. Jadi kompleksitas waktunya O(n). Kalau datanya ada di paling ujung atau malah nggak ada sama sekali, program harus muter sebanyak jumlah data yang ada (Worst Case).

4. Operasi Hapus Data (Remove di DynamicArray)
   Ini yang agak berat. Kalau saya menghapus data di posisi paling akhir, waktunya cuma O(1). Tapi kalau saya menghapus data di posisi pertama atau di tengah, waktunya jadi O(n). Kenapa? Karena semua data yang ada di sebelah kanannya harus digeser satu per satu ke kiri buat nutupin celah kosong supaya urutannya nggak bolong.

**Bagian 2: Penelusuran (Trace) Manual Operasi Hapus**
Biar lebih jelas, mari kita simulasikan gimana fungsi remove() di DynamicArray saya bekerja di belakang layar saat menghapus data di tengah.

Kondisi Awal:
Katakanlah array saya ukurannya 5 dan isinya penuh: [A, B, C, D, E] (size = 5).
Lalu user menekan tombol hapus untuk data "B" yang ada di indeks ke-1.
Perintah yang jalan di kode: remove(1).

Langkah-langkah di memori:

1. Validasi dulu: Apakah indeks 1 itu valid? Iya, karena batasnya dari 0 sampai 4.
2. Program mengamankan data "B" ke dalam variabel sementara biar nggak hilang saat mau di-return nanti.
3. Hitung jumlah elemen yang harus digeser (numMoved). Rumusnya: size - posisi - 1. Berarti 5 - 1 - 1 = 3 elemen yang harus digeser (yaitu C, D, E).
4. Fungsi System.arraycopy akan menggeser C, D, dan E ke kiri sebanyak satu langkah.
    - C (indeks 2) pindah ke indeks 1.
    - D (indeks 3) pindah ke indeks 2.
    - E (indeks 4) pindah ke indeks 3.
      Sekarang bentuk array-nya jadi: [A, C, D, E, E].

5. Kurangi batas ukuran (size) jadi 4.
6. Hapus elemen duplikat di ujung kanan (indeks ke-4) jadi null biar memorinya bersih.
   Hasil akhirnya: [A, C, D, E, null].
7. Terakhir, program memanggil validateInvariant() untuk memastikan ukurannya benar-benar 4 dan elemen setelahnya murni null. Semuanya aman.