package com.example.duongkyquy_1472.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @Column(name = "ma_nv")
    private String ma_nv;

    @Column(name = "ten_nv")
    @NotNull(message = "Employee name is required")
    private String ten_nv;

    @Column(name = "phai")
    private String phai;

    @Column(name = "noi_sinh")
    private String noi_sinh;
    @ManyToOne
    @JoinColumn(name = "ma_phong")
    private PhongBan phongBan;
    @Column(name = "luong")
    private int luong;
}
