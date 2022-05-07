package Tools;

import java.lang.annotation.*;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/5/7 16:36
 * 4
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface StopWatch {
}
