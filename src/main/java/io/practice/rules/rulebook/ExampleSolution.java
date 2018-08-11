package io.practice.rules.rulebook;

import com.deliveredtechnologies.rulebook.Fact;
import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.model.runner.RuleBookRunner;

public class ExampleSolution {
  public static void main(String[] args) {
    RuleBookRunner ruleBook = new RuleBookRunner("com.example.rulebook");
    NameValueReferableMap<ApplicantBean> facts = new FactMap<>();

    ApplicantBean applicant1 = new ApplicantBean(10000, 20000, true);
    //ApplicantBean applicant2 = new ApplicantBean(620, 30000, true);
    facts.put(new Fact<>(applicant1));
   // facts.put(new Fact<>(applicant2));

    ruleBook.setDefaultResult(1);
    ruleBook.run(facts);
    ruleBook.getResult().ifPresent(result -> System.out.println("Applicant qualified for the following rate: " + result));
  }
}