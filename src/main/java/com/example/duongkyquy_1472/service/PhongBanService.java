package com.example.duongkyquy_1472.service;


import com.example.duongkyquy_1472.entity.PhongBan;
import com.example.duongkyquy_1472.reposiroty.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }

    public void addPhongBan(PhongBan newCategory){
        phongBanRepository.save(newCategory);
    }
    public PhongBan savePhongBan(PhongBan category) { return phongBanRepository.save(category);}
    public void update(PhongBan category){
        phongBanRepository.save(category);
    }
}
