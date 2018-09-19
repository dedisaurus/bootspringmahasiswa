package com.restweb.demo.restwebdemo.controller;

import com.restweb.demo.restwebdemo.model.MahasiswaModel;
import com.restweb.demo.restwebdemo.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MahasiswaController {

    private MahasiswaService mahasiswaService;

    @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    //tampil data mahasiswa
    @RequestMapping("/mahasiswa")
    public String MahasiswaList(Model model){
        model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());
        return "mahasiswa";
    }

    //tampil halaman create
    @RequestMapping(value = "/mahasiswa/create",method = RequestMethod.GET)
    public String tampilform(Model model){
        model.addAttribute("mahasiswa", new MahasiswaModel());
        return "formMahasiswa";
    }

    //simpan data
    @RequestMapping(value = "mahasiswa/create", method = RequestMethod.POST)
    public String simpanDataMahasiswa(Model model, MahasiswaModel mahasiswaModel){
        model.addAttribute("mahasiswa", mahasiswaService.saveOrUpdateDataMhs(mahasiswaModel));
        //hasil balikan setelah ngejalanin method
        return "redirect:/mahasiswa";
    }

    //show edit data
    @RequestMapping(value = "/mahasiswa/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("mahasiswa",mahasiswaService.getIdMahasiswa(id));
        return "formMahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/hapus/{id}")
    public String hapusData(@PathVariable Integer id){
        mahasiswaService.hapusData(id);
        return "redirect:/mahasiswa";
    }

}
