package com.restweb.demo.restwebdemo.service;

import com.restweb.demo.restwebdemo.model.MahasiswaModel;

import java.util.List;

public interface MahasiswaService {

    List<MahasiswaModel> listMahasiswa();
    MahasiswaModel saveOrUpdateDataMhs(MahasiswaModel mahasiswaModel);
    MahasiswaModel getIdMahasiswa(Integer Id);
}
