package com.example.backend.services;

import com.example.backend.model.Quote;
import com.example.backend.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote saveQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

}
