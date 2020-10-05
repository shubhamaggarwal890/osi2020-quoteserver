package com.example.osi2020.osi2020quoteserver.service;

import com.example.osi2020.osi2020quoteserver.entity.Quotes;
import com.example.osi2020.osi2020quoteserver.repository.QuoteRepository;
import com.example.osi2020.osi2020quoteserver.service.implementation.QuoteServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuoteService implements QuoteServiceImpl {

    private QuoteRepository quoteRepository;

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public boolean addQuote(String quote, String author){
        Quotes quotes = new Quotes();
        quotes.setQuote(quote);
        quotes.setAuthor(author);
        try{
            quoteRepository.save(quotes);
            return true;
        }catch (DataAccessException error){
            System.out.println("Error while saving the quote -" + error.getLocalizedMessage());
        }
        return false;
    }

    public List<Quotes> getQuotes(){
        return (List<Quotes>)quoteRepository.findAll();
    }
}
