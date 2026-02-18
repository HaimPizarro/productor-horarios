package com.duoc.productor_horarios.service;

import com.duoc.productor_horarios.config.RabbitMQConfig;
import com.duoc.productor_horarios.model.InfoRuta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void enviarActualizacion(InfoRuta info) {
        try {
            String mensajeJson = objectMapper.writeValueAsString(info);
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_HORARIOS, mensajeJson);
            System.out.println("Enviado a RabbitMQ: " + mensajeJson);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error enviando mensaje");
        }
    }
}