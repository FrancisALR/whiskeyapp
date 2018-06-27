package admin;

import dbUtil.dbConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField brand;
    @FXML
    private TextField name;
    @FXML
    private TextArea desc;
    @FXML
    private CheckBox sexynod;
    @FXML
    private CheckBox wowfactor;
    @FXML
    private TextField packaging;
    @FXML
    private TextField rating;

    @FXML
    private Button loadButton;
    @FXML
    private TableView<WhiskeyData> whiskeytable;

    @FXML
    private TableColumn<WhiskeyData, String> brandcolumn;
    @FXML
    private TableColumn<WhiskeyData, String> namecolumn;
    @FXML
    private TableColumn<WhiskeyData, String> desccolumn;
    @FXML
    private TableColumn<WhiskeyData, String> packagingcolumn;
    @FXML
    private TableColumn<WhiskeyData, String> wowfactorcolumn;
    @FXML
    private TableColumn<WhiskeyData, String> ratingcolumn;
    @FXML
    private TableColumn<WhiskeyData, String> sexynodcolumn;

    private dbConnector db;
    private ObservableList<WhiskeyData> datalist;

    private String getAllSQL = "SELECT * FROM whiskeys";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.db = new dbConnector();
    }

    @FXML
    public void loadWhiskeyData() throws SQLException {
        try {

            Connection con = dbConnector.getConnection();
            this.datalist = FXCollections.observableArrayList();
            ResultSet res = con.createStatement().executeQuery(getAllSQL);
            while (res.next()) {
                this.datalist.add(new WhiskeyData(res.getString(1), res.getString(2),res.getString(3),
                        res.getString(4),res.getString(5), res.getString(6), res.getString(7), res.getString(8)));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        this.namecolumn.setCellValueFactory(new PropertyValueFactory<WhiskeyData, String>("name"));
        this.brandcolumn.setCellValueFactory(new PropertyValueFactory<WhiskeyData, String>("brand"));
        this.desccolumn.setCellValueFactory(new PropertyValueFactory<WhiskeyData, String>("desc"));
        this.packagingcolumn.setCellValueFactory(new PropertyValueFactory<WhiskeyData, String>("packaging"));
        this.sexynodcolumn.setCellValueFactory(new PropertyValueFactory<WhiskeyData, String>("sexynod"));
        this.wowfactorcolumn.setCellValueFactory(new PropertyValueFactory<WhiskeyData, String>("wowfactor"));
        this.ratingcolumn.setCellValueFactory(new PropertyValueFactory<WhiskeyData, String>("rating"));

        this.whiskeytable.setItems(null);
        this.whiskeytable.setItems(this.datalist);
    }

    @FXML
    private void addWhiskey() throws SQLException {
        String sqlInsert = "INSERT INTO whiskeys(id, brandname, whiskeyname, desc, nod, wfactor, packaging, rating) VALUES (?,?,?,?,?,?,?,?)";
        try {
            Connection conn = dbConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, this.id.getText());
            stmt.setString(2, this.brand.getText());
            stmt.setString(3, this.name.getText());
            stmt.setString(4, this.desc.getText());
            stmt.setString(5, this.sexynod.getText());
            stmt.setString(6, this.wowfactor.getText());
            stmt.setString(7, this.packaging.getText());
            stmt.setString(8, this.rating.getText());

            stmt.executeUpdate()
            ;
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
