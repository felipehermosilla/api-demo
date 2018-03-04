package py.com.api.demo.web.dto;

import org.springframework.beans.support.PagedListHolder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Paginator details
 *
 * @author felipehermosilla
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationDTO {

    @JsonProperty(value = "page")
    private Integer currentPage;
    @JsonProperty(value = "pageSize")
    private Integer pageSize;
    @JsonProperty(value = "totalPages")
    private Integer totalPages;
    @JsonProperty(value = "totalRecords")
    private Integer totalRecords;

    public PaginationDTO() {
        super();
    }

    public PaginationDTO(Integer currentPage, Integer pageSize, Integer totalPages, Integer totalRecords) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalRecords = totalRecords;
    }

    public PaginationDTO(Integer currentPage, Integer pageSize, Integer totalRecords) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
    }

    public PaginationDTO(PagedListHolder<?> page) {
        this.currentPage = page.getPage();
        this.pageSize = page.getPageSize();
        this.totalPages = page.getPageCount();
        this.totalRecords = page.getPageList().size();
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Override
    public String toString() {
        return "PaginationDTO [" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", totalRecords=" + totalRecords +
                ']';
    }
}
