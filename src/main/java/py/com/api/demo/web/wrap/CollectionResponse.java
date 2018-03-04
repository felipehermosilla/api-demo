package py.com.api.demo.web.wrap;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import py.com.api.demo.web.dto.PaginationDTO;

/**
 * Generic collection response
 *
 * @author felipehermosilla
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectionResponse<E> extends ServiceResponse {

	@JsonProperty
	private List<E> results;
	@JsonProperty
	private PaginationDTO pagination;

	public CollectionResponse() {
		super();
	}

	public CollectionResponse(List<E> results) {
		this();
		this.results = results;
	}

	public List<E> getResults() {
		return results;
	}

	public void setResults(List<E> results) {
		this.results = results;
	}

	public PaginationDTO getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDTO pagination) {
		this.pagination = pagination;
	}
}

