# Judul: Panduan Skenario Demo Aplikasi

Dokumen ini berisi panduan urutan pengujian aplikasi saat presentasi UTS. Semua skenario ini dibuat untuk membuktikan kalau struktur data dan fitur yang diminta di soal benar-benar jalan dengan baik.


# Skenario 1: Memuat 50 Data Utama

Cara tes: Buka aplikasi, klik tombol Upload File CSV, lalu pilih file putusan-50.csv dari folder data.

Yang diharapkan: Aplikasi berhasil memuat tepat 50 baris data ke dalam tabel UI. Cek tulisan indikator di layar bawah, harus tertulis "Total: 50 data".

Screenshot bukti: **(img/bukti-50-data.png)**


# Skenario 2: Menguji Fitur Pencarian (Search)

Cara tes: Di kolom pencarian, pilih mode "Nomor Perkara" atau "Case ID", lalu ketik:

Nomor perkara yang posisinya ada di tengah tabel.

Nomor perkara asal-asalan yang pasti nggak ada (misal: "XYZ-999").

Nomor perkara yang ada di urutan paling atas atau paling bawah.

Yang diharapkan: Tabel langsung menyaring dan menampilkan hasil yang pas. Teks status di bawah juga memunculkan pesan "Ditemukan X data untuk pencarian...".

Screenshot bukti: **(img/bukti-uji-fitur-pencarian.png)**


# Skenario 3: Penghapusan dan Pergeseran Indeks

Cara tes: Pilih baris data paling pertama di tabel lalu klik Hapus. Lakukan hal yang sama untuk data yang posisinya di tengah, dan terakhir hapus data yang posisinya paling bawah.

Yang diharapkan: Indikator total data berkurang jadi 47. Tabel merapat ke atas tanpa ada baris kosong atau error, membuktikan fungsi geser (arraycopy) di DynamicArray sukses bekerja.

Screenshot bukti: **(img/bukti-penghapusan-dan-penggeseran-indeks.png)**


# Skenario 4: Penambahan Data Baru dan Cek Invariant

Cara tes: Isi form di sebelah kiri secara manual. Tambahkan 3 data perkara baru.

Yang diharapkan: Total data kembali menjadi 50. Data baru muncul di tabel, dan tidak ada pesan error Invariant (artinya ukuran array dan pointer-nya sinkron).

Screenshot bukti: **(img/bukti-tambah-data-dan-cek-invariant.png)**

# Skenario 5: Filter Berjenjang dan Bukti Provenance

Cara tes: Gunakan fitur filter rentang vonis atau rentang barang bukti (misalnya set Vonis Min 10, Vonis Max 60 bulan).

Yang diharapkan: Tabel cuma menampilkan kasus yang vonisnya antara rentang tersebut. Cek salah satu hasilnya, lalu cocokkan manual dengan dokumen data-provenance.csv untuk membuktikan data yang difilter valid dan akurat.

Screenshot bukti: **(img/bukti-filter.png)**


# Skenario 6: Uji Coba Stack Audit Log

Cara tes: Lakukan beberapa aksi berturut-turut (misal: Tambah, Update, Hapus). Lalu cek area teks Audit Log di layar.

Yang diharapkan: Muncul riwayat aktivitas. Aktivitas yang paling terakhir dikerjakan pasti muncul di urutan paling atas (bukti bahwa Stack LIFO berjalan benar).

Screenshot bukti: **(img/bukti-stack-audit-log.png)**


# Skenario 7: Validasi Error Input (Handling Kesalahan)

Cara tes: Kosongkan kolom Nomor Perkara, lalu isikan huruf "abc" ke kolom Vonis (yang seharusnya berisi angka). Lalu klik tombol Tambah.

Yang diharapkan: Aplikasi tidak crash atau keluar sendiri. Muncul peringatan (Alert) yang memberi tahu kalau Nomor Perkara wajib diisi dan Vonis harus berupa angka. Data lama di tabel sama sekali tidak terpengaruh.

Screenshot bukti: **(img/bukti-validasi-error-input.png)**