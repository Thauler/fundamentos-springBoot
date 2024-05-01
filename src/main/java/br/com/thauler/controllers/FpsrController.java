package br.com.thauler.controllers;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraController")
public class FpsrController {

  @GetMapping("/primeiroMetodo/{id}")
  public String primeiroMetodo (@PathVariable String id) {
    return "Acessando o metodo GET do primeiro metodo com o ID: " + id;
  }

  @GetMapping("/primeiroQueryParam")
  public String segundoMetodo (@RequestParam String id) {
    return "Acessando o metodo GET do segundo metodo com o query param ID: " + id;
  }

  @GetMapping("/segundoQueryParam")
  public String terceiroMetodo (@RequestParam Map<String, String> allParams) {
    return "Acessando o metodo GET do terceiro metodo com o " + allParams.entrySet();
  }

  @PostMapping("/metodoComBodyParams")
  public String quartoMetodo (@RequestBody User username) {
    return "User: " + username.user();
  }

  @PostMapping("/metodoComHeaders")
  public String quintoMetodo (@RequestHeader Map<String, String> headers) {
    return "Metodo com headers: " + headers.entrySet();
  }

  @GetMapping("/metodoResponseEntity/{id}")
  public ResponseEntity<Object> sextoMetodo(@PathVariable Long id) {
    var user = new User("Thauler");

    if (id >= 5) {
      return ResponseEntity.ok().body(user);
    }
    return ResponseEntity.badRequest().body("Numero menor que 5");
  }

  record User (String user) {}
}
