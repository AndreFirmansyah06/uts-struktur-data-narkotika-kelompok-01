# UTS Struktur Data: Pengolahan 50 Putusan Pengadilan Narkotika

Aplikasi Java (JavaFX) berorientasi objek yang menyimpan dan mengolah 50 putusan pengadilan negeri perkara narkotika. Seluruh data disimpan dalam struktur data buatan sendiri, tanpa `ArrayList`, `LinkedList`, `Stack`, dan koleksi lain dari `java.util`.

## 1. Identitas Kelompok

| Keterangan | Isi |
|---|---|
| Mata kuliah | Struktur Data |
| Dosen pengampu | Galih W. Wicaksono |
| Kelas / Semester | D / 3 |
| Kelompok | 01 |
| Anggota 1 | Andre Firmansyah (202510370110099) [AndreFirmansyah06](https://github.com) |
| Anggota 2 | Faiq Fahreza Bhasurona Putra (202510370110059) [faiqreza](https://github.com) |


## 2. Struktur Data yang Dipilih

| Peran | Struktur | Lokasi kode | Isi |
|---|---|---|---|
| Struktur utama | Array dinamis `DynamicArray<T>` (generik, dibuat dari nol) | `util/DynamicArray.java` | Seluruh 50 objek `Putusan` |
| Struktur sekunder | Stack berbasis array `ArrayStack<T>` (generik, dibuat dari nol) | `util/ArrayStack.java` | Riwayat operasi pengguna (`AuditLog`) |

Kedua struktur mengimplementasikan interface `StrukturData<T>` (`model/StrukturData.java`) dan memiliki `validateInvariant()`. Pemetaan operasi Stack ke kontrak umum beserta alasan penyimpangan dijelaskan di ADR.

Keputusan desain ada di `docs/adr/`:

- `001-pemilihan-struktur-data.md`
- `002-strategi-pencarian.md`
- `003-strategi-pengurutan.md`

### Ringkasan kompleksitas

| Operasi (DynamicArray) | Kompleksitas | Catatan |
|---|---|---|
| `get(i)`, `set(i, x)` | O(1) | Akses langsung lewat indeks |
| `add` (di akhir) | O(1) amortized | O(n) pada saat `resize` karena menyalin elemen |
| `insert(i, x)` | O(n) | Elemen setelah indeks digeser |
| `remove(i)` | O(n) | Elemen setelah indeks digeser ke kiri |
| `search` | O(n) | Pencarian linear; jumlah langkah dilaporkan |
| `resize` | O(n) | Membuat array baru dan menyalin isi |
| `size`, `isEmpty` | O(1) | |

| Operasi (ArrayStack) | Kompleksitas |
|---|---|
| `push`, `pop`, `peek` | O(1) |

Invariant `DynamicArray`: kapasitas tidak kurang dari ukuran minimal, `size` tidak melebihi kapasitas, dan elemen aktif tersusun rapat pada indeks `0` sampai `size - 1`. Invariant `ArrayStack`: urutan LIFO dan `top` konsisten dengan jumlah elemen.

## 3. Data

| File | Isi |
|---|---|
| `data/putusan-50.csv` | 50 record putusan terstruktur sesuai skema panduan |
| `docs/data-provenance.csv` | Satu baris per atribut penting per putusan: `case_id, field_name, value, source_file, source_page, extractor, reviewer, status` |

Ketentuan data:

- Berkas PDF sumber tidak diunggah ke repository. Sumber putusan: <https://putusan3.mahkamahagung.go.id>.
- Nama terdakwa disamarkan dengan kode (`terdakwaKode`). Nomor perkara dan metadata putusan tetap dipakai sebagai identitas sumber.
- Nilai yang tidak ditemukan ditulis `0` atau `null`, tidak diperkirakan.
- Aturan agregasi `beratBarangBuktiGram`: nilai adalah **jumlah berat netto** seluruh barang bukti narkotika (semua jenis) dalam gram, sebagaimana tercantum pada berita acara penimbangan atau amar putusan. Berat bruto tidak dipakai. Barang bukti yang bukan narkotika atau yang dihitung per butir (misalnya tablet obat keras) tidak dihitung dan hanya dicatat pada kolom `barangBukti`. Jika berat tidak tercantum, nilainya `0`. Contoh: putusan 65/Pid.Sus/2026/PN.Mlg memuat ekstasi 0,2 gram dan sabu 0,25 gram sehingga `beratBarangBuktiGram` = 0,45.
- Format tanggal `yyyy-MM-dd`. Teks yang mengandung koma dibungkus tanda kutip ganda.

Header `putusan-50.csv`:

```
caseId,nomorPerkara,pengadilan,tanggalPutusan,terdakwaKode,jenisNarkotika,beratBarangBuktiGram,pasalDakwaan,pasalTerbukti,tuntutanBulan,vonisBulan,dendaRupiah,barangBukti,keadaanMemberatkan,keadaanMeringankan,sourcePages
```

## 4. Prasyarat

- JDK 25 (sesuai `maven-compiler-plugin` di `pom.xml`)
- Git
- Maven tidak perlu dipasang terpisah karena repository menyertakan Maven Wrapper (`mvnw` / `mvnw.cmd`)
- JavaFX 21.0.6, Apache Commons CSV 1.10.0, dan JUnit 5 diunduh otomatis oleh Maven lewat `pom.xml`

Periksa versi Java:

```bash
java -version
```

## 5. Cara Build

```bash
git clone https://github.com/AndreFirmansyah06/uts-struktur-data-narkotika-kelompok-01.git
cd uts-struktur-data-narkotika-kelompok-01
./mvnw clean compile
```

Di Windows gunakan `mvnw.cmd clean compile`.

## 6. Cara Test

```bash
./mvnw test
```

Test mencakup operasi `DynamicArray` (tambah, sisip, hapus pertama/tengah/terakhir, struktur kosong, indeks di luar batas, `resize`), `validateInvariant()`, `ArrayStack`, impor CSV dengan record tidak valid, dan pencarian pada struktur sekunder yang tidak mengubah urutan.

## 7. Cara Menjalankan

```bash
./mvnw javafx:run
```

Dari IDE (IntelliJ IDEA): buka folder project, tunggu Maven selesai mengunduh dependency, lalu jalankan class `Main` di package `com.example.utsstrukdat.app` dengan tombol Run di sebelah `public static void main`.

### Contoh penggunaan

Tampilan utama aplikasi terdiri dari tiga bagian: **Form Input Putusan** (kiri), tabel data beserta alat pencarian dan filter (tengah), serta **Statistik Ringkasan** dan **Audit Log** (kanan). Status operasi terakhir muncul di bilah bawah, dan jumlah data di bawah tabel (`Total: 50 data`).

1. **Impor data**: klik **Upload File (.csv)** lalu pilih `data/putusan-50.csv`. Bilah status menampilkan hasil impor (misalnya "Berhasil mengimpor data. Total data saat ini: 50"), dan record yang tidak valid ditolak dengan pesan kesalahan tanpa menghentikan aplikasi.
2. **Cari**: pilih kriteria pada dropdown di samping label **Cari**, ketik nomor perkara atau case ID pada kolom pencarian, lalu klik **Cari**. Hasil dan jumlah langkah pencarian ditampilkan.
3. **Filter jenis narkotika**: pilih jenis pada dropdown **Jenis**, lalu klik **Filter**.
4. **Filter rentang vonis**: isi **Min** dan **Maks** pada **Rentang Vonis (bulan)**, lalu klik **Filter Vonis**.
5. **Filter rentang berat barang bukti**: isi **Min** dan **Maks** pada **Rentang BB**, lalu klik **Filter BB**.
6. **Reset filter**: klik **Reset Filter** untuk menampilkan kembali seluruh data.
7. **Tambah putusan**: isi **Form Input Putusan** lalu klik **Tambah Putusan**. Klik **Reset Form** untuk mengosongkan isian.
8. **Ubah dan hapus**: pilih satu baris pada tabel, lalu klik **Update Putusan** atau **Hapus Putusan**.
9. **Statistik**: panel **Statistik Ringkasan** menampilkan total perkara, rata-rata vonis (bulan), total denda, dan distribusi jenis narkotika.
10. **Audit**: setiap operasi tercatat pada panel **Audit Log**.
11. **Ekspor**: klik **Ekspor CSV** untuk menyimpan data atau hasil pencarian ke file CSV.


## 8. Fitur

| Fitur | Keterangan |
|---|---|
| Impor | Membaca tepat 50 record CSV dan menolak record tidak valid tanpa menghentikan program |
| Tampil | Ringkasan semua putusan sesuai urutan struktur utama |
| Tambah dan hapus | Memakai operasi asli `DynamicArray` |
| Cari | Berdasarkan nomor perkara atau `caseId`, disertai jumlah langkah |
| Filter | Jenis narkotika, rentang berat barang bukti, pasal terbukti, rentang vonis |
| Agregasi | Jumlah perkara, rata-rata vonis, total denda, distribusi jenis narkotika |
| Urutan | Tampilan terurut berdasarkan vonis tanpa merusak invariant struktur utama |
| Audit | Operasi pengguna direkam ke `ArrayStack` dan riwayatnya dapat ditampilkan |
| Ekspor | Hasil pencarian atau laporan disimpan ke file teks atau CSV |

## 9. Skenario Uji dan Bukti Demo

1. Muat 50 record dan buktikan `size` bernilai 50.
2. Cari satu perkara yang ada, satu yang tidak ada, dan satu record pada posisi batas.
3. Hapus elemen pertama, tengah, dan terakhir, lalu tunjukkan pergeseran elemen.
4. Tambahkan kembali tiga record dan buktikan invariant serta urutan data.
5. Jalankan filter gabungan dan cocokkan hasilnya dengan pemeriksaan provenance manual.
6. Tunjukkan bahwa pencarian pada Stack tidak mengubah urutan akhir.
7. Masukkan record tidak valid, tampilkan pesan kesalahan, dan pastikan struktur tetap konsisten.

Bukti: skenario dan tangkapan layar di `docs/demo/` (`skenario-demo.md` dan folder `img/`), analisis trace manual di `docs/trace/analisis-trace.md`.

## 10. Struktur Repository

```
uts-struktur-data-narkotika-kelompok-XX/
|-- src/main/java/com/example/utsstrukdat/
|   |-- app/          titik masuk aplikasi
|   |-- controller/   PutusanController
|   |-- model/        Putusan, StrukturData, StatistikPutusan, KnowledgeRepository
|   |-- util/         DynamicArray, ArrayStack, AuditLog, CSVFileHandler, InputHandler
|   `-- view/         FXMLController
|-- src/main/resources/
|-- src/test/java/    unit test
|-- data/putusan-50.csv
|-- docs/
|   |-- data-provenance.csv
|   |-- adr/
|   |-- trace/
|   `-- demo/
|-- AI_USAGE.md
|-- CONTRIBUTIONS.md
|-- README.md
`-- pom.xml
```

