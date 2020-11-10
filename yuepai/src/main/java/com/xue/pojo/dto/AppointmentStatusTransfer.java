package com.xue.pojo.dto;

public class AppointmentStatusTransfer {
    private String inviteAccount;

    private String invitedAccount;

    private Integer appointmentId;

    public String getInviteAccount() {
        return inviteAccount;
    }

    public void setInviteAccount(String inviteAccount) {
        this.inviteAccount = inviteAccount;
    }

    public String getInvitedAccount() {
        return invitedAccount;
    }

    public void setInvitedAccount(String invitedAccount) {
        this.invitedAccount = invitedAccount;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }
}
