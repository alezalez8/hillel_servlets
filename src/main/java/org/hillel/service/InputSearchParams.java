package org.hillel.service;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputSearchParams {


    private int totalPages; // кол-во выводимых страниц
    private int maxResult; // кол-во записей на странице
    private String sortBy = null; // запрос параметра, по которому осушествляется сортировка
    public boolean isSortAsc; //  сортировка по возрастанию/убыванию
    private String filterKey;
    private String filterValue;

    /*public void setisSortAsc(boolean ascSort) {
        isSortAsc = ascSort;
    }*/
}
