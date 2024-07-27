import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", 20, 45000),
                new Employee("Naresh", 28, 33000),
                new Employee("Chris", 64, 75000),
                new Employee("Doe", 20, 48000)
        );

        employees.stream()
                .sorted(Comparator
                        .comparingInt(Employee::getAge).reversed()
                        .thenComparing(Employee::getSalary).reversed())
                .findFirst().ifPresent((emp)->System.out.println(emp.getName()));
        // youngest employee with highest salary
//        Optional<Employee> employee = employees.stream()
//                .sorted((ele1, ele2)->{
//                    if(ele1.getAge()>ele2.getAge()){
//                        return 1;
//                    }else if(ele1.getAge()==ele2.getAge()){
//                        if(ele1.getSalary()<ele2.getSalary()){
//                            return 1;
//                        }else{
//                            return -1;
//                        }
//                    }else{
//                        return -1;
//                    }
//                })
//                .findFirst();
//
//        if (employee.isPresent()) {
//            System.out.println(employee.get().getName());
//        }
    }
}