package com.example.backend.controller;

import com.example.backend.model.Quote;
import com.example.backend.services.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @PostMapping
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteService.saveQuote(quote);
    }
}
