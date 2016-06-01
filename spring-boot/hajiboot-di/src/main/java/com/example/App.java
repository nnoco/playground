package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;

@EnableAutoConfiguration
@Import(AppConfig.class)
@ComponentScan
public class App implements CommandLineRunner {
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;

    public static void main( String[] args ) {
    	SpringApplication.run(App.class,  args);
    }

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enter 2 numbers like 'a b' : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
		
	}
}
