package com.example.utsstrukdat.view;

import com.example.utsstrukdat.model.StatistikPutusan;
import com.example.utsstrukdat.util.CSVFileHandler;
import com.example.utsstrukdat.util.DynamicArray;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.utsstrukdat.model.Putusan;
import com.example.utsstrukdat.controller.KnowledgeController;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;

public class FXMLController {

    @FXML
    private TextField txtCaseId;

    @FXML
    private TextField txtNomorPerkara;
    @FXML
    private TextField txtPengadilan;
    @FXML
    private DatePicker txtTanggalPutusan;
    @FXML
    private TextField txtKodeTerdakwa;

    @FXML
    private ComboBox<String> cmbJenisNarkotika;
    @FXML
    private TextField txtBeratBarangBukti;
    @FXML
    private TextField txtPasalDakwaan;
    @FXML
    private TextField txtPasalTerbukti;
    @FXML
    private TextField txtTuntutanBulan;
    @FXML
    private TextField txtVonisBulan;
    @FXML
    private TextField txtDendaRupiah;
    @FXML
    private TextField txtBarangBukti;
    @FXML
    private TextField txtKeadaanMemberatkan;
    @FXML
    private TextField txtKeadaanMeringankan;
    @FXML
    private TextField txtSourcePages;
    
    @FXML
    private TableView<Putusan> tablePutusan;
    @FXML
    private TableColumn<Putusan, String> colCase;
    @FXML
    private TableColumn<Putusan, String> colNomorPerkara;
    @FXML
    private TableColumn<Putusan, String> colPengadilan;
    @FXML
    private TableColumn<Putusan, LocalDate> colTanggalPutusan;
    @FXML
    private TableColumn<Putusan, String> colKodeTerdakwa;
    @FXML
    private TableColumn<Putusan, String> colJenisNarkotika;
    @FXML
    private TableColumn<Putusan, Double> colBeratBarangBukti;
    @FXML
    private TableColumn<Putusan, String> colPasalDakwaan;
    @FXML
    private TableColumn<Putusan, String> colPasalTerbukti;
    @FXML
    private TableColumn<Putusan, Integer> colTuntutanBulan;
    @FXML
    private TableColumn<Putusan, Integer> colVonisBulan;
    @FXML
    private TableColumn<Putusan, Long> colDendaRupiah;
    @FXML
    private TableColumn<Putusan, String> colBarangBukti;
    @FXML
    private TableColumn<Putusan, String> colKeadaanMemberatkan;
    @FXML
    private TableColumn<Putusan, String> colKeadaanMeringankan;
    @FXML
    private TableColumn<Putusan, String> colSourcePages;

    @FXML
    private TextField txtCari;
    @FXML
    private Button btnUploadFile;
    @FXML
    private Button btnExport;
    @FXML
    private TextField txtVonisMin;
    @FXML
    private TextField txtVonisMax;
    @FXML
    private TextField txtBeratMin;
    @FXML
    private TextField txtBeratMax;
    @FXML
    private ComboBox<String> cmbFilterJenis;
    @FXML
    private ComboBox<String> cbSearchMode;

    @FXML
    private Label lblTotalPutusan;
    @FXML
    private Label lblRataRataVonis;
    @FXML
    private Label lblRataRataDenda;
    @FXML
    private TextArea txtDistribusiPeran;
    @FXML
    private TextArea txtAuditLog;

    @FXML
    private Label lblStatus;
    @FXML
    private Label lblTotalData;


    private KnowledgeController controller;

    private ObservableList<Putusan> dataList = FXCollections.observableArrayList();

    public void setController(KnowledgeController controller) {
        this.controller = controller;
        refreshTabel(controller.getSemuaPutusan());
        amountData();
    }

    @FXML
    public void initialize() {
        // SETUP KOLOM
        colCase.setCellValueFactory(cell ->
                cell.getValue().caseIdProperty());
        colNomorPerkara.setCellValueFactory(cell ->
                cell.getValue().nomorPerkaraProperty());
        colPengadilan.setCellValueFactory(cell ->
                cell.getValue().pengadilanProperty());
        colTanggalPutusan.setCellValueFactory(cell ->
                cell.getValue().tanggalPutusanProperty());
        colKodeTerdakwa.setCellValueFactory(cell ->
                cell.getValue().terdakawaKodeProperty());
        colJenisNarkotika.setCellValueFactory(cell ->
                cell.getValue().jenisNarkotikaProperty());
        colBeratBarangBukti.setCellValueFactory(cell ->
                cell.getValue().beratBarangBuktiGramProperty().asObject());
        colPasalDakwaan.setCellValueFactory(cell ->
                cell.getValue().pasalDakwaanProperty());
        colPasalTerbukti.setCellValueFactory(cell ->
                cell.getValue().pasalTerbuktiProperty());
        colTuntutanBulan.setCellValueFactory(cell ->
                cell.getValue().tuntutanBulanProperty().asObject());
        colVonisBulan.setCellValueFactory(cell ->
                cell.getValue().vonisBulanProperty().asObject());
        colDendaRupiah.setCellValueFactory(cell ->
                cell.getValue().dendaRupiahProperty().asObject());
        colBarangBukti.setCellValueFactory(cell ->
                cell.getValue().BarangBuktiProperty());
        colKeadaanMemberatkan.setCellValueFactory(cell ->
                cell.getValue().keadaanMemberatkanProperty());
        colKeadaanMeringankan.setCellValueFactory(cell ->
                cell.getValue().keadaanMeringankanProperty());
        colSourcePages.setCellValueFactory(cell ->
                cell.getValue().sourcePagesProperty());


        // EVENT UNTUK UPDATE (KLIK DATA DI TABEL DAN DATA AKAN MUNCUL DI FORM
        tablePutusan.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        txtCaseId.setText(newVal.getCaseId());
                        txtNomorPerkara.setText(newVal.getNomorPerkara());
                        txtPengadilan.setText(newVal.getPengadilan());
                        txtTanggalPutusan.setValue(newVal.getTanggalPutusan());
                        txtKodeTerdakwa.setText(newVal.getterdakawaKode());
                        txtPasalDakwaan.setText(String.valueOf(newVal.getpasalDakwaan()));
                        cmbJenisNarkotika.setValue(newVal.getJenisNarkotika());
                        txtBeratBarangBukti.setText(String.valueOf(newVal.getBeratBarangBuktiGram()));
                        txtPasalTerbukti.setText(newVal.getpasalTerbukti());
                        txtTuntutanBulan.setText(String.valueOf(newVal.gettuntutanBulan()));
                        txtVonisBulan.setText(String.valueOf(newVal.getVonisBulan()));
                        txtDendaRupiah.setText(String.valueOf(newVal.getdendaRupiah()));
                        txtBarangBukti.setText(String.valueOf(newVal.getBarangBukti()));
                        txtKeadaanMemberatkan.setText(newVal.getkeadaanMemberatkan());
                        txtKeadaanMeringankan.setText(newVal.getkeadaanMeringankan());
                        txtSourcePages.setText(newVal.getSourcePages());
                    }
                }
        );

        tablePutusan.setItems(dataList);
    }

    @FXML
    private void onTambahPutusan() {

        String jenisNarkotika = cmbJenisNarkotika.getValue();

        try {
            controller.tambahPutusan(
                    txtCaseId.getText(),
                    txtNomorPerkara.getText(),
                    txtPengadilan.getText(),
                    txtTanggalPutusan.getValue(),
                    txtKodeTerdakwa.getText(),
                    txtBeratBarangBukti.getText(),
                    jenisNarkotika,
                    txtBarangBukti.getText(),
                    txtPasalDakwaan.getText(),
                    txtPasalTerbukti.getText(),
                    txtTuntutanBulan.getText(),
                    txtDendaRupiah.getText(),
                    txtVonisBulan.getText(),
                    txtKeadaanMeringankan.getText(),
                    txtKeadaanMemberatkan.getText(),
                    txtSourcePages.getText()
            );

            setStatus("");
            showAlert(Alert.AlertType.INFORMATION, "Tambah Data Putusan", "Data Putusan Berhasil Ditambahkan");
            onClearForm();
            refreshTabel(controller.getSemuaPutusan());
            amountData();
            updateStatistik();
            AuditLog();

        } catch (Exception e) {
            setStatus("");
            showAlert(Alert.AlertType.WARNING, "Tambah Data Putusan", e.getMessage());
        }
    }

    @FXML
    private void onUpdatePutusan() {
        String nomor = txtNomorPerkara.getText();
        if (nomor == null || nomor.isBlank()) {
            setStatus("Nomor perkara tidak boleh kosong saat update.");
            return;
        }
        String jenisNarkotika = cmbJenisNarkotika.getValue();


        try {
            boolean berhasil = controller.updatePutusan(

                    txtCaseId.getText(),
                    nomor.trim(),
                    txtPengadilan.getText(),
                    txtTanggalPutusan.getValue(),
                    txtKodeTerdakwa.getText(),
                    txtBeratBarangBukti.getText(),
                    jenisNarkotika,
                    txtBarangBukti.getText(),
                    txtPasalDakwaan.getText(),
                    txtPasalTerbukti.getText(),
                    txtVonisBulan.getText(),
                    txtTuntutanBulan.getText(),
                    txtDendaRupiah.getText(),
                    txtKeadaanMeringankan.getText(),
                    txtKeadaanMemberatkan.getText(),
                    txtSourcePages.getText()
            );
            if (berhasil) {
                showAlert(Alert.AlertType.INFORMATION, "Update Data Putusan", "Data Putusan Berhasil Diupdate");
                setStatus("");
                onClearForm();
                refreshTabel(controller.getSemuaPutusan());
//                amountData();
                updateStatistik();
                AuditLog();
            } else {
                setStatus("");
                showAlert(Alert.AlertType.WARNING, "Update Data Putusan", "Data dengan nomor perkara " + nomor + " tersebut tidak ditemukan");
            }
        } catch (IllegalArgumentException e) {
            setStatus(e.getMessage());
            showAlert(Alert.AlertType.WARNING, "Update Data Putusan", "Pastikan kolom Umur, Berat, Vonis Hukuman, dan Denda berisi angka yang valid");
        }
    }

    @FXML
    private void onHapusPutusan() {
        String nomor = txtNomorPerkara.getText();
        if (nomor == null || nomor.isBlank()) {
            setStatus("Pilih nomor perkara yang ingin dihapus.");
            return;
        }
        boolean berhasil = controller.hapusPutusan(nomor.trim());
        if (berhasil) {
            setStatus("");
            showAlert(Alert.AlertType.INFORMATION, "Hapus Data Putusan", "Data putusan nomor " + nomor + " berhasil dihapus");
            onClearForm();
            refreshTabel(controller.getSemuaPutusan());
            amountData();
            updateStatistik();
            AuditLog();
        } else {
            setStatus("");
            showAlert(Alert.AlertType.WARNING, "Hapus Data Putusan", "Data dengan nomor perkara tersebut tidak ditemukan");
        }
    }

}
