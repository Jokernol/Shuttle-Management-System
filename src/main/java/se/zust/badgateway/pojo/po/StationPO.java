package se.zust.badgateway.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王怀瑾
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationPO {
    private Double lngX;
    private Double latY;
    private String positionName;
}
