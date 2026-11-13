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

}
