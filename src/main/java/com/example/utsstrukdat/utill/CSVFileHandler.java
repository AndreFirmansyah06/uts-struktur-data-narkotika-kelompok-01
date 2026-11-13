package com.example.utsstrukdat.utill;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;

public class CSVFileHandler {

    public static DynamicArray<Putusan> bacaFile(File file) {
        DynamicArray<Putusan> daftar = new DynamicArray<>();

        CSVFormat format = CSVFormat.RFC4180.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setIgnoreEmptyLines(true)
                .setTrim(true)
                .build();

        try (Reader reader = new FileReader(file);
             CSVParser csvParser = new CSVParser(reader, format)) {

            for (CSVRecord record : csvParser) {

                if (record.size() != 16) {
                    System.err.println("[SKIP CSV] Baris ke-" + record.getRecordNumber() + " dilewati karena jumlah kolom (" + record.size() + ") != 16");
                    continue;
                }

                try {
                    String caseId = record.get(0);
                    String nomorPerkara = record.get(1);
                    String pengadilan = record.get(2);
                    String tanggalStr = record.get(3);
                    LocalDate tanggal = LocalDate.parse(tanggalStr);

                    String kodeTerdakwa = record.get(4);
                    String jenisNarkotika = record.get(5);

                    String beratStr = record.get(6).replace(",", ".");
                    double beratBarangBuktiGram = Double.parseDouble(beratStr);

                    String pasalDakwaan = record.get(7);
                    String pasalTerbukti = record.get(8);
                    int tuntutanBulan = Integer.parseInt(record.get(9));
                    int vonisBulan = Integer.parseInt(record.get(10));

                    String dendaStr = record.get(11).replace(".", "");
                    long dendaRupiah = Long.parseLong(dendaStr);

                    String barangBukti = record.get(12);
                    String keadaanMemberatkan = record.get(13);
                    String keadaanMeringankan = record.get(14);
                    String sourcePages = record.get(15);

                    Putusan p = new Putusan(
                            caseId, nomorPerkara, pengadilan, tanggal, kodeTerdakwa, tuntutanBulan, vonisBulan, dendaRupiah, barangBukti,
                            jenisNarkotika, beratBarangBuktiGram, pasalTerbukti, pasalDakwaan, keadaanMemberatkan, keadaanMeringankan, sourcePages
                    );

                    daftar.add(p);
                } catch (Exception e) {
                    System.err.println("[SKIP CSV] Gagal parse baris ke-" + record.getRecordNumber() + ": " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Gagal membaca file CSV: " + e.getMessage());
        }

        System.out.println("[DEBUG CSV] Total baris CSV berhasil di-parse: " + daftar.size());
        return daftar;
    }
