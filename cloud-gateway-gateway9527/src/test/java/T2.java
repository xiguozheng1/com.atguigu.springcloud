import java.time.ZonedDateTime;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-04-22 16-48
 * @since 1.8
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();// 默认时区
        System.out.println(zonedDateTime);
    }
}
