package com.example.duongkyquy_1472.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @Column(name = "ma_phong")
    private String ma_phong;
    @Column(name = "ten_phong")
    @NotNull(message = "Name is required")
    private String ten_phong;
    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}
