package Framework;

import java.util.NoSuchElementException;
import java.util.OptionalInt;

/**
 * Created by Igor Sychev on 08.11.14.
 */
public class LambdaExtensions {

    public static int get(OptionalInt optionalInt) {
        try {
            return optionalInt.getAsInt();
        } catch (NoSuchElementException e) {
        }
        return 0;
    }
}
