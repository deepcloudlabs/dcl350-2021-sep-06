package com.example.hr.domain;

import java.util.List;

// Problem Space -> Domain -- divide/conquer? --> Sub-domain / Department/Role
// Solution Space -> Design
// DDD:  I) Bounded-Context (Solution space) --> Sub-domain (HR)(Problem Space)
//      II) Ubiquitous Language -> Model Stakeholder -> Employee, TcKimlikNo, FullName, Money, Iban, Department, Photo, ...   
// 1) Entity Class -> i) Persist ii) Identity iii) Mutable
// 2) Value Object -> i) stores value ii) does not have an identity iii) immutable
// 3) Aggregate -> Entity Root -> Sub-domain information 
//    enforce Validation/Business Rule/Pre-/Post-condition/invariants 
//    transaction boundary
@Entity(identity = "identity")
@Aggregate
public class Employee {
    private TcKimlikNo identity;
    private FullName fullName;
    private Money salary;
    private Iban iban;
    private List<Department> departments;
    private BiometricPhoto photo;
    private JobStyle jobStyle;
    
}
