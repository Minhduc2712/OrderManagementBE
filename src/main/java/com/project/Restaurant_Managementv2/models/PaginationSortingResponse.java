package com.project.Restaurant_Managementv2.models;

import com.project.Restaurant_Managementv2.dto.product.ProductDto;

import java.util.List;

public class PaginationSortingResponse {
    private List<ProductDto> content;
    private int pageNo;
    private int pageSize;
    private int totalElements;
    private int totalPages;
    private boolean last;

//    public PaginationSortingResponse(List<Product> listOfProducts, long totalElements, int number, int totalPages, int size){
//        super();
//    }

//    public PaginationSortingResponse(List<Product> content, int pageNo, int pageSize, int totalElements, int totalPages, boolean last) {
//        this.content = content;
//        this.pageNo = pageNo;
//        this.pageSize = pageSize;
//        this.totalElements = totalElements;
//        this.totalPages = totalPages;
//        this.last = last;
//    }

    public List<ProductDto> getContent() {
        return content;
    }

    public void setContent(List<ProductDto> content) {
        this.content = content;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "PaginationSortingResponse{" +
                "content=" + content +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", last=" + last +
                '}';
    }
}
