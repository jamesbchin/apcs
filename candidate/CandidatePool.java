/*========== CandidatePool.java ==========

  Each CandidatePool object contains the following
  instance variables that you may need to use:
       
  pool
      An ArrayList of only Candidate objects

  You will need to write the following methods:
   
  getCandidatesForPosition(String pos)
      returns a candidate-only ArrayList containing all
      the Candidates in pool that have positions pos

  getBestCandidate(String pos)
      returns the Candidte in pool that matches position
      pos with the highest score
      If there are no candidates for the given position, 
      returns null

  removeCandidatesForPosition(String pos)
      Removes all the Candidates in the pool that match
      position pos.
      Returns the number of candidates removed

jdyrlandweaver
=========================*/
import java.io.*;
import java.util.*;

public class CandidatePool {
    
    //=================================
  //DO NOT MODIFY ANY OF THIS CODE
  ArrayList pool;
  
  public CandidatePool() {
    pool = new ArrayList();
  }
  public void addCandidate(Candidate c) {
    pool.add(c);
  }
  public String toString() {
    return pool.toString();
  }
  
  //=================================
  //START YOUR WORK HERE
  public ArrayList getCandidatesForPosition(String pos) {
    ArrayList newPool = new ArrayList();
    Candidate c;
    for (int i = 0; i < pool.size(); i++) {
      c = (Candidate)pool.get(i);
      if (c.getPosition().equals(pos)) {
        newPool.add(c);
      }
    }
    //System.out.println("pool \n" + pool);
    return newPool;
  }

  public Candidate getBestCandidate(String pos) {
    ArrayList newPool = getCandidatesForPosition(pos);
    Candidate one;
    Candidate two;
    for (int i = newPool.size() - 1; i > 0; i--) {
      one = (Candidate)newPool.get(i);
      two = (Candidate)newPool.get(i - 1);
      if ((long)one.getInterviewScore() > (long)two.getInterviewScore()) {
        newPool.remove(i - 1);
      }
      else {
        newPool.remove(i);
      }
    }
    return (Candidate)newPool.get(0);
  }

  public int removeCandidatesForPosition(String pos){
    ArrayList newPool = getCandidatesForPosition(pos);
    Candidate c;
    int removed = 0;
    for (int i = newPool.size() - 1; i >= 0; i--) {
      c = (Candidate)newPool.get(i);
      if (c.getPosition().equals(pos)) {
        newPool.remove(i);
        removed++;
      }
    }
    return(removed);
  }

}

    
