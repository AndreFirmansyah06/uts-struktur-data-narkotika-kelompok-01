package com.example.utsstrukdat.model;

import java.util.HashMap;
import java.util.Map;

public class StatistikPutusan {

    private int totalPerkara;
    private double rataRataVonis;
    private double grandTotalDenda;
    private String jenisNarkotikaTerbanyak;
    private String[] distribusiNarkoba;

    private DynamicArray<Putusan> daftar;


    public StatistikPutusan(DynamicArray<Putusan> daftar) {
        this.daftar = daftar;
        hitungSemua();
    }

    public void hitungSemua() {
        if (daftar == null || daftar.isEmpty()) {
            totalPerkara = 0;
            rataRataVonis = 0;
            grandTotalDenda = 0;
            jenisNarkotikaTerbanyak = "Tidak ada data";
            distribusiNarkoba = new String[]{"Tidak ada data"};
            return;
        }

        totalPerkara = daftar.size();

        int totalVonis = 0;
        for (int i = 0; i < daftar.size(); i++) {
            Putusan p = daftar.get(i);
            totalVonis += p.getVonisBulan();
        }
        rataRataVonis = (double) totalVonis / daftar.size();

        double totalDenda = 0;
        for (int i = 0; i < daftar.size(); i++) {
            Putusan p = daftar.get(i);
            totalDenda += p.getdendaRupiah();

        }
        grandTotalDenda = totalDenda;

        HashMap<String, Integer> hitungJenis = new HashMap<>();
        for (int i = 0; i < daftar.size(); i++) {
            Putusan p = daftar.get(i);
            String jenis = p.getJenisNarkotika();
            hitungJenis.put(jenis, hitungJenis.getOrDefault(jenis, 0) + 1);

        }

        HashMap<String, Integer> hitungNarkotika = new HashMap<>();
        for (int i = 0; i < daftar.size(); i++) {
            Putusan p = daftar.get(i);
            String peran = p.getJenisNarkotika();
            hitungNarkotika.put(peran, hitungNarkotika.getOrDefault(peran, 0) + 1);

        }

        distribusiNarkoba = new String[hitungNarkotika.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : hitungNarkotika.entrySet()) {
            distribusiNarkoba[i++] = entry.getKey() + ": " + entry.getValue() + " kasus";
        }
    }