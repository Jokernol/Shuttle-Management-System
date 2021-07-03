package se.zust.badgateway.pojo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDO {
    private Double x;
    private Double y;
    private String position;
}
