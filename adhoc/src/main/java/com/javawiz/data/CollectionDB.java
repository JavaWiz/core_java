package com.javawiz.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javawiz.model.Address;
import com.javawiz.model.Employee;
import com.javawiz.model.Person;

public class CollectionDB {

    public static List<Person> getAllPersons(){
    	return Arrays.asList(
                Person.builder().id(1).name("Ranjan").age(36).weight(72).gender(Person.Gender.MALE).build(),
                Person.builder().id(2).name("Rakesh").age(38).weight(75).gender(Person.Gender.MALE).build(),
                Person.builder().id(3).name("Raman").age(35).weight(77).gender(Person.Gender.MALE).build(),
                Person.builder().id(4).name("Rejina").age(33).weight(45).gender(Person.Gender.FEMALE).build(),
                Person.builder().id(5).name("Rabina").age(31).weight(55).gender(Person.Gender.FEMALE).build(),
                Person.builder().id(6).name("Bivas").age(36).weight(78).gender(Person.Gender.MALE).build(),
                Person.builder().id(7).name("Rihanshi").age(5).weight(20).gender(Person.Gender.FEMALE).build(),
                Person.builder().id(8).name("Mahesh").age(34).weight(75).gender(Person.Gender.MALE).build(),
                Person.builder().id(9).name("Reema").age(32).weight(54).gender(Person.Gender.FEMALE).build(),
                Person.builder().id(10).name("Mahesh").age(32).weight(75).gender(Person.Gender.MALE).build()
            );
    }
    
    public static List<Employee> getEmployees(){
    	return Arrays.asList(
                new Employee(3, "Elle", 34, 12000.00, Arrays.asList("425-423-5355", "324-424-4234")),
                new Employee(1, "Ranjan", 36, 42000.00, Arrays.asList("312-476-8686", "312-224-7575")),
                new Employee(2, "Akash", 32, 23000.00, Arrays.asList("767-432-5757", "324-424-4234")),
                new Employee(6, "Bikash", 37, 24000.00, Arrays.asList("224-545-8678", "224-534-4431")),
                new Employee(4, "Satish", 38, 26000.00, Arrays.asList("132-243-7565", "353-545-7757")),
                new Employee(5, "Bivas", 35, 30000.00, Arrays.asList("432-568-3443", "355-325-3534"))
        );
    }

    public static Map<Employee, Address> getEmployeeMap(){
        Map<Employee, Address> map = new HashMap<>();
        map.put(new Employee(3, "Elle", 34, 12000.00, Arrays.asList("425-423-5355", "324-424-4234")), new Address(111, "Bangalore", 560066, "KA"));
        map.put(new Employee(1, "Ranjan", 36, 12000.00, Arrays.asList("312-476-8686", "312-224-7575")), new Address(111, "Bangalore", 560066, "KA"));
        map.put(new Employee(2, "Akash", 32, 23000.00, Arrays.asList("767-432-5757", "324-424-4234")), new Address(112, "Mumbai", 123456, "MH"));
        map.put(new Employee(6, "Bikash", 37, 24000.00, Arrays.asList("224-545-8678", "224-534-4431")), new Address(113, "Delhi", 324567, "UP"));
        map.put(new Employee(4, "Satish", 38, 26000.00, Arrays.asList("132-243-7565", "353-545-7757")), new Address(114, "Pune", 532526, "MH"));
        map.put(new Employee(4, "Satish", 38, 26000.00, Arrays.asList("132-243-7565", "353-545-7757")) , new Address(115, "Chennai", 534353, "TN"));
        return map;
    }
}
