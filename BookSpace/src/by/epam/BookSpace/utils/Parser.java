package by.epam.BookSpace.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class Parser {
    private static final Logger log = LogManager.getLogger();

    public static Integer parseInteger(String number) {
        Integer ans = -1;
        try {
            ans = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            log.error(e);
        }
        return ans;
    }

    public static UUID parseUUID(String id) {
        UUID ans = null;
        try {
            ans = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            log.error(e);
        }
        return ans;
    }
}
