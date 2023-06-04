package actions;

import constants.PathAPI;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import example.Order;

import static io.restassured.RestAssured.given;

// Вызовы ручек вынесены в отдельный класс OrderClient
public class OrderClient extends BaseAPI { // класс OrderClient - наследник класса BaseAPI

    public OrderClient() {

    }

    @Step("Метод для шага Создать заказ")
    @Description("POST на ручку api/v1/orders")

    public Response createOrder(Order order) {
        return given(RequestSpecification()) // вызываем метод RequestSpecification(), где хранится Base url
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(PathAPI.ORDER_BASE_URL);
    }

    @Step("Метод для шага Получить заказы")
    @Description("GET  на ручку api/v1/orders")

    public Response getOrder() {
        return given(RequestSpecification()) // вызываем метод RequestSpecification(), где хранится Base url
                .get(PathAPI.ORDER_BASE_URL);
    }

}