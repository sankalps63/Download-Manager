package com.example.selfproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private TextField tf;
    @FXML
    private TableView<FileInfo> tv;
    @FXML
    private TableColumn<FileInfo, String> Name;
    @FXML
    private TableColumn<FileInfo, Integer> Sno;
    @FXML
    private TableColumn<FileInfo, String> Status;
    @FXML
    private TableColumn<FileInfo, Double> Progress;
    @FXML
    private TableColumn<FileInfo, Double> Percentage;

    public ObservableList<FileInfo> list;
    public ArrayList<FileInfo> arrayList = new ArrayList<>();
    int index = 0;

    @FXML
    public void initialize(){
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Sno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        Status.setCellValueFactory(new PropertyValueFactory<>("status"));
        Progress.setCellValueFactory(new PropertyValueFactory<>("progress"));
        Progress.setCellFactory(ProgressBarTableCell.<FileInfo>forTableColumn());
        Percentage.setCellValueFactory(new PropertyValueFactory<>("percentage"));
//        list = FXCollections.observableArrayList(arrayList);
        tv.setItems(FXCollections.observableArrayList(arrayList));
    }

    @FXML
    public void DownloadButton(){
        String url = tf.getText().trim();
        tf.clear();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Download Path");
        fileChooser.setInitialFileName(url.substring(url.lastIndexOf("/") + 1));

        File selectedFile = fileChooser.showSaveDialog(tv.getScene().getWindow());

        if(selectedFile != null){
            String downloadPath = selectedFile.getAbsolutePath();

            FileInfo fin = new FileInfo(++index, url.substring(url.lastIndexOf("/")+1), "Starting...", url);
            arrayList.add(fin);
            tv.getItems().add(fin);
            System.out.println(fin.getStatus());
            DThread th = new DThread(fin, downloadPath);
            th.start();
        }

        tv.refresh();
    }

}