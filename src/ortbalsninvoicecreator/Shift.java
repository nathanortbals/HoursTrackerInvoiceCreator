/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortbalsninvoicecreator;

import java.util.Date;

/**
 *
 * @author nathan
 */
public class Shift {
    
    private Date clockedIn;
    private Date clockedOut;
    private Double hourlyRate;
    private Double duration;
    private Double earnings;
    private String comment;
    
    public Shift(Date clockedIn, Date clockedOut, Double hourlyRate, Double duration, double earnings, String comment){
        this.clockedIn = clockedIn;
        this.clockedOut = clockedOut;
        this.hourlyRate = hourlyRate;
        this.duration = duration;
        this.earnings = earnings;
        this.comment = comment;
    }

    /**
     * @return the clockedIn
     */
    public Date getClockedIn() {
        return clockedIn;
    }

    /**
     * @param clockedIn the clockedIn to set
     */
    public void setClockedIn(Date clockedIn) {
        this.clockedIn = clockedIn;
    }

    /**
     * @return the clockedOut
     */
    public Date getClockedOut() {
        return clockedOut;
    }

    /**
     * @param clockedOut the clockedOut to set
     */
    public void setClockedOut(Date clockedOut) {
        this.clockedOut = clockedOut;
    }

    /**
     * @return the hourlyRate
     */
    public Double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * @param hourlyRate the hourlyRate to set
     */
    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * @return the duration
     */
    public Double getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    /**
     * @return the earnings
     */
    public Double getEarnings() {
        return earnings;
    }

    /**
     * @param earnings the earnings to set
     */
    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
