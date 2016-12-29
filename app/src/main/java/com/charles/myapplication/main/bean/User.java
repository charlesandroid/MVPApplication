package com.charles.myapplication.main.bean;

public class User {
    public String address;
    public String agentPhone;
    public String agentName;
    public String appMobile;
    public String appName;
    public String appNo;
    public String clerkId;
    public String clerkName;
    public String clerkPersonId;
    public String clerkPhone;
    public String agentCompanyName;
    public String createDt;
    public String frontTaskStatus;
    public String loanType;
    public String score;
    public String sunlineDt;
    public String taskId;
    public String taskStatus;
    public String taskType;
    public String updatedDt;

    public String appLoanAmount;
    public String monthlyIntRate;
    public String loanTerm;
    public String remark;

    public String channelName;
    public String channelPhone;
    public String mortgageRate;

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                ", agentPhone='" + agentPhone + '\'' +
                ", agentName='" + agentName + '\'' +
                ", appMobile='" + appMobile + '\'' +
                ", appName='" + appName + '\'' +
                ", appNo='" + appNo + '\'' +
                ", clerkId='" + clerkId + '\'' +
                ", clerkName='" + clerkName + '\'' +
                ", clerkPersonId='" + clerkPersonId + '\'' +
                ", clerkPhone='" + clerkPhone + '\'' +
                ", agentCompanyName='" + agentCompanyName + '\'' +
                ", createDt='" + createDt + '\'' +
                ", frontTaskStatus='" + frontTaskStatus + '\'' +
                ", loanType='" + loanType + '\'' +
                ", score='" + score + '\'' +
                ", sunlineDt='" + sunlineDt + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskType='" + taskType + '\'' +
                ", updatedDt='" + updatedDt + '\'' +
                ", appLoanAmount='" + appLoanAmount + '\'' +
                ", monthlyIntRate='" + monthlyIntRate + '\'' +
                ", loanTerm='" + loanTerm + '\'' +
                ", remark='" + remark + '\'' +
                ", channelName='" + channelName + '\'' +
                ", channelPhone='" + channelPhone + '\'' +
                ", mortgageRate='" + mortgageRate + '\'' +
                '}';
    }

}