package com.example.task.specification;

import com.example.task.entities.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Component
public class ProductSpec {
    public Specification<Product> getUsers(Integer category_id, String desciption, Integer price) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (desciption != null) {
                predicates.add((Predicate) criteriaBuilder.equal(root.get("desciption"), desciption));
            }
            if (price != null ) {
                predicates.add((Predicate) criteriaBuilder.like(criteriaBuilder.lower(root.get("price")),
                        String.valueOf(price)));
            }
//
            query.orderBy(criteriaBuilder.desc(root.get("experience")));
            return criteriaBuilder.and((javax.persistence.criteria.Predicate) predicates);
        };
    }
}