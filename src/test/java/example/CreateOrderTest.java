package example;

import actions.OrderClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class) // Аннотация. Перед тестовым классом нужно указать раннер Parameterized — класс, который помогает запускать тесты с параметризацией
public class CreateOrderTest {
    private final Order order; // создали поля тестового класса

    OrderClient orderClient = new OrderClient();

    public CreateOrderTest(Order order) { // создали конструктор тестового класса
        this.order = order;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTestDataForColor() {
        return new Object[][]{
                // Выбран самокат черного цвета
                {new RandomOrders(new String[]{"BLACK"})},
                // Выбран самокат серого цвета
                {new RandomOrders(new String[]{"GREY"})},
                // Выбраны одновременно оба цвета самоката
                {new RandomOrders(new String[]{"BLACK", "GREY"})},
                // Цвет самоката не выбран
                {new RandomOrders(null)}, // передали тестовые данные
        };
    }

    @Test
    @DisplayName("Проверяем код и тело ответа в случае валидного запроса")
    @Description("Ожидаемый результат: код 201, заказ создан, тело запроса содержит track")

    public void checkCreateValidOrder() {
        orderClient.createOrder(order)
                .then()
                .assertThat()
                .statusCode(201) // проверка статуса ответа
                .and()
                .body("track", notNullValue()); // тело ответа содержит track; матчер notNullValue() проверяет, что аргумент метода assertThat — не null-значение
    }

}