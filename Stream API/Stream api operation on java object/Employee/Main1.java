import java.util.*;
import java.util.stream.Collectors;
class Employee{
    String name;
    String department;
    int salary;
    int age;
    List<String>phoneNumbers;
    public Employee(String name,String department,int salary,int age,List<String>phoneNumbers){
        this.name=name;
        this.department=department;
        this.salary=salary;
        this.age=age;
        this.phoneNumbers=phoneNumbers;
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
    public void setPhoneNumbers(List<String>phoneNumbers){
        this.phoneNumbers=phoneNumbers;
    }
    public List<String> getPhoneNumbers(){
        return phoneNumbers;
    }
    
    public String toString(){
        return this.name+" "+this.department+" "+this.salary+" "+this.age+" "+this.phoneNumbers;
    }
}
class Main {
    public static void main(String[] args) {
       List < Employee > employees = Arrays.asList(
            new Employee("John", "IT", 5000, 28,Arrays.asList("2090","2067")),
            new Employee("Alice", "HR", 6000, 35,Arrays.asList("6090","5200")),
            new Employee("Bob", "IT", 7000, 32,Arrays.asList("0207","1090")),
            new Employee("Diana", "Finance", 8000, 40,Arrays.asList("3070","2000")),
            new Employee("Eve", "HR", 5500, 30,Arrays.asList("6090","1020")));
            
        //forEach()
        System.out.println("Print employee object----------");
        employees.stream().forEach(System.out::println);
        
        //filter()
        System.out.println("Print employee whose salary is greater than 5000----");
        employees.stream().filter(salary->salary.getSalary()>5000).forEach(System.out::println);
        
        System.out.println("Print employee name whose salary is greater than 5000---");
        employees.stream().filter(salary->salary.getSalary()>5000).map(name->name.getName()).forEach(System.out::println);
        
        //map() One to one  mapping
        System.out.println("Store the employee name into list and print the list---");
        List<String>names=employees.stream().map(employee->employee.getName()).collect(Collectors.toList());
        System.out.println(names);
        
        System.out.println("Store the employee phone numbers into list and print the list---");
        List<List<String>>phoneNumbers=employees.stream().map(employee->employee.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(phoneNumbers);
        
        //flatMap() //one to many mapping
        System.out.println("Store the employee phone numbers into single list and print the list---");
        List<String>phoneNumbers1=employees.stream().flatMap(employee->employee.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phoneNumbers1);
        
        //max()
        System.out.println("Print the highest salaried employee----");
        employees.stream().max(Comparator.comparing(salary->salary.getSalary())).ifPresent(System.out::println);
        
        //min()
        System.out.println("Print the lowest salaried employee----");
        employees.stream().min(Comparator.comparing(salary->salary.getSalary())).ifPresent(System.out::println);
        
        //average() and mapToInt()
        System.out.println("Calculate the average age of all employee----");
        employees.stream().mapToInt(age->age.getAge()).average().ifPresent(System.out::println);
        
        //sum()
        System.out.println("Calculate the total salary of all employee----");
        int sum=employees.stream().mapToInt(salary->salary.getSalary()).sum();
        System.out.println(sum);

        //count()
        System.out.println("Count the number of employees with a salary greater than 5000 ---------");
        long count= employees.stream().filter(salary->salary.getSalary()>5000).count();
        System.out.println(count);
        
        //sorted()
        System.out.println("Sort the employee based on the name in ascending order---------");
        employees.stream().sorted(Comparator.comparing(name->name.getName())).forEach(System.out::println);
         
        System.out.println("Sort the employee based on the name in descending order---------");
        employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
         
        System.out.println("Sort employees by department first then by name ---------");
        employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(name->name.getName())).forEach(System.out::println);
         
        //limit()
        System.out.println("Print first three employee ---------");
        employees.stream().limit(3).forEach(System.out::println);
       
        System.out.println("Print top 3 highest-paid employees ---------");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);
        
        //skip()
        System.out.println("Skip first three employee and print remaining employee ---------");
        employees.stream().skip(3).forEach(System.out::println);

        //allMatch()
        System.out.println("Check if all employees have a salary greater than 5000---------");
        boolean allAbove5000=employees.stream().allMatch(employee->employee.getSalary()>5000);
        System.out.println(allAbove5000);
        
        //anyMatch()
        System.out.println("Check if any employees have a salary greater than 5000---------");
        boolean anyAbove5000=employees.stream().anyMatch(employee->employee.getSalary()>5000);
        System.out.println(anyAbove5000);
        
        //nonMatch()
        System.out.println("Check if no employee has a salary less than 4000---------");
        boolean allBelow4000=employees.stream().noneMatch(employee->employee.getSalary()<4000);
        System.out.println(allBelow4000);
        
        //findAny()
        System.out.println("Find any employee with a salary greater than 5000---------");
        employees.stream().filter(salary->salary.getSalary()>5000).findAny().ifPresent(System.out::println);
        
        //findFirst()
        System.out.println("Find the First Employee in the List---------");
        employees.stream().findFirst().ifPresent(System.out::println);
        
        //toMap() and collect()
        System.out.println("Collect Employees into a Map,Name as Key and Salary as Value---------");
        Map<String,Integer>map=employees.stream().collect(Collectors.toMap(name->name.getName(),salary->salary.getSalary()));
        map.forEach((key,value)->System.out.println(key+" "+value));
        
        //distinct()
        System.out.println("Remove duplicate department and print unique department---------");
        employees.stream().map(department->department.getDepartment()).distinct().forEach(System.out::println);
        
        //Collectors
        System.out.println("Filter employee by department---------");
        List<Employee>listOfEmployee=employees.stream().filter(department->department.getDepartment().equals("IT")).collect(Collectors.toList());
        listOfEmployee.forEach(System.out::println);
         
        //Joining()
        System.out.println("Concatenate Employee Names into a Single String---------");
        String employeeName=employees.stream().map(employee->employee.getName()).collect(Collectors.joining(", "));
        System.out.println(employeeName);
       
    }
}
