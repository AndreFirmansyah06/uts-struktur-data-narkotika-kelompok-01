package com.example.utsstrukdat.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Putusan {

    private SimpleStringProperty caseId;
    private SimpleStringProperty nomorPerkara;
    private SimpleStringProperty pengadilan;
    private ObjectProperty<LocalDate> tanggalPutusan;
    private SimpleStringProperty terdakawaKode;
    private SimpleStringProperty jenisNarkotika;
    private SimpleDoubleProperty beratBarangBuktiGram;
    private SimpleStringProperty pasalDakwaan;
    private SimpleStringProperty pasalTerbukti;
    private SimpleIntegerProperty tuntutanBulan;
    private SimpleIntegerProperty vonisBulan;
    private SimpleLongProperty dendaRupiah;
    private SimpleStringProperty barangBukti;
    private SimpleStringProperty keadaanMemberatkan;
    private SimpleStringProperty keadaanMeringankan;
    private SimpleStringProperty sourcePages;

    private static int jumlahDibuat = 0;


    public Putusan() {
        this.caseId = new SimpleStringProperty("");
        this.nomorPerkara = new SimpleStringProperty("");
        this.pengadilan = new SimpleStringProperty("");
        this.tanggalPutusan = new SimpleObjectProperty<>(LocalDate.now());
        this.terdakawaKode = new SimpleStringProperty("");
        this.jenisNarkotika = new SimpleStringProperty("");
        this.beratBarangBuktiGram = new SimpleDoubleProperty(0);
        this.pasalDakwaan = new SimpleStringProperty("");
        this.pasalTerbukti = new SimpleStringProperty("");
        this.tuntutanBulan = new SimpleIntegerProperty(0);
        this.vonisBulan = new SimpleIntegerProperty(0);
        this.dendaRupiah = new SimpleLongProperty(0);
        this.barangBukti = new SimpleStringProperty("");
        this.keadaanMemberatkan = new SimpleStringProperty("");
        this.keadaanMeringankan = new SimpleStringProperty("");
        this.sourcePages = new SimpleStringProperty("");
        jumlahDibuat++;
    }

    public Putusan(String caseId, String nomorPerkara, String pengadilan, LocalDate tanggalPutusan,
                   String terdakawaKode, int tuntutanBulan, int vonisBulan, long dendaRupiah, String barangBukti, String jenisNarkotika,
                   double beratBarangBukti, String pasalTerbukti, String pasalDakwaan,
                   String keadaanMemberatkan, String keadaanMeringankan, String sourcePages) {
        this.caseId = new SimpleStringProperty(caseId);
        this.nomorPerkara = new SimpleStringProperty(nomorPerkara);
        this.pengadilan = new SimpleStringProperty(pengadilan);
        this.tanggalPutusan = new SimpleObjectProperty<>(tanggalPutusan);
        this.terdakawaKode = new SimpleStringProperty(terdakawaKode);
        this.tuntutanBulan = new SimpleIntegerProperty(tuntutanBulan);
        this.jenisNarkotika = new SimpleStringProperty(jenisNarkotika);
        this.beratBarangBuktiGram = new SimpleDoubleProperty(beratBarangBukti);
        this.pasalTerbukti = new SimpleStringProperty(pasalTerbukti);
        this.pasalDakwaan = new SimpleStringProperty(pasalDakwaan);
        this.vonisBulan = new SimpleIntegerProperty(vonisBulan);
        this.dendaRupiah = new SimpleLongProperty(dendaRupiah);
        this.barangBukti = new SimpleStringProperty(barangBukti);
        this.keadaanMemberatkan = new SimpleStringProperty(keadaanMemberatkan);
        this.keadaanMeringankan = new SimpleStringProperty(keadaanMeringankan);
        this.sourcePages = new SimpleStringProperty(sourcePages);
        jumlahDibuat++;
    }


    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }


    @Override
    public String toString() {
        return String.format("Nomor: %s | Terdakwa: %s | Vonis: %d bulan | Denda: Rp%.0f",
                nomorPerkara.get(), terdakawaKode.get(), vonisBulan.get(), dendaRupiah.get());
    }