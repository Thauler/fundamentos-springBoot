package br.com.thauler.fpsr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.thauler")
public class FpsrApplication {

  public static void main(String[] args) {
    SpringApplication.run(FpsrApplication.class, args);
  }

}
