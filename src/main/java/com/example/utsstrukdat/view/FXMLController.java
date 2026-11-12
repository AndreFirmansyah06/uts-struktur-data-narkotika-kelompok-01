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
}
