package todo_list.domain.common;

import java.util.UUID;

public class UUIDGenerator {

    public static String getID() {
        return UUID.randomUUID().toString();
    }
}
