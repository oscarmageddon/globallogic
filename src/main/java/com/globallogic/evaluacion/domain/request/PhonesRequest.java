package com.globallogic.evaluacion.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Phones Request")
public class PhonesRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(notes = "number")
  private String number;

  @ApiModelProperty(notes = "city code")
  private String citycode;

  @ApiModelProperty(notes = "contry code")
  private String contrycode;
}
