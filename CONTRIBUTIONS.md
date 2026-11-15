# CONTRIBUTIONS

Dokumen ini menjelaskan pembagian tugas dan kontribusi setiap anggota kelompok dalam pengembangan aplikasi **Sistem Pengelolaan Data Putusan Narkotika** untuk memenuhi tugas UTS Struktur Data.

## 1. Identitas Anggota

| Nama | Username GitHub | Tanggung Jawab |
|---|---|---|
| Andre Firmansyah | [AndreFirmansyah06](https://github.com) | Pengembangan dan implementasi seluruh kode program aplikasi |
| Faiq Fahreza Bhasurona Putra | [faiqreza](https://github.com) | Pengolahan dataset, data provenance, dokumentasi, dan pengelolaan repository |

## 2. Pembagian Kontribusi

### A. Andre Firmansyah [AndreFirmansyah06](https://github.com)

Bertanggung jawab atas seluruh proses pengembangan dan implementasi kode program aplikasi.

Ruang lingkup pekerjaan:

- Mengimplementasikan struktur data Dynamic Array.
- Mengembangkan class dan model data putusan.
- Mengimplementasikan fitur import data CSV.
- Mengembangkan fitur tambah, tampil, dan hapus data putusan.
- Mengembangkan fitur pencarian dan filter data putusan.
- Mengimplementasikan fitur agregasi dan pengurutan data.
- Mengembangkan fitur audit riwayat operasi.
- Mengimplementasikan fitur ekspor data dan laporan.
- Mengembangkan GUI aplikasi.
- Mengimplementasikan validasi input dan pengelolaan file.
- Melakukan debugging, refactoring, dan pengujian kode program.
- Membuat Pull Request untuk perubahan kode program.
- Mengimplementasikan solusi terhadap Issues yang berkaitan dengan fitur aplikasi.
- Menyelesaikan Issues yang dibuat oleh anggota lain melalui Pull Request.
- Melakukan integrasi dan pemeriksaan kode program.

### B. Faiq Fahreza Bhasurona Putra [faiqreza](https://github.com)

Bertanggung jawab atas pengolahan data, penyusunan dataset, data provenance, dokumentasi, serta kebutuhan pendukung proyek.

**1. Pengolahan Dataset**

- Mengekstrak informasi dari dokumen PDF putusan pengadilan.
- Mengumpulkan dan mengolah data putusan narkotika.
- Memilah informasi putusan ke dalam file CSV.
- Menyiapkan dataset sebanyak 50 data putusan.
- Membuat dan mengelola folder data pada repository.
- Memastikan data tersusun sesuai kebutuhan aplikasi.

**2. Data Provenance**

- Memisahkan data putusan dengan data provenance.
- Menyusun file `data-provenance.csv`.
- Mencatat informasi sumber data dan halaman dokumen putusan.
- Melengkapi informasi provenance untuk mendukung keterlacakan data.

**3. Dokumentasi Proyek**

- Menyusun dokumentasi Architecture Decision Record (ADR).
- Membuat dokumentasi trace operasi aplikasi.
- Menyusun analisis trace dan skenario demonstrasi aplikasi.
- Membuat panduan demo aplikasi.
- Melengkapi dokumentasi akhir proyek.
- Menyusun dan memperbarui file `CONTRIBUTIONS.md`.

**4. Pengelolaan Repository dan Kolaborasi**

- Mengelola file dataset dan dokumentasi dalam repository.
- Membuat Pull Request untuk perubahan yang dikerjakan.
- Membuat dan mengelola Issues sesuai kebutuhan proyek.
- Membantu pengelolaan Pull Request dan integrasi perubahan.
- Berkoordinasi dengan Andre dalam proses finalisasi proyek.

## 3. Issues yang Dibuat oleh [faiqreza](https://github.com)

Terdapat 14 Issues berstatus Closed.

| Issue | Judul |
|---|---|
| #1 | Ekstrak Data Putusan |
| #2 | Memilah File CSV Putusan ke File Provenance |
| #3 | Membuat JAVA GUI untuk Kelola Data Putusan |
| #4 | Implementasi Fitur Import Data Putusan |
| #5 | Implementasi Fitur Tampil Data Putusan |
| #6 | Implementasi Fitur Tambah dan Hapus Data Putusan |
| #7 | Implementasi Fitur Pencarian Data Putusan |
| #8 | Implementasi Fitur Filter Data Putusan |
| #9 | Implementasi Fitur Agregasi Data Putusan |
| #10 | Implementasi Fitur Pengurutan Data Putusan |
| #11 | Implementasi Fitur Audit Riwayat Operasi |
| #12 | Implementasi Fitur Ekspor Data dan Laporan |
| #18 | Implementasi Struktur Data Kustom, File I/O CSV, Audit Log, dan Validasi Input |
| #34 | Pembuatan Dokumen Analisis Trace dan Skenario Demo Aplikasi |

**Catatan:** Daftar tersebut menunjukkan Issues yang dibuat menggunakan akun `faiqreza`, bukan berarti seluruh implementasi solusi dikerjakan oleh pembuat Issue. Andre bertanggung jawab atas implementasi kode program dan turut menyelesaikan Issues yang dibuat Faiq melalui Pull Request.

## 4. Pull Requests [AndreFirmansyah06](https://github.com)

Terdapat 9 Pull Requests yang seluruhnya berstatus Merged.

| PR | Judul | Status |
|---|---|---|
| #14 | Feature/view | Merged |
| #16 | Feature/controller | Merged |
| #17 | refactor pom.xml | Merged |
| #20 | fix(main & launcher):fix main dan launcher application | Merged |
| #23 | refactor(class):mengubah nama class yang belum konsisten | Merged |
| #24 | refactor(import):mengubah nama package controller yang di import | Merged |
| #27 | refactor(environment):mengubah config main class | Merged |
| #28 | fix(package):merubah nama package yang salah | Merged |
| #31 | fix(Main):memperbaiki class Main | Merged |

Pull Request tersebut menunjukkan aktivitas Andre dalam pengembangan fitur aplikasi, perbaikan kode program, penyesuaian konfigurasi, serta refactoring struktur proyek.

## 5. Pull Requests [faiqreza](https://github.com)

Terdapat 11 Pull Requests yang seluruhnya berstatus Merged.

| PR | Judul | Status |
|---|---|---|
| #13 | Feature/model | Merged |
| #15 | Feature/utill | Merged |
| #19 | Feature/utill | Merged |
| #21 | refactor: refactor import package | Merged |
| #22 | refactor: mengubah nama folder util dan menambahkan import package | Merged |
| #25 | refactor: import package | Merged |
| #26 | refactor: refactor import package | Merged |
| #29 | docs: tambah dokumentasi adr, trace operasi, dan panduan demo | Merged |
| #30 | data: membuat folder data beserta file dataset putusan 50 CSV | Merged |
| #32 | feat(data): tambah dataset 50 data putusan yang sudah diubah dari PDF | Merged |
| #33 | Melengkapi dokumen tugas (ADR, Trace, Demo) dan file provenance | Merged |

Pull Request Reza mencakup kontribusi kolaboratif dalam repository, termasuk perubahan yang berkaitan dengan kode program, pengolahan dataset, dan dokumentasi.

**Catatan:** Status dan author Pull Request menunjukkan akun yang membuat PR dan keberhasilan penggabungan perubahan. Hal tersebut tidak secara otomatis menunjukkan bahwa seluruh implementasi kode dalam PR dilakukan oleh pembuatnya. Pembagian tanggung jawab implementasi tetap mengacu pada kesepakatan dan pelaksanaan pekerjaan kelompok, yaitu Andre bertanggung jawab atas implementasi kode program, sedangkan Faiq berfokus pada pengolahan data dan dokumentasi.

## 6. Kolaborasi dan Workflow GitHub

Pengembangan aplikasi dilakukan secara kolaboratif menggunakan Git dan GitHub.

Alur kerja yang dilakukan:

1. Membuat dan mengelola Issues sesuai kebutuhan proyek.
2. Membagi pekerjaan antara pengembangan kode program dan pengolahan data serta dokumentasi.
3. Andre mengembangkan dan mengimplementasikan kode program aplikasi.
4. Reza menyiapkan dataset, provenance, dan dokumentasi proyek.
5. Melakukan commit terhadap perubahan yang dikerjakan.
6. Membuat Pull Request untuk menggabungkan perubahan ke repository.
7. Andre mengimplementasikan solusi terhadap Issues, termasuk Issues yang dibuat oleh Faiq.
8. Melakukan koordinasi dan pemeriksaan terhadap pekerjaan anggota lainnya.
9. Mengintegrasikan kode program, dataset, dan dokumentasi.
10. Melakukan pemeriksaan akhir sebelum pengumpulan tugas.

## 7. Ringkasan Kontribusi

| Anggota | Kontribusi Utama | PR Merged |
|---|---|---:|
| Andre Firmansyah | Seluruh implementasi kode program, pengembangan fitur, debugging, refactoring, pengujian aplikasi, dan penyelesaian Issues melalui Pull Request | 9 |
| Faiq Fahreza Bhasurona Putra | Ekstraksi data, dataset 50 putusan, provenance, ADR, trace, demo, dokumentasi, serta pengelolaan Issues dan Pull Requests | 11 |

### Rekapitulasi Aktivitas GitHub

| Aktivitas | Jumlah |
|---|---:|
| Pull Requests Andre (Merged) | 9 |
| Pull Requests Reza (Merged) | 11 |
| **Total Pull Requests (Merged)** | **20** |
| Issues Reza (Closed) | 14 |

## 8. Penutup

Dokumen ini disusun sebagai bentuk transparansi pembagian tanggung jawab dan kontribusi setiap anggota selama proses pengerjaan proyek UTS Struktur Data.

Seluruh aktivitas GitHub yang dicantumkan didasarkan pada riwayat repository, dengan membedakan pembuat Issues, pembuat Pull Requests, serta pihak yang bertanggung jawab atas implementasi kode program.

Melalui pembagian tugas tersebut, Andre Firmansyah berfokus pada pengembangan dan implementasi aplikasi, sedangkan Faiq Fahreza Bhasurona Putra berfokus pada pengolahan dataset, data provenance, dokumentasi, dan pengelolaan kebutuhan pendukung proyek.
