package objects

data class Employee(val name: String, val salary: Double)

object Payroll {
    val allEmployees = mutableListOf<Employee>()

    fun calculateSalary(): Double {
        var total = 0.0
        allEmployees.forEach { total += it.salary }

        return total
    }
}

fun main() {
    Payroll.allEmployees.add(Employee("Oriza", 100.0))
    Payroll.allEmployees.add(Employee("Bastion", 500.0))

    val total = Payroll.calculateSalary()
    println("total = $total")
}

