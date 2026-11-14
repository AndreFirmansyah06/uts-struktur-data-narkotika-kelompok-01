# Judul: ADR 002 Implementasi Algoritma Pencarian

Konteks :
Sistem butuh fitur untuk mencari data perkara berdasarkan nomor atau ID perkaranya, lalu menampilkannya langsung ke tabel aplikasi.

Keputusan :
Saya memilih menggunakan algoritma Linear Search atau pencarian berurutan. Logika pencariannya saya letakkan di dalam kelas KnowledgeRepository.

Alasan Keputusan :
Berhubung data yang masuk ke array tidak saya urutkan secara otomatis, cara yang paling masuk akal dan aman adalah mencarinya satu per satu dari awal sampai akhir. Selain itu, pendekatan ini lebih gampang disesuaikan untuk pencarian teks. Jadi, walaupun user ngetiknya huruf kecil semua atau cuma ingat sebagian karakter nomornya saja, datanya tetap bisa ketemu.

Konsekuensi :
Kelemahannya, waktu proses pencariannya akan sangat bergantung pada jumlah data secara keseluruhan (kompleksitasnya O(n)). Tapi karena target datanya cuma 50 putusan, proses pencarian ini tetap terasa sangat cepat dan sama sekali tidak membuat aplikasi melambat.