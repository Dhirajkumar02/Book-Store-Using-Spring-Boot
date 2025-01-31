package com.bookstore.utility;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.net.URI;

@Component
public class BrowserLauncher implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		openBrowser();
	}

	public void openBrowser() {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			URI uri = new URI("http://localhost:8091/login");

			if (os.contains("win")) {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + uri);
			} else if (os.contains("mac")) {
				Runtime.getRuntime().exec("open " + uri);
			} else if (os.contains("nix") || os.contains("nux")) {
				Runtime.getRuntime().exec("xdg-open " + uri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


