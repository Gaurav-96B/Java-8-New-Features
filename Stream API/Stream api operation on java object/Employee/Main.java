import java.util.*;
import java.util.stream.Collectors;
class Employee {
    String name;
    String department;
    int salary;
    int age;

    // Constructor
    public Employee(String name, String department, int salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + department + "), Salary: " + salary + ", Age: " + age;
    }
}



public class Main {
    public static void main(String[] args) {
        List < Employee > employees = Arrays.asList(
            new Employee("John", "IT", 5000, 28),
            new Employee("Alice", "HR", 6000, 35),
            new Employee("Bob", "IT", 7000, 32),
            new Employee("Diana", "Finance", 8000, 40),
            new Employee("Eve", "HR", 5500, 30));

      
      1.  // ForEach() method
        //	--- -----------------------------------------------------------------------------
        //Print the employee Object
        employees.stream().forEach(System.out::println);

      2. // filter() method
        //	----------------------------------------------------------------------------------
        //Find the employee whose salary is greater than 4000
        employees.stream().filter(salary - > salary.getSalary() > 4000).forEach(System.out::println);

        //Print the name of employee in HR department
        employees.stream().filter(department - > department.getDepartment().equals("HR")).map(name - > name.getName()).forEach(System.out::println);


      3. // Max() method
        //	--------------------------------------------------------------------------------------
        //Print the name of the highest salary employee
        String maxEmployeeSalary = employees.stream().max((emp1, emp2) - > Integer.compare(emp1.getSalary(), emp2.getSalary())).map(name - > name.getName()).get();
        //OR
        String maxEmployeeSalary = employees.stream().max(Comparator.comparingInt(Employee::getSalary)).map(name - > name.getName()).get();
        //OR
        String maxEmployeeSalary = employees.stream().max(Comparator.comparing(Employee::getSalary)).map(name - > name.getName()).get();
        System.out.println(maxEmployeeSalary);

        
        //Print the employee who has max salary
        employees.stream().max(Comparator.comparing(e->e.getSalary())).ifPresent(e->System.out.println(employee));
        OR
        Employee employee=employees.stream().max(Comparator.comparing(e->e.getSalary())).get();
        System.out.println(employee);

        
        //Print the name of the employee who have max Salary
        String name=employees.stream().max(Comparator.comparing(e->e.getSalary())).map(name1->name1.getName()).get();
        System.out.println(name);


      4. // Min() method
        //	----------------------------------------------------------------------------------------------
        //Print the name of the lowest salary employee
        String minEmployeeSalary = employees.stream().min((emp1, emp2) - > Integer.compare(emp1.getSalary(), emp2.getSalary())).map(name - > name.getName()).get();
        //OR
        String minEmployeeSalary = employees.stream().min(Comparator.comparingInt(Employee::getSalary)).map(name - > name.getName()).get();
        //OR
        String minEmployeeSalary = employees.stream().min(Comparator.comparing(Employee::getSalary)).map(name - > name.getName()).get();
        System.out.println(minEmployeeSalary);

      5. // distinct() method
        //	----------------------------------------------------------------------------------------------------                         
        //Remove duplicate deparment and print unique deparment
        employees.stream().map(deparment - > deparment.getDepartment()).distinct().forEach(System.out::println);

      6. // sort() Method
        //	-----------------------------------------------------------------------------------------------------
        //Sort the employee  based on the name
        employees.stream().sorted((emp1, emp2) - > emp1.getName().compareTo(emp2.getName())).forEach(System.out::println);

        // Sort employees by department first, then by name  or sort the employee based on the department and name
        List < Employee > sortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getName)).collect(Collectors.toList());
        sortedEmployees.forEach(System.out::println);

      7. // Sum() method and mapToInt method
        //	--------------------------------------------------------------------------------------------------------
        //Calcluate total salary of all employee
        int sum = employees.stream().mapToInt(employee - > employee.getSalary()).sum();
        //OR
        int sum = employees.stream().mapToInt(Employee::getSalary).sum();
        System.out.println(sum);

     8.  // average() and mapToInt method
        //	------------------------------------------------------------------------------------------------------------                     
        //Calcluate average age of all employee
        double averageAge = employees.stream().mapToInt(employee - > employee.getAge()).average().orElse(0);
        //OR
        double averageAge = employees.stream().mapToInt(Employee::getAge).average().orElse(0);
        System.out.println(averageAge);
        //OR
        employees.stream().mapToInt(employee->employee.getAge()).average().ifPresent(System.out::println);

    9.   // Collectors class
        //	-------------------------------------------------------------------------------------------------------------
        //Filter Employees by Department
        List < Employee > itEmployees = employees.stream().filter(emp - > emp.getDepartment().equals("IT")).collect(Collectors.toList());
        itEmployees.forEach(System.out::println);


    10.  // groupingBy() method
        //	----------------------------------------------------------------------------------------------------------------                     
        // Group Employees by Department
        Map < String, List < Employee >> employeesByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        employeesByDept.forEach((dept, empList) - > {
            System.out.println(dept + ": " + empList);
        });

        // Group by department and count the number of employees in each department
        Map < String, Long > employeeCountByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        // Print the number of employees in each department
        employeeCountByDepartment.forEach((department, count) - >
            System.out.println("Department: " + department + ", Number of Employees: " + count)
        );

      11.// partitioningBy() method
        //	------------------------------------------------------------------------------------------------------
        //Partition Employees Based on Salary
        Map < Boolean, List < Employee >> partitionedBySalary = employees.stream().collect(Collectors.partitioningBy(emp - > emp.getSalary() > 6000));
        partitionedBySalary.forEach((isHighSalary, empList) - > {
            System.out.println(isHighSalary ? "High Salary:" : "Low/Medium Salary:");
            empList.forEach(System.out::println);
        });


     12. // joining() method
        //	------------------------------------------------------------------------------------------------------------
        //Concatenate Employee Names into a Single String
        String employeeNamesString = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println("Employee Names: " + employeeNamesString);

        // findFirst() method
        //	----------------------------------------------------------------------------------------------------------------
        //Find the First Employee in the List
        Optional < Employee > firstEmployee = employees.stream().findFirst();
        firstEmployee.ifPresent(System.out::println);
        //OR
        employees.stream().findFirst().ifPresent(System.out::println);


     13. // anyMatch() method
        //	----------------------------------------------------------------------------------------------------------------
        //Find if Any Employee is Older Than 35
        boolean isAnyEmployeeOlderThan35 = employees.stream().anyMatch(emp - > emp.getAge() > 35);
        System.out.println("Any Employee Older Than 35? " + isAnyEmployeeOlderThan35);


     14. // toMap() and collect() method
        //	--------------------------------------------------------------------------------------------------------------
        //Collect Employees into a Map (Name as Key, Salary as Value)
        Map < String, Integer > employeeSalaryMap = employees.stream().collect(Collectors.toMap(employee - > employee.getName(), employee - > employee.getSalary()));
        employeeSalaryMap.forEach((name, salary) - > System.out.println(name + ": " + salary));
        //OR
        Map < String, Integer > employeeSalaryMap = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        employeeSalaryMap.forEach((name, salary) - > System.out.println(name + ": " + salary));

     15. // limit() method
        //	-------------------------------------------------------------------------------------------------------------
        //Get First N employee
        //Get first 3 employees
        List < Employee > limitedEmployees = employees.stream().limit(3).collect(Collectors.toList());
        limitedEmployees.forEach(System.out::println);

     16. // skip() method
        //	-----------------------------------------------------------------------------------------------------------------
        //Skip First N Employees
        //Skip first 2 employees
        List < Employee > skippedEmployees = employees.stream().skip(2).collect(Collectors.toList());
        skippedEmployees.forEach(System.out::println);

        //Skip first 2 employees and then take the next 2 employees
        List < Employee > rangedEmployees = employees.stream()
            .skip(2) // Skip first 2 employees
            .limit(2) // Limit to the next 2 employees
            .collect(Collectors.toList());
        rangedEmployees.forEach(System.out::println);

        //Get top 3 highest-paid employees
        //Get top 3 highest-paid employees
        List < Employee > top3Employees = employees.stream()
            .sorted((emp1, emp2) - > Integer.compare(emp2.getSalary(), emp1.getSalary())) // Sort by salary descending
            .limit(3) // Take top 3 employees
            .collect(Collectors.toList());
        top3Employees.forEach(System.out::println);

        List < Employee > top3Employees = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed()) // Sort by salary descending
            .limit(3) // Take top 3 employees
            .collect(Collectors.toList());

        top3Employees.forEach(System.out::println);


    17.  // toArray() method
        // --------------------------------------------------------------------------------------------------
        // Convert the stream to an array of Employee objects
        Employee[] employeeArray = employees.stream()
            .toArray(Employee[]::new);
        Employee[] employeeArray = employees.stream()
            .toArray(size - > new Employee[size]);

        //Create a immutable set object

        Set < Employee > employeeSet = Set.of(
            new Employee("John", "IT", 5000, 28),
            new Employee("Alice", "HR", 6000, 35),
            new Employee("Bob", "IT", 7000, 32),
            new Employee("Diana", "Finance", 8000, 40),
            new Employee("Eve", "HR", 5500, 30)
        );
        System.out.println("Employee Array: " + Arrays.toString(employeeArray));

  18.    // allMatch() method
        //	-----------------------------------------------------------------------------------------------------------
        // Check if all employees have a salary greater than 5000
        boolean allAbove5000 = employees.stream()
            .allMatch(emp - > emp.getSalary() > 5000);
        System.out.println("All employees have a salary greater than 5000: " + allAbove5000);

        // count() method
        //	 -------------------------------------------------------------------------------------------------------------                                    
        // Count the number of employees with a salary greater than 5000
        long highSalaryCount = employees.stream()
            .filter(emp - > emp.getSalary() > 5000)
            .count();

        System.out.println("Number of employees with a salary greater than 5000: " + highSalaryCount);


   19.    // findAny() method
        //	----------------------------------------------------------------------------------------------------------
        // Find any employee with a salary greater than 5000
        Optional < Employee > employeeOptional = employees.stream().filter(emp - > emp.getSalary() > 5000).findAny();
        employeeOptional.ifPresent(emp - >
            System.out.println("Found an employee with a salary greater than 5000: " + emp)
        );

   20.   // mapToInt() method
        //	------------------------------------------------------------------------------------------------
        //calculate the total salary
        int totalSalary = employees.stream()
            .mapToInt(Employee::getSalary) // Extract salaries as an IntStream
            .sum(); // Sum the salaries

        System.out.println("Total Salary: " + totalSalary);

        // Calculate the average salary
        double averageSalary = employees.stream()
            .mapToInt(Employee::getSalary) // Extract salaries as an IntStream
            .average() // Calculate the average
            .orElse(0); // Default to 0 if no employees

        System.out.println("Average Salary: " + averageSalary);

    21.  // noneMatch() method
        //	---------------------------------------------------------------------------------------------------------
        // Check if no employee has a salary less than 4000
        boolean noLowSalary = employees.stream()
            .noneMatch(emp - > emp.getSalary() < 4000);

        System.out.println("No employee has a salary less than 4000: " + noLowSalary);

     22. // peek() method  
        //	------------------------------------------------------------------------------------------------------------
        // Inspect elements at different stages of the stream
        List < Employee > sortedEmployees1 = employees.stream()
            .peek(e - > System.out.println("Before sorting: " + e)) // Inspect before sorting
            .sorted(Comparator.comparing(Employee::getDepartment)
                .thenComparing(Employee::getName))
            .peek(e - > System.out.println("After sorting: " + e)) // Inspect after sorting
            .collect(Collectors.toList());


        System.out.println("Final Sorted List:");
        sortedEmployees1.forEach(System.out::println);

    23.  // flatMap() method
        //  -------------------------------------------------------------------------------------------------------------



      

    }

}
