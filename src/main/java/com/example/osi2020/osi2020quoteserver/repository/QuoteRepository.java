package com.example.osi2020.osi2020quoteserver.repository;

import com.example.osi2020.osi2020quoteserver.entity.Quotes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quotes, Integer> {

}
