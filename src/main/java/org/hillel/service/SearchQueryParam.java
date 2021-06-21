package org.hillel.service;

import lombok.Getter;
import lombok.Setter;

// import class from HW 7
@Getter
@Setter
public class SearchQueryParam {
    private int totalPages; // кол-во выводимых страниц
    private int maxResult; // кол-во записей на странице
    private String sortBy = null; // запрос параметра, по которому осушествляется сортировка
    private boolean isSortAsc = true; //  сортировка по возрастанию/убыванию
    private String filterKey; // имя фильтра
    private String filterValue; // значение фильтра

    private int pageIndex; //  текущий номер страницы
    private int fromRecordIndex; // с какой страницы выводить
    private int maxRecordIndex;  // максимальное кол-во записей


//https://betacode.net/11797/pagination-in-java-hibernate


    public SearchQueryParam(int totalPages, int maxResult, String sortBy, boolean isSortAsc, String filterKey, String filterValue) {

        this.totalPages = totalPages;
        this.maxResult = maxResult;
        this.sortBy = sortBy;
        this.isSortAsc = isSortAsc;
        this.filterKey = filterKey;
        this.filterValue = filterValue;

       /* this.pageIndex = Math.max(fromPage - 1, 0);
        this.fromRecordIndex = pageIndex * recordOnPage;
        this.maxResult = recordOnPage;
        this.maxRecordIndex = fromRecordIndex + maxResult;
        this.isSortAsc = isSortAsc;
        this.sortBy = sortBy;*/
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isSortAsc() {
        return isSortAsc;
    }

    public int getFromRecordIndex() {
        return fromRecordIndex;
    }




    public String getQueryParam() {
        if (sortBy != null) {
            return sortBy;
        }
        return "";
    }
}
