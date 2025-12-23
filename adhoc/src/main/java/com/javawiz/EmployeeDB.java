package com.javawiz;

import com.javawiz.model.Employee;
import java.util.List;

public class EmployeeDB {
    public static List<Employee> getEmployees(){
        return List.of(
            new Employee(3, "Elle", 34, 12000.00, List.of("425-423-5355", "324-424-4234")),
            new Employee(1, "Ranjan", 36, 42000.00, List.of("312-476-8686", "312-224-7575")),
            new Employee(2, "Akash", 32, 23000.00, List.of("767-432-5757", "324-424-4234")),
            new Employee(6, "Bikash", 37, 24000.00, List.of("224-545-8678", "224-534-4431")),
            new Employee(4, "Satish", 38, 26000.00, List.of("132-243-7565", "353-545-7757")),
            new Employee(5, "Bivas", 35, 30000.00, List.of("432-568-3443", "355-325-3534"))
        );
    }
}
