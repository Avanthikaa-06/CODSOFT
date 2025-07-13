package org.currency_converter;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class Currency {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("CURRENCY CONVERTER");
		System.out.println("CHOOSE THE BASE CURRENCY CODE  \r\n"
				+ "USD - US Dollar  \r\n"
				+ "EUR - Euro  \r\n"
				+ "INR - Indian Rupee  \r\n"
				+ "GBP - British Pound Sterling  \r\n"
				+ "JPY - Japanese Yen  \r\n"
				+ "AUD - Australian Dollar  \r\n"
				+ "CAD - Canadian Dollar  \r\n"
				+ "CNY - Chinese Yuan  \r\n"
				+ "CHF - Swiss Franc  \r\n"
				+ "SGD - Singapore Dollar\r\n" );
		System.out.println("Enter base currency code(eg.EUR,): ");
		String base= scan.nextLine().toUpperCase();
		System.out.println("Enter target currency code (e.g., INR): ");
		String target = scan.nextLine().toUpperCase();
		System.out.println("Enter the amount to be converted:");
		double amt= scan.nextDouble();

        try {
            // API URL (Free API: https://open.er-api.com)
            String apiUrl = "https://open.er-api.com/v6/latest/" + base;

      
			URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Read API response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder apiResponse = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                apiResponse.append(inputLine);
            }
            in.close();

            // Parse JSON
            JSONObject jsonObj = new JSONObject(apiResponse.toString());
            JSONObject rates = jsonObj.getJSONObject("rates");

            if (rates.has(target)) {
                double rate = rates.getDouble(target);
                double converted = amt * rate;

                System.out.printf("\n%.2f %s = %.2f %s\n", amt, base, converted, target);
            } else {
                System.out.println("Invalid target currency code or not available in API.");
            }

        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }

        scan.close();
    }

    }

		
	
		
		
		
		

	


