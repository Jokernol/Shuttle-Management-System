package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author fang
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private UUID id;
    private String password;
    private String identity;
    private int tel;
}
