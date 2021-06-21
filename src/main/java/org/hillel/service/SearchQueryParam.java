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
    boolean isAscSort = true; //  сортировка по возрастанию/убыванию
    private String filterKey; // имя фильтра
    private String filterValue; // значение фильтра

    private int pageIndex; //  текущий номер страницы
    private int fromRecordIndex; // с какой страницы выводить
    private int maxRecordIndex;  // максимальное кол-во записей


//https://betacode.net/11797/pagination-in-java-hibernate



    public SearchQueryParam(){
    }

    public SearchQueryParam(int fromPage, int recordOnPage, String sortBy, boolean isAscSort) {

        this.pageIndex = Math.max(fromPage - 1, 0);
        this.fromRecordIndex = pageIndex * recordOnPage;
        this.maxResult = recordOnPage;
        this.maxRecordIndex = fromRecordIndex + maxResult;
        this.isAscSort = isAscSort;
        this.sortBy = sortBy;
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

    public boolean isAscSort() {
        return isAscSort;
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
