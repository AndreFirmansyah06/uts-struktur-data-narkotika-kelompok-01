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
}
