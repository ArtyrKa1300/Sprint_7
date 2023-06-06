package actions;

import constants.PathAPI;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import example.Courier;

import static io.restassured.RestAssured.given;

// Вызовы ручек вынесены в отдельный класс CourierClient
public class CourierClient extends BaseAPI { // класс CourierClient - наследник класса BaseAPI

    public CourierClient()  {

    }

    @Step("Метод для шага Создание курьера")
    @Description("POST на ручку /api/v1/courier")
    public Response createCourier(Courier courier) {
        return
                // метод given() помогает сформировать запрос
                given(RequestSpecification()) // вызываем метод RequestSpecification(), где хранится Base url
                        .header("Content-type", "application/json") // Строка указывает, что данные в теле запроса передаются в формате JSON
                        .and()
                        .body(courier)
                        .when()
                        // отправляем POST-запрос с помощью метода post, недостающую часть URL (ручку) передаём в него в качестве параметра
                        .post(PathAPI.COURIER_BASE_URL);


    }

    @Step("Авторизация курьера в системе")
    @Description("POST на ручку /api/v1/courier/login")
    public Response loginCourier(Courier courier) {
        return
                given(RequestSpecification()) // вызываем метод RequestSpecification(), где хранится Base url
                        .header("Content-type", "application/json")
                        .and()
                        .body(courier)
                        .when()
                        .post(PathAPI.COURIER_LOGIN);
    }

    @Step("Удалить курьера из системы")
    @Description("DELETE на ручку /api/v1/courier/:id")
    public void deleteCourier(Courier courier) {
        try {
            int id = loginCourier(courier).then().extract().path("id");


            given(RequestSpecification()) // вызываем метод RequestSpecification(), где хранится Base url
                    .header("Content-type", "application/json")
                    .and()
                    .body(courier)
                    .when()
                    .delete(PathAPI.COURIER_BASE_URL + id);

        } catch (NullPointerException e) {
            System.out.println("Нечего удалять после теста");
        }
    }

}