package com.example.voting.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.voting.model.Candidate;
import com.example.voting.model.Voter;
import com.example.voting.service.VotingService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VotingController {

    private final VotingService service;

    public VotingController(VotingService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody Voter voter) {
        return service.register(voter);
    }

    @GetMapping("/candidates")
    public List<Candidate> getCandidates() {
        return service.getCandidates();
    }

    @PostMapping("/vote")
    public String vote(@RequestParam int voterId, @RequestParam int candidateId) {
        return service.vote(voterId, candidateId);
    }

    @GetMapping("/results")
    public List<Candidate> results() {
        return service.results();
    }
}