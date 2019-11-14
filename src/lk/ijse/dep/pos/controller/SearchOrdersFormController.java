package lk.ijse.dep.pos.controller;

/*
import lk.ijse.dep.pos.db.DB;
import lk.ijse.dep.pos.db.Order;
import lk.ijse.dep.pos.db.OrderDetail;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.pos.util.CustomerTM;
import lk.ijse.dep.pos.util.OrderTM;

import java.io.IOException;
import java.net.URL;
*/
public class SearchOrdersFormController {
    /*
    public TextField txtSearch;
    public TableView<OrderTM> tblOrders;

    public void initialize() {
        // Let's map
        tblOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        tblOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        ObservableList<OrderTM> olOrders = tblOrders.getItems();

        for (Order order : DB.orders) {
            String orderId = order.getOrderId();
            String orderDate = order.getOrderDate().toString();
            String customerId = order.getCustomerId();
            String customerName = null;

            for (CustomerTM customer : DB.customers) {
                if (customer.getId().equals(customerId)) {
                    customerName = customer.getName();
                    break;
                }
            }

            double total = 0.0;
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                double orderDetailTotal = orderDetail.getQty() * orderDetail.getUnitPrice();
                total += orderDetailTotal;
            }

            OrderTM orderTM = new OrderTM(orderId, orderDate, customerId, customerName, total);
            olOrders.add(orderTM);
        }

        ObservableList<OrderTM> olAllOrders =
                FXCollections.observableArrayList(olOrders);

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                String searchText = txtSearch.getText();

                ObservableList<OrderTM> tempOrders = FXCollections.observableArrayList();

                for (OrderTM order : olAllOrders) {
                    if (order.getOrderId().contains(searchText) ||
                            order.getOrderDate().contains(searchText) ||
                            order.getCustomerId().contains(searchText) ||
                            order.getCustomerName().contains(searchText)) {
                        tempOrders.add(order);
                    }
                }

                tblOrders.setItems(tempOrders);
            }
        });

    }

    @FXML
    private void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/lk.ijse.dep.pos.view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.txtSearch.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void tblOrders_OnMouseClicked(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2) {

            URL resource = this.getClass().getResource("/lk.ijse.dep.pos.view/PlaceOrderForm.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(resource);
            Parent root = fxmlLoader.load();
            Scene placeOrderScene = new Scene(root);
            Stage secondaryStage = new Stage();
            secondaryStage.setScene(placeOrderScene);
            secondaryStage.centerOnScreen();
            secondaryStage.setTitle("View Order");
            secondaryStage.setResizable(false);

            PlaceOrderFormController ctrl = fxmlLoader.getController();
            OrderTM selectedOrder = tblOrders.getSelectionModel().getSelectedItem();
            ctrl.initializeForSearchOrderForm(selectedOrder.getOrderId());

            secondaryStage.show();
        }
    }*/
}
