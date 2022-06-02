package com.Minin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    ArrayList<Product> products = initProduct();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            resp.getWriter().printf("<h1>Номер: " + products.get(i).getId() + " продукт: " + products.get(i).getTitle() + " стоимость: " + products.get(i).getCost() + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }

    private ArrayList<Product> initProduct() {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Курица", 400));
        products.add(new Product(2, "Свинина", 500));
        products.add(new Product(3, "Молоко", 90));
        products.add(new Product(4, "Яйца", 100));
        products.add(new Product(5, "Творог", 200));
        products.add(new Product(6, "Конфеты", 300));
        products.add(new Product(7, "Блокнот", 100));
        products.add(new Product(8, "Ручка", 30));
        products.add(new Product(9, "Карандаш", 20));
        products.add(new Product(10, "Тетрадь", 20));
        return products;
    }
}
