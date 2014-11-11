package Framework;

import java.util.logging.Logger;

/**
 * Created by Ильмира on 11.11.14.
 */
public class LogFactory {

    private static Logger logger = Logger.getGlobal();

    public static Logger getLogger(){
        return logger;
    }
}
