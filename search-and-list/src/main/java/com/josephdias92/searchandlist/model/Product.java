package com.josephdias92.searchandlisting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Product {
    @Id
    @JsonProperty("product_id")
    private String id;
    private String category;
    private String description;
    private String name;
    private Double rent;
    private Integer maxDaysToRent;
    private Integer howOld;
}
