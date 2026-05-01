package com.example.voting.service;

import com.example.voting.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VotingService {

    List<Voter> voters = new ArrayList<>();
    List<Candidate> candidates = new ArrayList<>();

    public VotingService() {
        candidates.add(new Candidate(1, "Alice"));
        candidates.add(new Candidate(2, "Bob"));
        candidates.add(new Candidate(3, "Mike"));
    }

    public String register(Voter v) {
        voters.add(v);
        return "Registered successfully";
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public String vote(int voterId, int candidateId) {
        for (Voter v : voters) {
            if (v.voterId == voterId) {

                if (v.isVoted) return "Already voted";

                for (Candidate c : candidates) {
                    if (c.id == candidateId) {
                        c.votes++;
                        v.isVoted = true;
                        return "Vote casted";
                    }
                }
            }
        }
        return "Voter not found";
    }

    public List<Candidate> results() {
        return candidates;
    }
}