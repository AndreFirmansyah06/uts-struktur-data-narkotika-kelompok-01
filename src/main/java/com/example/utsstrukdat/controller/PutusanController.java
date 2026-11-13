package com.example.utsstrukdat.controller;

import com.example.utsstrukdat.model.Putusan;
import com.example.utsstrukdat.model.StatistikPutusan;
import com.example.utsstrukdat.util.ArrayStack;
import com.example.utsstrukdat.util.AuditLog;
import com.example.utsstrukdat.util.DynamicArray;
import com.example.utsstrukdat.util.InputHandler;
import com.example.utsstrukdat.util.CSVFileHandler;
import com.example.utsstrukdat.model.KnowledgeRepository;

import java.io.File;
import java.time.LocalDate;



public class PutusanController {
    private final KnowledgeRepository repository;
    private final ArrayStack<AuditLog> audit = new ArrayStack<>();

    public KnowledgeController(KnowledgeRepository repository) {

        this.repository = repository;
    }

    // GET ALL DATA
    public DynamicArray<Putusan> getSemuaPutusan() {

        return repository.getDaftarSemua();
    }

    // GET TOTAL DATA
    public int getTotalDataPutusan() {

        return repository.getTotalData();
    }

    public void tambahPutusan(
            String caseIdStr,
            String nomorPerkaraStr,
            String pengadilanStr,
            LocalDate tanggalStr,
            String kodeTerdakwaStr,
            String beratBBDb,
            String jenisNarkotikaStr,
            String barangBuktiStr,
            String pasalDakwaanStr,
            String pasalTerbuktiStr,
            String vonisBulanStr,
            String tuntutanBulanStr,
            String dendaRupiahStr,
            String keadaanMeringankanStr,
            String keadaanMemberatkanStr,
            String sourcePageStr
    ) {

        // 1. Validasi & parsing field String wajib (lewat InputHandler)
        String caseId = InputHandler.validasiString(caseIdStr, "Case Id");
        String nomorPerkara = InputHandler.validasiString(nomorPerkaraStr, "Nomor Perkara");
        String pengadilan = InputHandler.validasiString(pengadilanStr, "Pengadilan");
        LocalDate tanggal = tanggalStr;
        String kodeTerdakwa = InputHandler.validasiString(kodeTerdakwaStr, "Kode Terdakwa");
        String jenisNarkotika = InputHandler.validasiString(jenisNarkotikaStr, "Jenis Narkotika");
        Double beratBarangBuktiGram = InputHandler.validasiDouble(beratBBDb, "Berat Barang Bukti");
        String pasalDakwaan = InputHandler.validasiString(pasalDakwaanStr, "Pasal Dakwaan");
        String pasalTerbukti = InputHandler.validasiString(pasalTerbuktiStr, "Pasal Terbukti");
        long dendaRupiah = (long) InputHandler.validasiLong(dendaRupiahStr, "Denda Rupiah");
        int vonisBulan = InputHandler.validasiInt(vonisBulanStr, "Vonis Bulan");
        int tuntutanBulan = InputHandler.validasiInt(tuntutanBulanStr, "Tuntutan Bulan");
        String keadaanMeringankan = InputHandler.validasiString(keadaanMeringankanStr, "Keadaan Meringankan");
        String keadaanMemberatkan = InputHandler.validasiString(keadaanMemberatkanStr, "Keadaan Memberatkan");
        String sourcePages = InputHandler.validasiString(sourcePageStr, "Source Pages");
        String barangBukti = InputHandler.validasiString(barangBuktiStr, "Barang Bukti");

        // Validasi nomor perkara tidak boleh duplikat
        if (repository.isNomorPerkaraExists(nomorPerkara)) {
            throw new IllegalArgumentException(
                    "Nomor perkara \"" + nomorPerkara + "\" sudah terdaftar.");
        }

        Putusan pts = new Putusan(
                caseId, nomorPerkara, pengadilan, tanggal, kodeTerdakwa, tuntutanBulan, vonisBulan, dendaRupiah, barangBukti
                , jenisNarkotika, beratBarangBuktiGram, pasalTerbukti, pasalDakwaan, keadaanMemberatkan, keadaanMeringankan, sourcePages
        );

        repository.simpan(pts);
        catat("TAMBAH", caseId);
    }

    public boolean updatePutusan(String caseIdStr,
                                 String nomorPerkaraStr,
                                 String pengadilanStr,
                                 LocalDate tanggalStr,
                                 String kodeTerdakwaStr,
                                 String beratBBDb,
                                 String jenisNarkotikaStr,
                                 String barangBuktiStr,
                                 String pasalDakwaanStr,
                                 String pasalTerbuktiStr,
                                 String vonisBulanStr,
                                 String tuntutanBulanStr,
                                 String dendaRupiahStr,
                                 String keadaanMeringankanStr,
                                 String keadaanMemberatkanStr,
                                 String sourcePageStr
    ) {

        // 1. Validasi & parsing field String wajib (lewat InputHandler)
        String caseId = InputHandler.validasiString(caseIdStr, "Case Id");
        String nomorPerkara = InputHandler.validasiString(nomorPerkaraStr, "Nomor Perkara");
        String pengadilan = InputHandler.validasiString(pengadilanStr, "Pengadilan");
        LocalDate tanggal = tanggalStr;
        String kodeTerdakwa = InputHandler.validasiString(kodeTerdakwaStr, "Kode Terdakwa");
        String jenisNarkotika = InputHandler.validasiString(jenisNarkotikaStr, "Jenis Narkotika");
        Double beratBarangBuktiGram = InputHandler.validasiDouble(beratBBDb, "Berat Barang Bukti");
        String pasalDakwaan = InputHandler.validasiString(pasalDakwaanStr, "Pasal Dakwaan");
        String pasalTerbukti = InputHandler.validasiString(pasalTerbuktiStr, "Pasal Terbukti");
        long dendaRupiah = (long) InputHandler.validasiLong(dendaRupiahStr, "Denda Rupiah");
        int vonisBulan = InputHandler.validasiInt(vonisBulanStr, "Vonis Bulan");
        int tuntutanBulan = InputHandler.validasiInt(tuntutanBulanStr, "Tuntutan Bulan");
        String keadaanMeringankan = InputHandler.validasiString(keadaanMeringankanStr, "Keadaan Meringankan");
        String keadaanMemberatkan = InputHandler.validasiString(keadaanMemberatkanStr, "Keadaan Memberatkan");
        String sourcePages = InputHandler.validasiString(sourcePageStr, "Source Pages");
        String barangBukti = InputHandler.validasiString(barangBuktiStr, "Barang Bukti");

        Putusan dataBaru = new Putusan(
                caseId, nomorPerkara, pengadilan, tanggal, kodeTerdakwa, tuntutanBulan, vonisBulan, dendaRupiah, barangBukti
                , jenisNarkotika, beratBarangBuktiGram, pasalTerbukti, pasalDakwaan, keadaanMemberatkan, keadaanMeringankan, sourcePages
        );

        repository.update(nomorPerkara, dataBaru);
        catat("Update", caseId);
        return true;
    }

    public boolean hapusPutusan(String nomor) {
        catat("Hapus", nomor);
        return repository.hapus(nomor);

    }`

    public DynamicArray<Putusan> cariPutusan(String keyword, String mode) {
        if (keyword == null || keyword.isBlank() || mode == null) {
            return new DynamicArray<>();
        }

        switch (mode.toLowerCase().trim()) {
            case "nomor perkara":
                return repository.cariByNomor(keyword); // ini baru

            case "case id":
                return repository.cariByCaseId(keyword); // ini baru - Langsung return DynamicArray

            default:
                return new DynamicArray<>();
        }
    }

    //     FILTER DATA
    public DynamicArray<Putusan> filterPutusan(String kriteria, String nilai) {
        if (kriteria == null || nilai == null) {
            return new DynamicArray<>();
        }
        switch (kriteria.toLowerCase()) {
            case "jenis":
                return repository.filterByJenis(nilai);
//            case "pengadilan":
//                return repository.filterByPengadilan(nilai);
            default:
                return new DynamicArray<>();
        }
    }

    // GET DATA STATISTIK
    public StatistikPutusan getStatistik() {

        return new StatistikPutusan(repository.getDaftarSemua());
    }

    public void importData(File file) {
        if (file == null) return;

        try {
            DynamicArray<Putusan> data = CSVFileHandler.bacaFile(file);

            if (data == null) return;

            // ini baru - Kunci ukuran batas awal sebelum looping berjalan
            int totalDataBaru = data.size();
            System.out.println("[DEBUG IMPORT] Memulai import " + totalDataBaru + " data...");

            for (int i = 0; i < totalDataBaru; i++) { // ini baru - Gunakan variabel totalDataBaru
                Putusan p = data.get(i);
                if (p != null) {
                    repository.simpan(p);
                }
            }
            catat("Import Berhasil ", "");
            System.out.println("[DEBUG IMPORT] Selesai mengimpor data.");
        }
        catch (Exception e) {
            System.err.println("Gagal import: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
