package com.example.duongkyquy_1472.service;

import com.example.duongkyquy_1472.entity.NhanVien;
import com.example.duongkyquy_1472.reposiroty.NhanVienRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }
    public NhanVien getNhanVienById(String id){
        Optional<NhanVien> optionalBook = nhanVienRepository.findById(id);
        return optionalBook.orElse(null);
    }
    public void add(NhanVien newNhanVien){
        nhanVienRepository.save(newNhanVien);
    }
    public void update(NhanVien newNhanVien){
        nhanVienRepository.save(newNhanVien);
    }
    public void delete(String id){
        nhanVienRepository.deleteById(id);
    }
}
