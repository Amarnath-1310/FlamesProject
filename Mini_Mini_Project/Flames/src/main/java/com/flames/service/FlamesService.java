package com.flames.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FlamesService {

  private static final String FLAMES = "FLAMES";

  public Map<String, String> calculate(String male, String female) {
    String cleanMale = sanitize(male);
    String cleanFemale = sanitize(female);

    int remaining = computeRemainingCount(cleanMale, cleanFemale);
    char resultChar = computeFlamesLetter(remaining);

    Map<String, String> res = new HashMap<>();
    String letter = String.valueOf(resultChar);
    res.put("result", letter);

    switch (resultChar) {
      case 'F':
        res.put("meaning", "Friends");
        res.put("image", "F.svg");
        break;
      case 'L':
        res.put("meaning", "Love");
        res.put("image", "L.svg");
        break;
      case 'A':
        res.put("meaning", "Affection");
        res.put("image", "A.svg");
        break;
      case 'M':
        res.put("meaning", "Marriage");
        res.put("image", "M.svg");
        break;
      case 'E':
        res.put("meaning", "Enemies");
        res.put("image", "E.svg");
        break;
      case 'S':
        res.put("meaning", "Siblings");
        res.put("image", "S.svg");
        break;
      default:
        res.put("meaning", "Unknown");
        res.put("image", "F.svg");
    }

    return res;
  }

  private String sanitize(String s) {
    if (s == null)
      return "";
    return s.toLowerCase().replaceAll("[^a-z]", "");
  }

  private int computeRemainingCount(String a, String b) {
    int[] freqA = new int[26];
    int[] freqB = new int[26];

    for (char c : a.toCharArray())
      freqA[c - 'a']++;
    for (char c : b.toCharArray())
      freqB[c - 'a']++;

    int sum = 0;
    for (int i = 0; i < 26; i++) {
      sum += Math.abs(freqA[i] - freqB[i]);
    }
    return sum;
  }

  private char computeFlamesLetter(int count) {
    if (count == 0) {
      // all letters canceled - treat as Siblings
      return 'S';
    }

    StringBuilder sb = new StringBuilder(FLAMES);
    int idx = 0;
    while (sb.length() > 1) {
      idx = (idx + count - 1) % sb.length();
      sb.deleteCharAt(idx);
    }
    return sb.charAt(0);
  }
}