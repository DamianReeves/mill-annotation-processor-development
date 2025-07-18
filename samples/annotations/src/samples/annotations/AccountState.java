
package samples.annotations;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface AccountState {
}
