package com.example.osi2020.osi2020quoteserver.controller;

import com.example.osi2020.osi2020quoteserver.entity.Quotes;
import com.example.osi2020.osi2020quoteserver.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class QuotesController {

    private QuoteService quoteService;

    @Autowired
    public void setQuoteService(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping("/set")
    public ResponseEntity<Quotes> setQuoteData(@RequestBody Quotes quote){
        if(quoteService.addQuote(quote.getQuote(), quote.getAuthor())){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get")
    public ResponseEntity<List<Quotes>> getQuotes(){
        List<Quotes> quotes = quoteService.getQuotes();
        if(!quotes.isEmpty()){
            return ResponseEntity.ok().body(quotes);
        }
        return ResponseEntity.notFound().build();
    }



}
