package org.example.productcatalogservice.TableInheritanceExamples.MappedSuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User {
    private String email;

    @Id
    private Long id;
}
