package org.example.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel {
    private String title;

    private String description;

    private String imageUrl;

    private Double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    private Boolean isPrimeSpecific;
}
