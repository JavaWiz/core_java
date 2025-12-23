package com.javawiz.model;

import java.util.Arrays;
import java.util.List;
import lombok.Builder;

@Builder
public record Employee(int id, String name, int age, Double salary, List<String> phoneNumber, Department department) {
    public static List<Employee> getEmployees(){
        return Arrays.asList(
            Employee.builder().id(3).name("Elle").age(34).salary(12000.00).phoneNumber(Arrays.asList("425-423-5355", "324-424-4234"))
                .department(Department.builder().deptId(1).deptName(DeptName.IT).build()).build(),
            Employee.builder().id(1).name("Ranjan").age(36).salary(42000.00).phoneNumber(Arrays.asList("312-476-8686", "312-224-7575"))
                .department(Department.builder().deptId(2).deptName(DeptName.HR).build()).build(),
            Employee.builder().id(2).name("Akash").age(32).salary(23000.00).phoneNumber(Arrays.asList("767-432-5757", "324-424-4234"))
                .department(Department.builder().deptId(3).deptName(DeptName.FINANCE).build()).build(),
            Employee.builder().id(6).name("Bikash").age(37).salary(24000.00).phoneNumber(Arrays.asList("224-545-8678", "224-534-4431"))
                .department(Department.builder().deptId(2).deptName(DeptName.SALES).build()).build(),
            Employee.builder().id(4).name("Satish").age(38).salary(26000.00).phoneNumber(Arrays.asList("132-243-7565", "353-545-7757"))
                .department(Department.builder().deptId(4).deptName(DeptName.MARKETING).build()).build(),
            Employee.builder().id(5).name("Rejina").age(35).salary(30000.00).phoneNumber(Arrays.asList("432-568-3443", "355-325-3534"))
                .department(Department.builder().deptId(1).deptName(DeptName.IT).build()).build(),
            Employee.builder().id(7).name("Rohit").age(29).salary(28000.00).phoneNumber(Arrays.asList("789-456-1234", "987-654-3210"))
                .department(Department.builder().deptId(3).deptName(DeptName.FINANCE).build()).build(),
            Employee.builder().id(8).name("Anita").age(31).salary(32000.00).phoneNumber(Arrays.asList("654-321-7890", "321-654-0987"))
                .department(Department.builder().deptId(4).deptName(DeptName.MARKETING).build()).build(),
            Employee.builder().id(9).name("Vikram").age(40).salary(45000.00).phoneNumber(Arrays.asList("123-456-7890", "098-765-4321"))
                .department(Department.builder().deptId(2).deptName(DeptName.SALES).build()).build(),
            Employee.builder().id(10).name("Sneha").age(28).salary(27000.00).phoneNumber(Arrays.asList("567-890-1234", "432-109-8765"))
                .department(Department.builder().deptId(1).deptName(DeptName.IT).build()).build(),
            Employee.builder().id(11).name("Karan").age(33).salary(31000.00).phoneNumber(Arrays.asList("876-543-2109", "210-987-6543"))
                .department(Department.builder().deptId(3).deptName(DeptName.FINANCE).build()).build(),
            Employee.builder().id(12).name("Pooja").age(30).salary(29000.00).phoneNumber(Arrays.asList("345-678-9012", "654-321-0987"))
                .department(Department.builder().deptId(4).deptName(DeptName.MARKETING).build()).build(),
            Employee.builder().id(13).name("Amit").age(39).salary(40000.00).phoneNumber(Arrays.asList("789-012-3456", "321-654-9870"))
                .department(Department.builder().deptId(2).deptName(DeptName.SALES).build()).build(),
            Employee.builder().id(14).name("Ritu").age(27).salary(26000.00).phoneNumber(Arrays.asList("012-345-6789", "987-654-3210"))
                .department(Department.builder().deptId(1).deptName(DeptName.IT).build()).build(),
            Employee.builder().id(15).name("Sanjay").age(41).salary(47000.00).phoneNumber(Arrays.asList("456-789-0123", "210-987-6543"))
                .department(Department.builder().deptId(3).deptName(DeptName.FINANCE).build()).build(),
            Employee.builder().id(16).name("Neha").age(29).salary(28000.00).phoneNumber(Arrays.asList("678-901-2345", "543-210-9876"))
                .department(Department.builder().deptId(4).deptName(DeptName.MARKETING).build()).build(),
            Employee.builder().id(17).name("Raj").age(34).salary(33000.00).phoneNumber(Arrays.asList("890-123-4567", "678-901-2345"))
                .department(Department.builder().deptId(2).deptName(DeptName.SALES).build()).build(),
            Employee.builder().id(18).name("Simran").age(32).salary(30000.00).phoneNumber(Arrays.asList("123-789-4560", "456-012-7893"))
                .department(Department.builder().deptId(1).deptName(DeptName.IT).build()).build(),
            Employee.builder().id(19).name("Manish").age(36).salary(35000.00).phoneNumber(Arrays.asList("234-567-8901", "567-890-1234"))
                .department(Department.builder().deptId(3).deptName(DeptName.FINANCE).build()).build(),
            Employee.builder().id(20).name("Tina").age(28).salary(27000.00).phoneNumber(Arrays.asList("345-678-9012", "678-901-2345"))
                .department(Department.builder().deptId(4).deptName(DeptName.MARKETING).build()).build(),
            Employee.builder().id(21).name("Vikas").age(38).salary(40000.00).phoneNumber(Arrays.asList("456-789-0123", "789-012-3456"))
                .department(Department.builder().deptId(2).deptName(DeptName.SALES).build()).build(),
            Employee.builder().id(22).name("Ayesha").age(30).salary(29000.00).phoneNumber(Arrays.asList("567-890-1234", "890-123-4567"))
                .department(Department.builder().deptId(1).deptName(DeptName.IT).build()).build()
        );
    }

}


