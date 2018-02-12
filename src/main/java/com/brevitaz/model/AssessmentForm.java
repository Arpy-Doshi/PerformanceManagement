package com.brevitaz.model;

public class AssessmentForm
{
    private String selfAssessment;
    private String peerAssessment;

    public String getSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(String selfAssessment) {
        this.selfAssessment = selfAssessment;
    }

    public String getPeerAssessment() {
        return peerAssessment;
    }

    public void setPeerAssessment(String peerAssessment) {
        this.peerAssessment = peerAssessment;
    }

    @Override
    public String toString() {
        return "AssessmentForm{" +
                "selfAssessment='" + selfAssessment + '\'' +
                ", peerAssessment='" + peerAssessment + '\'' +
                '}';
    }
}
