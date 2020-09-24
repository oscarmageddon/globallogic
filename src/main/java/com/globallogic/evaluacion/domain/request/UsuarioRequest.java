package com.globallogic.evaluacion.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Usuario Request")
public class UsuarioRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(notes = "name")
  private String name;

  @ApiModelProperty(notes = "email")
  @Size(max = 256, min = 6)
  @Pattern(
      regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
      message = "Format must be like Example, correo@email.com")
  private String email;

  @ApiModelProperty(notes = "password")
  @Size(max = 8, min = 6)
  @Pattern(
      regexp = "^(?=.*[A-Z])(?=.*[0-9].*[0-9])(?=.*[a-z]).{8}$",
      message = "Format must be like Example, correo@email.com")
  private String password;

  private List<PhonesRequest> phones;
}
