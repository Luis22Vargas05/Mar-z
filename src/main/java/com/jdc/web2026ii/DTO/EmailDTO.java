package com.jdc.web2026ii.DTO;

public class EmailDTO {
    public String [] toUser;
    private String subjet;
    private String message;

    public EmailDTO(){

    }
    public EmailDTO(String [] toUser, String subjet, String message){
        this.toUser = toUser;
        this.subjet = subjet;
        this.message=  message;

    }

    public String[] getToUser() {
        return toUser;
    }

    public void setToUser(String[] toUser) {
        this.toUser = toUser;
    }

    public String getSubjet() {
        return subjet;
    }

    public void setSubjet(String subjet) {
        this.subjet = subjet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}