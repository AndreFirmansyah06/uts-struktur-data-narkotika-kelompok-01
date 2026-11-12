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

    // 2. Method khusus VALIDASI TAMBAH DATA (Cek Duplikasi) - Mengembalikan boolean
    public boolean isNomorPerkaraExists(String nomor) { // ini baru
        if (nomor == null || nomor.isBlank()) { // ini baru
            return false;
        }

        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            // Menggunakan equalsIgnoreCase untuk mencocokkan nomor perkara secara PERSIS
            if (p.getNomorPerkara() != null &&
                    p.getNomorPerkara().equalsIgnoreCase(nomor.trim())) { // ini baru
                return true; // Langsung kembalikan true jika ditemukan yang sama
            }
        }
        return false; // Kembalikan false jika tidak ada yang sama
    }

    public DynamicArray<Putusan> cariByCaseId(String caseId) { // ini baru - Ubah return type ke DynamicArray
        DynamicArray<Putusan> hasil = new DynamicArray<>(); // ini baru

        if (caseId == null || caseId.isBlank()) { // ini baru
            return hasil;
        }

        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            // PERBAIKAN: Gunakan getCaseId() (bukan getNomorPerkara()) dan gunakan contains
            if (p.getCaseId() != null &&
                    p.getCaseId().toLowerCase().contains(caseId.toLowerCase().trim())) { // ini baru
                hasil.add(p); // ini baru
            }
        }
        return hasil; // ini baru
    }