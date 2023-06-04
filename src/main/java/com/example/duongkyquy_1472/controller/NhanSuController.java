package com.example.duongkyquy_1472.controller;


import com.example.duongkyquy_1472.entity.NhanVien;
import com.example.duongkyquy_1472.service.NhanVienService;
import com.example.duongkyquy_1472.service.PhongBanService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhansu")
public class NhanSuController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String listBooks(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        model.addAttribute("listNhanVien", nhanViens);
        model.addAttribute("title", "DUONG KY QUY-2080601472");
        return "nhansu/index";
    }

    @GetMapping("/create")
    public String addBookForm(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
        return "nhansu/create";
    }
    @PostMapping("/create")
    public String addBook(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhansu/create";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhansu";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") String id, Model model){
        NhanVien editNhanVien = nhanVienService.getNhanVienById(id);
        if(editNhanVien != null){
            model.addAttribute("nhanvien", editNhanVien);
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhansu/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("nhanvien")NhanVien updateNhanVien, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhansu/edit";
        }
        nhanVienService.update(updateNhanVien);
        return "redirect:/nhansu";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id){
        nhanVienService.delete(id);
        return "redirect:/nhansu";
    }
}
