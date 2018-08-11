package io.practice.rules.rulebook;

import com.deliveredtechnologies.rulebook.annotation.Given;
import com.deliveredtechnologies.rulebook.annotation.Result;
import com.deliveredtechnologies.rulebook.annotation.Rule;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;

import java.util.List;

@Rule(order = 4)
public class FirstTimeHomeBuyerRule {
  @Given
  List<ApplicantBean> applicants;

  @Result
  private double rate;

  @When
  public boolean when() {
    return
      applicants.stream().anyMatch(applicant -> applicant.isFirstTimeHomeBuyer());
  }

  @Then
  public void then() {
    rate = rate - (rate * 0.20);
  }
}