package com.example.client;

import com.example.client.Objects.CreateOrder;
import com.example.client.Objects.Customer;
import com.example.client.Objects.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

@Service
public class ShopClient {
  public void run() {

    System.out.println();
    System.out.println("Oferta climb-shop:");
    System.out.println();

    RestTemplate restTemplate = new RestTemplate();
    Product[] response = restTemplate.getForObject("http://localhost:8080/api/products", Product[].class);

//    restTemplate.exchange("http://localhost:8080/api/products", HttpMethod.GET, null, Product[].class);

    for (int i = 0; i < response.length; i++) {
      System.out.println(response[i].getId() + ". " + response[i].getName() + "   rozmiar: " + response[i].getSize() + "   sztuk: " + response[i].getAmount() + "      " + response[i].getPrize() + " PLN");
    }
    Scanner scan = new Scanner(System.in);

    System.out.println();
    System.out.println("W celu zakupu podaj numer produktu: ");
    System.out.println("Jeśli chcesz wyjść, wciśnij 'x'. ");
    String wybor = scan.next();
    Long id;
    Double suma = 0.0;
    int sztuk;
    Map<Long, Integer> listazakupow = new HashMap<>();
    while (!Objects.equals("x", wybor)) {
      id = Long.parseLong(wybor);
      System.out.println("Podaj liczbę sztuk: ");
      wybor = scan.next();
      sztuk = parseInt(wybor);
      for (int i = 0; i < response.length; i++) {
        if (id == response[i].getId()) {
          suma = suma + response[i].getPrize() * sztuk;
        }
      }
      System.out.println("W celu zakupu podaj numer produktu: ");
      System.out.println("Jeśli chcesz wyjść, wciśnij 'x'. ");
      //Integer.toString(wybor);
      wybor = scan.next();
      listazakupow.put(id, sztuk);
    }

    System.out.println("");
    System.out.println("W celu zakupu konieczna autoryzacja.");
    System.out.println("Podaj login: ");
    String login = scan.next();
    System.out.println("Podaj hasło:");
    String password = scan.next();
    Customer customer = new Customer();
    customer.setLogin(login);
    customer.setPassword(password);

    CreateOrder createOrder = new CreateOrder();
    createOrder.setCustomer(customer);
    createOrder.setMapa(listazakupow);

    HttpEntity<CreateOrder> httpEntity = new HttpEntity<>(createOrder);
    restTemplate.exchange("http://localhost:8080/api/order", HttpMethod.PUT, httpEntity, Void.class);

    System.out.println("Twoje zamowienie jest poprawne, zapraszamy ponownie!");
    System.out.println("Twój rachunek:    " + suma + "PLN");
    System.out.println();
    System.out.println("Oferta climb-shop:");
    System.out.println();

    response = restTemplate.getForObject("http://localhost:8080/api/products", Product[].class);
    for (int i = 0; i < response.length; i++) {
      System.out.println(response[i].getId() + ". " + response[i].getName() + "   rozmiar: " + response[i].getSize() + "   sztuk: " + response[i].getAmount() + "      " + response[i].getPrize() + " PLN");
    }
  }
}
