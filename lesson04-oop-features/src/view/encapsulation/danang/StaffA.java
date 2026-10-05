package view.encapsulation.danang;

import java.math.BigDecimal;

public class StaffA {

    public String name;
    private BigDecimal salary;

    public static void main(String[] args) {
        CompanyA companyA = new CompanyA();

        System.out.println("company's taxId --> "+ companyA.taxId);
        System.out.println("company's projects --> "+ companyA.projects);
    }
}
