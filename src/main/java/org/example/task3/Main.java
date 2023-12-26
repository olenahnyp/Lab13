package org.example.task3;

public class Main {
    public static void main(String[] args) {
        PDLReader enricher = new PDLReader();
        CompanyData company = enricher.extract("https://shop.silpo.ua");
        System.out.println(company.getName());
        System.out.println(company.getLogo());
        System.out.println(company.getDescription());
    }
}
