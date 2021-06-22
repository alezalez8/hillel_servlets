package org.hillel.service;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputSearchParams {


    private int totalPages; // кол-во выводимых страниц
    private int maxResult; // кол-во записей на странице
    private String sortBy; // запрос параметра, по которому осушествляется сортировка
    public boolean sortDirect; //  сортировка по возрастанию/убыванию
    private String filterKey;
    private String filterValue;



    @Override
    public String toString() {
        return "InputSearchParams{" +
                "totalPages=" + totalPages +
                ", maxResult=" + maxResult +
                ", sortBy='" + sortBy + '\'' +
                ", sortDirect=" + sortDirect +
                ", filterKey='" + filterKey + '\'' +
                ", filterValue='" + filterValue + '\'' +
                '}';
    }
}
