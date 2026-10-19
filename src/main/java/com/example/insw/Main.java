
package com.example.insw;

import com.example.insw.model.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

public class Main {

    private static final Logger log =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        try (InputStream input = Main.class
                .getClassLoader()
                .getResourceAsStream("orders.json")) {

            if (input == null) {
                throw new IllegalStateException(
                        "No se encontró orders.json en resources"
                );
            }

            List<Order> orders = mapper.readValue(
                    input,
                    new TypeReference<List<Order>>() {}
            );

            for (Order order : orders) {
                log.debug("Loaded order: {}", order.getId());
            }
        }
    }
}
