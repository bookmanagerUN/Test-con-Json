/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Data.Notes;

import java.util.Arrays;

/**
 * @author Usuario
 */
//Hola 
class AuxBook {
    private int actualPage;
    private boolean status;
    private Object[] bookInformation;
    private Notes[] notes;
    private String opinion;

    public AuxBook(int actualPage, boolean status, Object[] bookInformation, Notes[] notes, String opinion) {
        System.out.println("util.AuxBook.<init>()");
        this.actualPage = actualPage;
        this.status = status;
        this.bookInformation = bookInformation;
        this.notes = notes;
        this.opinion = opinion;
    }

    public String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public int getActualPage() {
        return actualPage;
    }

    public void setActualPage(int actualPage) {
        this.actualPage = actualPage;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object[] getBookInformation() {
        return bookInformation;
    }

    public void setBookInformation(Object[] bookInformation) {
        this.bookInformation = bookInformation;
    }

    public Notes[] getNotes() {
        return notes;
    }

    public void setNotes(Notes[] notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "AuxBook{" +
                "actualPage= " + actualPage +
                ", status= " + status +
                ", bookInformation= " + Arrays.toString(bookInformation) +
                ", notes= " + Arrays.toString(notes) +
                ", opinion= " + this.opinion +
                '}';
    }
}
