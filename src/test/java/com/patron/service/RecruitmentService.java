package com.patron.service;

import com.patron.pages.SearchBar;
import com.patron.pages.recruitment.candidate.AddCandidatePage;
import com.patron.pages.recruitment.candidate.CandidateDetailPage;
import com.patron.pages.recruitment.candidate.CandidatePage;

public class RecruitmentService {

  public void createCandidate(String firstname, String lastname, String email, String type) {
    new SearchBar()
        .openRecruitmentPage()
        .goToAddCandidate()
        .createCandidate(firstname, lastname, email, type);
  }

  public void confirmCandidateCreated() {
    new AddCandidatePage().confirmCreatedCandidate();
  }

  public void deleteCandidate(String firstname, String lastname) {
    new SearchBar()
        .openRecruitmentPage()
        .searchCandidate(firstname, lastname)
        .deleteCandidate(firstname, lastname)
        .confirmDelete();

    new CandidatePage().confirmDeleteCandidate();
  }


  public void hireCandidate(String date) {
    new CandidateDetailPage()
        .goToAcceptCandidate()
        .accept()
        .goToScheduleInterview()
        .scheduleInterview(date)
        .markInterviewPassed()
        .accept()
        .offerJob()
        .accept()
        .hire()
        .accept();
  }

  public void checkCandidateStatus() {
    new CandidateDetailPage().checkStatus();
  }

  public void createVacancy(String type, String manager) {
    new SearchBar()
        .openRecruitmentPage()
        .goToVacancyPage()
        .goToAddVacancy()
        .createVacancy(type, manager);
  }

  public void deleteVacancy(String type) {
    new SearchBar()
        .openRecruitmentPage()
        .goToVacancyPage()
        .searchVacancy(type)
        .deleteVacancy(type)
        .confirmDeleteVacancy();
  }
}
