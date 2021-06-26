package com.crypto.app;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.ApplicationContextException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crypto.app.event.EventHandler;
import com.crypto.app.portfolio.PortfolioEvent;
import com.crypto.app.portfolio.PortfolioEventListener;
import com.crypto.app.price.PriceEvent;
import com.crypto.app.price.PriceEventListener;
import com.crypto.app.price.PriceGenerator;

/**
 * @author rohsi
 *
 */
public class PortfolioManager {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext("spring-config.xml");
            EventHandler dispatcher = (EventHandler) ctx.getBean("eventDispatcher");
            PriceEventListener priceEventListener = (PriceEventListener) ctx.getBean("priceEventListener");
            PortfolioEventListener portfolioEventListener = (PortfolioEventListener) ctx
                    .getBean("portfolioEventListener");
            dispatcher.registerHandler(PriceEvent.class, priceEventListener);
            dispatcher.registerHandler(PortfolioEvent.class, portfolioEventListener);

            PriceGenerator priceGenerator = (PriceGenerator) ctx.getBean("priceGenerator");

            // generating prices every 2 secs
            TimerTask repeatedTask = new TimerTask() {
                @Override
                public void run() {
                    priceGenerator.generate();

                }
            };
            Timer timer = new Timer("Timer");

            long delay = 1000L;
            long period = 2000L;
            timer.scheduleAtFixedRate(repeatedTask, delay, period);

        } catch (ApplicationContextException e) {
            e.printStackTrace();
            ctx.close();
        }
    }

}
