package example;

import actions.OrderClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class GetOrderTest {
    OrderClient orderClient = new OrderClient();

    @Test
    @DisplayName("Проверяем тело в случае валидного запроса")
    @Description("Ожидаемый результат: тело ответа возвращает список заказов")

    public void getOrderReturnAllOrders() {

        orderClient.getOrder()
                .then()
                .body("orders", notNullValue()); // тело ответа содержит orders; матчер notNullValue() проверяет, что аргумент метода assertThat — не null-значение
        // могут быть разные проверки:
        //.body("orders", not(isEmpty()));
        //.body("orders", hasSize(greaterThan(0))); // тело ответа содержит orders; матчер hasSize() проверяет, что аргумент — содержит больше чем 0 элементов
    }

}