package com.pragma.powerup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order_status_logs")
public class OrderStatusLog {

    @Id
    private String id;
    @Field(name = "id_pedido")
    private Long orderId;
    @Field(name = "id_cliente")
    private Long clientId;
    @Field(name = "correo_cliente")
    private String clientEmail;
    @Field(name = "fecha")
    private Date date;
    @Field(name = "estado_anterior")
    private String lastStatus;
    @Field(name = "estado_nuevo")
    private String newStatus;
    @Field(name = "id_empleado")
    private Long employeeId;
    @Field(name = "correo_empleado")
    private String employeeEmail;

}