package com.example.selfproject;

import javafx.beans.property.*;

public class FileInfo {
    IntegerProperty sno;
    StringProperty name;
    StringProperty status;
    String url;
    DoubleProperty progress;
    DoubleProperty percentage;





    public double getProgress() {
        return progress.get();
    }

    public DoubleProperty progressProperty() {
        return progress;
    }

    public double getPercentage() {
        return percentage.get();
    }

    public DoubleProperty percentageProperty() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage.set(percentage);
    }

    public void setProgress(double progress) {
        this.progress.set(progress);
    }

    public FileInfo(int SNo, String Name, String Status, String Url){
        sno = new SimpleIntegerProperty(SNo);
        name = new SimpleStringProperty(Name);
        status = new SimpleStringProperty(Status);
        url = Url;
        progress = new SimpleDoubleProperty(0.0);
        percentage = new SimpleDoubleProperty(0.00);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSno() {
        return sno.get();
    }

    public IntegerProperty snoProperty() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno.set(sno);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
