package actions; // пакет действия

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPI { // класс Base url во всем проекте один, поэтому присвоили один раз
    public RequestSpecification RequestSpecification() { // метод RequestSpecification() добавляемм в каждый шаг CourierClient и OrderClient
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
        return RestAssured.given();
    }

}