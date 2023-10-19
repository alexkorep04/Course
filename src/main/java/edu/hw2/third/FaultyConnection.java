package edu.hw2.third;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();

    boolean random;

    public FaultyConnection() {
        random = new Random().nextBoolean();
    }

    @Override
    public void execute(String command) {
        if (random) {
            LOGGER.info("Task " + command + " successfully executed!");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection successfully closed!");
    }
}
