package com.nhnacademy.resimanage.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 세대 테이블
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household")
public class Household {
    @Id
    @Column(name = "household_serial_number")
    private Integer householdSerialNumber;

    // 주민과 비식별관계, fk
    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident resident;

    @Column(name = "household_composition_date")
    private LocalDate householdCompositionDate;

    @Column(name = "household_composition_reason_code", length = 20)
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address", length = 500)
    private String currentHouseMovementAddress;

    // 세대구성주민과 식별관계
    @OneToMany(mappedBy = "household", cascade = CascadeType.PERSIST)
    private List<HouseholdCompositionResident> householdCompositionResidentList = new ArrayList<>();

    // 세대전입주소와 식별관계
    @OneToMany(mappedBy = "household", cascade = CascadeType.PERSIST)
    private List<HouseholdMovementAddress> householdMovementAddressList = new ArrayList<>();
}
