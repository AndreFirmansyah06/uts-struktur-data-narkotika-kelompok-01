package com.example.utsstrukdat.model;

public class KnowledgeRepository {

    private DynamicArray<Putusan> daftarPutusan = new DynamicArray<>();

    public void simpan(Putusan p) {
        if (p != null) {
            daftarPutusan.add(p);
            System.out.println("[DEBUG REPO] Berhasil simpan 1 data. Size saat ini: " + daftarPutusan.size());
        } else {
            System.err.println("[DEBUG REPO] Objek Putusan yang akan disimpan bernilai NULL!");
        }
    }


    // 1. Method untuk FITUR PENCARIAN (Search Table) - Mengembalikan DynamicArray
    public DynamicArray<Putusan> cariByNomor(String nomor) { // ini baru
        DynamicArray<Putusan> hasil = new DynamicArray<>();

        if (nomor == null || nomor.isBlank()) { // ini baru
            return hasil;
        }
        System.out.println("DEBUG REPOSITORY -> Size daftarPutusan: " + daftarPutusan.size());
        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            // Menggunakan contains agar fleksibel (user tidak perlu mengetik nomor perkara secara penuh)
            if (p.getNomorPerkara() != null &&
                    p.getNomorPerkara().toLowerCase().contains(nomor.toLowerCase().trim())) { // ini baru
                hasil.add(p);
                System.out.println("Data Ditemukan");
            } else {
                System.out.println("Data Tidak Ada");
            }
        }
        return hasil;
    }
