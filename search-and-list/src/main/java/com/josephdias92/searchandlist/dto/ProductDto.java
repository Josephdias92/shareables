package com.josephdias92.searchandlisting.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ProductDto {
    private String category;
    private String description;
    private String name;
    private Double rent;
    private Integer maxDaysToRent;
    private Integer howOld;
}
