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