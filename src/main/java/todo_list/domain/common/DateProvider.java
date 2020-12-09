package todo_list.domain.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProvider {

    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return ft.format(date);
    }
}
