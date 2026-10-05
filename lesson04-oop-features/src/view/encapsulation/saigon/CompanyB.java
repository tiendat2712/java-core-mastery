package view.encapsulation.saigon;

import view.encapsulation.danang.CompanyA;

public class CompanyB {

    public static void main(String[] args) {

        CompanyA companyA = new CompanyA();
        companyA.taxId = "Nvidia";

        System.out.println("companyA's taxId --> "+ companyA.taxId);

    }
}
