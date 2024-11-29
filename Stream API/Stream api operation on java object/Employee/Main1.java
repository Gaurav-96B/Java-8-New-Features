import java.util.*;
import java.util.stream.Collectors;
class Employee{
    String name;
    String department;
    int salary;
    int age;
    public Employee(String name,String department,int salary,int age){
        this.name=name;
        this.department=department;
        this.salary=salary;
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
    public int getSalary(){
        return salary;
    }
    public int getAge(){
        return age;
    }
    
    public String toString(){
        return this.name+" "+this.department+" "+this.salary+" "+this.age;
    }
}
class Main {
    public static void main(String[] args) {
       List < Employee > employees = Arrays.asList(
            new Employee("John", "IT", 5000, 28),
            new Employee("Alice", "HR", 6000, 35),
            new Employee("Bob", "IT", 7000, 32),
            new Employee("Diana", "Finance", 8000, 40),
            new Employee("Eve", "HR", 5500, 30));
            
        
        System.out.println("Print employee object----------");
        employees.stream().forEach(System.out::println);
        
        System.out.println("Print employee whose salary is greater than 5000----");
        employees.stream().filter(salary->salary.getSalary()>5000).forEach(System.out::println);
        
        System.out.println("Print employee name whose salary is greater than 5000---");
        employees.stream().filter(salary->salary.getSalary()>5000).map(name->name.getName()).forEach(System.out::println);
        
        System.out.println("Print the highest salaried employee----");
        employees.stream().max(Comparator.comparing(salary->salary.getSalary())).ifPresent(System.out::println);
        
        System.out.println("Print the lowest salaried employee----");
        employees.stream().min(Comparator.comparing(salary->salary.getSalary())).ifPresent(System.out::println);
        
        System.out.println("Calculate the average age of all employee----");
        employees.stream().mapToInt(age->age.getAge()).average().ifPresent(System.out::println);
        
        System.out.println("Calculate the total salary of all employee----");
        int sum=employees.stream().mapToInt(salary->salary.getSalary()).sum();
        System.out.println(sum);
        
        System.out.println("Sort the employee based on the name in ascending order---------");
        employees.stream().sorted(Comparator.comparing(name->name.getName())).forEach(System.out::println);
         
        System.out.println("Sort the employee based on the name in descending order---------");
        employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
         
        System.out.println("Sort employees by department first then by name ---------");
        employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(name->name.getName())).forEach(System.out::println);
       
        System.out.println("Count the number of employees with a salary greater than 5000 ---------");
        long count= employees.stream().filter(salary->salary.getSalary()>5000).count();
        System.out.println(count);
         
        System.out.println("Print first three employee ---------");
        employees.stream().limit(3).forEach(System.out::println);
       
        System.out.println("Skip first three employee and print remaining employee ---------");
        employees.stream().skip(3).forEach(System.out::println);
       
        System.out.println("Print top 3 highest-paid employees ---------");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);
       
        System.out.println("Check if all employees have a salary greater than 5000---------");
        boolean allAbove5000=employees.stream().allMatch(employee->employee.getSalary()>5000);
        System.out.println(allAbove5000);
        
        System.out.println("Check if no employee has a salary less than 4000---------");
        boolean allBelow4000=employees.stream().noneMatch(employee->employee.getSalary()<4000);
        System.out.println(allBelow4000);
        
        System.out.println("Find any employee with a salary greater than 5000---------");
        employees.stream().filter(salary->salary.getSalary()>5000).findAny().ifPresent(System.out::println);
        
        System.out.println("Find the First Employee in the List---------");
        employees.stream().findFirst().ifPresent(System.out::println);
         
        System.out.println("Collect Employees into a Map,Name as Key and Salary as Value---------");
        Map<String,Integer>map=employees.stream().collect(Collectors.toMap(name->name.getName(),salary->salary.getSalary()));
        map.forEach((key,value)->System.out.println(key+" "+value));
        
        System.out.println("Remove duplicate department and print unique department---------");
        employees.stream().map(department->department.getDepartment()).distinct().forEach(System.out::println);
        
        System.out.println("Filter employee by department---------");
        List<Employee>listOfEmployee=employees.stream().filter(department->department.getDepartment().equals("IT")).collect(Collectors.toList());
        listOfEmployee.forEach(System.out::println);
         
        System.out.println("Concatenate Employee Names into a Single String---------");
        String employeeName=employees.stream().map(employee->employee.getName()).collect(Collectors.joining(", "));
        System.out.println(employeeName);
       
    }
}
